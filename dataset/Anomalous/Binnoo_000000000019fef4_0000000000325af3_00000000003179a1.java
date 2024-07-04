import java.util.*;

public class Solution {

    private int t;
    private Scanner scanner;
    private int U;
    private Random random = new Random();
    private Set<Integer> usedChars = new HashSet<>();
    private char[] secret = new char[10];
    private Map<Character, Integer> secretToPosition = new HashMap<>();
    private int[][] counts;
    private Map<Character, Integer> countsUnk = new HashMap<>();
    private Set<Character> allChars = new HashSet<>();

    public Solution(int t, Scanner scanner) {
        this.t = t;
        this.scanner = scanner;
    }

    public void solve() {
        U = scanner.nextInt();
        counts = new int[10][U];
        choseSecret();
        processQueries();
        System.out.println("Case #" + t + ": " + deriveSecret());
    }

    private long tenAtU() {
        long result = 1;
        for (int i = 0; i < U; i++) {
            result *= 10;
        }
        return result;
    }

    private void processQueries() {
        int queries = 10000;
        for (int i = 0; i < queries; i++) {
            scanner.next();
            String query = scanner.next();
            allChars.add(query.charAt(query.length() - 1));
            if (query.length() == U) {
                char leftMost = query.charAt(0);
                countsUnk.put(leftMost, countsUnk.getOrDefault(leftMost, 0) + 1);
            }
        }
    }

    private String deriveSecret() {
        StringBuilder guessedSecret = new StringBuilder();
        for (char c : allChars) {
            if (!countsUnk.containsKey(c)) {
                guessedSecret.append(c);
                break;
            }
        }
        for (int i = 0; i < 9; i++) {
            char best = ' ';
            int max = 0;
            for (Map.Entry<Character, Integer> entry : countsUnk.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    best = entry.getKey();
                }
            }
            guessedSecret.append(best);
            countsUnk.remove(best);
        }
        return guessedSecret.toString();
    }

    private String convert(long q) {
        StringBuilder sb = new StringBuilder();
        if (q == 0) {
            return String.valueOf(secret[0]);
        }
        while (q != 0) {
            int digit = (int) (q % 10);
            sb.append(secret[digit]);
            q /= 10;
        }
        return sb.reverse().toString();
    }

    private void choseSecret() {
        int count = 0;
        while (count < 10) {
            int rand = random.nextInt(26);
            if (!usedChars.contains(rand)) {
                usedChars.add(rand);
                secret[count++] = (char) ('A' + rand);
            }
        }
        for (int i = 0; i < 10; i++) {
            secretToPosition.put(secret[i], i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            new Solution(i + 1, scanner).solve();
        }
        scanner.close();
    }
}