import java.util.*;
import java.io.*;

public class solution
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
                if(a[i][1] > a[i+1][0] && a[i][1] > a[i+2][0] && a[i+1][1] > a[i+2][0])
                {
                    im = true;
                    System.out.println("Case #"+cs+": IMPOSSIBLE");
                }
            }

            if(!im)
            {
                for(int i=1; i<n;i++)
                {
                    if(a[i][0] < cf )
                    {
                        s=s.substring(0,i)+"J"+s.substring(i+1);
                        jf = a[i][1];
                    }
                    else
                    {
                        s=s.substring(0,i)+"C"+s.substring(i+1);
                        cf = a[i][1];
                    }
                }
                
                System.out.println("Case #"+cs+": "+s);
            }
            cs++;
            --t;
        }
    }
}