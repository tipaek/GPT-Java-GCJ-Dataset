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
            String[] strArr = new String[n];
            List<String> strList = new ArrayList<>();
            String[] startStrArr = new String[n];
            String[] endStrArr = new String[n];
            int maxStartStrLenInd = -1;
            int maxEndStrLenInd = -1;
            int maxStarCount = 0;
            int maxStarIndex = 0;

            for (int i = 0; i < n; i++) {
                strArr[i] = sc.nextLine().replaceAll("\\s+", "");
                String[] parts = strArr[i].split("\\*");
                int lastStarIndex = strArr[i].lastIndexOf('*');
                int starCount = parts.length - 1;

                if (parts.length > 0 && !parts[0].isEmpty()) {
                    startStrArr[i] = parts[0];
                    if (maxStartStrLenInd == -1 || startStrArr[i].length() > startStrArr[maxStartStrLenInd].length()) {
                        maxStartStrLenInd = i;
                    }
                }

                if (lastStarIndex != strArr[i].length() - 1) {
                    endStrArr[i] = strArr[i].substring(lastStarIndex + 1);
                    if (maxEndStrLenInd == -1 || endStrArr[i].length() > endStrArr[maxEndStrLenInd].length()) {
                        maxEndStrLenInd = i;
                    }
                }

                for (int j = 1; j < parts.length - 1; j++) {
                    if (!parts[j].isEmpty() && !strList.contains(parts[j])) {
                        strList.add(parts[j]);
                    }
                }

                if (starCount > maxStarCount) {
                    maxStarCount = starCount;
                    maxStarIndex = i;
                }
            }

            boolean isValidStart = isValid(startStrArr, maxStartStrLenInd);
            boolean isValidEnd = isValid(endStrArr, maxEndStrLenInd);

            if (isValidStart && isValidEnd) {
                StringBuilder finalStr = new StringBuilder();
                if (maxStartStrLenInd != -1) {
                    finalStr.append(startStrArr[maxStartStrLenInd]);
                }

                String[] maxStarParts = strArr[maxStarIndex].split("\\*");
                int listIndex = 0;
                for (String part : maxStarParts) {
                    while (listIndex < strList.size() && strList.get(listIndex).isEmpty()) {
                        listIndex++;
                    }
                    if (listIndex < strList.size()) {
                        finalStr.append(strList.get(listIndex));
                        listIndex++;
                    } else {
                        finalStr.append(part);
                    }
                }

                if (maxEndStrLenInd != -1) {
                    finalStr.append(endStrArr[maxEndStrLenInd]);
                }

                System.out.println("Case #" + (titer + 1) + ": " + finalStr);
            } else {
                System.out.println("Case #" + (titer + 1) + ": *");
            }
        }
    }

    private static boolean isValid(String[] strArr, int maxLenInd) {
        if (maxLenInd == -1) return true;
        String maxStr = strArr[maxLenInd];
        for (String str : strArr) {
            if (str != null && !maxStr.contains(str)) {
                return false;
            }
        }
        return true;
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