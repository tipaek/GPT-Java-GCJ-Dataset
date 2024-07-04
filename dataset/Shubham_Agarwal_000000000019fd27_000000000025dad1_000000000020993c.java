import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,c=1,i,j,n,x=0,row=0,col=0;
        t=Integer.parseInt(br.readLine());
        while(c<=t)
        {
            row=0;
            col=0;
            n=Integer.parseInt(br.readLine());
            int arr[][]=new int[n][n];
            HashSet<Integer> hrow = new HashSet<Integer>();
            HashSet<Integer> hcol = new HashSet<Integer>();
            x=0;
            row=0;
            col=0;
            for(i=0;i<n;i++)
            {
                String str[]=br.readLine().split(" ");
                for(j=0;j<n;j++)
                {
                    arr[i][j]=Integer.parseInt(str[j]);
                }
            }
            for(i=0;i<n;i++)
            x=x+arr[i][i];
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    hrow.add(arr[i][j]);
                    hcol.add(arr[j][i]);
                }
                if(hrow.size()!=n)
                row++;
                if(hcol.size()!=n)
                col++;
                hrow.clear();
                hcol.clear();
                
            }
            System.out.println("Case #"+c+": "+x+" "+row+" "+col);
            c++;
        }
    }
}