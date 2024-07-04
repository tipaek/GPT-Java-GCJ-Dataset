import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static String solve(int n, String[] patterns) {
        int[] asterisks = new int[n];
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            asterisks[i] = patterns[i].indexOf('*');
            if (asterisks[i] > asterisks[maxIndex]) {
                maxIndex = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!patterns[maxIndex].startsWith(patterns[i].substring(0, asterisks[i]))) {
                return null;
            }
        }

        StringBuilder result = new StringBuilder(patterns[maxIndex].substring(0, asterisks[maxIndex]));
        int[] lastAsterisk = new int[n];

        while (true) {
            boolean found = false;

            for (int i = 0; i < n; i++) {
                int nextAsterisk = patterns[i].indexOf('*', asterisks[i] + 1);
                if (nextAsterisk == -1) {
                    lastAsterisk[i] = asterisks[i];
                    continue;
                }
                found = true;
                result.append(patterns[i], asterisks[i] + 1, nextAsterisk);
                asterisks[i] = nextAsterisk;
            }

            if (!found) {
                break;
            }
        }

        maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (patterns[i].length() - lastAsterisk[i] - 1 > patterns[maxIndex].length() - lastAsterisk[maxIndex] - 1) {
                maxIndex = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (lastAsterisk[i] != patterns[i].length() - 1) {
                if (!patterns[maxIndex].endsWith(patterns[i].substring(lastAsterisk[i] + 1))) {
                    return null;
                }
            }
        }

        result.append(patterns[maxIndex].substring(lastAsterisk[maxIndex] + 1));
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();

        for (int tc = 1; tc <= testCases; tc++) {
            int n = reader.nextInt();
            String[] patterns = reader.nextStringArray(n);
            String answer = solve(n, patterns);

            if (answer == null) {
                System.out.println("Case #" + tc + ": *");
            } else {
                System.out.println("Case #" + tc + ": " + answer);
            }
        }
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public String[] nextStringArray(int n) {
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = next();
        }
        return array;
    }
}