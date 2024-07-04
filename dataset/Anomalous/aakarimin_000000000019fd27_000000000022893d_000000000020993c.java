import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> rows = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] items = line.split(" ");
            List<Integer> row = new ArrayList<>();
            
            try {
                for (String item : items) {
                    row.add(Integer.parseInt(item));
                }
            } catch (NumberFormatException e) {
                // Ignore invalid input
                continue;
            }

            System.out.println("ROW: " + row.size());
            rows.add(row);
        }

        System.out.println("ROWS: " + rows.size());
        int caseNumber = 1;

        for (List<Integer> row : rows) {
            Set<Integer> duplicates = new HashSet<>();
            Set<Integer> seen = new HashSet<>();
            StringBuilder output = new StringBuilder();

            for (Integer num : row) {
                if (!seen.add(num)) {
                    duplicates.add(num);
                }
            }

            if (!duplicates.isEmpty()) {
                output.append("Case #").append(caseNumber).append(":");
                for (Integer num : row) {
                    output.append(" ").append(num);
                }
                System.out.println(output.toString().trim());
                caseNumber++;
            }
        }

        scanner.close();
    }
}