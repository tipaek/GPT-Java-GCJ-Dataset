import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int numCases = sc.nextInt();
        StringBuilder out = new StringBuilder();
        
        for (int c = 0; c < numCases; c++) {
            String unNest = sc.next();
            int unnestLen = unNest.length();
            StringBuilder temp = new StringBuilder(unNest + "0");
            StringBuilder nested = new StringBuilder(unNest);

            int[] indexList = new int[unnestLen + 1];
            for (int x = 0; x < unnestLen + 1; x++) {
                indexList[x] = x;
            }

            while (Long.parseLong(temp.toString()) != 0) {
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
                    nestTemp.append(nested.substring(0, indexList[startInd]));
                }
                nestTemp.append("(").append(nested.substring(indexList[startInd], indexList[endInd])).append(")");
                if (indexList[endInd] != nested.length()) {
                    nestTemp.append(nested.substring(indexList[endInd]));
                }
                nested = nestTemp;

                for (int r = startInd; r < unnestLen + 1; r++) {
                    if (r < endInd) {
                        indexList[r]++;
                    } else {
                        indexList[r] += 2;
                    }
                }

                for (int r = startInd; r < endInd; r++) {
                    temp.setCharAt(r, (char) (temp.charAt(r) - 1));
                }
            }

            out.append("Case #").append(c + 1).append(": ").append(nested).append("\n");
        }

        System.out.print(out);
    }
}