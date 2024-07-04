import java.util.*;

class Solution
{

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {

            int n = sc.nextInt();
            System.out.printf("Case #%d:\n", t);
            if(n <= 500) {
                for(int i = 0; i < n; i++)
                    System.out.printf("%d %d\n", i+1, 1);
            } else {
                System.out.printf("%d %d\n", 1, 1);
                System.out.printf("%d %d\n", 2, 1);
                System.out.printf("%d %d\n", 3, 2);
                System.out.printf("%d %d\n", 3, 1);
                n -= 5;
                for(int i = 0; i < n; i++)
                    System.out.printf("%d %d\n", i+4, 1);
            }
        }
    }
}
