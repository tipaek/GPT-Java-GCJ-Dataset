import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for(int t = 1; t <= numTests; t++){
            int n = sc.nextInt();

            int minStart = 24 * 60;
            int maxEnd = 0;

            boolean[] used = new boolean[n];
            char[] possibleSolution = new char[n];
            int[][] activities = new int[n][2];

            for(int i = 0; i < n; i++){
                int[] cur = {sc.nextInt(), sc.nextInt()};
                activities[i] = cur;

                minStart = Math.min(minStart, activities[i][0]);
                maxEnd = Math.max(maxEnd, activities[i][1]);
            }

            boolean impossible = false;
            boolean cBusy = false;
            boolean jBusy = false;
            int cBusyTill = 0;
            int jBusyTill = 0;

            for(int i = minStart; i <= maxEnd; i++){
                for(int j = 0; j < activities.length; j++){
                    if(used[j]) continue;

                    if(cBusyTill == i) cBusy = false;
                    if(jBusyTill == i) jBusy = false;

                    if(activities[j][0] == i){
                        if(cBusy && jBusy){
                            impossible = true;
                            break;
                        } else {
                            if(!cBusy){
                                cBusy = true;
                                cBusyTill = activities[j][1];
                                possibleSolution[j] = 'C';
                            } else {
                                jBusy = true;
                                jBusyTill = activities[j][1];
                                possibleSolution[j] = 'J';
                            }
                            used[j] = true;
                        }
                    }
                }
                if(impossible){
                    break;
                }
            }

            if(impossible){
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + t + ": " + String.valueOf(possibleSolution));
            }
        }
    }
}
