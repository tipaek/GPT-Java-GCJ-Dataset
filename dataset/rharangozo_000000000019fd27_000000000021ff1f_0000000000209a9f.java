import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws RuntimeException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        in.nextLine();
//        System.out.println(t);
        for (int c = 0; c < t; ++c) {

            String line = in.nextLine().trim();
            int last = 0;
            System.out.print("Case #" + (c + 1) + ": ");
            for (int i = 0; i < line.length(); ++i) {
                int curr = line.charAt(i) - '0';
                int opening = curr - last;
                last = curr;
                if (opening < 0) {

                    for (int k = 0; k < -opening; ++k) {
                        System.out.print(')');
                    }
                    System.out.print(line.charAt(i));
                } else {
                    for (int k = 0; k < opening; ++k) {
                        System.out.print('(');
                    }
                    System.out.print(line.charAt(i));
                }
            }
            for (int k = 0; k < last; ++k) {
                System.out.print(')');
            }

            System.out.println();

        }
    }

    private static boolean hasDupes(String[] a) {
        Set<String> s = new HashSet<String>();
        Collections.addAll(s, a);
        return a.length != s.size();
    }
}
