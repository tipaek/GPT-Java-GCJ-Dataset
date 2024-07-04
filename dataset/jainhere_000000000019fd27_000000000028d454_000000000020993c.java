import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
		int n = t,i,j,k,r,c;
        while(t>0)
        {

            int size=sc.nextInt();
            int a[][]=new int[size][size];

            for(i=0;i<size;i++)
            {
                for(j=0;j<size;j++)
                {
                    a[i][j]=sc.nextInt();
                }
            }

			k=trace(a,size);
            r=findDupRowCount(a,size);
            c=findDupColCount(a,size);
            System.out.println("Case #" +(n-t+1)+ ":"+" " +k+ " " +r+ " " +c); 

        }
    }

    public static int trace(int arr[][],int size)
    {
        int sum=0;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(i==j)
                    sum=sum+arr[i][j];
            }
        }
        return sum;
    }
    public static int findDupRowCount(int arr[][],int size)
	 {
        Hashtable<Integer,Integer> h=new Hashtable<>();
        int count=0;
        for(int i=0;i<size;i++)
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

    public static int findDupColCount(int arr[][],int size)
    {
        Hashtable<Integer,Integer> h=new Hashtable<>();
        int count=0;
        for(int i=0;i<size;i++)
		{
            for(int j=0;j<size;j++)
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
}






