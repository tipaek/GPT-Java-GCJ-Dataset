import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();
        StringBuilder output = new StringBuilder();

        for (int c = 0; c < numCases; c++) {
            String unNest = sc.next();
            int unNestLen = unNest.length();
            String temp = unNest + "0";
            StringBuilder nested = new StringBuilder(unNest);
            int[] indexList = new int[unNestLen + 1];

            for (int i = 0; i <= unNestLen; i++) {
                indexList[i] = i;
            }

            while (Integer.parseInt(temp) != 0) {
                int startInd = 0, endInd = unNestLen;
                boolean isFirstNonZero = true;

                for (int r = 0; r <= unNestLen; r++) {
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

                for (int r = startInd; r <= unNestLen; r++) {
                    indexList[r] += (r < endInd) ? 1 : 2;
                }

                for (int r = startInd; r < endInd; r++) {
                    temp = temp.substring(0, r) + (char)(temp.charAt(r) - 1) + temp.substring(r + 1);
                }
            }

            output.append("Case #").append(c + 1).append(": ").append(nested).append("\n");
        }

        System.out.print(output);
    }
}