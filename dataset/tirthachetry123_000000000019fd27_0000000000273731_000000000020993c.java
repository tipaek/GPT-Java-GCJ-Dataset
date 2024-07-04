
import java.util.*;

class Solution {
    
    public static int row_duplicate(int arr[][],int size)
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

    public static int col_duplicate(int arr[][],int size)
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
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int t =0;
        int q = 0;
        if(s.hasNext()){t=s.nextInt();}
        for(q=0;q<t;q++){
            int N = s.nextInt();
            int [][]arr = new int[N][N];
            int diagonal = 0;
            for(int i =0;i<N;i++){
                for(int j=0;j<N;j++){
                    arr[i][j]=s.nextInt();
                    if(i==j){diagonal+=arr[i][j];}
                }
            }
            int res = q+1;
            System.out.println("Case "+ "#"+res+": "+diagonal+" "+row_duplicate(arr,N)+" "+col_duplicate(arr,N));
            
        }


    }
}