package edu.governet.core.fecdataaccess;

public class Contribution {
    private String committeeId;
    private String amendmentIndicator;
    private String reportType;
    private String primaryGeneralIndicator;
    private String microfilmLocation;
    private String transactionType;
    private String entityType;
    private String name;
    private String city;
    private String state;
    private String zip;
    private String employer;
    private String occupation;
    private String transactionDate;
    private String transactionAmmount;
    private String otherId;
    private String candidateId;
    private String transactionId;
    private String fileNumber;
    private String memoCd;
    private String memoText;
    private String subId;

    public static class ContributionBuilder {
        private String committeeId;
        private String amendmentIndicator;
        private String reportType;
        private String primaryGeneralIndicator;
        private String microfilmLocation;
        private String transactionType;
        private String entityType;
        private String name;
        private String city;
        private String state;
        private String zip;
        private String employer;
        private String occupation;
        private String transactionDate;
        private String transactionAmmount;
        private String otherId;
        private String candidateId;
        private String transactionId;
        private String fileNumber;
        private String memoCd;
        private String memoText;
        private String subId;

        public ContributionBuilder committeeId(String committeeId) {
            this.committeeId = committeeId;
            return this;
        }

        public ContributionBuilder amendmentIndicator(String amendmentIndicator) {
            this.amendmentIndicator = amendmentIndicator;
            return this;
        }

        public ContributionBuilder reportType(String reportType) {
            this.reportType = reportType;
            return this;
        }

        public ContributionBuilder primaryGeneralIndicator(String primaryGeneralIndicator) {
            this.primaryGeneralIndicator = primaryGeneralIndicator;
            return this;
        }

        public ContributionBuilder microfilmLocation(String microfilmLocation) {
            this.microfilmLocation = microfilmLocation;
            return this;
        }

        public ContributionBuilder transactionType(String transactionType) {
            this.transactionType = transactionType;
            return this;
        }

        public ContributionBuilder entityType(String entityType) {
            this.entityType = entityType;
            return this;
        }

        public ContributionBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ContributionBuilder city(String city) {
            this.city = city;
            return this;
        }

        public ContributionBuilder state(String state) {
            this.state = state;
            return this;
        }

        public ContributionBuilder zip(String zip) {
            this.zip = zip;
            return this;
        }

        public ContributionBuilder employer(String employer) {
            this.employer = employer;
            return this;
        }

        public ContributionBuilder occupation(String occupation) {
            this.occupation = occupation;
            return this;
        }

        public ContributionBuilder transactionDate(String transactionDate) {
            this.transactionDate = transactionDate;
            return this;
        }

        public ContributionBuilder transactionAmmount(String transactionAmmount) {
            this.transactionAmmount = transactionAmmount;
            return this;
        }

        public ContributionBuilder otherId(String otherId) {
            this.otherId = otherId;
            return this;
        }

        public ContributionBuilder candidateId(String candidateId) {
            this.candidateId = candidateId;
            return this;
        }

        public ContributionBuilder transactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public ContributionBuilder fileNumber(String fileNumber) {
            this.fileNumber = fileNumber;
            return this;
        }

        public ContributionBuilder memoCd(String memoCd) {
            this.memoCd = memoCd;
            return this;
        }

        public ContributionBuilder memoText(String memoText) {
            this.memoText = memoText;
            return this;
        }

        public ContributionBuilder subId(String subId) {
            this.subId = subId;
            return this;
        }

        public Contribution createContribution() {
            return new Contribution(committeeId, amendmentIndicator, reportType, primaryGeneralIndicator, microfilmLocation, transactionType, entityType, name, city, state, zip, employer, occupation, transactionDate, transactionAmmount, otherId, candidateId, transactionId, fileNumber, memoCd, memoText, subId);
        }
    }

