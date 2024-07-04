import java.util.*;
class Vestigium {
	public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for(int z=1;z<=T;z++)
        {

            int size=sc.nextInt();
            int arr[][]=new int[size][size];

            for(int i=0;i<size;i++)
            {
                for(int j=0;j<size;j++)
                {
                    arr[i][j]=sc.nextInt();
                }
            }
            int k=trace(arr,size);

            int r=rowDuplicate(arr,size);

            int c=colDuplicate(arr,size);

            System.out.println("Case #" +z+ ":"+" " +k+ " " +r+ " " +c);
        }
    } 
    public static int rowDuplicate(int arr[][],int size)
    {
        Hashtable<Integer,Integer> h=new Hashtable<>();
        int flag=0;
        for(int i=0;i<size;i++)
        {
            int row[]=arr[i];
            for(int j=0;j<row.length;j++)
            {
                if(h.containsKey(row[j]))
                {
                    flag++;
                    break;
                }
                else
                {
                    h.put(row[j],1);
                }
            }
            h.clear();
        }
        return flag;
    }
    public static int colDuplicate(int arr[][],int size)
    {
        Hashtable<Integer,Integer> h=new Hashtable<>();
        int flag=0;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                int ele=arr[j][i];
                if(h.containsKey(ele))
                {
                    flag++;
                    break;
                }
                else
                {
                    h.put(ele,1);
                }
            }
            h.clear();
        }
        return flag;
    }
    public static int trace(int arr[][],int size)
    {
        int sums=0;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(i==j)
                    sums=sums+arr[i][j];
            }
        }
        return sums;
    }
}
