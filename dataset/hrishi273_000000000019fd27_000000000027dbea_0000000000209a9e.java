import java.util.*;

public class Solution {


    public static void main(String[] args) {
        int t, b;
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();
        b = sc.nextInt();

        while (t-- != 0) {
            int[] barr = new int[b];

            for (int i = 1; i <= b; i++) {
                int p;
                if (i % 10 == 1) {
                    int cnt = 30;
                    while (cnt-- != 0) {
                        System.out.println(i);
                        p = sc.nextInt();
                    }
                }
                System.out.println(i);
                p = sc.nextInt();
                
                barr[i-1] = p;    
            }

            StringBuilder sb = new StringBuilder();
            for (int n : barr) {
                sb.append(n);
            }

            System.out.println(sb);
            String response = sc.next();
            if ("N".equals(response))
                break;
            //System.out.println(response);
        }
    }
}
