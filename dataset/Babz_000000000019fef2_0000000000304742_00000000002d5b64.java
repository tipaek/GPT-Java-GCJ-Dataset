import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int j = 1; j <= t; ++j) {
            int r = in.nextInt();
            int s = in.nextInt();
            int count = 0;
            List<String> myShuffle = new ArrayList<>();
            if (r > s) {
                int lastShuffle = s;
                for (int i = r * (s - 1); (i >= s); i--) {
                    count++;
                    myShuffle.add(String.format("%d %d", i, lastShuffle));
                    if (count % (s - 1) == 0) {
                        lastShuffle--;
                    }
                }
                System.out.println("Case #" + j + ": " + count);
                myShuffle.forEach(c -> System.out.println(c));
            }
           else if (r == s) {
                int lastShuffle = s - 1;
                for (int i = r * (s - 1); (i >= s); i--) {
                    count++;
                    myShuffle.add(String.format("%d %d", i, lastShuffle));
                    if (count % (s - 1) == 0) {
                        lastShuffle--;
                    }
                }
                System.out.println("Case #" + j + ": " + count);
                myShuffle.forEach(c -> System.out.println(c));
            } else {
                int start = (r - 1) * s;
                int firstShuffle = r;
                for (int i = start; (i >= r); i--) {
                    count++;
                    myShuffle.add(String.format("%d %d", firstShuffle, i));
                    if (count % r == 0) {
                        firstShuffle--;
                    }
                }
                System.out.println("Case #" + j + ": " + count);
                myShuffle.forEach(c -> System.out.println(c));
            }

        }
    }
}