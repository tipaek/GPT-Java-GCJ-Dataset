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
            String temp = unNest + "0";
            StringBuilder nested = new StringBuilder(unNest);
            int[] indexList = new int[unnestLen + 1];
            
            for (int i = 0; i <= unnestLen; i++) {
                indexList[i] = i;
            }

            while (Integer.parseInt(temp) != 0) {
                int startInd = 0;
                int endInd = unnestLen - 1;
                boolean isFirstNonZero = true;

                for (int i = 0; i <= unnestLen; i++) {
                    if (temp.charAt(i) != '0') {
                        if (isFirstNonZero) {
                            startInd = i;
                            isFirstNonZero = false;
                        }
                    } else {
                        if (!isFirstNonZero) {
                            endInd = i;
                            break;
                        }
                    }
                }

                nested.insert(indexList[startInd], '(');
                nested.insert(indexList[endInd] + 1, ')');

                for (int i = startInd; i <= unnestLen; i++) {
                    indexList[i] += (i < endInd) ? 1 : 2;
                }

                for (int i = startInd; i < endInd; i++) {
                    int newValue = Character.getNumericValue(temp.charAt(i)) - 1;
                    temp = temp.substring(0, i) + newValue + temp.substring(i + 1);
                }
            }

            output.append("Case #").append(c + 1).append(": ").append(nested).append("\n");
        }

        System.out.print(output);
    }
}