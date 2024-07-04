package ca.mobilelive.investor.api.v1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Verdict {

    private static void findDuplicate(List<List<Integer>> lines) {
        int i = 1;
        for (List<Integer> row : lines) {
            final Set<Integer> finalSet = new HashSet<>();
            final Set<Integer> comparingSet = new HashSet<>();
            final StringBuffer sb = new StringBuffer();
            for (Integer integer : row) {
                if (!comparingSet.add(integer)) {
                    finalSet.add(integer);
                }
                if (!finalSet.isEmpty()) {
                    sb.append("Case #").append(i).append(":");
                    finalSet.forEach(x -> sb.append(" ").append(x));
                }
                System.out.println(sb.toString().trim());
                i++;
            }
        }
    }

}
