import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();
        StringBuilder output = new StringBuilder();

        for (int c = 0; c < numCases; c++) {
            String unNest = sc.next();
            int unnestLen = unNest.length();
            StringBuilder nested = new StringBuilder(unNest);
            int[] indexList = new int[unnestLen + 1];

            for (int x = 0; x <= unnestLen; x++) {
                indexList[x] = x;
            }

            String temp = unNest + "0";
            while (Integer.parseInt(temp) != 0) {
                int startInd = 0;
                int endInd = unnestLen;
                boolean isFirstNonZero = true;

                for (int r = 0; r <= unnestLen; r++) {
                    if (temp.charAt(r) != '0') {
                        if (isFirstNonZero) {
                            startInd = r;
                            isFirstNonZero = false;
                        }
                    } else if (!isFirstNonZero) {
                        endInd = r;
                        break;
                    }
                }

                nested.insert(indexList[startInd], '(');
                nested.insert(indexList[endInd] + 1, ')');

                for (int r = startInd; r <= unnestLen; r++) {
                    indexList[r] += (r < endInd) ? 1 : 2;
                }

                for (int r = startInd; r < endInd; r++) {
                    temp = temp.substring(0, r) + (Character.getNumericValue(temp.charAt(r)) - 1) + temp.substring(r + 1);
                }
            }

            output.append("Case #").append(c + 1).append(": ").append(nested).append("\n");
        }

        System.out.print(output);
    }
}