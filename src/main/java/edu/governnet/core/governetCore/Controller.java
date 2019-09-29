package edu.governnet.core.governetCore;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.context.index.CandidateComponentsIndex;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    /**
     * Initialize the application by loading the data from file at runtime,
     * using the AppInit and AppContext for dependency and configuration injection.
     */
    AppInit init = new AppInit().withDataDirectory("/data/");
    AppContext context = new AppContext(init);

    @RequestMapping("/candidates")
    public List<Candidate> candidates(
            @RequestParam(value="state", defaultValue="pa") String state){
        return context.getCandidates();
    }

    @RequestMapping(path="/candidates/{candId}")
    public List<Candidate> candidate(
            @PathVariable String candId){
        return context.getCandidates()
                .stream()
                .filter(c -> c.getCandidateId().matches(candId))
                .collect(Collectors.toList());
    }

    @RequestMapping(path="/candidates/{candId}/committees")
    public List<Committee> candCmteLinkage(
            @PathVariable String candId){
        return context.getCommittees()
                .stream()
                .filter(c -> c.getCandidateId().matches(candId))
                .collect(Collectors.toList());
    }

    @RequestMapping("/candidates/{candId}/contributions")
    public List<Contribution> contributionsByCandidate(
            @PathVariable String candId){
        return context.getContributions()
                .stream()
                .filter(c -> c.getCandidateId().matches(candId))
                .collect(Collectors.toList());
    }

    @RequestMapping("/committees")
    public List<Committee> committees(
            @RequestParam(value="state", defaultValue="pa") String state){
        return context.getCommittees();
    }

    @RequestMapping("/committees/{cmteId}")
    public List<Committee> committee(
            @PathVariable String cmteId){
        return context.getCommittees()
                .stream()
                .filter(c -> c.getCommitteeId().matches(cmteId))
                .collect(Collectors.toList());
    }

    @RequestMapping("/committees/{cmteId}/candidates")
    public List<Candidate> cmteCandLinkage(
            @PathVariable String cmteId){

        List<String> candidateIds = context.getContributions()
                .stream()
                .filter(c -> c.getCommitteeId().matches(cmteId))
                .map(c -> c.getCandidateId())
                .collect(Collectors.toList());

        List<Candidate> candidates = context.getCandidates()
                .stream()
                .filter(c -> candidateIds.contains(c.getCandidateId()))
                .collect(Collectors.toList());

        return candidates;
    }

    @RequestMapping("/committees/{cmteId}/contributions")
    public List<Contribution> contributionsByCommittee(
            @PathVariable String cmteId){
        return context.getContributions()
                .stream()
                .filter(c -> c.getCommitteeId().matches(cmteId))
                .collect(Collectors.toList());
    }

    @RequestMapping("/contributions")
    public List<Contribution> contributions(
            @RequestParam(value="state", defaultValue="pa") String state){
        return context.getContributions();
    }

    @RequestMapping("/contributions/{contId}")
    public List<Contribution> contribution(
            @PathVariable String contId){
        return context.getContributions()
                .stream()
                .filter(c -> c.getTransactionId().matches(contId))
                .collect(Collectors.toList());
    }
}