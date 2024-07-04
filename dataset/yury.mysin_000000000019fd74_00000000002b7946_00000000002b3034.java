import java.io.*;
import java.util.*;

public class Solution {

    private static final InputReader inputReader = new InputReader();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int k = inputReader.nextInt();
        for (int i = 0; i < k; i++) {
            solve(i + 1);
        }
    }

    private static void solve(int caseN) {
        int n = inputReader.nextInt();
        List<String> patterns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            patterns.add(inputReader.nextLine());
        }
        List<String> notStarEnding = new ArrayList<>();
        List<String> notStarStarting = new ArrayList<>();
        for (String pattern : patterns) {
            if (pattern.charAt(0) != '*') {
                notStarStarting.add(pattern);
            }
            if (pattern.charAt(pattern.length() - 1) != '*') {
                notStarEnding.add(pattern);
            }
        }
        String tail = findTail(notStarEnding);
        String prefix = findPrefix(notStarStarting);
        if (tail.equals("*") || prefix.equals("*")) {
            System.out.println("Case #" + caseN + ": *");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(prefix);
            for (int i = 0; i < n; i++) {
                String[] split = patterns.get(i).split("\\*+");
                for (String s : split) {
                    stringBuilder.append(s);
                }
            }
            stringBuilder.append(tail);
            System.out.println("Case #" + caseN + ": " + stringBuilder);
        }
    }

    private static String findTail(List<String> notEnding) {
        if (notEnding.isEmpty()) return "";
        String[] split = notEnding.get(0).split("\\*+");
        String tail = split[split.length - 1];
        for (int i = 1; i < notEnding.size(); i++) {
            String[] split1 = notEnding.get(i).split("\\*+");
            String tail1 = split1[split1.length - 1];
            if (tail1.length() > tail.length()) {
                if (tail1.endsWith(tail)) {
                    tail = tail1;
                } else {
                    return "*";
                }
            } else {
                if (!tail.endsWith(tail1)) {
                    return "*";
                }
            }
        }
        return tail;
    }

    private static String findPrefix(List<String> notStarting) {
        if (notStarting.isEmpty()) return "";
        String[] split = notStarting.get(0).split("\\*+");
        String tail = split[0];
        for (int i = 1; i < notStarting.size(); i++) {
            String[] split1 = notStarting.get(i).split("\\*+");
            String tail1 = split1[0];
            if (tail1.length() > tail.length()) {
                if (tail1.startsWith(tail)) {
                    tail = tail1;
                } else {
                    return "*";
                }
            } else {
                if (!tail.startsWith(tail1)) {
                    return "*";
                }
            }
        }
        return tail;
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer st;

        public InputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}