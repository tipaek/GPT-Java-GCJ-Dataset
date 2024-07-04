import java.util.*;

public class Solution
{
    public static void main (String[] args)
    {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        int i = 0;
        while(i < t)
        {
            i++;
            String s = sc.next();
            char[] cs = s.toCharArray();
            int[] arr = new int[s.length()];
            int l = 0;
            for(char c: cs)
            {
                arr[l] = Integer.parseInt(String.valueOf(c));
                l++;
            }
        
            StringBuilder f = new StringBuilder();
            int m = 0;
            int n = 0;
            for(int t1 = 0; t1 < arr[0]; t1++)
            {
                f.append("(");
                m++;
            }
            f.append(arr[0]);
          
            for(int t1 = 1; t1 < arr.length; t1++)
            {
                int t2 = arr[t1 - 1] - arr[t1];
                if(t2 >= 0){
                    for(int t3 = 0; t3 < t2; t3++)
                    {
                    f.append(")");
                    n++;
                    }
                }
                else if(t2 < 0)
                {
                    for(int t3 = 0; t3 < -t2; t3++)
                    {
                    f.append("(");
                    m++;
                    }
                }
                f.append(arr[t1]);

            }
            if(m - n > 0)
            {
                for(int t2 = 0; t2 < m - n; t2++)
                {
                    f.append(")");
                }
            }

            System.out.println("Case #" + i + ": " + f.toString());

        }
        sc.close();

    }
}