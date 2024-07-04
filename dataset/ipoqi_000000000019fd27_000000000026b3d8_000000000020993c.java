import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Arrays.*;

public class Solution {

    public static void main(String[] args) {
        new Solution().haha();
    }

    public void haha() {
        BufferedReader in = null;

        try{
            //in = new BufferedReader(new FileReader("xxx.txt"));
            in = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(in.readLine());
            for(int i=0;i<T;i++){
                System.out.print("Case #"+(i+1)+":");
                //String[] line = in.readLine().split(" ");
                String line1 = in.readLine();
                int N = Integer.parseInt(line1);
                int[][] m = new int[N][N];
                for(int a=0;a<N;a++){
                    String line[] = in.readLine().split(" ");
                    for(int b=0;b<N;b++){
                        m[a][b] = Integer.parseInt(line[b]);
                    }
                }
                int k = 0;
                int r = 0;
                int c = 0;
                for(int a=0;a<N;a++){
                    k = k + m[a][a];
                }
                
                for(int a=0;a<N;a++){
                   int[] rr = new int[N];
                   for(int b=0;b<N;b++){
                       int v = m[a][b] - 1;
                       if(rr[v]==0){
                           rr[v] = 1;
                       } else {
                           r = r + 1;
                           break;
                       }
                   }
                }
                
                for(int a=0;a<N;a++){
                   int[] cc = new int[N];
                   for(int b=0;b<N;b++){
                       int v = m[b][a] - 1;
                       if(cc[v]==0){
                           cc[v] = 1;
                       } else {
                           c = c + 1;
                           break;
                       }
                   }
                }
                
               
                System.out.print(" "+k+" "+r+" "+c+"\n");
                
            }
            in.close();
        }catch(Exception e){
            e.printStackTrace();
            try{
                in.close();
            }catch(Exception ee){
                ee.printStackTrace();
            }
        }
        //System.out.print("Ha Ha :D\n");
    }
}