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
    private static final String CMTE_PREFIX = "cm";
    private static final String CAND_PREFIX = "cn";
    private static final String CONT_PREFIX = "itpas2";
    private static final String FILE_SUFFIX = ".txt";

    private FileReader fileReader = new FileReader();

    private String dataDirectory;
    private List<Candidate> candidates;
    private List<Committee> committees;
    private List<Contribution> contributions;

    public AppInit(String dataDirectory){
        this.dataDirectory = dataDirectory;
    }

    private void initCandidates(){
        String candidateFile = CAND_PREFIX + FILE_SUFFIX;
        List<String> candidateList = fileReader.processFile(dataDirectory, candidateFile);
        CandidateHelper candidateHelper = new CandidateHelper(candidateList);
        candidateHelper.buildCandidatesFromFile();
        candidates = candidateHelper.getCandidateList();
    }

    private void initCommittees(){
        String committeeFile = CMTE_PREFIX + FILE_SUFFIX;
        List<String> committeeList = fileReader.processFile(dataDirectory, committeeFile);
        CommitteeHelper committeeHelper = new CommitteeHelper(committeeList);
        committeeHelper.buildCommitteesFromFile();
        committees = committeeHelper.getCommitteeList();
    }

    private void initContributions(){
        String contributionsFile = CONT_PREFIX + FILE_SUFFIX;
        List<String> contributionList = fileReader.processFile(dataDirectory, contributionsFile);
        ContributionHelper contributionHelper = new ContributionHelper(contributionList);
        contributionHelper.builContributionsFromFile();
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
