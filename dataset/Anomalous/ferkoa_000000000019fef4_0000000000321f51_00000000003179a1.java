import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class Solution {

    private static String solve(int u, long[] q, char[][] r) {
        Set<Character> charsAtStart = new HashSet<>();
        Map<Character, Integer> charsFreq = new HashMap<>();

        for (int i = 0; i < q.length; i++) {
            for (int j = 0; j < r[i].length; j++) {
                if (j == 0) {
                    charsAtStart.add(r[i][j]);
                }
                charsFreq.merge(r[i][j], 1, Integer::sum);
            }
        }

        Set<Character> zeroChar = new HashSet<>(charsFreq.keySet());
        zeroChar.removeAll(charsAtStart);
        Character c0 = null;

        if (zeroChar.size() == 1) {
            c0 = zeroChar.iterator().next();
            charsFreq.remove(c0);
        }

        List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(charsFreq.entrySet());
        sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue()));

        StringBuilder result = new StringBuilder();
        if (c0 != null) {
            result.append(c0);
        }
        for (Map.Entry<Character, Integer> entry : sortedEntries) {
            result.append(entry.getKey());
        }

        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintStream out = System.out;

        int t = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= t; i++) {
            int u = scanner.nextInt();
            scanner.nextLine();
            long[] q = new long[10000];
            char[][] r = new char[10000][];

            for (int j = 0; j < q.length; j++) {
                q[j] = scanner.nextLong();
                r[j] = scanner.nextLine().trim().toCharArray();
            }

            out.println("Case #" + i + ": " + solve(u, q, r));
        }

        scanner.close();
    }
}