

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int tests = scanner.nextInt();

            for (int t = 0; t < tests; t++) {
                int N = scanner.nextInt();
                Day d = new Day();
                boolean isPOssible = true;
                for (int i = 0; i < N; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    Period p = new Period(start, end, i + 1);
                    boolean result = d.add(p);
                    if (!result) {
                        isPOssible = false;
                        break;
                    }
                }

                sout(t + 1, isPOssible ? d.answer : "IMPOSSIBLE");
            }
            scanner.close();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }


    private static void sout(int x, String s) {
        System.out.println("Case #" + x + ": " + s);
    }
}

class Period {
    int start;
    int end;
    int n;

    public Period(int start, int end, int n) {
        this.start = start;
        this.end = end;
        this.n = n;
    }

    public boolean overlap(Period p) {
        if (this.start < p.end && this.end >= p.end) return true;
        if (p.start < this.end && p.end >= this.end) return true;

        return false;
    }
}

class Day {
    String answer = "";
    List<Period> c = new LinkedList<>();
    List<Period> j = new LinkedList<>();

    public boolean add(Period period) {
        Optional<Period> first = c.stream().filter(p -> p.overlap(period)).findFirst();
        if (!first.isPresent()) {
            c.add(period);
            answer += "C";
            return true;
        }

        Optional<Period> second = j.stream().filter(p -> p.overlap(period)).findFirst();
        if (!second.isPresent()) {
            j.add(period);
            answer += "J";
            return true;
        }

        return false;
    }


}

