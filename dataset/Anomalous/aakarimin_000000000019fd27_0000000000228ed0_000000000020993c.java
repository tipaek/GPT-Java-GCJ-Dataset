import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> rows = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String readString = scanner.nextLine();
            if (readString.isEmpty()) break;

            String[] arrRowItems = readString.split(" ");
            List<Integer> row = new ArrayList<>();
            for (String arrRowItem : arrRowItems) {
                try {
                    row.add(Integer.parseInt(arrRowItem));
                } catch (NumberFormatException e) {
                    // Ignore invalid integers
                }
            }
            rows.add(row);
        }

        findDuplicate(rows);
        scanner.close();
    }

    private static void findDuplicate(List<List<Integer>> lines) {
        int caseNumber = 1;
        for (List<Integer> row : lines) {
            Set<Integer> finalSet = new HashSet<>();
            Set<Integer> comparingSet = new HashSet<>();
            StringBuilder sb = new StringBuilder();

            for (Integer value : row) {
                if (!comparingSet.add(value)) {
                    finalSet.add(value);
                }
            }

            if (!finalSet.isEmpty()) {
                sb.append("Case #").append(caseNumber).append(":");
                for (Integer value : row) {
                    sb.append(" ").append(value);
                }
                caseNumber++;
                System.out.println(sb.toString().trim());
            }
        }
    }
}