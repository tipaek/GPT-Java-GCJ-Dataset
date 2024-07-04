import java.util.*;
public class Solution{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), b = sc.nextInt();
        while(t-->0)
        {
            StringBuilder sb = new StringBuilder("");
            int p = 1;
            while(p<=10)
            {
                System.out.println(p);
                String ans = sc.next();
                if(ans.charAt(0)=='N')
                    System.exit(0);
                sb.append(ans);
                p++;
            }
            System.out.println(sb.toString());
            String ans = sc.next();
            if(ans.charAt(0)=='Y')
                continue;
            System.exit(0);
        }
    }
}