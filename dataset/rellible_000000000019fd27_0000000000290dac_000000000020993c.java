import java.util.*;

public class Solution
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        for(int i = 1; i <= S; i++)
        {
            int size = sc.nextInt();
            int mt[][] = new int [size][size];
            
            for(int x = 0; x < size; x++)
            {
                for(int j = 0; j < size; j++)
                {
                    mt[x][j] = sc.nextInt();
                }
            }
            int k = track(mt, size);
            int r = rowDup(mt, size);
            int c = colDup(mt, size);
            
            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
        
        
    }
    private static int track(int arr[][], int size)
    {
        int sum = 0;
        for(int i = 0; i<size; i++)
        {
            for(int j = 0; j<size; j++)
            {
                if(i==j)
                {
                    sum = sum+arr[i][j];
                }
            }
        }
        return sum;
    }
    private static int rowDup(int arr[][], int size)
    {
        Hashtable<Integer, Integer> h = new Hashtable<>();
        int cnt = 0;
        for(int i = 0; i < size; i++)
        {
          int row[] = arr[i];
          for(int j = 0; j < row.length; j++)
          {
              if(h.containsKey(row[j]))
              {
                  cnt ++;
                  break;
              }
              else
              {
                  h.put(row[j], i);
              }
          }
          h.clear();
        }
        return cnt;
    }
    private static int colDup(int arr[][], int size)
    {
        Hashtable<Integer, Integer> h = new Hashtable<>();
        int cnt = 0;
        for(int i = 0; i<size; i++)
        {
            for(int j = 0; j<size; j++)
            {
                int el = arr[j][i];
                if(h.containsKey(el))
                {
                    cnt++;
                    break;
                }
                else
                {
                    h.put(el, 1);
                }
            }
            h.clear();
        }
        return cnt;
    }
}