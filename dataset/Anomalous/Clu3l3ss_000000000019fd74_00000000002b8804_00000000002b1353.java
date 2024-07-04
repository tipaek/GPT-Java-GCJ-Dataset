import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int number = Integer.parseInt(reader.readLine());
            System.out.println("Case #" + testCase + ":");

            if (number <= 500) {
                for (int i = 1; i <= number; i++) {
                    System.out.println(i + " " + 1);
                }
            } else if (number == 501) {
                System.out.println("1 1");
                System.out.println("2 1");
                System.out.println("3 2");
                for (int i = 3; i <= 499; i++) {
                    System.out.println(i + " 1");
                }
            }
        }
    }
}