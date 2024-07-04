import java.util.*;

public class Solution {

    private static class E {
        public int start;
        public int end;
        public int index;
        public char job;

        public E(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public String toString() {
            return "(" + start + " " + end + " " + index + ")";
        }
    }

    public static String solve3(Scanner s) {
        int n = s.nextInt();
        E[] a = new E[n];
        for (int i = 0; i < n; i++) {
            int st = s.nextInt();
            int end = s.nextInt();
            a[i] = new E(st, end, i);
        }
        Arrays.sort(a, new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                return o1.start == o2.start ? (o1.end - o2.end) : o1.start - o2.start;
            }
        });
        int cEnd = -1;
        int jEnd = -1;
        for (int i = 0; i < n; i++) {
            if (cEnd <= a[i].start) {
                a[i].job = 'C';
                cEnd = a[i].end;
            } else if (jEnd <= a[i].start) {
                a[i].job = 'J';
                jEnd = a[i].end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        Arrays.sort(a, new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                return o1.index - o2.index;
            }
        });
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            stringBuffer.append(a[i].job);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 1; t <= T; t++) {
            System.out.println("Case #" + t + ": " + solve3(s));
        }
    }
}
