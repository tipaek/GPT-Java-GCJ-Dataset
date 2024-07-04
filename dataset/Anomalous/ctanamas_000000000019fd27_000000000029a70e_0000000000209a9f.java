import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();
        StringBuilder out = new StringBuilder();

        for (int c = 0; c < numCases; c++) {
            String unNest = sc.next();
            int unnestLen = unNest.length();
            StringBuilder nested = new StringBuilder(unNest);
            int[] indexList = new int[unnestLen + 1];

            for (int x = 0; x <= unnestLen; x++) {
                indexList[x] = x;
            }

            while (!unNest.equals("0".repeat(unnestLen))) {
                int startInd = 0;
                int endInd = unnestLen;
                boolean isFirstNonZero = true;

                for (int r = 0; r <= unnestLen; r++) {
                    if (unNest.charAt(r) != '0') {
                        if (isFirstNonZero) {
                            startInd = r;
                            isFirstNonZero = false;
                        }
                    } else {
                        if (!isFirstNonZero) {
                            endInd = r;
                            break;
                        }
                    }
                }

                nested.insert(indexList[startInd], '(');
                nested.insert(indexList[endInd] + 1, ')');

                for (int r = startInd; r <= unnestLen; r++) {
                    if (r < endInd) {
                        indexList[r]++;
                    } else {
                        indexList[r] += 2;
                    }
                }

                StringBuilder temp = new StringBuilder(unNest);
                for (int r = startInd; r < endInd; r++) {
                    temp.setCharAt(r, (char) (temp.charAt(r) - 1));
                }
                unNest = temp.toString();
            }

            out.append("Case #").append(c + 1).append(": ").append(nested).append("\n");
        }

        System.out.print(out);
    }
}