import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCases = scanner.nextInt();
        StringBuilder output = new StringBuilder();

        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            String inputString = scanner.next();
            String nestedString = nestString(inputString);
            output.append("Case #").append(caseIndex + 1).append(": ").append(nestedString).append("\n");
        }

        System.out.print(output);
    }

    private static String nestString(String inputString) {
        int length = inputString.length();
        StringBuilder nested = new StringBuilder(inputString);
        int[] indexList = new int[length + 1];

        for (int i = 0; i <= length; i++) {
            indexList[i] = i;
        }

        String temp = inputString + "0";

        while (Integer.parseInt(temp) != 0) {
            int startInd = 0;
            int endInd = length;

            boolean foundNonZero = false;
            for (int i = 0; i <= length; i++) {
                if (temp.charAt(i) != '0') {
                    if (!foundNonZero) {
                        startInd = i;
                        foundNonZero = true;
                    }
                } else {
                    if (foundNonZero) {
                        endInd = i;
                        break;
                    }
                }
            }

            StringBuilder nestTemp = new StringBuilder();

            if (indexList[startInd] != 0) {
                nestTemp.append(nested.substring(0, indexList[startInd]));
            }
            nestTemp.append("(").append(nested.substring(indexList[startInd], indexList[endInd])).append(")");

            if (indexList[endInd] != nested.length()) {
                nestTemp.append(nested.substring(indexList[endInd]));
            }

            nested = nestTemp;

            for (int i = startInd; i <= length; i++) {
                if (i < endInd) {
                    indexList[i]++;
                } else {
                    indexList[i] += 2;
                }
            }

            for (int i = startInd; i < endInd; i++) {
                temp = temp.substring(0, i) + (Character.getNumericValue(temp.charAt(i)) - 1) + temp.substring(i + 1);
            }
        }

        return nested.toString();
    }
}