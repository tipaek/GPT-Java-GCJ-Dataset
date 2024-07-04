import java.util.*;

class Solution 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for(int ca=1;ca<=T;ca++)
        {
            int n=sc.nextInt();
            int m[][]=new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    m[i][j]=sc.nextInt();
                }
            }
            int k=trc(m,n);
            int r=rduplicate(m,n);
            int c=cduplicate(m,n);
            System.out.println("Case #" +ca+ ":"+" " +k+ " " +r+ " " +c); 
        }
    }

    public static int rduplicate(int arr[][],int n)
    {
        HashMap<Integer,Integer> h=new HashMap<>();
        int count=0;
        for(int i=0;i<n;i++)
        {
            int row[]=arr[i];
            for(int j=0;j<row.length;j++)
            {
                if(h.containsKey(row[j]))
                {
                    count++;
                    break;
                }
                else
                {
                    h.put(row[j],1);
                }
            }
            h.clear();
        }
        return count;
    }

    public static int cduplicate(int arr[][],int n)
    {
        HashMap<Integer,Integer> h=new HashMap<>();
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int ele=arr[j][i];
                if(h.containsKey(ele))
                {
                    count++;
                    break;
                }
                else
                {
                    h.put(ele,1);
                }
            }
            h.clear();
        }
        return count;
    }
    public static int trc(int arr[][],int n)
    {
        int tc=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j)
                {
                    tc=tc+arr[i][j];
                }
            }
        }
        return tc;
    }
}