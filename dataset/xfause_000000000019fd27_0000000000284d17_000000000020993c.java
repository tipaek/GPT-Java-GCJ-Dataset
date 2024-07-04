import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int T=input.nextInt();
        for(int p=1;p<=T;p++)
        {
            int size=input.nextInt();
            int matrix[][]=new int[size][size];
            for(int i=0;i<size;i++)
            {
                for(int j=0;j<size;j++)
                {
                    matrix[i][j]=input.nextInt();
                }
            }
            int k=trace(matrix,size);
            int row=row_calc(matrix,size);
            int col=col_calc(matrix,size);
            System.out.println("Case #" +p+ ":"+" " +k+ " " +row+ " " +col);
        }
    }

    public static int trace(int matrix[][],int size)
    {
        int sum=0;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(i==j)
                    sum+=matrix[i][j];
            }
        }
        return sum;
    }
    public static int row_calc(int matrix[][],int size)
    {
        Hashtable<Integer,Integer> h=new Hashtable<>();
        int count=0;
        for(int i=0;i<size;i++)
        {
            int row[]=matrix[i];
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

    public static int col_calc(int matrix[][],int size)
    {
        Hashtable<Integer,Integer> h=new Hashtable<>();
        int count=0;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                int ele=matrix[j][i];
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