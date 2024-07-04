import java.util.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        int noOfTestCases = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int U = scanner.nextInt();
        for (int testCaseNumber = 0; testCaseNumber < noOfTestCases; testCaseNumber++) {
            Map<Integer, Set<String>> integerListMap = new TreeMap<>();
            for (int i=0; i < 10000; i++) {
                int M = scanner.nextInt();
                String UStr = scanner.next();
                if (M < 11) {
                    Set<String> stringList = integerListMap.getOrDefault(M, new TreeSet<>());
                    integerListMap.put(M, stringList);
                    stringList.add(UStr);
                }
            }
            System.out.println("Case #" + (testCaseNumber + 1) + ": " + solve(integerListMap));
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        }
        scanner.close();
    }

    public static String solve(Map<Integer, Set<String>> integerListMap) {
        Set<String> processedAlphabets = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, Set<String>> e : integerListMap.entrySet()) {
            e.getValue().removeAll(processedAlphabets);
            String unique = e.getValue().iterator().next();
            if(unique.length() > 1) {
                for (String procc : processedAlphabets) {
                    unique = unique.replaceAll(procc, "");
                }
                builder.insert(0, unique);
            } else {
                builder.append(unique);
            }
            processedAlphabets.add(unique);
        }
        return builder.toString();
    }
}