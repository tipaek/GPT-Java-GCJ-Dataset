import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < numCases; i++) {
            String unNest = scanner.next();
            int unNestLen = unNest.length();
            String temp = unNest + "0";
            StringBuilder nested = new StringBuilder(unNest);
            int[] indexList = new int[unNestLen + 1];

            for (int j = 0; j <= unNestLen; j++) {
                indexList[j] = j;
            }

            while (Long.parseLong(temp) != 0) {
                int startInd = 0;
                int endInd = unNestLen - 1;
                boolean isFirstNonZero = true;

                for (int j = 0; j <= unNestLen; j++) {
                    if (temp.charAt(j) != '0') {
                        if (isFirstNonZero) {
                            startInd = j;
                            isFirstNonZero = false;
                        }
                    } else {
                        if (!isFirstNonZero) {
                            endInd = j;
                            break;
                        }
                    }
                }

                StringBuilder nestTemp = new StringBuilder();
                nestTemp.append("(")
                        .append(nested.substring(indexList[startInd], indexList[endInd]))
                        .append(")");
                nested = nestTemp;

                for (int j = startInd; j <= unNestLen; j++) {
                    if (j < endInd) {
                        indexList[j]++;
                    } else {
                        indexList[j] += 2;
                    }
                }

                for (int j = startInd; j < endInd; j++) {
                    temp = temp.substring(0, j) + (Character.getNumericValue(temp.charAt(j)) - 1) + temp.substring(j + 1);
                }
            }

            output.append("Case #").append(i + 1).append(": ").append(nested).append("\n");
        }

        System.out.print(output.toString());
    }
}