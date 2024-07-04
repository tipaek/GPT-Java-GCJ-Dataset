import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int t = readInt();
        for (int z = 1; z <= t; z++) {
            System.out.print("Case #" + z + ": ");
            int n = readInt();
            int maxLength = -1;
            String[] arr = new String[n];
            ArrayList<String> candidates = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String line = readLine();
                arr[i] = line;
                if (line.length() > maxLength) {
                    candidates.clear();
                    maxLength = line.length();
                    candidates.add(line);
                } else if (line.length() == maxLength) {
                    candidates.add(line);
                }
            }

            boolean found = false;
            for (String candidate : candidates) {
                boolean isValid = true;
                String mainWord = candidate.replaceAll("\\*", "");

                for (String pattern : arr) {
                    String cleanPattern = pattern.replaceAll("\\*", "");

                    if (pattern.charAt(0) == '*') {
                        if (!mainWord.endsWith(cleanPattern)) {
                            isValid = false;
                            break;
                        }
                    } else if (pattern.charAt(pattern.length() - 1) == '*') {
                        if (!mainWord.startsWith(cleanPattern)) {
                            isValid = false;
                            break;
                        }
                    } else if (pattern.contains("*")) {
                        String[] splitPattern = pattern.split("\\*");
                        int index = mainWord.indexOf(splitPattern[0]);

                        if (index == -1 || !mainWord.substring(index).contains(splitPattern[1])) {
                            isValid = false;
                            break;
                        }
                    }
                }

                if (isValid) {
                    System.out.println(mainWord);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("*");
            }
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(input.readLine().trim());
        }
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readChar() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return input.readLine().trim();
    }
}