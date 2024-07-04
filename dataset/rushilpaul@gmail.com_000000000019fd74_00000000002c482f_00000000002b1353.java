import java.util.*;

class Solution
{

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {

            int n = sc.nextInt();
            System.out.printf("Case #%d:\n", t);
            System.out.printf("%d %d\n", 1, 1);
            n--;
            int s = 1;
            while(n-s >= 0) {
                n -= s;
                System.out.printf("%d %d\n", s + 1, 2);
                s++;
            }
            s--;
            for(int i = 0; i < n; i++)
                System.out.printf("%d %d\n", s + 1 + i, 1);
        }
    }
}
