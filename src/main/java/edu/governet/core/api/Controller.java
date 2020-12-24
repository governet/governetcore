package edu.governet.core.api;

import java.util.*;
import java.util.stream.Collectors;

import edu.governet.core.AppInit;
import edu.governet.core.fecdataaccess.Candidate;
import edu.governet.core.fecdataaccess.Committee;
import edu.governet.core.fecdataaccess.Contribution;
import edu.governet.core.fecdataaccess.Network;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class Controller {
    /**
     * Initialize the application by loading the data from file at runtime,
     * using the AppInit and AppContext for dependency and configuration injection.
     */
    private static final String DATA_SUBDIRECTORY = "/data/";
    private static final String CROSS_ORIGIN_ACCEPT_LOCAL = "http://localhost:8081";

    private static final String CANDIDATE_TYPE_IDENTIFIER = "CANDIDATE";
    private static final String COMMITTEE_TYPE_IDENTIFIER = "COMMITTEE";

    private static final Logger logger = LogManager.getLogger(Controller.class);

    AppInit init = new AppInit().withDataDirectory(DATA_SUBDIRECTORY);
    AppContext context = new AppContext(init);

    @CrossOrigin(origins = CROSS_ORIGIN_ACCEPT_LOCAL)
    @RequestMapping("/candidates")
    public List<Candidate> candidates(
            @RequestParam(value="state", defaultValue="pa") String state){
        return context.getCandidates();
    }

    @CrossOrigin(origins = CROSS_ORIGIN_ACCEPT_LOCAL)
    @RequestMapping(path="/candidates/{candId}")
    public List<Candidate> candidate(
            @PathVariable String candId){
        return context.getCandidates()
                .stream()
                .filter(c -> c.getCandidateId().matches(candId))
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = CROSS_ORIGIN_ACCEPT_LOCAL)
    @RequestMapping(path="/candidates/{candId}/committees")
    public List<Committee> candCmteLinkage(
            @PathVariable String candId){
        return context.getCommittees()
                .stream()
                .filter(c -> c.getCandidateId().matches(candId))
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = CROSS_ORIGIN_ACCEPT_LOCAL)
    @RequestMapping("/candidates/{candId}/contributors")
    public List<Committee> contributorsByCandidate(
            @PathVariable String candId){
         List<String> contributorIds = context.getContributions()
                 .stream()
                 .filter(c -> c.getCandidateId().matches(candId))
                 .map(Contribution::getCommitteeId)
                 .distinct()
                 .collect(Collectors.toList());

         return context.getCommittees()
                 .stream()
                 .filter(committee -> contributorIds.contains(committee.getCommitteeId()))
                 .collect(Collectors.toList());
    }

    @CrossOrigin(origins = CROSS_ORIGIN_ACCEPT_LOCAL)
    @RequestMapping("/candidates/{candId}/contributions")
    public List<Contribution> contributionsByCandidate(
            @PathVariable String candId){
        return context.getContributions()
                .stream()
                .filter(c -> c.getCandidateId().matches(candId))
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = CROSS_ORIGIN_ACCEPT_LOCAL)
    @RequestMapping("/committees")
    public List<Committee> committees(
            @RequestParam(value="state", defaultValue="pa") String state){
        return context.getCommittees();
    }

    @CrossOrigin(origins = CROSS_ORIGIN_ACCEPT_LOCAL)
    @RequestMapping("/committees/{cmteId}")
    public List<Committee> committee(
            @PathVariable String cmteId){
        return context.getCommittees()
                .stream()
                .filter(c -> c.getCommitteeId().matches(cmteId))
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = CROSS_ORIGIN_ACCEPT_LOCAL)
    @RequestMapping("/committees/{cmteId}/candidates")
    public List<Candidate> cmteCandLinkage(
            @PathVariable String cmteId){

        List<String> candidateIds = context.getContributions()
                .stream()
                .filter(c -> c.getCommitteeId().matches(cmteId))
                .map(Contribution::getCandidateId)
                .collect(Collectors.toList());

        List<Candidate> candidates = context.getCandidates()
                .stream()
                .filter(c -> candidateIds.contains(c.getCandidateId()))
                .collect(Collectors.toList());

        return candidates;
    }

    @CrossOrigin(origins = CROSS_ORIGIN_ACCEPT_LOCAL)
    @RequestMapping("/committees/{cmteId}/contributions")
    public List<Contribution> contributionsByCommittee(
            @PathVariable String cmteId){
        return context.getContributions()
                .stream()
                .filter(c -> c.getCommitteeId().matches(cmteId))
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = CROSS_ORIGIN_ACCEPT_LOCAL)
    @RequestMapping("/contributions")
    public List<Contribution> contributions(
            @RequestParam(value="state", defaultValue="pa") String state){
        return context.getContributions();
    }

    @CrossOrigin(origins = CROSS_ORIGIN_ACCEPT_LOCAL)
    @RequestMapping("/contributions/{contId}")
    public List<Contribution> contribution(
            @PathVariable String contId){
        return context.getContributions()
                .stream()
                .filter(c -> c.getTransactionId().matches(contId))
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = CROSS_ORIGIN_ACCEPT_LOCAL)
    @RequestMapping(path="/network")
    public Network network(){

        List<String> firstLink = context.getCandidates()
                .stream()
                .limit(10000)
                .map(Candidate::getCandidateId)
                .collect(Collectors.toList());

        List<String> secondLink = new ArrayList<>(firstLink);

        Collections.reverse(secondLink);

        List<Network.NetworkLink> links = firstLink
                .stream()
                .limit(100000)
                .map(L -> new Network.NetworkLink(L, secondLink.get(getRandomNumber())))
                .collect(Collectors.toList());

        List<Network.NetworkNode> nodes = context.getCandidates()
                .stream()
                .limit(100000)
                .map(c -> new Network.NetworkNode(
                        c.getCandidateId(), c.getCandidateName(), c.getPartyDesignation(), CANDIDATE_TYPE_IDENTIFIER))
                .collect(Collectors.toList());

        return new Network(nodes, links);
    }

    private int getRandomNumber() {
        int min = 0;
        int max = 7590;
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }

    @CrossOrigin(origins = CROSS_ORIGIN_ACCEPT_LOCAL)
    @RequestMapping(path="/network/contributions")
    public Map<String, Map<String, List<Contribution>>> contributionNetwork(){

        List<Contribution> majorContributions = context.getContributions().stream()
                .filter(c -> Long.parseLong(c.getTransactionAmmount()) > 5000)
                .collect(Collectors.toList());

        Long totalContributions = context.getContributions().stream()
                .map(c -> Long.parseLong(c.getTransactionAmmount()))
                .reduce(0L, Long::sum);

        HashMap<String, ArrayList<String>> candCommitteeLinkage = new HashMap<>();
        context.getContributions()
                .forEach(c -> candCommitteeLinkage.get(c.getCandidateId()));

        Map<String, List<Contribution>> contributionsByCandidate = context.getContributions()
                .stream()
                .collect(Collectors.groupingBy(Contribution::getCandidateId));

        Map<String, Map<String, List<Contribution>>> contributionsToCandByCmte = context.getContributions()
                .stream()
                .filter(c -> Long.parseLong(c.getTransactionAmmount()) >= 500)
                .collect(Collectors.groupingBy(
                        Contribution::getCandidateId, Collectors.groupingBy(
                                Contribution::getCommitteeId)));

        return contributionsToCandByCmte;
    }

    @CrossOrigin(origins = CROSS_ORIGIN_ACCEPT_LOCAL)
    @RequestMapping("/network/candidates")
    public Network candidateContributionNetwork(
            @RequestParam(value = "candId", required = false) Stack<String> candidateIds) {
        logger.info("Input request parameters: {}", candidateIds.toString());
        // http://127.0.0.1:8080/network/candidates?candId=H2MA04073&candId=S2MA00170
        // this works! use the above to get union of funders between Warren and Kennedy!
        Network candidateContributionNetwork;
        List<Network.NetworkNode> nodes = new ArrayList<>();
        List<Network.NetworkLink> links = new ArrayList<>();
        try {
            logger.info("Mapping candidates to their contributors and contributions...");
            logger.info("{}", candidateIds.toString());
            Map<String, Map<String, List<Contribution>>> contributionsToCandByCmte = context.getContributions()
                    .stream()
                    .filter(c -> candidateIds.contains(c.getCandidateId()))
                    .collect(Collectors.groupingBy(
                            Contribution::getCandidateId, Collectors.groupingBy(
                                    Contribution::getCommitteeId)));
            logger.info("{}", contributionsToCandByCmte.size());
            logger.info("{}", contributionsToCandByCmte.keySet());

            logger.info("Generating candidate and committee nodes...");
            while (!candidateIds.isEmpty()) {
                String candidateId = candidateIds.pop();
                logger.info("Processing candidate {}...", candidateId);
                if (!context.getCandidatesMap().containsKey(candidateId)){
                    logger.info("Candidate {} does not exist in the loaded records...moving on",
                            candidateId);
                    break;
                }
                Candidate candidate = context.getCandidatesMap().get(candidateId);

                logger.info("Building network node for candidate {}", candidateId);
                Network.NetworkNode candidateNode = new Network.NetworkNode(
                        candidate.getCandidateId(),
                        candidate.getCandidateName(),
                        candidate.getPartyDesignation(),
                        CANDIDATE_TYPE_IDENTIFIER);
                nodes.add(candidateNode);

                for (String otherCandidateId : candidateIds) {
                    logger.info("Building connections between candidate {} and candidate {}", candidateId, otherCandidateId);
                    if (!contributionsToCandByCmte.containsKey(candidateId)) {
                        logger.info("Doesn't look like candidate {} has any contributions...moving on...", otherCandidateId);
                        break;
                    }
                    for (String cmteId : contributionsToCandByCmte.get(candidateId).keySet()) {
                        logger.info("Determing links via committee {}", cmteId);
                        if (contributionsToCandByCmte.get(otherCandidateId).containsKey(cmteId)) {
                            logger.info("Committee {} has contributed to both {} and {}, adding committee as node...",
                                    cmteId, candidateId, otherCandidateId);
                            Committee committee = context.getCommitteesMap().get(cmteId);

                            logger.info("Adding network node for committee {}", cmteId);
                            Network.NetworkNode commmitteeNode = new Network.NetworkNode(
                                    committee.getCommitteeId(),
                                    committee.getCommitteeName(),
                                    committee.getCommitteParty(),
                                    COMMITTEE_TYPE_IDENTIFIER
                            );
                            logger.info("Adding committee node to node list...");
                            nodes.add(commmitteeNode);

                            logger.info("Adding links between candidates {} and {} via shared contributor {}",
                                    candidateId, otherCandidateId, cmteId);
                            Network.NetworkLink cmteToCand1Link = new Network.NetworkLink(cmteId, candidateId);
                            Network.NetworkLink cmteToCand2Link = new Network.NetworkLink(cmteId, otherCandidateId);
                            links.add(cmteToCand1Link);
                            links.add(cmteToCand2Link);
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Encountered an unexpected error while constructing graph;", e);
        }
        logger.info("Constructing graph from nodes and links objects...");
        candidateContributionNetwork = new Network(nodes, links);
        logger.info("Finished constructing contribution network...");
        return candidateContributionNetwork;
    }

    @CrossOrigin(origins = CROSS_ORIGIN_ACCEPT_LOCAL)
    @RequestMapping("/network/candidates/full")
    public Network candidateContributionNetworkFull(){
        Network candidateContributionNetwork;
        Stack<String> candidateIds = new Stack<>();

        candidateIds.addAll(context.getCandidates().stream()
                .map(Candidate::getCandidateId)
                .filter(candId -> context.getCandidatesMap().get(candId).getState().equals("MA"))
                .collect(Collectors.toList()));

        List<Network.NetworkNode> nodes = new ArrayList<>();
        List<Network.NetworkLink> links = new ArrayList<>();
        try {
            logger.info("Mapping candidates to their contributors and contributions...");
            logger.info("{}", candidateIds.toString());
            Map<String, Map<String, List<Contribution>>> contributionsToCandByCmte = context.getContributions()
                    .stream()
                    .filter(c -> candidateIds.contains(c.getCandidateId()))
                    .collect(Collectors.groupingBy(
                            Contribution::getCandidateId, Collectors.groupingBy(
                                    Contribution::getCommitteeId)));
            logger.info("{}", contributionsToCandByCmte.size());
            logger.info("{}", contributionsToCandByCmte.keySet());

            logger.info("Generating candidate and committee nodes...");
            while (!candidateIds.isEmpty()) {
                String candidateId = candidateIds.pop();
                logger.info("Processing candidate {}...", candidateId);
                if (!context.getCandidatesMap().containsKey(candidateId)){
                    logger.info("Candidate {} does not exist in the loaded records...moving on",
                            candidateId);
                    continue;
                }

                if (!contributionsToCandByCmte.containsKey(candidateId)) {
                    logger.info("Doesn't look like candidate {} has any contributions...moving on...", candidateId);
                    continue;
                }

                Candidate candidate = context.getCandidatesMap().get(candidateId);

                try {
                    logger.info("Building network node for candidate {}", candidateId);
                    Network.NetworkNode candidateNode = new Network.NetworkNode(
                            candidate.getCandidateId(),
                            candidate.getCandidateName(),
                            candidate.getPartyDesignation(),
                            CANDIDATE_TYPE_IDENTIFIER);
                    nodes.add(candidateNode);
                } catch (Exception e) {
                    logger.error("Failed to generate candidate node for candidate {}; moving on;", candidateId, e);
                    continue;
                }

                for (String otherCandidateId : candidateIds) {
                    logger.info("Building connections between candidate {} and candidate {}", candidateId, otherCandidateId);
                    for (String cmteId : contributionsToCandByCmte.get(candidateId).keySet()) {
                        logger.info("Determing links via committee {}", cmteId);
                        if (contributionsToCandByCmte.containsKey(otherCandidateId) && contributionsToCandByCmte.get(otherCandidateId).containsKey(cmteId)) {
                            logger.info("Committee {} has contributed to both {} and {}, adding committee as node...",
                                    cmteId, candidateId, otherCandidateId);
                            Committee committee = context.getCommitteesMap().get(cmteId);

                            try {
                                logger.info("Adding network node for committee {}", cmteId);
                                Network.NetworkNode committeeNode = new Network.NetworkNode(
                                        committee.getCommitteeId(),
                                        committee.getCommitteeName(),
                                        committee.getCommitteParty(),
                                        COMMITTEE_TYPE_IDENTIFIER
                                );
                                nodes.add(committeeNode);
                            } catch (Exception e) {
                                logger.info("Failed to generate committee node; moving on;", e);
                                continue;
                            }
                            logger.info("Adding committee node to node list...");

                            logger.info("Adding links between candidates {} and {} via shared contributor {}",
                                    candidateId, otherCandidateId, cmteId);
                            Network.NetworkLink cmteToCand1Link = new Network.NetworkLink(cmteId, candidateId);
                            Network.NetworkLink cmteToCand2Link = new Network.NetworkLink(cmteId, otherCandidateId);
                            links.add(cmteToCand1Link);
                            links.add(cmteToCand2Link);
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Encountered an unexpected error while constructing graph;", e);
        }
        logger.info("Constructing graph from nodes and links objects...");
        candidateContributionNetwork = new Network(nodes, links);
        logger.info("Finished constructing contribution network...");
        return candidateContributionNetwork;
    }
}