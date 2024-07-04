import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public  static void  main(String[]  args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testNum = scanner.nextInt();
        for (int i = 0; i < testNum; i++)  {
            solve(scanner, i);
        }
    }

    private static void solve(Scanner scanner, int testNum) {
        long L = scanner.nextLong();
        long R = scanner.nextLong();

        long i = 1;
        while (true) {
            if (L >= R) {
                if (L >= i) {
                    L -= i;
                } else {
                    i--;
                    break;
                }
            } else {
                if (R >= i) {
                    R -= i;
                } else {
                    i--;
                    break;
                }
            }
            i++;
        }

        System.out.print("Case #" + (testNum + 1) +  ": ");
        System.out.println("" + i + " " + L + " " + R);
    }
}