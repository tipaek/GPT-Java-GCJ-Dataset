import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution{
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
          
        sol();
    }

    public static void sol()
    {
        int test = in.nextInt();

        in.nextLine();
      
        for(int t=0; t<test;t++)
        {
            String result = sol2();
            System.out.println("Case #"+(t+1)+": "+result);
        }
      
    }
  
    public static String sol2()
    {
        int n = in.nextInt();

        int[][] arr = new int[n][2];
        int[][] sortArr = arr.clone();
      
  
        char p = 'J';
        char[] ch = new char[n];
      
      
      
        Map< int[],Integer> map = new  HashMap<>();
      
        Stack<int[]> s1 = new Stack<>() ;
        Stack<int[]> s2 = new Stack<>() ;
      
        boolean impossible = false;
      
        for(int i = 0; i<arr.length; i++)
        {
            for(int j = 0; j< arr[i].length;j++)
            {
                arr[i][j] = in.nextInt();
              
            }
            map.put(arr[i] ,i );
        }
      
        Arrays.sort(sortArr  , new Comparator<int[]>()
        {
            @Override
            public int compare(int[] a, int[] b )
            {
                return a[0] - b[0];
            }
        });
      
      
      
        for (int i = 0; i < sortArr.length; i++)
        {
            ch[map.get(sortArr[i])] =p ;
            if(i <  sortArr.length-1 && doesOverlap(sortArr[i], sortArr[i+1] ))
            {
                if(p == 'J')
                {
                s1.push(sortArr[i] );
                p = getPerson(p);
              
                if(!s2.isEmpty() && doesOverlap( s2.peek() , sortArr[i+1]))
                {
                    impossible = true;
                    break;
                }
              
              
              
                }
                else
                {
                    s2.push(sortArr[i] );
                    p = getPerson(p);
                  
                    if(!s1.isEmpty() && doesOverlap( s1.peek() , sortArr[i+1]))
                    {
                        impossible = true;
                        break;
                    }
                  
                }
            }
            else {
              
                if(p == 'J')
                {
                    s1.push(sortArr[i]);
                }
                else
                {
                    s2.push(sortArr[i]);
                }
            }
      
          
          
        }
      
      
      
      
      
        return impossible? "IMPOSSIBLE": new String(ch) ;
      
    }
  
    private static char getPerson(char p )
    {
        return p =='J' ? 'C' :'J' ;
    }

    public static boolean doesOverlap(int[] a, int[] b)
    {
        return a[1] > b[0];
    }
  
  

}
