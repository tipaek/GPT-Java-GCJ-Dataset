import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for (int i=1; i<=t; i++)
        {
            int n=sc.nextInt();
            int arr[][]=new int[n][2];
            int cp[][]=new int[n][2];
            for (int j=0; j<n; j++)
            {
                for (int k=0; k<2; k++)
                {
                    arr[j][k]=sc.nextInt();
                    cp[j][k]=arr[j][k];
                }
            }
            sort (arr);
            
            String s="CJ";
            int cm=0;
            int jm=1;
            
            for (int j=2; j<n; j++)
            {
                if (arr[cm][1]<=arr[j][0])
                {
                    s=s+"C";
                    cm=j;
                }
                else if (arr[jm][1]<=arr[j][0])
                {
                    s=s+"J";
                    jm=j;
                }
                else
                {
                    System.out.println("Case #"+i+": IMPOSSIBLE");
                    break;
                }
            }
            if (s.length()==n)
            {
                String an="";
                for (int j=0; j<n; j++)
                {
                    for (int k=0; k<n; k++)
                    {
                        if (arr[k][0]==cp[j][0] && arr[k][1]==cp[j][1])
                        {
                            an=an+s.charAt(k);
                            break;
                        }
                    }
                }
                System.out.println("Case #"+i+": "+an);
            }
        }
    }
    
    static void sort(int arr[][])
    {
        for (int i=0; i<arr.length-1; i++)
        {
            for (int j=i+1; j<arr.length; j++)
            {
                if (arr[i][0]>arr[j][0])
                {
                    arr[i][0]=arr[i][0]+arr[j][0];
                    arr[j][0]=arr[i][0]-arr[j][0];
                    arr[i][0]=arr[i][0]-arr[j][0];
                    
                    arr[i][1]=arr[i][1]+arr[j][1];
                    arr[j][1]=arr[i][1]-arr[j][1];
                    arr[i][1]=arr[i][1]-arr[j][1];
                }
            }
        }
    }
}