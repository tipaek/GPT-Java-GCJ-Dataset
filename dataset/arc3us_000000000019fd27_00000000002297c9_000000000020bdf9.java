import java.util.*;
import java.io.*;

public class Solution
{
    public static void sorttime(int arr[][]) 
    { 
        Arrays.sort(arr, new Comparator<int[]>() { 

                @Override              
                public int compare(final int[] a,  
                final int[] b) { 
                    if (a[0] > b[0]) 
                        return 1; 
                    else
                        return -1; 
                } 
            });  
    } 

    public static void main (String[] args)
    {
        Scanner ob=new Scanner(System.in);
        int t = ob.nextInt();
        int cs=1;
        while(t!=0)
        {
            int n = ob.nextInt();
            int a[][] = new int[n][2];
            for(int i=0; i<n;i++)
            {
                for(int j=0;j<2;j++)
                    a[i][j]=ob.nextInt();
            }

            String s="";

            for(int i=0; i<n;i++)
                s=s+"C";

            sorttime(a);
            boolean im = false;
            int cf=a[0][1];
            int jf=0;

            for(int i=0;i<n-2;i++)
            {

                if(a[i][1]>a[i+1][0] && jf<=a[i+1][0])
                {
                    s=s.substring(0,i+1)+"J"+s.substring(i+2);  
                    jf=a[i+1][1];
                }

                else if(a[i][1]>a[i+1][0] && cf<=a[i+1][0])
                {
                    s=s.substring(0,i+1)+"C"+s.substring(i+2);  
                    cf=a[i+1][1];
                }

                if(i>=1)
                {
                    if(a[i+1][0]<a[i-1][1] && jf<=a[i+1][0])
                    {
                        s=s.substring(0,i+1)+"J"+s.substring(i+2);  
                        jf=a[i+1][1];
                    }
                    else if (a[i+1][0]<a[i-1][1] && cf<=a[i+1][0])
                    {
                        s=s.substring(0,i+1)+"C"+s.substring(i+2);  
                        cf=a[i+1][1];
                    }
                }

                if(a[i][1] > a[i+1][0] && a[i][1] > a[i+2][0] && a[i+1][1] > a[i+2][0])
                {
                    im = true;
                    System.out.println("Case #"+cs+": IMPOSSIBLE");
                }
            }

            if(!im)
                System.out.println("Case #"+cs+": "+s);
            cs++;
            --t;
        }
    }
}