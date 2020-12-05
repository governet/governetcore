package edu.governet.core.fecdataaccess;

import edu.governet.core.api.AppContext;

import java.util.List;
import java.util.stream.Collectors;

public class ElectoralContest {

    private AppContext context;

    private String electionYear;
    private String primaryIndicator;
    private String state;

    private String district;

    public List<Candidate> candidates;
    public List<Committee> committees;
    public List<Contribution> contributions;

    public ElectoralContest(AppContext context, String electionYear, String primaryIndicator, String state){
        this.context = context;
        this.electionYear = electionYear;
        this.primaryIndicator = primaryIndicator;
        this.state = state;
    }

    public ElectoralContest withDistrict(String district) {
        this.district = district;
        return this;
    }

    public ElectoralContest build(){
        this.filterCandidates();
        this.filterContributions();
        this.filterCommittees();
        return this;
    }

    private void filterCandidates() {
        candidates = context.getCandidates()
                .stream()
                .filter(c -> c.getElectionYear().equals(electionYear))
                .filter(c -> c.getState().equals(state))
                .collect(Collectors.toList());
    }

    private void filterContributions() {
        contributions = context.getContributions().stream()
                .filter(cont -> cont.getPrimaryGeneralIndicator().equals(primaryIndicator))
                .filter(cont -> candidates.stream()
                        .anyMatch(cand ->
                                cont.getCandidateId().equals(cand.getCandidateId())))
                .collect(Collectors.toList());
    }

    private void filterCommittees() {
        committees = context.getCommittees().stream()
                .filter(cmte -> contributions
                        .stream()
                        .anyMatch(cont ->
                                cmte.getCommitteeId().equals(cont.getCommitteeId())))
                .collect(Collectors.toList());
    }

    int calculateTotalSpending() {
        return contributions.stream()
                .map(cont -> new Integer(cont.getTransactionAmmount()))
                .reduce(0, Integer::sum);
    }
}
