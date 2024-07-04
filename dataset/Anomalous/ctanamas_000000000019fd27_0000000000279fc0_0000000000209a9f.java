import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = sc.nextInt();
        int[] cases = new int[numCases];
        StringBuilder output = new StringBuilder();

        for (int c = 0; c < numCases; c++) {
            String unNested = sc.next();
            int length = unNested.length();
            String temp = unNested + "0";
            String nested = unNested;

            int[] indexList = new int[length + 1];
            for (int i = 0; i <= length; i++) {
                indexList[i] = i;
            }

            // The commented-out section of the original code
            /*
            while (Integer.parseInt(temp) != 0) {
                int startInd = 0;
                int endInd = length - 1;
                boolean foundFirstNonZero = true;
                
                for (int r = 0; r <= length; r++) {
                    if (temp.charAt(r) != '0') {
                        if (foundFirstNonZero) {
                            startInd = r;
                            foundFirstNonZero = false;
                        }
                    } else {
                        if (!foundFirstNonZero) {
                            endInd = r;
                            break;
                        }
                    }
                }

                nested = nested.substring(0, indexList[startInd]) + "(" + nested.substring(indexList[startInd], indexList[endInd]) + ")" + nested.substring(indexList[endInd]);

                for (int r = startInd; r <= length; r++) {
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
            */
        }

        System.out.print("asd");
        // System.out.print(output.toString());
    }
}