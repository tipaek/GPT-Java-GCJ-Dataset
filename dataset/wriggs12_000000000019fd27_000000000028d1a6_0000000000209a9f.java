import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int numCases = Integer.parseInt(keyboard.nextLine());

        for (int i = 1; i <= numCases; i++) {

            String nums = keyboard.nextLine();
            int[] numsArr = new int[nums.length()];
            String ans = "";

            for (int k = 0; k < numsArr.length; k++) {
                numsArr[k] = Integer.parseInt(nums.substring(k, k + 1));
            }

            boolean moreNums = true;
            int curNum = numsArr[0];

                int openPar = 0;
                int closedPar = 0;
                for (int k = 0; k < curNum; k++) {
                    ans += "(";
                    openPar++;
                }
                ans += curNum;
                for (int w = 0; w < numsArr.length - 1; w++) {
                    int first = numsArr[w];
                    int sec = numsArr[w + 1];
                    if (first > sec) {
                        int numPar = first - sec;
                        for (int k = 0; k < numPar; k++) {
                            ans += ")";
                            closedPar ++;
                        }
                        ans += sec;
                    }
                    else if (sec > first) {
                        int needOpen = sec - (openPar - closedPar);
                        for (int j = 0; j < needOpen; j++) {
                            ans += "(";
                            openPar++;
                        }
                        ans += sec;
                    }
                    else {
                        ans += sec;
                    }
                }
                for (int t = 0; t < numsArr[numsArr.length - 1]; t++) {
                    ans += ")";
                }
            System.out.println("Case #" + i + ": " + ans);
        }
    }
}