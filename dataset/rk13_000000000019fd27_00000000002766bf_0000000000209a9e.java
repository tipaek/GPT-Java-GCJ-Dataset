import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] s = in.nextLine().split(" ");

        int t = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);

        for (int i = 1; i <= t; ++i) {
            int[] a = new int[b];
            if (b != 10) {
                System.out.println("00");
                String answer = in.nextLine();
                System.exit(1);
            }

            for (int j = 0; j < b; j++) {
                System.out.println(j + 1);
                a[j] = Integer.parseInt(in.nextLine());
            }
            System.out.println(Arrays.stream(a).boxed().map(String::valueOf).collect(Collectors.joining()));
            String answer = in.nextLine();
            if ("N".equals(answer)) {
                System.exit(1);
            }
        }
    }
}
