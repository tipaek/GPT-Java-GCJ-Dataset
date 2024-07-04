import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int noOfTestCases = input.nextInt();
        List<List<String>> listOfInput = new ArrayList<>();

        for (int i = 0; i < noOfTestCases; i++) {
            int dimension = input.nextInt();
            input.nextLine();
            List<String> list = new ArrayList<>();
            for (int j = 0; j < dimension; j++) {
                list.add(input.nextLine());
            }
            listOfInput.add(list);
        }

        int caseNumber = 1;
        for (List<String> list : listOfInput) {
            System.out.println("Case #" + caseNumber + ": " + calculateOutput(list));
            caseNumber++;
        }
    }

    private static String calculateOutput(List<String> list) {
        int dimension = list.size();
        List<Set<String>> rowSets = new ArrayList<>(dimension);
        List<Set<String>> colSets = new ArrayList<>(dimension);

        for (int i = 0; i < dimension; i++) {
            rowSets.add(new HashSet<>());
            colSets.add(new HashSet<>());
        }

        int traceSum = 0;
        int rowDup = 0;
        int colDup = 0;
        Map<String, Boolean> duplicationMap = new HashMap<>();

        for (int i = 0; i < dimension; i++) {
            String[] row = list.get(i).split(" ");
            for (int j = 0; j < dimension; j++) {
                String value = row[j];

                if (i == j) {
                    traceSum += Integer.parseInt(value);
                }

                if (!rowSets.get(i).add(value)) {
                    if (!duplicationMap.containsKey("row_" + i)) {
                        rowDup++;
                        duplicationMap.put("row_" + i, true);
                    }
                }

                if (!colSets.get(j).add(value)) {
                    if (!duplicationMap.containsKey("col_" + j)) {
                        colDup++;
                        duplicationMap.put("col_" + j, true);
                    }
                }
            }
        }

        return traceSum + " " + rowDup + " " + colDup;
    }
}