import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(reader.readLine());
            Interval[] A = new Interval[N];
            for (int j = 0; j < N; j++) {
                String[] temp = reader.readLine().split("[ ]");
                A[j] = new Interval(j, Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
            }
            String result = solution(N, A);
            System.out.println("Case #" + i + ": " + result);

        }
        reader.close();
    }

    public static String solution(int N, Interval[] A) {
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval P, Interval Q) {
                return P.start - Q.start;
            }
        };
        Arrays.sort(A, comparator);
        LinkedList<Interval> C = new LinkedList<>();
        LinkedList<Interval> J = new LinkedList<>();
        for (Interval current : A) {
            if (isValid(C, current)) {
                C.addLast(current);
            } else if (isValid(J, current)) {
                J.addLast(current);
            } else {
                return "IMPOSSIBLE";
            }
        }
        char[] types = new char[N];
        for (Interval current : C) {
            types[current.id] = 'C';
        }
        for (Interval current : J) {
            types[current.id] = 'J';
        }
        return String.valueOf(types);
    }

    private static boolean isValid(LinkedList<Interval> list, Interval current) {
        return list.isEmpty() || isValid(list.peekLast(), current);
    }

    private static boolean isValid(Interval A, Interval B) {
        return B.start >= A.end;
    }


    public static class Interval {
        int start, end;
        int id;

        public Interval(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }
    }

}
