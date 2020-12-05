package edu.governet.core.fecdataaccess;

public class Committee {
    private String committeeId;
    private String committeeName;
    private String treasurerName;
    private String streetOne;
    private String streetTwo;
    private String cityOrTown;
    private String state;
    private String zip;
    private String committeeDesignation;
    private String committeeType;
    private String committeeParty;
    private String filingFrequency;
    private String organizationType;
    private String organizationName;
    private String candidateId;

    public static class CommitteeBuilder {
        private String committeeId;
        private String committeeName;
        private String treasurerName;
        private String streetOne;
        private String streetTwo;
        private String cityOrTown;
        private String state;
        private String zip;
        private String committeeDesignation;
        private String committeeType;
        private String committeeParty;
        private String filingFrequency;
        private String organizationType;
        private String organizationName;
        private String candidateId;

        public CommitteeBuilder committeeId(String committeeId) {
            this.committeeId = committeeId;
            return this;
        }

        public CommitteeBuilder committeeName(String committeeName) {
            this.committeeName = committeeName;
            return this;
        }

        public CommitteeBuilder treasurerName(String treasurerName) {
            this.treasurerName = treasurerName;
            return this;
        }

        public CommitteeBuilder streetOne(String streetOne) {
            this.streetOne = streetOne;
            return this;
        }

        public CommitteeBuilder streetTwo(String streetTwo) {
            this.streetTwo = streetTwo;
            return this;
        }

        public CommitteeBuilder cityOrTown(String cityOrTown) {
            this.cityOrTown = cityOrTown;
            return this;
        }

        public CommitteeBuilder state(String state) {
            this.state = state;
            return this;
        }

        public CommitteeBuilder zip(String zip) {
            this.zip = zip;
            return this;
        }

        public CommitteeBuilder committeeDesignation(String committeeDesignation) {
            this.committeeDesignation = committeeDesignation;
            return this;
        }

        public CommitteeBuilder committeeType(String committeeType) {
            this.committeeType = committeeType;
            return this;
        }

        public CommitteeBuilder committeeParty(String committeeParty) {
            this.committeeParty = committeeParty;
            return this;
        }

        public CommitteeBuilder filingFrequency(String filingFrequency) {
            this.filingFrequency = filingFrequency;
            return this;
        }

        public CommitteeBuilder organizationType(String organizationType) {
            this.organizationType = organizationType;
            return this;
        }

        public CommitteeBuilder organizationName(String organizationName) {
            this.organizationName = organizationName;
            return this;
        }

        public CommitteeBuilder candidateId(String candidateId) {
            this.candidateId = candidateId;
            return this;
        }

        public Committee createCommittee() {
            return new Committee(committeeId, committeeName, treasurerName, streetOne, streetTwo, cityOrTown, state, zip, committeeDesignation, committeeType, committeeParty, filingFrequency, organizationType, organizationName, candidateId);
        }
    }


    private Committee(String committeeId, String committeeName, String treasurerName, String streetOne, String streetTwo, String cityOrTown, String state, String zip, String committeeDesignation, String committeeType, String committeeParty, String filingFrequency, String organizationType, String organizationName, String candidateId) {
        this.committeeId = committeeId;
        this.committeeName = committeeName;
        this.treasurerName = treasurerName;
        this.streetOne = streetOne;
        this.streetTwo = streetTwo;
        this.cityOrTown = cityOrTown;
        this.state = state;
        this.zip = zip;
        this.committeeDesignation = committeeDesignation;
        this.committeeType = committeeType;
        this.committeeParty = committeeParty;
        this.filingFrequency = filingFrequency;
        this.organizationType = organizationType;
        this.organizationName = organizationName;
        this.candidateId = candidateId;
    }

    public String getCommitteeId() {
        return committeeId;
    }

    public Committee setCommitteeId(String committeeId) {
        this.committeeId = committeeId;
        return this;
    }

    public String getCommitteeName() {
        return committeeName;
    }

    public Committee setCommitteeName(String committeeName) {
        this.committeeName = committeeName;
        return this;
    }

    public String getTreasurerName() {
        return treasurerName;
    }

    public Committee setTreasurerName(String treasurerName) {
        this.treasurerName = treasurerName;
        return this;
    }

    public String getStreetOne() {
        return streetOne;
    }

    public Committee setStreetOne(String streetOne) {
        this.streetOne = streetOne;
        return this;
    }

    public String getStreetTwo() {
        return streetTwo;
    }

    public Committee setStreetTwo(String streetTwo) {
        this.streetTwo = streetTwo;
        return this;
    }

    public String getCityOrTown() {
        return cityOrTown;
    }

    public Committee setCityOrTown(String cityOrTown) {
        this.cityOrTown = cityOrTown;
        return this;
    }

    public String getState() {
        return state;
    }

    public Committee setState(String state) {
        this.state = state;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public Committee setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public String getCommitteeDesignation() {
        return committeeDesignation;
    }

    public Committee setCommitteeDesignation(String committeeDesignation) {
        this.committeeDesignation = committeeDesignation;
        return this;
    }

    public String getCommitteeType() {
        return committeeType;
    }

    public Committee setCommitteeType(String committeeType) {
        this.committeeType = committeeType;
        return this;
    }

    public String getCommitteParty() {
        return committeeParty;
    }

    public Committee setCommitteParty(String committeeParty) {
        this.committeeParty = committeeParty;
        return this;
    }

    public String getFilingFrequency() {
        return filingFrequency;
    }

    public Committee setFilingFrequency(String filingFrequency) {
        this.filingFrequency = filingFrequency;
        return this;
    }

    public String getOrganizationType() {
        return organizationType;
    }

    public Committee setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
        return this;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public Committee setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public Committee setCandidateId(String candidateId) {
        this.candidateId = candidateId;
        return this;
    }

    @Override
    public String toString() {
        return "Committee{" +
                "committeeId='" + committeeId + '\'' +
                ", committeeName='" + committeeName + '\'' +
                ", treasurerName='" + treasurerName + '\'' +
                ", streetOne='" + streetOne + '\'' +
                ", streetTwo='" + streetTwo + '\'' +
                ", cityOrTown='" + cityOrTown + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", committeeDesignation='" + committeeDesignation + '\'' +
                ", committeeType='" + committeeType + '\'' +
                ", committeeParty='" + committeeParty + '\'' +
                ", filingFrequency='" + filingFrequency + '\'' +
                ", organizationType='" + organizationType + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", candidateId='" + candidateId + '\'' +
                '}';
    }
}
