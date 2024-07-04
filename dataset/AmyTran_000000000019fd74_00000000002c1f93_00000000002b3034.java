import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int numberOfTest = sc.nextInt();

        for (int i = 0; i < numberOfTest; i++) {
            int numberOfPattern = sc.nextInt();
            List<String> patternList = new ArrayList<>();
            for (int j = 0; j < numberOfPattern; j++) {
                patternList.add(sc.nextToken());
            }
            System.out.println("Case #" + (i + 1) + ": " + findFinalPattern(patternList));
        }
    }

    public static String findFinalPattern(List<String> patternList) {
        List<String> finalPattern = new ArrayList<>();
        for (int i = 0; i < patternList.size(); i++) {
            List<String> convertedList = new ArrayList<>();
            int startIndex = 0;
            String pattern = patternList.get(i);
            for (int j = 0 ; j < pattern.length(); j++) {
                if (pattern.charAt(j) == '*') {
                    if (j - startIndex > 0) {
                        convertedList.add(pattern.substring(startIndex, j));
                    }
                    convertedList.add("");
                    startIndex = j + 1;
                }
                if (j == pattern.length() - 1) {
                    if (j - startIndex > 0) {
                        convertedList.add(pattern.substring(startIndex, j + 1));
                    }
                }
            }
            List<String> tempFinalPattern = new ArrayList<>(finalPattern);
            if (!checkStartPart(finalPattern, tempFinalPattern, convertedList)) {
                return "*";
            }
            if (!checkEndPart(finalPattern, tempFinalPattern, convertedList)) {
                return "*";
            }
            finalPattern = new ArrayList<>(tempFinalPattern);
        }
        StringBuilder finalString = new StringBuilder();
        for (String part : finalPattern) {
            finalString.append(part);
        }
        return finalString.toString();
    }

    private static boolean checkStartPart(List<String> finalPattern, List<String> tempFinalPattern, List<String> convertedList) {
        String startPartInCurrentPattern = "";
        String startPartInFinalPattern = "";
        if (convertedList.size() > 0 ) {
            startPartInCurrentPattern = convertedList.get(0);
        }
        if (finalPattern.size() > 0) {
            startPartInFinalPattern = finalPattern.get(0);
        }
        if (startPartInCurrentPattern.startsWith(startPartInFinalPattern)) {
            if (finalPattern.size() == 0) {
                tempFinalPattern.add(startPartInCurrentPattern);
            } else {
                tempFinalPattern.set(0, startPartInCurrentPattern);
            }
        } else if (!startPartInFinalPattern.startsWith(startPartInCurrentPattern)) {
            return false;
        }
        return true;
    }

    private static boolean checkEndPart(List<String> finalPattern, List<String> tempFinalPattern, List<String> convertedList) {
        String endPartInCurrentPattern = "";
        String endPartInFinalPattern = "";
        if (finalPattern.size() > 0) {
            endPartInFinalPattern = finalPattern.get(finalPattern.size() - 1);
        }
        if (convertedList.size() > 0) {
            endPartInCurrentPattern = convertedList.get(convertedList.size() - 1);
        }
        if (endPartInCurrentPattern.endsWith(endPartInFinalPattern)) {
            tempFinalPattern.set(tempFinalPattern.size() - 1, endPartInCurrentPattern);
        } else if (!endPartInFinalPattern.endsWith(endPartInCurrentPattern)) {
            return false;
        }
        return true;
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
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
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
