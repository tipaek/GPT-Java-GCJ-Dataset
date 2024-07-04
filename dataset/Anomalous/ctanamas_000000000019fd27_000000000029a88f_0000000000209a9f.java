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

            for (int x = 0; x <= unnestLen; x++) {
                indexList[x] = x;
            }

            while (!temp.equals("0")) {
                int startInd = 0;
                int endInd = unnestLen - 1;
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

                StringBuilder nestedBuilder = new StringBuilder();
                if (indexList[startInd] != 0) {
                    nestedBuilder.append(nested, 0, indexList[startInd]);
                }
                nestedBuilder.append("(")
                             .append(nested, indexList[startInd], indexList[endInd])
                             .append(")");
                if (indexList[endInd] != nested.length()) {
                    nestedBuilder.append(nested.substring(indexList[endInd]));
                }
                nested = nestedBuilder.toString();

                for (int r = startInd; r <= unnestLen; r++) {
                    if (r < endInd) {
                        indexList[r]++;
                    } else {
                        indexList[r] += 2;
                    }
                }

                StringBuilder tempBuilder = new StringBuilder(temp);
                for (int r = startInd; r < endInd; r++) {
                    char newChar = (char) (temp.charAt(r) - 1);
                    tempBuilder.setCharAt(r, newChar);
                }
                temp = tempBuilder.toString();
            }

            output.append("Case #").append(c + 1).append(": ").append(nested).append("\n");
        }

        System.out.print(output.toString());
    }
}