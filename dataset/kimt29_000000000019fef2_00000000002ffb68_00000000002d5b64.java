import java.util.*;
import java.io.*;
import java.util.regex.Pattern;
public class Solution {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int r = scanner.nextInt();
            int s = scanner.nextInt();
            int min = (r-1)*(s-1);
            System.out.println("Case #" + i + ": " + min);
            int b = r * s - r - 1;
            int a = r;
            int count = s - 1;
            for (int j = 0; j < min; j++) {
                System.out.println(a + " " +  b);
                b--;
                count--;
                if (count == 0) {
                    count = s - 1;
                    a--;
                }
            }
        }
    }
}