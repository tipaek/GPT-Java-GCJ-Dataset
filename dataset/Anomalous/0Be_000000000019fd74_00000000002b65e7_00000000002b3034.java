import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int testCases = Integer.parseInt(in.readLine());
        StringBuilder output = new StringBuilder();

        for (int currentCase = 1; currentCase <= testCases; currentCase++) {
            output.append("Case #").append(currentCase).append(": ");

            int patternCount = Integer.parseInt(in.readLine());
            String[][] patterns = new String[patternCount][3];
            int maxPrefixIndex = 0, maxSuffixIndex = 0;
            int maxPrefixLength = 0, maxSuffixLength = 0;

            for (int i = 0; i < patternCount; i++) {
                char[] patternArray = in.readLine().toCharArray();
                int length = patternArray.length;

                StringBuilder prefix = new StringBuilder();
                int j = 0;
                for (; j < length; j++) {
                    if (patternArray[j] == '*') {
                        if (j > maxPrefixLength) {
                            maxPrefixIndex = i;
                            maxPrefixLength = j;
                        }
                        break;
                    } else {
                        prefix.append(patternArray[j]);
                    }
                }
                if (j != 0) {
                    patterns[i][0] = prefix.toString();
                }

                StringBuilder suffix = new StringBuilder();
                int k = length - 1;
                for (; k >= 0; k--) {
                    if (patternArray[k] == '*') {
                        if (length - k - 1 > maxSuffixLength) {
                            maxSuffixIndex = i;
                            maxSuffixLength = length - k - 1;
                        }
                        break;
                    } else {
                        suffix.insert(0, patternArray[k]);
                    }
                }
                if (k != length - 1) {
                    patterns[i][2] = suffix.toString();
                }

                StringBuilder middle = new StringBuilder();
                for (int m = j + 1; m < k; m++) {
                    if (patternArray[m] != '*') {
                        middle.append(patternArray[m]);
                    }
                }
                patterns[i][1] = middle.toString();
            }

            boolean isPossible = true;
            for (int i = 0; i < patternCount; i++) {
                if (maxPrefixLength != 0 && patterns[i][0] != null) {
                    if (!patterns[maxPrefixIndex][0].startsWith(patterns[i][0])) {
                        isPossible = false;
                        break;
                    }
                }

                if (maxSuffixLength != 0 && patterns[i][2] != null) {
                    if (!patterns[maxSuffixIndex][2].endsWith(patterns[i][2])) {
                        isPossible = false;
                        break;
                    }
                }
            }

            if (!isPossible) {
                output.append('*');
            } else {
                if (maxPrefixLength != 0) {
                    output.append(patterns[maxPrefixIndex][0]);
                }

                for (int i = 0; i < patternCount; i++) {
                    if (patterns[i][1].length() > 0) {
                        output.append(patterns[i][1]);
                    }
                }

                if (maxSuffixLength != 0) {
                    output.append(patterns[maxSuffixIndex][2]);
                }
            }

            output.append('\n');
        }

        out.print(output);
        in.close();
        out.close();
    }
}