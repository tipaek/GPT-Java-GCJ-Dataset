import java.util.Scanner;
class Solution
{
    public static void merge(int m[][], int start, int mid, int end)
    {
        int p=start;int q=mid+1;
        int arr[][] = new int[end-start+1][2];
        int k=0;
        for(int i=start;i<=end;i++)
        {
            if(p>mid)
            {
                arr[k][0] = m[q][0];
                arr[k++][1] = m[q++][1];
            }
            else if (q>end)
            {
                arr[k][0] = m[p][0];
                arr[k++][1]=m[p++][1];
            }
            else if(m[p][0]<m[q][0])
            {
                arr[k][0] = m[p][0];
                arr[k++][1] = m[p++][1];
            }
            else
            {
                arr[k][0] = m[q][0];
                arr[k++][1] = m[q++][1];
            }
        }
        for(int t=0;t<k;t++)
        {
            m[start][0] = arr[t][0];
            m[start++][1] = arr[t][1];
        }
    }
    public static void merge_sort(int m[][], int start, int end)
    {
        if(start<end)
        {
            int mid = (start + end) /2;
            merge_sort(m,start,mid);
            merge_sort(m,mid+1,end);
            merge(m,start,mid,end);
        }
    }
    public static String calc(int a[][],int b[][], int n)
    {
        String p="CJ";
        merge_sort(a,0,n-1);
        int m[] = new int [n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            { 
                if(a[i][0]==b[j][0] && a[i][1]==b[j][1])
                m[j] = i;
            }
        }
        int c=0;
        int h=1;
        for(int i=2;i<n;i++)
        {
            if(a[i][0]<a[c][1] && a[i][0] <a[h][1])
            return "IMPOSSIBLE";
            else if(a[i][0]>=a[c][1])
            {
                p=p+"C";
                c=i;               
            }
            else if (a[i][0]>=a[h][1])
            {
                p=p+"J";
                h=i;
                
            }
        }
       
        String f="";
        for(int i =0;i<n;i++)
        {
            f = f + Character.toString(p.charAt(m[i]));
        }
        return f;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            int n = sc.nextInt();
            int a[][] = new int [n][2];
            int b[][] = new int[n][2];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<2;k++)
                {
                    a[j][k] = sc.nextInt();
                    b[j][k] = a[j][k];
                }
            }
            String p = calc(a,b,n);
            System.out.println("Case #"+i+": "+p);
        }
        
    }
}