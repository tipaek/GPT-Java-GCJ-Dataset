import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numCases = sc.nextInt();
        StringBuilder output = new StringBuilder();

        for (int c = 0; c < numCases; c++) {
            String unNest = sc.next();
            int unnestLen = unNest.length();
            String temp = unNest + "0"; // Append '0' to handle trailing digits
            String nested = unNest; // Initialize nested string with unNest
            int[] indexList = new int[unnestLen + 1]; // To track indices in the nested string

            for (int x = 0; x <= unnestLen; x++) {
                indexList[x] = x;
            }

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
                    } else {
                        if (!isFirstNonZero) {
                            endInd = r;
                            break;
                        }
                    }
                }

                nested = nested.substring(0, indexList[startInd]) + "(" +
                         nested.substring(indexList[startInd], indexList[endInd]) + ")" +
                         nested.substring(indexList[endInd]);

                for (int r = startInd; r <= unnestLen; r++) {
                    if (r < endInd) {
                        indexList[r]++;
                    } else {
                        indexList[r] += 2;
                    }
                }

                for (int r = startInd; r < endInd; r++) {
                    temp = temp.substring(0, r) + (char)(temp.charAt(r) - 1) + temp.substring(r + 1);
                }
            }

            output.append("Case #").append(c + 1).append(": ").append(nested).append("\n");
        }

        System.out.print(output.toString());
    }
}