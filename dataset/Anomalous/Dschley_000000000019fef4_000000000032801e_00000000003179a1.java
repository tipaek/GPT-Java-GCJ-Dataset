import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int u = scanner.nextInt();
            List<Pair> queryList = new ArrayList<>();

            for (int j = 0; j < 10000; j++) {
                int qi = scanner.nextInt();
                String ri = scanner.next();
                queryList.add(new Pair(qi, ri));
            }

            String result = deriveString(u, queryList);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String deriveString(int m, List<Pair> queryList) {
        queryList.sort(Comparator.comparingInt(pair -> pair.q));

        Set<Character> discoveredChars = new HashSet<>();
        char[] resultArray = new char[10];
        int index = 1;

        for (Pair query : queryList) {
            if (query.q < index) {
                continue;
            }

            for (char ch : query.r.toCharArray()) {
                if (!discoveredChars.contains(ch)) {
                    if (index == resultArray.length) {
                        index = 0;
                    }
                    discoveredChars.add(ch);
                    resultArray[index++] = ch;
                    if (index == 1) {
                        return new String(resultArray);
                    }
                }
            }
        }

        return new String(resultArray);
    }

    static class Pair {
        int q;
        String r;

        public Pair(int q, String r) {
            this.q = q;
            this.r = r;
        }
    }
}