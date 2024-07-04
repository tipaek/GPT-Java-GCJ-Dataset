import java.util.*;
class Solution 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for(int z=1;z<=T;z++)
        {

            int size=sc.nextInt();
            int mat[][]=new int[size][size];

            for(int i=0;i<size;i++)
             {
                for(int j=0;j<size;j++)
                {
                    mat[i][j]=sc.nextInt();
                }
            }

            int k=trace(mat,size);

            int r=rowDuplicate(mat,size);

            int c=colDuplicate(mat,size);

            System.out.println("Case #" +z+ ":"+" " +k+ " " +r+ " " +c); //Case #1: 4 0 0
        }
    }

    public static int trace(int arr[][],int size)
    {
        int sum=0;
        for(int i=0;i<size;i++)
        {
            for(int j=0 ; j< size;j++)
            {
                if(i==j)
                    sum += arr[i][j];
            }
        }
        return sum;
    }
        public static int rowDuplicate(int arr[][],int size)
    {
        Hashtable<Integer,Integer> h=new Hashtable<>();
        int count=0;
        
        for(int i=0;i<size;i++)
        {
            int row[]=arr[i];
            h = new Hashtable<>();
            for(int j=0;j<row.length;j++)
            {
                if(!h.containsKey(row[j]))
                {
                    h.put(row[j],1);
                }
                else
                {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    public static int colDuplicate(int arr[][],int size)
    {
        Hashtable<Integer,Integer> h=new Hashtable<>();
        int count=0;
        
        for(int i=0;i<size;i++)
        {
            h = new Hashtable<>();
            for(int j=0;j<size;j++)
            {
                int ele=arr[j][i];
                if(!h.containsKey(ele))
                {
                    h.put(ele,1);
                }
                else
                {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}