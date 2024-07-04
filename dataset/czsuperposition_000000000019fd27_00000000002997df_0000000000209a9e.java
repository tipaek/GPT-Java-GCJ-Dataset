import java.util.*;

public class Solution {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int B = scanner.nextInt();
        if(B != 10)
            System.exit(0);
        for(int i=0;i<T;i++)
        {
            String arr = "";
            System.out.println(1);
            int reply = scanner.nextInt();
            arr += reply;
            for(int j=1;j<B;j++)
            {
                System.out.println(j+1);
                reply = scanner.nextInt();
                arr += "" + reply;
            }
            System.out.println(arr);
            String ok = scanner.next();
            if(ok.equals("N"))
                System.exit(0);
        }
        System.exit(0);
    }
}
