import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        StringBuilder output = new StringBuilder();

        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            String unNested = scanner.next();
            int unNestedLength = unNested.length();
            String temp = unNested + "0";
            String nested = unNested;
            int[] indexList = new int[unNestedLength + 1];

            for (int i = 0; i <= unNestedLength; i++) {
                indexList[i] = i;
            }

            while (Long.parseLong(temp) != 0) {
                int startInd = 0;
                int endInd = unNestedLength - 1;
                boolean foundFirstNonZero = false;

                for (int i = 0; i <= unNestedLength; i++) {
                    if (temp.charAt(i) != '0') {
                        if (!foundFirstNonZero) {
                            startInd = i;
                            foundFirstNonZero = true;
                        }
                    } else {
                        if (foundFirstNonZero) {
                            endInd = i;
                            break;
                        }
                    }
                }

                StringBuilder nestedTemp = new StringBuilder();

                if (indexList[startInd] != 0) {
                    nestedTemp.append(nested, 0, indexList[startInd]);
                }
                nestedTemp.append("(").append(nested, indexList[startInd], indexList[endInd]).append(")");

                if (indexList[startInd] != nested.length() - 1) {
                    nestedTemp.append(nested.substring(indexList[endInd]));
                }
                nested = nestedTemp.toString();

                for (int i = startInd; i <= unNestedLength; i++) {
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

            output.append("Case #").append(caseIndex + 1).append(": ").append(nested).append("\n");
        }

        System.out.print(output);
    }
}