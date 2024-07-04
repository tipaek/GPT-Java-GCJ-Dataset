import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t=scanner.nextInt();
        for(int z = 0;z<t;z++) {
            boolean flag = false;
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            
            for(int i=1;i<=n;i++) {
                if (i*n == k) {
                    flag = true;
                    break;
                }
            }

            if (flag)
                System.out.println("Case #"+(z+1)+": POSSIBLE");
            else
                System.out.println("Case #"+(z+1)+": IMPOSSIBLE");
        }
    }
}
