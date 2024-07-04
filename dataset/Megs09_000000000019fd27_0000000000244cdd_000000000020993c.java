import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int tc=Integer.parseInt(br.readLine());
        for(int i=1;i<=tc;i++)
        {   int n=Integer.parseInt(br.readLine());
            int mat[][]=new int[n][n];
            int r=0;int c=0;int t=0;
            for(int j=0;j<n;j++)
            {   String s[]=br.readLine().split(" ");
                for(int p=0;p<n;p++){
                    mat[j][p]=Integer.parseInt(s[p]);
                    if(j==p)
                        t+=mat[j][p];
                }
            }
            for(int j=0;j<n;j++)
            {   HashSet<Integer> hs=new HashSet<Integer>();
                for(int k=0;k<n;k++)
                    hs.add(mat[j][k]);
                if(hs.size()<n)
                    r++;
            }
            for(int j=0;j<n;j++)
            {   HashSet<Integer> hs=new HashSet<Integer>();
                for(int k=0;k<n;k++)
                    hs.add(mat[k][j]);
                if(hs.size()<n)
                    c++;
            }
            System.out.println("Case #"+i+": "+t+" "+r+" "+c);
        }
    }
}
     