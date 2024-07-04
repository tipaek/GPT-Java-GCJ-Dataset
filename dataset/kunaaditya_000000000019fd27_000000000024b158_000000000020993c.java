import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int T=Integer.parseInt(br.readLine());
        while(T-->0){
            int n=Integer.parseInt(br.readLine());
            int[][] mat=new int[n][n];
            int row=0,col=0,t=0;
            for(int i=0;i<n;i++){
                HashSet hs=new HashSet<Integer>();
                String[] st=br.readLine().split(" ");
                for(int j=0;j<n;j++){
                    mat[i][j]=Integer.parseInt(st[j]);
                    hs.add(mat[i][j]);
                    if(i==j){
                        t+=mat[i][j];
                    }
                }
                if(hs.size()<n)
                    row++;
            }
            for(int i=0;i<n;i++){
                HashSet hs=new HashSet<Integer>();
                for(int j=0;j<n;j++){
                    hs.add(mat[j][i]);
                }
                if(hs.size()<n)
                    col++;
            }
            bw.write("Case #"+(T+1)+":"+" "+t+" "+row+" "+col+"\n");
            
        }
        bw.flush();
    }
}