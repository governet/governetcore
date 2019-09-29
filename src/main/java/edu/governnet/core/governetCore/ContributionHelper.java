package edu.governnet.core.governetCore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContributionHelper {
    List<String> contributionFile;
    List<Contribution> contributionList = new ArrayList<>();


    public ContributionHelper(List<String> contributionList) {
        this.contributionFile = contributionList;
    }

    public void builContributionsFromFile(){
        for (String contributionInfo : contributionFile) {
            String[] contributionInfoFields = contributionInfo.split("\\|", -1);

            List<String> contributionsProcessed = Arrays.stream(contributionInfoFields)
                    .map(field -> field.trim())
                    .collect(Collectors.toList());

            Contribution contribution = new Contribution.ContributionBuilder()
                    .committeeId(contributionsProcessed.get(0))
                    .amendmentIndicator(contributionsProcessed.get(1))
                    .reportType(contributionsProcessed.get(2))
                    .primaryGeneralIndicator(contributionsProcessed.get(3))
                    .microfilmLocation(contributionsProcessed.get(4))
                    .transactionType(contributionsProcessed.get(5))
                    .entityType(contributionsProcessed.get(6))
                    .name(contributionsProcessed.get(7))
                    .city(contributionsProcessed.get(8))
                    .state(contributionsProcessed.get(9))
                    .zip(contributionsProcessed.get(10))
                    .employer(contributionsProcessed.get(11))
                    .occupation(contributionsProcessed.get(12))
                    .transactionDate(contributionsProcessed.get(13))
                    .transactionAmmount(contributionsProcessed.get(14))
                    .otherId(contributionsProcessed.get(15))
                    .candidateId(contributionsProcessed.get(16))
                    .transactionId(contributionsProcessed.get(17))
                    .fileNumber(contributionsProcessed.get(18))
                    .memoCd(contributionsProcessed.get(19))
                    .memoText(contributionsProcessed.get(20))
                    .subId(contributionsProcessed.get(21))
                    .createContribution();

            contributionList.add(contribution);
        }
    }

    public List<Contribution> getContributionList() {
        return contributionList;
    }
}