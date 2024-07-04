import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCases = sc.nextInt();
        StringBuilder output = new StringBuilder();

        for (int c = 0; c < numCases; c++) {
            String unNest = sc.next();
            int unnestLen = unNest.length();
            String temp = unNest + "0";
            String nested = unNest;
            int[] indexList = new int[unnestLen + 1];

            for (int x = 0; x < unnestLen + 1; x++) {
                indexList[x] = x;
            }

            while (Integer.parseInt(temp) != 0) {
                int startInd = 0;
                int endInd = unnestLen - 1;
                boolean isFirstNonZero = true;

                for (int r = 0; r < unnestLen + 1; r++) {
                    if (temp.charAt(r) != '0') {
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

                StringBuilder nestedTemp = new StringBuilder();
                if (indexList[startInd] != 0) {
                    nestedTemp.append(nested.substring(0, indexList[startInd]));
                }
                nestedTemp.append("(").append(nested.substring(indexList[startInd], indexList[endInd])).append(")");
                if (indexList[endInd] != nested.length() - 1) {
                    nestedTemp.append(nested.substring(indexList[endInd]));
                }
                nested = nestedTemp.toString();

                for (int r = startInd; r < unnestLen + 1; r++) {
                    if (r < endInd) {
                        indexList[r]++;
                    } else {
                        indexList[r] += 2;
                    }
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