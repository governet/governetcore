package edu.governnet.core.governetCore;

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

    public AppInit(){

    }

    public AppInit withDataDirectory(String dataDirectory) {
        this.dataDirectory = dataDirectory;
        return this;
    }

    private void initCandidates(){
        CandidateHelper candidateHelper = new CandidateHelper();
        candidateHelper.buildCandidatesFromFile(dataDirectory);
        candidates = candidateHelper.getCandidateList();
    }

    private void initCommittees(){
        CommitteeHelper committeeHelper = new CommitteeHelper();
        committeeHelper.buildCommitteesFromFile(dataDirectory);
        committees = committeeHelper.getCommitteeList();
    }

    private void initContributions(){
        ContributionHelper contributionHelper = new ContributionHelper();
        contributionHelper.buildContributionsFromFile(dataDirectory);
        contributions= contributionHelper.getContributionList();
    }

    public void initApp(){
        initCandidates();
        initCommittees();
        initContributions();
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public List<Committee> getCommittees() {
        return committees;
    }

    public List<Contribution> getContributions() {
        return contributions;
    }
}
