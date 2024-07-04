import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int cas = scanner.nextInt();

        char[] symb = {'J','C'};

        for (int i = 0; i < cas; i++) {
            int n = scanner.nextInt();
            boolean possible = true;

            Interval[] intervals = new Interval[n];
            Integer[] idx = new Integer[n];
            char[] att = new char[n];
            int[] disp = {0,0};

            for (int j = 0; j < n; j++) {
                intervals[j] = new Interval(scanner.nextInt(), scanner.nextInt());
                idx[j] = j;
            }

            Arrays.sort(idx, Comparator.comparingInt(a -> intervals[a].deb));

            for (int j = 0; j < n; j++) {
                int k = idx[j];
                Interval interval = intervals[k];

                if (interval.deb >= disp[0]) {
                    att[k] = symb[0];
                    disp[0] = interval.fin;
                } else if (interval.deb >= disp[1]) {
                    att[k] = symb[1];
                    disp[1] = interval.fin;
                } else {
                    possible = false;
                    break;
                }
            }

            StringBuilder str = new StringBuilder("Case #");
            str.append(i+1).append(": ");

            if (possible) {
                for (int j = 0; j < n; j++) {
                    str.append(att[j]);
                }
            } else
                str.append("IMPOSSIBLE");

            System.out.println(str.toString());
        }
    }

}

class Interval {
    int deb, fin;

    public Interval(int deb, int fin) {
        this.deb = deb;
        this.fin = fin;
    }
}
