import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n,c=1,k,j,i;
        t=Integer.parseInt(br.readLine());
        while(c<=t)
        {
            String str[]=br.readLine().split(" ");
            n=Integer.parseInt(str[0]);
            List<Integer> arr=new ArrayList<>();
            for(i=1;i<=n;i++)
            {
                arr.add(i);
            }
            Collections.rotate(arr,1);
            k=Integer.parseInt(str[1]);
            if(k%n==0)     
            {
                System.out.println("Case #"+c+": POSSIBLE");
                for(j=0;j<n;j++)
                {
                    for(i=0;i<n;i++)
                    {
                        System.out.print(arr.get(i)+" ");
                    }
                    System.out.println();
                    Collections.rotate(arr,n-1);
                }
            }
            else
                System.out.println("Case #"+c+": IMPOSSIBLE");
            c++;
            arr.clear();
        }
    }
}