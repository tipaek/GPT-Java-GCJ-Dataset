import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();

        for (int i = 0; i < tests; i++) {
            int r = in.nextInt();
            int s = in.nextInt();

            int count = 0;
            int pile = 1;
            StringBuilder str = new StringBuilder();


            for (int x = 1; x < r; x++) {
                int uppile = 0;
                for (int j = 1; j < s; j++) {
                    int a = r * (s - j-(x-1)) + uppile;
                    int b = r * s - a - pile;
                    uppile = b;
                    count++;
                    pile++;
                    str.append(a);
                    str.append(" ");
                    str.append(b);
                    str.append("\n");
                    //System.out.println(String.format("%d, %d", a, b));

                }
            }

            System.out.println(String.format("Case #%d: %d", i+1, count));
            System.out.print(str.toString());


        }
    }
}