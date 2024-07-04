import java.io.*;
import java.util.*;

public class Solution{


    public static void main(String[] args) throws IOException {
        //Reader sc = new Reader();
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        StringBuilder sb = new StringBuilder("");
        int t=sc.nextInt();
        long c=1;
        while(t-->0){
            int n=sc.nextInt();
            boolean rowHash[][]=new boolean [n][n+1];
            boolean colHash[][]=new boolean [n][n+1];
            HashSet<Integer> rc=new HashSet<Integer>();
            HashSet<Integer> cc=new HashSet<Integer>();
            long trace=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    long ele=sc.nextLong();
                    if(i==j)
                    {
                        trace+=ele;
                    }
                    if(rowHash[i][(int)ele])
                    {
                        rc.add(i);
                    }
                    rowHash[i][(int)ele]=true;
                    if(colHash[j][(int)ele])
                    {
                        cc.add(j);
                    }
                    colHash[j][(int)ele]=true;
                }
            }
            sb.append("Case #"+c+": "+trace+" "+rc.size()+" "+cc.size());
            sb.append("\n");
            c++;
        }
        System.out.println(sb.toString().trim());
        sc.close();
    }
    
}