    private Contribution(String committeeId, String amendmentIndicator, String reportType, String primaryGeneralIndicator, String microfilmLocation, String transactionType, String entityType, String name, String city, String state, String zip, String employer, String occupation, String transactionDate, String transactionAmmount, String otherId, String candidateId, String transactionId, String fileNumber, String memoCd, String memoText, String subId) {
        this.committeeId = committeeId;
        this.amendmentIndicator = amendmentIndicator;
        this.reportType = reportType;
        this.primaryGeneralIndicator = primaryGeneralIndicator;
        this.microfilmLocation = microfilmLocation;
        this.transactionType = transactionType;
        this.entityType = entityType;
        this.name = name;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.employer = employer;
        this.occupation = occupation;
        this.transactionDate = transactionDate;
        this.transactionAmmount = transactionAmmount;
        this.otherId = otherId;
        this.candidateId = candidateId;
        this.transactionId = transactionId;
        this.fileNumber = fileNumber;
        this.memoCd = memoCd;
        this.memoText = memoText;
        this.subId = subId;
    }

    public String getCommitteeId() {
        return committeeId;
    }

    public Contribution setCommitteeId(String committeeId) {
        this.committeeId = committeeId;
        return this;
    }

    public String getAmendmentIndicator() {
        return amendmentIndicator;
    }

    public Contribution setAmendmentIndicator(String amendmentIndicator) {
        this.amendmentIndicator = amendmentIndicator;
        return this;
    }

    public String getReportType() {
        return reportType;
    }

    public Contribution setReportType(String reportType) {
        this.reportType = reportType;
        return this;
    }

    public String getPrimaryGeneralIndicator() {
        return primaryGeneralIndicator;
    }

    public Contribution setPrimaryGeneralIndicator(String primaryGeneralIndicator) {
        this.primaryGeneralIndicator = primaryGeneralIndicator;
        return this;
    }

    public String getMicrofilmLocation() {
        return microfilmLocation;
    }

    public Contribution setMicrofilmLocation(String microfilmLocation) {
        this.microfilmLocation = microfilmLocation;
        return this;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public Contribution setTransactionType(String transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    public String getEntityType() {
        return entityType;
    }

    public Contribution setEntityType(String entityType) {
        this.entityType = entityType;
        return this;
    }

    public String getName() {
        return name;
    }

    public Contribution setName(String name) {
        this.name = name;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Contribution setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public Contribution setState(String state) {
        this.state = state;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public Contribution setZip(String zip) {
        this.zip = zip;
        return this;
    }

    public String getEmployer() {
        return employer;
    }

    public Contribution setEmployer(String employer) {
        this.employer = employer;
        return this;
    }

    public String getOccupation() {
        return occupation;
    }

    public Contribution setOccupation(String occupation) {
        this.occupation = occupation;
        return this;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public Contribution setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
        return this;
    }

    public String getTransactionAmmount() {
        return transactionAmmount;
    }

    public Contribution setTransactionAmmount(String transactionAmmount) {
        this.transactionAmmount = transactionAmmount;
        return this;
    }

    public String getOtherId() {
        return otherId;
    }

    public Contribution setOtherId(String otherId) {
        this.otherId = otherId;
        return this;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public Contribution setCandidateId(String candidateId) {
        this.candidateId = candidateId;
        return this;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Contribution setTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public Contribution setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
        return this;
    }

    public String getMemoCd() {
        return memoCd;
    }

    public Contribution setMemoCd(String memoCd) {
        this.memoCd = memoCd;
        return this;
    }

    public String getMemoText() {
        return memoText;
    }

    public Contribution setMemoText(String memoText) {
        this.memoText = memoText;
        return this;
    }

    public String getSubId() {
        return subId;
    }

    public Contribution setSubId(String subId) {
        this.subId = subId;
        return this;
    }

    @Override
    public String toString() {
        return "Contribution{" +
                "committeeId='" + committeeId + '\'' +
                ", amendmentIndicator='" + amendmentIndicator + '\'' +
                ", reportType='" + reportType + '\'' +
                ", primaryGeneralIndicator='" + primaryGeneralIndicator + '\'' +
                ", microfilmLocation='" + microfilmLocation + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", entityType='" + entityType + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", employer='" + employer + '\'' +
                ", occupation='" + occupation + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                ", transactionAmmount='" + transactionAmmount + '\'' +
                ", otherId='" + otherId + '\'' +
                ", candidateId='" + candidateId + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", fileNumber='" + fileNumber + '\'' +
                ", memoCd='" + memoCd + '\'' +
                ", memoText='" + memoText + '\'' +
                ", subId='" + subId + '\'' +
                '}';
    }
}
