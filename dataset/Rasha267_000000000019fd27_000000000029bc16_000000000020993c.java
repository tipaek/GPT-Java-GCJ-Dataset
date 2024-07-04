import java.util.*;

/**
 *
 * @author Rasha267
 */
public class Solution 
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int T=in.nextInt();
        for(int z=1;z<=T;z++)
        {

            int size=in.nextInt();
            int mat[][]=new int[size][size];

            for(int i=0;i<size;i++)
            {
                for(int j=0;j<size;j++)
                {
                    mat[i][j]=in.nextInt();
                }
            }
            int k=trace(mat,size);

            int r=row_count(mat,size);

            int c=col_count(mat,size);

            System.out.println("Case #" +z+ ":"+" " +k+ " " +r+ " " +c);
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
    public static int row_count(int arr[][],int size)
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

    public static int col_count(int arr[][],int size)
    {
        Hashtable<Integer,Integer> h=new Hashtable<>();
        int count=0;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                int col=arr[j][i];
                if(h.containsKey(col))
                {
                    count++;
                    break;
                }
                else
                {
                    h.put(col,1);
                }
            }
            h.clear();
        }
        return count;
    }
}
