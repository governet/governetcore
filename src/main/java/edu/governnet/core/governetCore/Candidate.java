package edu.governnet.core.governetCore;

public class Candidate {
    private String candidateId;
    private String candidateName;
    private String partyDesignation;
    private String electionYear;
    private String officeState;
    private String office;
    private String currentDistrict;
    private String incumbentStatus;
    private String candidateStatus;
    private String streetOne;
    private String streetTwo;
    private String cityOrTown;
    private String state;
    private String zipCode;
    private String principleCampaignCommitteeId;

    public static class CandidateBuilder {
        private String candidateId;
        private String candidateName;
        private String partyDesignation;
        private String electionYear;
        private String officeState;
        private String office;
        private String currentDistrict;
        private String incumbentStatus;
        private String candidateStatus;
        private String streetOne;
        private String streetTwo;
        private String cityOrTown;
        private String state;
        private String zipCode;
        private String principleCampaignCommitteeId;

        public CandidateBuilder officeState(String officeState) {
            this.officeState = officeState;
            return this;
        }

        public CandidateBuilder office(String office) {
            this.office = office;
            return this;
        }

        public CandidateBuilder incumbentStatus(String incumbentStatus) {
            this.incumbentStatus = incumbentStatus;
            return this;
        }

        public CandidateBuilder candidateId(String candidateId) {
            this.candidateId = candidateId;
            return this;
        }

        public CandidateBuilder candidateName(String candidateName) {
            this.candidateName = candidateName;
            return this;
        }

        public CandidateBuilder partyDesignation(String partyDesignation) {
            this.partyDesignation = partyDesignation;
            return this;
        }

        public CandidateBuilder candidateStatus(String candidateStatus) {
            this.candidateStatus = candidateStatus;
            return this;
        }

        public CandidateBuilder streetOne(String streetOne) {
            this.streetOne = streetOne;
            return this;
        }

        public CandidateBuilder streetTwo(String streetTwo) {
            this.streetTwo = streetTwo;
            return this;
        }

        public CandidateBuilder cityOrTown(String cityOrTown) {
            this.cityOrTown = cityOrTown;
            return this;
        }

        public CandidateBuilder state(String state) {
            this.state = state;
            return this;
        }

        public CandidateBuilder zipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public CandidateBuilder principleCampaignCommitteeId(String principleCampaignCommitteeId) {
            this.principleCampaignCommitteeId = principleCampaignCommitteeId;
            return this;
        }

        public CandidateBuilder electionYear(String electionYear) {
            this.electionYear = electionYear;
            return this;
        }

        public CandidateBuilder currentDistrict(String currentDistrict) {
            this.currentDistrict = currentDistrict;
            return this;
        }

        public Candidate createCandidate() {
            return new Candidate(this);
        }
    }

    private Candidate (CandidateBuilder builder)
    {
        this.candidateId = builder.candidateId;
        this.candidateName = builder.candidateName;
        this.partyDesignation = builder.partyDesignation;
        this.candidateStatus = builder.candidateStatus;
        this.streetOne = builder.streetOne;
        this.streetTwo = builder.streetTwo;
        this.cityOrTown = builder.cityOrTown;
        this.state = builder.state;
        this.zipCode = builder.zipCode;
        this.principleCampaignCommitteeId = builder.principleCampaignCommitteeId;
        this.electionYear = builder.electionYear;
        this.officeState = builder.officeState;
        this.office = builder.office;
        this.incumbentStatus = builder.incumbentStatus;
        this.currentDistrict = builder.currentDistrict;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public Candidate setCandidateId(String candidateId) {
        this.candidateId = candidateId;
        return this;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public Candidate setCandidateName(String candidateName) {
        this.candidateName = candidateName;
        return this;
    }

    public String getPartyDesignation() {
        return partyDesignation;
    }

    public Candidate setPartyDesignation(String partyDesignation) {
        this.partyDesignation = partyDesignation;
        return this;
    }

    public String getPartyDesignation2() {
        return partyDesignation;
    }

    public Candidate setPartyDesignation2(String partyDesignation) {
        this.partyDesignation = partyDesignation;
        return this;
    }

    public String getCandidateStatus() {
        return candidateStatus;
    }

    public Candidate setCandidateStatus(String candidateStatus) {
        this.candidateStatus = candidateStatus;
        return this;
    }

    public String getStreetOne() {
        return streetOne;
    }

    public Candidate setStreetOne(String streetOne) {
        this.streetOne = streetOne;
        return this;
    }

    public String getStreetTwo() {
        return streetTwo;
    }

    public Candidate setStreetTwo(String streetTwo) {
        this.streetTwo = streetTwo;
        return this;
    }

    public String getCityOrTown() {
        return cityOrTown;
    }

    public Candidate setCityOrTown(String cityOrTown) {
        this.cityOrTown = cityOrTown;
        return this;
    }

    public String getState() {
        return state;
    }

    public Candidate setState(String state) {
        this.state = state;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Candidate setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getPrincipleCampaignCommitteeId() {
        return principleCampaignCommitteeId;
    }

    public Candidate setPrincipleCampaignCommitteeId(String principleCampaignCommitteeId) {
        this.principleCampaignCommitteeId = principleCampaignCommitteeId;
        return this;
    }

    public String getElectionYear() {
        return electionYear;
    }

    public Candidate setElectionYear(String electionYear) {
        this.electionYear = electionYear;
        return this;
    }

    public String getCurrentDistrict() {
        return currentDistrict;
    }

    public Candidate setCurrentDistrict(String currentDistrict) {
        this.currentDistrict = currentDistrict;
        return this;
    }


    public String getOfficeState() {
        return officeState;
    }

    public Candidate setOfficeState(String officeState) {
        this.officeState = officeState;
        return this;
    }

    public String getOffice() {
        return office;
    }

    public Candidate setOffice(String office) {
        this.office = office;
        return this;
    }

    public String getIncumbentStatus() {
        return incumbentStatus;
    }

    public Candidate setIncumbentStatus(String incumbentStatus) {
        this.incumbentStatus = incumbentStatus;
        return this;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "candidateId='" + candidateId + '\'' +
                ", candidateName='" + candidateName + '\'' +
                ", partyDesignation='" + partyDesignation + '\'' +
                ", electionYear='" + electionYear + '\'' +
                ", officeState='" + officeState + '\'' +
                ", office='" + office + '\'' +
                ", currentDistrict='" + currentDistrict + '\'' +
                ", incumbentStatus='" + incumbentStatus + '\'' +
                ", candidateStatus='" + candidateStatus + '\'' +
                ", streetOne='" + streetOne + '\'' +
                ", streetTwo='" + streetTwo + '\'' +
                ", cityOrTown='" + cityOrTown + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", principleCampaignCommitteeId='" + principleCampaignCommitteeId + '\'' +
                '}';
    }
}
