import java.io.*;
import java.lang.*;
import java.util.*;

class Solution{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = new Integer(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int z = 1;z<=t;z++){
            sb.append("Case #").append(z).append(":").append(" ");
            int n = new Integer(br.readLine());
            int[][] matrix = new int[n][n];
            int rrep=0,crep=0,trace=0;
            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<n;j++){
                    matrix[i][j]=new Integer(st.nextToken());
                    if(i==j){
                        trace+=matrix[i][j];
                    }
                }
            }
            boolean[] done = new boolean[n];
            for(int i=0;i<n;i++){
                Arrays.fill(done,false);
                for(int j=0;j<n;j++){
                    done[matrix[i][j]-1]=true;
                }
                for(int j=0;j<n;j++){
                    if(!done[j]){
                        rrep++;
                        break;
                    }
                }
            }
            for(int j=0;j<n;j++){
                Arrays.fill(done,false);
                for(int i=0;i<n;i++){
                    done[matrix[i][j]-1]=true;
                }
                for(int i=0;i<n;i++){
                    if(!done[i]){
                        crep++;
                        break;
                    }
                }
            }
            sb.append(trace).append(" ").append(rrep).append(" ").append(crep).append("\n");
        }
        br.close();
        System.out.println(sb);
    }
}