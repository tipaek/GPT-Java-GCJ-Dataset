import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int u = in.nextInt();
            in.nextLine();

            Map<Integer, Set<String>> mapping = new HashMap<>();

            for (int j = 0; j < 10000; j++) {
                String[] parts = in.nextLine().split(" ");

                int query = Integer.parseInt(parts[0]);
                String res = parts[1];

                if (!mapping.containsKey(query)) {
                    mapping.put(query, new HashSet<>());
                }

                mapping.get(query).add(res);
            }

            int[] mapOccs = new int[26];

            for (int m = 1; m <= 99; m++) {
                if (mapping.containsKey(m)) {
                    List<String> s = new ArrayList<>(mapping.get(m));

                    for (String r : s) {
                        char[] q = r.toCharArray();
                        if (q.length == 2 && q[0] == q[1]) {
                            q = new char[] { q[0] };
                        }

                        for (char c : q) {
                            mapOccs[c - 'A']++;
                        }
                    }
                }
            }

            String al = "";
            for (int d = 0; d < 10; d++) {
                int min = Integer.MAX_VALUE;
                int minInd = 0;
                {

                    for (int k = 0; k < 26; k++) {
                        int mapOccsK = mapOccs[k];
                        if (mapOccsK > 0) {
                            if (mapOccsK < min) {
                                min = mapOccsK;
                                minInd = k;
                            }
                        }
                    }

                    al = ((char) (minInd + 'A')) + al;
                    mapOccs[minInd] = 0;
                }
            }

            System.out.println("Case #" + i + ": " + al);
        }
    }
}