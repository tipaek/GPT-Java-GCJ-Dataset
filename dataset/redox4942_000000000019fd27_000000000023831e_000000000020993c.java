import java.util.Scanner;import java.util.Set;import java.util.Arrays; 
import java.util.HashSet;
public class prog1
{
    public static boolean repe(int arr[]) 
    { 
        Set<Integer> s = new HashSet<>();
        for (int t : arr){s.add(t);}
        return (s.size() != arr.length); 
    } 
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while(t>0)
        {
            int n=in.nextInt(),tr=0,cr=0,cc=0;
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=in.nextInt();
                    if(i==j) tr+=a[i][j];
                }
                if(repe(a[i])) cr++;
            }
            for(int i=0;i<n;i++)
            {
                int ar[]=new int[n];
                for(int j=0;j<n;j++)
                {
                    ar[j]=a[j][i];
                }
                if(repe(ar)) cc++;
            }
            System.out.println(tr+" "+cr+" "+cc);
        t--;}
        
    }
}