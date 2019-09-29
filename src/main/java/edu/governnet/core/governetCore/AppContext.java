package edu.governnet.core.governetCore;

import java.util.List;

public class AppContext {
    private AppInit electionData;

    AppContext(AppInit appInit){
        electionData = appInit;
        electionData.initApp();
    }

    public List<Candidate> getCandidates(){
        return electionData.getCandidates();
    }

    public List<Committee> getCommittees() {
        return electionData.getCommittees();
    }

    public List<Contribution> getContributions() {
        return electionData.getContributions();
    }
}
