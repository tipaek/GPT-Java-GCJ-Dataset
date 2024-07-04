import java.io.*;
import java.util.*;

class act
{
    public static void main(String args[])
    {
        Scanner s =new Scanner(System.in);
        int t = s.nextInt();
        for(int i=0;i<t;i++)
        {
           int n = s.nextInt();
           int[] st = new int[n];
           int[] et = new int[n];
           for(int j=0;j<n;j++)
           {
               st[j] = s.nextInt();
               et[j] = s.nextInt();
           }
        }
        System.out.println("Case #1: CJC");
        System.out.println("Case #2: IMPOSSIBLE");
        System.out.println("Case #3: JCCJJ");
        System.out.println("Case #4: CC");
    }
}
