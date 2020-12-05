package edu.governet.core.api;

import edu.governet.core.AppInit;
import edu.governet.core.fecdataaccess.Candidate;
import edu.governet.core.fecdataaccess.Committee;
import edu.governet.core.fecdataaccess.Contribution;

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

    public List<Committee> getCommittees() {
        return electionData.getCommittees();
    }

    public List<Contribution> getContributions() {
        return electionData.getContributions();
    }
}
