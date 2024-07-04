import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= testCases; i++) {
            handleTestCase(i, scanner);
        }
    }

    private static void handleTestCase(int testCaseNumber, Scanner scanner) {
        int u = scanner.nextInt();
        QRPair[] pairs = new QRPair[10000];

        for (int i = 0; i < 10000; i++) {
            int q = scanner.nextInt();
            String r = scanner.next();
            pairs[i] = new QRPair(q, r);
        }

        String result = analyzePairs(pairs, u);
        printResult(testCaseNumber, result);
    }

    private static String analyzePairs(QRPair[] pairs, int u) {
        int[] primaryCounts = new int[200];
        int[] secondaryCounts = new int[200];

        for (QRPair pair : pairs) {
            if (pair.result.length() == u) {
                char firstChar = pair.result.charAt(0);
                char secondChar = pair.result.charAt(1);

                primaryCounts[firstChar]++;
                secondaryCounts[secondChar]++;
            }
        }

        List<Rank> primaryRanks = new ArrayList<>();
        List<Rank> secondaryRanks = new ArrayList<>();

        for (int i = 0; i < 200; i++) {
            if (primaryCounts[i] > 0) {
                primaryRanks.add(new Rank(primaryCounts[i], i));
            }
            if (secondaryCounts[i] > 0) {
                secondaryRanks.add(new Rank(secondaryCounts[i], i));
            }
        }

        primaryRanks.sort(Comparator.comparingInt(Rank::getTally).reversed());

        StringBuilder result = new StringBuilder();

        for (Rank secondaryRank : secondaryRanks) {
            boolean found = false;
            for (Rank primaryRank : primaryRanks) {
                if (secondaryRank.value == primaryRank.value) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                result.append((char) secondaryRank.value);
            }
        }

        for (Rank primaryRank : primaryRanks) {
            result.append((char) primaryRank.value);
        }

        return result.toString();
    }

    public static class Rank {
        int tally;
        int value;

        Rank(int tally, int value) {
            this.tally = tally;
            this.value = value;
        }

        public int getTally() {
            return tally;
        }
    }

    public static class QRPair {
        int query;
        String result;

        QRPair(int query, String result) {
            this.query = query;
            this.result = result;
        }
    }

    private static void printResult(int testCaseNumber, String result) {
        System.out.println("Case #" + testCaseNumber + ": " + result);
    }
}