import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String []args){
        Scanner in=new Scanner(System.in);
        int t,N;
        t=in.nextInt();
        for(int a=1;a<=t;a++){
            N=in.nextInt();
            int[][] intervals=new int[N][3]; 
            for(int i=0;i<N;i++){
                intervals[i][0]=in.nextInt();
                intervals[i][1]=in.nextInt();
                intervals[i][2]=i;
            }
            Arrays.sort(intervals,(x,y)->x[1]-y[1]);
            String res=solve(intervals);
            
            System.out.println("Case #"+a+": "+res);
        }
    }
        private static String solve(int [][]intervals){
            char[] res=new char[intervals.length];
            int jend=0,cend=0;
            for(int interval[]:intervals){
                if(interval[0]<cend && interval[0]<jend)
                return "IMPOSSIBLE";
                else if(interval[0]>=cend){
                    cend=interval[1];
                    res[interval[2]]='C';
                }
                else{
                    jend=interval[1];
                    res[interval[2]]='J';
                }
            }
            return String.valueOf(res);
            
        }
}