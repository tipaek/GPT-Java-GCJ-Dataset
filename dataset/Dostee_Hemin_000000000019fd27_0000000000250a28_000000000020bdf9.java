import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for(int cs=1; cs<=T; cs++) {
            int n = input.nextInt();
            int[][] times = new int[n][2];
            for(int i=0; i<n; i++) {
                for(int j=0; j<2; j++) {
                    times[i][j] = input.nextInt();
                }
            }

            String newS = "";
            boolean isC = true;
            int prevEnd = 0;
            for (int i = 0; i < n; i++) {
                int start = times[i][0];
                int end = times[i][1];
                if (start < prevEnd) {
                    isC = !isC;
                    if(i > 1) {
                        int lastlastEnd = times[i - 2][1];
                        if(start < lastlastEnd && (newS.charAt(i-2) == 'C') == isC) {
                            newS = "IMPOSSIBLE";
                            break;
                        }
                    }
                }

                if (isC) {
                    newS += "C";
                } else {
                    newS += "J";
                }

                prevEnd = end;
            }
            System.out.println("Case #" + cs + ": " + newS);
        }
    }
}