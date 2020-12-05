package edu.governet.core;

import edu.governet.core.fecdataaccess.*;
import edu.governet.core.fecdataaccess.fileloader.CandidateLoader;
import edu.governet.core.fecdataaccess.fileloader.CommitteeLoader;
import edu.governet.core.fecdataaccess.fileloader.ContributionLoader;

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
        CandidateLoader candidateLoader = new CandidateLoader();
        candidateLoader.buildCandidatesFromFile(dataDirectory);
        candidates = candidateLoader.getCandidateList();
    }

    private void initCommittees(){
        CommitteeLoader committeeHelper = new CommitteeLoader();
        committeeHelper.buildCommitteesFromFile(dataDirectory);
        committees = committeeHelper.getCommitteeList();
    }

    private void initContributions(){
        ContributionLoader contributionLoader = new ContributionLoader();
        contributionLoader.buildContributionsFromFile(dataDirectory);
        contributions= contributionLoader.getContributionList();
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
