package edu.governet.core.api;

import java.util.*;
import java.util.stream.Collectors;

import edu.governet.core.AppInit;
import edu.governet.core.fecdataaccess.Candidate;
import edu.governet.core.fecdataaccess.Committee;
import edu.governet.core.fecdataaccess.Contribution;
import edu.governet.core.fecdataaccess.Network;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    /**
     * Initialize the application by loading the data from file at runtime,
     * using the AppInit and AppContext for dependency and configuration injection.
     */
    private static final String DATA_SUBDIRECTORY = "/data/";
    private static final String CROSS_ORIGIN_ACCEPT_LOCAL = "http://localhost:8081";

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
                        c.getCandidateId(), c.getCandidateName(), "female", c.getPartyDesignation()))
                .collect(Collectors.toList());

        return new Network(nodes, links);
    }

    public int getRandomNumber() {
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
}