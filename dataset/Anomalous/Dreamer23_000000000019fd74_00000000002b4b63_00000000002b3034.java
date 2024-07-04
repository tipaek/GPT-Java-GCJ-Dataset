import java.io.*;
import java.util.*;

public class Solution {

    private static void test() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("data/testIn"));
        StringBuilder total = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            total.append(line).append("\n");
        }
        InputStream testInput = new ByteArrayInputStream(total.toString().getBytes("UTF-8"));
        System.setIn(testInput);
        reader.close();
    }

    public static void main(String[] args) throws IOException {
        //test();
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = Integer.parseInt(scanner.nextLine());
            for (int i = 1; i <= testCases; i++) {
                int patterns = Integer.parseInt(scanner.nextLine());
                System.out.println("Case #" + i + ": " + getResult(patterns, scanner));
            }
        }
    }

    private static String getResult(int patterns, Scanner scanner) {
        Set<String> beginsWith = new HashSet<>();
        Set<String> endsWith = new HashSet<>();
        List<String[]> middleParts = new ArrayList<>();
        
        for (int i = 0; i < patterns; i++) {
            String[] parts = scanner.nextLine().split("\\*", -1);
            if (!parts[0].isEmpty()) {
                beginsWith.add(parts[0]);
            }
            if (!parts[parts.length - 1].isEmpty()) {
                endsWith.add(parts[parts.length - 1]);
            }
            if (parts.length > 2) {
                middleParts.add(Arrays.copyOfRange(parts, 1, parts.length - 1));
            }
        }
        
        String beginning = findLongestConsistentString(beginsWith, true);
        if (beginning == null) {
            return "*";
        }
        
        String end = findLongestConsistentString(endsWith, false);
        if (end == null) {
            return "*";
        }
        
        return beginning + end;
    }

    private static String findLongestConsistentString(Set<String> strings, boolean isPrefix) {
        String longest = "";
        for (String s : strings) {
            if (s.length() >= longest.length()) {
                if ((isPrefix && !s.startsWith(longest)) || (!isPrefix && !s.endsWith(longest))) {
                    return null;
                }
                longest = s;
            } else if ((isPrefix && !longest.startsWith(s)) || (!isPrefix && !longest.endsWith(s))) {
                return null;
            }
        }
        return longest;
    }
}