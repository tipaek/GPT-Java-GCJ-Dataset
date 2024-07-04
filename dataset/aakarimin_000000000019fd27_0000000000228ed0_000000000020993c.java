import java.util.*;

public class Solution {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        List<List<Integer>> rows = new ArrayList<>();
        String readString = scanner.nextLine();
        try {
            while (readString != null) {
                String[] arrRowItems = readString.split(" ");
                List<Integer> row = new ArrayList<>(arrRowItems.length);
                for (String arrRowItem : arrRowItems) {
                    row.add(Integer.valueOf(arrRowItem));
                }
                rows.add(row);

                if (scanner.hasNextLine()) {
                    readString = scanner.nextLine();
                } else
                    readString = null;
            }
        } catch (NumberFormatException e) {
            // ignore
        }

        Solution.findDuplicate(rows);
        scanner.close();
    }

    private static void findDuplicate(List<List<Integer>> lines) {
        int i = 1;
        for (List<Integer> row : lines) {
            final Set<Integer> finalSet = new HashSet<>();
            final Set<Integer> comparingSet = new HashSet<>();
            final StringBuffer sb = new StringBuffer();
            for (int k = 0; k < row.size(); k++) {
                if (!comparingSet.add(row.get(k))) {
                    finalSet.add(row.get(k));
                }
                if (!finalSet.isEmpty()) {
                    sb.append("Case #").append(i).append(":");
                    row.forEach(x -> sb.append(" ").append(x));
                    i++;
                }
            }
            System.out.println(sb.toString().trim());
        }
    }
}
