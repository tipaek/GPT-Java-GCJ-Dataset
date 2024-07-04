import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            if (n <= 500) {
                System.out.println("Case #" + i + ":");
                for (int j = 1; j <= n; j++)
                    System.out.println(j + " 1");
            } else
            if (n == 501) {
                System.out.println("Case #" + i + ":");
                System.out.println("1 1");
                System.out.println("2 2");
                System.out.println("3 2");
                for (int j = 3; j <= 499; j++)
                    System.out.println(j + " 1");
            }
            else {
                System.out.println("Case #" + i + ":");
                if (n % 2 == 0) {
                    int x = n - 497;
                    int a1 = x/2;
                    for (int j = 1; j <= a1; j++)
                        System.out.println(j + " 1");
                    System.out.println(a1+1 + " 2");
                    System.out.println(a1+2 + " 2");
                    for (int j = a1+2; j <= 498; j++)
                        System.out.println(j + " 1");
                    
                }
                if (n % 2 == 1) {
                    int x = n - 498;
                    int a1 = x/2;
                    for (int j = 1; j <= a1; j++)
                        System.out.println(j + " 1");
                    System.out.println(a1+1 + " 2");
                    System.out.println(a1+2 + " 2");
                    for (int j = a1+2; j <= 499; j++)
                        System.out.println(j + " 1");
                    
                }
            }

        }
    }
}