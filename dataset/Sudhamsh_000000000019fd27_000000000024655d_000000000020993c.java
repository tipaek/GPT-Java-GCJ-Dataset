import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import  java .util.*;
class Solution {
    public static void main(String[] agrs) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int x=1;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int a[][]=new int[n][];
            int row=0;
            int col=0;
            int ans=0;
            for(int i=0;i<n;i++)
            {
                a[i]=new int[n];
                String s[]=br.readLine().split(" ");
                for(int j=0;j<n;j++)
                    a[i][j]=Integer.parseInt(s[j]);
            }
            for(int i=0;i<n;i++)
            {
                HashSet<Integer> set=new HashSet<>();
                for(int j=0;j<n;j++)
                {
                    if(set.contains(a[i][j]))
                    {
                        row++;
                        break;
                    }
                    set.add(a[i][j]);
                }
            }
            for(int i=0;i<n;i++)
            {
                HashSet<Integer> set=new HashSet<>();
                for(int j=0;j<n;j++)
                {
                    if(set.contains(a[j][i]))
                    {
                        col++;
                        break;
                    }
                    set.add(a[j][i]);
                }
            }
            for(int i=0;i<n;i++)
            ans+=a[i][i];
            bw.write("Case #"+x+": "+ans+" "+row+" "+col+"\n");
        
            x++;
        }
        bw.flush();
    }
}