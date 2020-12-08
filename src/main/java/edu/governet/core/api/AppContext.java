package edu.governet.core.api;

import edu.governet.core.AppInit;
import edu.governet.core.fecdataaccess.Candidate;
import edu.governet.core.fecdataaccess.Committee;
import edu.governet.core.fecdataaccess.Contribution;

import java.util.HashMap;
import java.util.List;

public class AppContext {
    private final AppInit electionData;

    AppContext(AppInit appInit){
        electionData = appInit;
        electionData.initApp();
    }

    public List<Candidate> getCandidates(){
        return electionData.getCandidates();
    }
    public HashMap<String, Candidate> getCandidatesMap() { return electionData.getCandidatesMap(); }

    public List<Committee> getCommittees() {
        return electionData.getCommittees();
    }
    public HashMap<String, Committee> getCommitteesMap() { return electionData.getCommitteesMap(); }

    public List<Contribution> getContributions() {
        return electionData.getContributions();
    }
    public HashMap<String, Contribution> getContributionsMap() { return electionData.getContributionsMap(); }
}
