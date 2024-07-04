import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numCases = sc.nextInt();
        StringBuilder result = new StringBuilder();

        for (int c = 0; c < numCases; c++) {
            String unNest = sc.next();
            int unnestLen = unNest.length();
            String temp = unNest + "0";
            String nested = unNest;
            int[] indexList = new int[unnestLen + 1];

            for (int i = 0; i < unnestLen + 1; i++) {
                indexList[i] = i;
            }

            while (Integer.parseInt(temp) != 0) {
                int startInd = 0;
                int endInd = unnestLen - 1;
                boolean isFirstNonZ = true;

                for (int r = 0; r < unnestLen + 1; r++) {
                    if (temp.charAt(r) != '0') {
                        if (isFirstNonZ) {
                            startInd = r;
                            isFirstNonZ = false;
                        }
                    } else {
                        if (!isFirstNonZ) {
                            endInd = r;
                            break;
                        }
                    }
                }

                StringBuilder nestTemp = new StringBuilder();

                if (indexList[startInd] != 0) {
                    nestTemp.append(nested, 0, indexList[startInd]);
                }
                nestTemp.append("(").append(nested, indexList[startInd], indexList[endInd]).append(")");

                if (indexList[endInd] != nested.length()) {
                    nestTemp.append(nested.substring(indexList[endInd]));
                }

                nested = nestTemp.toString();

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

            result.append("Case #").append(c + 1).append(": ").append(nested).append("\n");
        }

        System.out.print(result);
    }
}