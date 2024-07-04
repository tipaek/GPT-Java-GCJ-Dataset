
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] arg){
        Scanner s=new Scanner(System.in);
        int tc=s.nextInt();
        for(int in=0;in<tc;in++){
            final int n=s.nextInt();
            StringBuffer result=new StringBuffer("");
            int[][] activities=new int[n][2];
            for(int i=0;i<n;i++){
                activities[i][0]=s.nextInt();
                activities[i][1]=s.nextInt();
            }
            Arrays.sort(activities, (a, b) -> Double.compare(a[0], b[0]));
            int startC=activities[0][0];
            int endC=activities[0][1];
            result.append("C");
            int startJ=-1;
            int endJ=-1;

            for(int i=1;i<n;i++){
                int start=activities[i][0];
                int end=activities[i][1];
                if(start>startC && start<endC || end>startC && end<endC){
                    if(start>startJ && start<endJ || end>startJ && end<endJ){
                        result=new StringBuffer("IMPOSSIBLE");
                        break;
                    } else {
                        startJ=start;
                        endJ=end;
                        result.append("J");
                    }
                } else{
                    startC=start;
                    endC=end;
                    result.append("C");
                }

            }
            int testno=in+1;
            System.out.println("Case #"+testno+": "+result);
        }
    }
}
