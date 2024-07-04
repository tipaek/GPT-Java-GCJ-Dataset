import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
            int t=Integer.parseInt(br.readLine());
            for(int p=1;p<=t;p++){
                int n=Integer.parseInt(br.readLine());
                int[][] ar=new int[n][n];
                for(int i=0;i<n;i++){
                    String[] s=br.readLine().split(" ");
                    for(int j=0;j<n;j++){
                        ar[i][j]=Integer.parseInt(s[j]);
                    }
                }
                int T=0;
                for(int i=0;i<n;i++) T+=ar[i][i];
                int c=0;
                int r=0;
                for(int i=0;i<n;i++){
                    HashSet<Integer> rhs=new HashSet<Integer>();
                    HashSet<Integer> chs=new HashSet<Integer>();
                    for(int j=0;j<n;j++){
                        rhs.add(ar[i][j]);
                        chs.add(ar[j][i]);
                    }
                    if(rhs.size()<n) r++;
                    if(chs.size()<n) c++;
                }
                bw.write("Case #"+p+":"+" "+T+" "+r+" "+c+"\n");
            }
            bw.flush();
        }
        catch(Exception e){}
    }
}