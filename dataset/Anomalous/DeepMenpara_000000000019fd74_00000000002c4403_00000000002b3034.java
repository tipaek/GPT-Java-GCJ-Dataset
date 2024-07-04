import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();

        for (int titer = 0; titer < t; titer++) {
            int n = sc.nextInt();
            String[] strarr = new String[n];
            List<String> substrings = new ArrayList<>();
            String[] startstrarr = new String[n];
            String[] endstrarr = new String[n];
            int maxStartLenIndex = -1;
            int maxEndLenIndex = -1;
            int maxStars = 0;
            int maxStarIndex = 0;
            int startCount = 0;
            int endCount = 0;

            for (int i = 0; i < n; i++) {
                strarr[i] = sc.nextLine().replaceAll("\\s+", "");
                int firstStarIndex = strarr[i].indexOf('*');
                int lastStarIndex = strarr[i].lastIndexOf('*');
                int starCount = (int) strarr[i].chars().filter(ch -> ch == '*').count();

                if (firstStarIndex > 0) {
                    startstrarr[startCount] = strarr[i].substring(0, firstStarIndex);
                    if (maxStartLenIndex == -1 || startstrarr[startCount].length() > startstrarr[maxStartLenIndex].length()) {
                        maxStartLenIndex = startCount;
                    }
                    startCount++;
                }

                if (lastStarIndex < strarr[i].length() - 1) {
                    endstrarr[endCount] = strarr[i].substring(lastStarIndex + 1);
                    if (maxEndLenIndex == -1 || endstrarr[endCount].length() > endstrarr[maxEndLenIndex].length()) {
                        maxEndLenIndex = endCount;
                    }
                    endCount++;
                }

                String[] parts = strarr[i].split("\\*");
                for (int j = 1; j < parts.length - 1; j++) {
                    if (!substrings.contains(parts[j])) {
                        substrings.add(parts[j]);
                    }
                }

                if (starCount > maxStars) {
                    maxStars = starCount;
                    maxStarIndex = i;
                }
            }

            boolean isValid = true;
            if (maxStartLenIndex != -1) {
                String longestStart = startstrarr[maxStartLenIndex];
                for (int i = 0; i < startCount; i++) {
                    if (i != maxStartLenIndex && !longestStart.contains(startstrarr[i])) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (maxEndLenIndex != -1) {
                String longestEnd = endstrarr[maxEndLenIndex];
                for (int i = 0; i < endCount; i++) {
                    if (i != maxEndLenIndex && !longestEnd.contains(endstrarr[i])) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid) {
                StringBuilder finalStr = new StringBuilder();
                if (maxStartLenIndex != -1) {
                    finalStr.append(startstrarr[maxStartLenIndex]);
                }

                String[] maxStarParts = strarr[maxStarIndex].split("\\*");
                int substringIndex = 0;
                for (int i = 0; i < maxStarParts.length; i++) {
                    if (i > 0 && i < maxStarParts.length - 1) {
                        if (substringIndex < substrings.size()) {
                            finalStr.append(substrings.get(substringIndex));
                            substringIndex++;
                        } else {
                            finalStr.append('A');
                        }
                    } else {
                        finalStr.append(maxStarParts[i]);
                    }
                }

                if (maxEndLenIndex != -1) {
                    finalStr.append(endstrarr[maxEndLenIndex]);
                }

                System.out.println("Case #" + (titer + 1) + ": " + finalStr.toString());
            } else {
                System.out.println("Case #" + (titer + 1) + ": *");
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}