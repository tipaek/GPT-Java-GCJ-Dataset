import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            boolean done = false;

            for (int x = -5; x <= 5 && !done; x++) {
                for (int y = -5; y <= 5 && !done; y++) {
                    System.out.println(x + " " + y);
                    String result = in.next();

                    if (result.equals("CENTER")) {
                        done = true;
                    } else if (result.equals("WRONG")) {
                        System.out.println("ERROR");
                    }

                }
            }

        }
    }
}