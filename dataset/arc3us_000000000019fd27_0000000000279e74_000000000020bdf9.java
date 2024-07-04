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

    public static void sortimp(int arr[][]) 
    { 
        Arrays.sort(arr, new Comparator<int[]>() { 

                @Override              
                public int compare(final int[] a,  
                final int[] b) { 
                    if (a[3] > b[3]) 
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
            int a[][] = new int[n][4];
            for(int i=0; i<n;i++)
            {
                a[i][3]=i;
                for(int j=0;j<2;j++)
                {
                    a[i][j]=ob.nextInt();
                }
            }

            for(int i=0; i<n;i++)
                a[i][2]=0;

            sorttime(a);
            boolean im = false;
            int cf=a[0][1];
            int jf=0;
            String s="";


            for(int i=1; i<n;i++)
            {
                if(a[i][0] < cf && a[i][0] >= jf )
                {
                    a[i][2]=1;
                    jf = a[i][1];
                }

                else if(a[i][0] < jf && a[i][0] >= cf)
                {
                    a[i][2]=0;
                    cf = a[i][1];
                }  
                else if(a[i][0] < cf && a[i][0] < jf)
                { 
                    im = true;
                    System.out.println("Case #"+cs+": IMPOSSIBLE");
                    break;
                }
                else
                {
                    cf = a[i][0];
                }
            }

            sortimp(a);
            if(!im)
            {
                for(int i=0; i<n;i++)
                {
                    if(a[i][2] == 0)
                        s=s+"C";
                    else
                        s=s+"J";
                }

                System.out.println("Case #"+cs+": "+s);
            }
            cs++;
            --t;
        }
    }
}