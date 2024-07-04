import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int tc = Integer.parseInt(s.nextLine());
        for (int t=0; t < tc; t++) {
            int n = Integer.parseInt(s.nextLine());
            int[][] timeline = new int[n][2];
            StringBuilder finalSched = new StringBuilder();
            for(int i=0;i<n;i++){
                int[] act = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                timeline[i][0]=act[0];
                timeline[i][1]=act[1];
            }
            int camStartTime = 1441;
            int camEndTime = -1;
            int jamStartTime = 1441;
            int jamEndTime = -1;
            for(int i = 0 ;i<n;i++){
                if(camEndTime<=timeline[i][0] || timeline[i][1]<=camStartTime){
                    finalSched.append("C");
                    camStartTime=timeline[i][0];
                    camEndTime=timeline[i][1];
                }
                else if(jamEndTime<=timeline[i][0] || timeline[i][1]<=jamStartTime){
                    finalSched.append("J");
                    jamStartTime=timeline[i][0];
                    jamEndTime=timeline[i][1];
                }
                else{
                    finalSched = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println(String.format("Case #%d: %s",t+1,finalSched));
        }

    }
}
