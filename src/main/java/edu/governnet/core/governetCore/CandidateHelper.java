package edu.governnet.core.governetCore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CandidateHelper {
    final static String FILE_PREFIX = "cn";
    final static String FILE_FORMAT = "txt";
    final static String FILE_NAME = FILE_PREFIX + "." + FILE_FORMAT;

    String dataDirectory;
    List<Candidate> candidateList = new ArrayList<>();

    public CandidateHelper() {
    }

    /**
     * Generate candidate objects from the standard FEC bulk data download format.
     */
    public void buildCandidatesFromFile(String dataDirectory){
        FileReader fileReader = new FileReader();
        List<String> candidatesData = fileReader.processFile(dataDirectory, FILE_NAME);
        for (String candidateInfo : candidatesData) {
            String[] candidateInfoFields = candidateInfo.split("\\|", -1);

            List<String> candidatesProcessed = Arrays.stream(candidateInfoFields)
                    .map(field -> field.trim())
                    .collect(Collectors.toList());

            Candidate candidate = new Candidate.CandidateBuilder()
                    .candidateId(candidatesProcessed.get(0))
                    .candidateName(candidatesProcessed.get(1))
                    .partyDesignation(candidatesProcessed.get(2))
                    .electionYear(candidatesProcessed.get(3))
                    .officeState(candidatesProcessed.get(4))
                    .office(candidatesProcessed.get(5))
                    .currentDistrict(candidatesProcessed.get(6))
                    .incumbentStatus(candidatesProcessed.get(7))
                    .candidateStatus(candidatesProcessed.get(8))
                    .principleCampaignCommitteeId(candidatesProcessed.get(9))
                    .streetOne(candidatesProcessed.get(10))
                    .streetTwo(candidatesProcessed.get(11))
                    .cityOrTown(candidatesProcessed.get(12))
                    .state(candidatesProcessed.get(13))
                    .zipCode(candidatesProcessed.get(14))
                    .createCandidate();

            candidateList.add(candidate);
        }
    }

    public List<Candidate> getCandidateList() {
        return candidateList;
    }
}