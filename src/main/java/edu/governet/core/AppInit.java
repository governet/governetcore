package edu.governet.core;

import edu.governet.core.fecdataaccess.*;
import edu.governet.core.fecdataaccess.fileloader.CandidateLoader;
import edu.governet.core.fecdataaccess.fileloader.CommitteeLoader;
import edu.governet.core.fecdataaccess.fileloader.ContributionLoader;

import java.util.HashMap;
import java.util.List;

public class AppInit {
    /**
     * Initialize the app from a set of files.
     * This should be a superclass, that is subclassed; so we can either
     * load the data from file, and pass it to the context;
     * or, we can load it from serialized data, or a db, and pass to the context.
     * This way we're seperating responsiblity for loading the data from the actually data processing.
     */
    private String dataDirectory;

    private List<Candidate> candidates;
    private List<Committee> committees;
    private List<Contribution> contributions;

    private HashMap<String, Candidate> candidatesMap = new HashMap<>();
    private HashMap<String, Committee> committeeMap = new HashMap<>();
    private HashMap<String, Contribution> contributionsMap = new HashMap<>();

    public AppInit(){

    }

    public AppInit withDataDirectory(String dataDirectory) {
        this.dataDirectory = dataDirectory;
        return this;
    }

    public void initApp(){
        initCandidates();
        initCommittees();
        initContributions();
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public HashMap<String, Candidate> getCandidatesMap() { return candidatesMap; }

    public List<Committee> getCommittees() {
        return committees;
    }

    public HashMap<String, Committee> getCommitteesMap() { return committeeMap; }

    public List<Contribution> getContributions() {
        return contributions;
    }

    public HashMap<String, Contribution> getContributionsMap() { return contributionsMap; }

    private void initCandidates(){
        CandidateLoader candidateLoader = new CandidateLoader();
        candidateLoader.buildCandidatesFromFile(dataDirectory);
        candidates = candidateLoader.getCandidateList();
        candidates.forEach(
                c -> candidatesMap.put(c.getCandidateId(), c)
        );
    }

    private void initCommittees(){
        CommitteeLoader committeeHelper = new CommitteeLoader();
        committeeHelper.buildCommitteesFromFile(dataDirectory);
        committees = committeeHelper.getCommitteeList();
        committees.forEach(
                c -> committeeMap.put(c.getCommitteeId(), c)
        );
    }

    private void initContributions(){
        ContributionLoader contributionLoader = new ContributionLoader();
        contributionLoader.buildContributionsFromFile(dataDirectory);
        contributions= contributionLoader.getContributionList();
        contributions.forEach(
                c -> contributionsMap.put(c.getTransactionId(), c)
        );
    }
}
