import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String test = br.readLine();
        if (test == null) return;
        int t = Integer.parseInt(test);
        int caseNumber = 1;

        while (t-- > 0) {
            String bound = br.readLine();
            int u = Integer.parseInt(bound);

            int[] charCount = new int[26];
            long[] values = new long[10000];
            Map<Long, List<String>> map = new HashMap<>();
            int j = 10000;

            while (j-- > 0) {
                String input = br.readLine();
                String[] parts = input.split(" ");
                long m = Long.parseLong(parts[0]);
                values[j] = m;
                String r = parts[1];

                map.computeIfAbsent(m, k -> new ArrayList<>()).add(r);

                for (int i = 0; i < r.length(); i++) {
                    charCount[r.charAt(i) - 'A']++;
                }
            }

            Arrays.parallelSort(values);

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (charCount[i] != 0) {
                    result.append((char) (i + 'A'));
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }
}