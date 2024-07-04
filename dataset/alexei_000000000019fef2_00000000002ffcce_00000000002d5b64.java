import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int c = 1; c <= T ; c++) {
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            int count = 0;

            int r = in.nextInt();
            int s = in.nextInt();

            while (r > 1) {
                for (int i = 0; i < s - 1; i++) {
                    count++;
                    a.add(r * (s - 1) - i);
                    b.add(r - 1);

                }
                r--;
            }
            System.out.println(String.format("Case #%d: %d", c, count));
            for (int i = 0; i < count; i++) {
                System.out.println(String.format("%d %d", a.get(i), b.get(i)));
            }
        }
    }
}