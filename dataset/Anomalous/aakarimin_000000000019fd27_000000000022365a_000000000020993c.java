package ca.mobilelive.investor.api.v1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Verdict {

    private static void findDuplicate(List<List<Integer>> lines) {
        int caseNumber = 1;
        for (List<Integer> row : lines) {
            Set<Integer> duplicates = new HashSet<>();
            Set<Integer> seen = new HashSet<>();
            StringBuilder result = new StringBuilder();

            for (Integer number : row) {
                if (!seen.add(number)) {
                    duplicates.add(number);
                }
            }

            if (!duplicates.isEmpty()) {
                result.append("Case #").append(caseNumber).append(":");
                for (Integer duplicate : duplicates) {
                    result.append(" ").append(duplicate);
                }
            }

            System.out.println(result.toString().trim());
            caseNumber++;
        }
    }

}