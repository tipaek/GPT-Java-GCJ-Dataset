import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < t; i++) {
            String[] lineParsed = scanner.nextLine().split(" ");
            int r = Integer.parseInt(lineParsed[0]);
            int s = Integer.parseInt(lineParsed[1]);

            int totalPairs = (s - 1) * (r - 1);
            String[] output = new String[totalPairs];
            int counter = 0;

            int rConv = r * (s - 1);
            for (int k = r - 1; k > 0; k--) {
                for (int p = s - 1; p > 0; p--) {
                    output[counter] = rConv + " " + (r - 1);
                    rConv--;
                    counter++;
                }
                r--;
            }

            System.out.println("Case #" + (i + 1) + ": " + counter);
            for (String str : output) {
                System.out.println(str);
            }
        }
    }
}