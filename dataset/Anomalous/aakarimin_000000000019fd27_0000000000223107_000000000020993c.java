import java.util.*;

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
                System.out.println(result.toString().trim());
            } else {
                System.out.println("Case #" + caseNumber + ":");
            }

            caseNumber++;
        }
    }

    public static void main(String[] args) {
        // Example usage
        List<List<Integer>> lines = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(1, 2, 2, 3, 4),
                Arrays.asList(5, 5, 5, 6, 7)
        );

        findDuplicate(lines);
    }
}