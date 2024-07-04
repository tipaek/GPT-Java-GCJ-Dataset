import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t,n,c=1,k,j,i,sum,z;
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
            k=Integer.parseInt(str[1]);
            sum=(n*(n+1))/2;
            if(n==1 && k==1)
            {
                System.out.println("Case #"+c+": POSSIBLE");
                System.out.println(1);
            }
            else if(n==2)
            {
                if(k==2)
                {
                    System.out.println("Case #"+c+": POSSIBLE");
                    System.out.println(1+" "+2);
                    System.out.println(2+" "+1);
                }
                else if(k==4)
                {
                    System.out.println("Case #"+c+": POSSIBLE");
                    System.out.println(2+" "+1);
                    System.out.println(1+" "+2);
                }
                else
                    System.out.println("Case #"+c+": IMPOSSIBLE");
            }
            else if(k<=(n*n) && k%n==0)
            {
                z=k/n;
                while(arr.get(0)!=z)
                Collections.rotate(arr,1);
                System.out.println("Case #"+c+": POSSIBLE");
                for(j=0;j<n;j++)
                {
                    for(i=0;i<n;i++)
                    {
                        System.out.print(arr.get(i)+" ");
                    }
                    System.out.println();
                    Collections.rotate(arr,1);
                }
            }
            else
                System.out.println("Case #"+c+": IMPOSSIBLE");
            c++;
            arr.clear();
        }
    }
}