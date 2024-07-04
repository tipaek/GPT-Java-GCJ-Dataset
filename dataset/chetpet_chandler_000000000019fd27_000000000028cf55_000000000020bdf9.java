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
            Arrays.sort(activities, (a, b) -> Integer.compare(a[0], b[0]));
            int startC=activities[0][0];
            int endC=activities[0][1];
            result.append("C");
            int startJ=activities[1][0];
            int endJ=activities[1][1];
            result.append("J");
            // for(int i=0;i<n;i++){
            //     System.out.println(activities[i][0]+" "+activities[i][1]);
            // }
            
            for(int i=2;i<n;i++){
                int start=activities[i][0];
                int end=activities[i][1];
                if(start<endC && end>startC){
                    if(start<endJ && end>startJ){
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
