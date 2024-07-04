import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public  static void  main(String[]  args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testNum = scanner.nextInt();
        for (int i = 0; i < testNum; i++)  {
            solve(scanner, i);
        }
    }

    private static void solve(Scanner scanner, int testNum) {
        int n = scanner.nextInt();
        Period[] periods = new Period[n];
        for (int i = 0; i < n; i++) {
            periods[i] = new Period(scanner.nextInt(), scanner.nextInt(), i);
        }
        Arrays.sort(periods);

        int endJ = Integer.MIN_VALUE;
        int endC = Integer.MIN_VALUE;
        boolean isImposible = false;
        for (Period p : periods) {
            if (p.start >= endC) {
                p.whoDuty = 'C';
                endC = p.end;
            } else if (p.start >= endJ) {
                p.whoDuty = 'J';
                endJ = p.end;
            } else {
                isImposible = true;
                break;
            }
        }

        System.out.print("Case #" + (testNum + 1) +  ": ");
        System.out.print(isImposible ? "IMPOSSIBLE" : getResult(periods));
        System.out.println("");
    }

    private static String getResult(Period[] periods) {
        Arrays.sort(periods, Comparator.comparingInt(p -> p.index));
        StringBuilder sb = new StringBuilder();
        for (Period p : periods) {
            sb.append(p.whoDuty);
        }
        return sb.toString();
    }

    private static class Period implements Comparable<Period>{
        final int start;
        final int end;
        final int index;
        char whoDuty;

        Period(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Period other) {
            return start - other.start;
        }
    }
}
