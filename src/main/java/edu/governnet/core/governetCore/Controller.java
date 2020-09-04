package edu.governnet.core.governetCore;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.context.index.CandidateComponentsIndex;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    /**
     * Initialize the application by loading the data from file at runtime,
     * using the AppInit and AppContext for dependency and configuration injection.
     */
    AppInit init = new AppInit().withDataDirectory("/data/");
    AppContext context = new AppContext(init);

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/candidates")
    public List<Candidate> candidates(
            @RequestParam(value="state", defaultValue="pa") String state){
        return context.getCandidates();
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(path="/candidates/{candId}")
    public List<Candidate> candidate(
            @PathVariable String candId){
        return context.getCandidates()
                .stream()
                .filter(c -> c.getCandidateId().matches(candId))
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(path="/candidates/{candId}/committees")
    public List<Committee> candCmteLinkage(
            @PathVariable String candId){
        return context.getCommittees()
                .stream()
                .filter(c -> c.getCandidateId().matches(candId))
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:8081")
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

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/candidates/{candId}/contributions")
    public List<Contribution> contributionsByCandidate(
            @PathVariable String candId){
        return context.getContributions()
                .stream()
                .filter(c -> c.getCandidateId().matches(candId))
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/committees")
    public List<Committee> committees(
            @RequestParam(value="state", defaultValue="pa") String state){
        return context.getCommittees();
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/committees/{cmteId}")
    public List<Committee> committee(
            @PathVariable String cmteId){
        return context.getCommittees()
                .stream()
                .filter(c -> c.getCommitteeId().matches(cmteId))
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:8081")
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

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/committees/{cmteId}/contributions")
    public List<Contribution> contributionsByCommittee(
            @PathVariable String cmteId){
        return context.getContributions()
                .stream()
                .filter(c -> c.getCommitteeId().matches(cmteId))
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/contributions")
    public List<Contribution> contributions(
            @RequestParam(value="state", defaultValue="pa") String state){
        return context.getContributions();
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/contributions/{contId}")
    public List<Contribution> contribution(
            @PathVariable String contId){
        return context.getContributions()
                .stream()
                .filter(c -> c.getTransactionId().matches(contId))
                .collect(Collectors.toList());
    }
}