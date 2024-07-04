import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author hum
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        String result = "Case #%d:";
        for (int cas = 1; cas <= n; cas++) {
            int num = sc.nextInt();
            if (num == 501) {
                System.out.println(String.format(result, cas));
                System.out.println("1 1");
                System.out.println("2 1");
                System.out.println("3 2");
                num -= 4;
                int i = 3;
                int j = 1;
                while (num-- > 0) {
                    System.out.println(i + " " + j);
                    i++;
                }
            } else if (num <= 500) {
                System.out.println(String.format(result, cas));
                int i = 1;
                int j = 1;
                while (num-- > 0) {
                    System.out.println(i + " " + j);
                    i++;
                }
            }
        }
    }
}