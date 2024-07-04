import java.util.*;
import java.io.*;
public class Solution {
    public static int[][] generator(int start, int N){
        int res[][] = new int[N][N];
        for(int i=0; i<N; i++)
        {
            int t = start;
            for(int j=0; j<N; j++){
                if(t<=N){
                    res[i][j] = t++;
                }
                else{
                    t=2;
                    res[i][j] = 1;
                }
            }
            if(start<N)
                start++;
            else
                start--;
        }
        return res;
    }
    public static int trace(int m[][]){
        int sum=0;
        for(int i=0; i<m.length; i++)
        {
            for(int j=0; j<m.length; j++)
            {
                if(i==j)
                sum+=m[i][j];
            }
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            
            int N = in.nextInt();
            int res[][] = new int[N][N];
            int K = in.nextInt();
            int flag = 0;
            for(int j=1; j<=N; j++){
                if(trace(generator(j,N))==K){
                    res = generator(j,N);
                    flag = 0;
                    break;
                }
                flag = 1;
            }
            if(flag==1)
                System.out.println("Case #"+i+": IMPOSSIBLE");
            else
            {
                System.out.println("Case #"+i+": POSSIBLE");
                for(int m=0; m<N; m++){
                    for(int n=0; n<N; n++){
                        System.out.print(res[m][n]+" ");
                    }
                    System.out.println();
                }
            }
        }
    }
}