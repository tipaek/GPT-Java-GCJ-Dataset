import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; i++) {
            StringBuilder result = new StringBuilder();
            int n = in.nextInt();
            in.nextLine();

            List<Tuple> activities = new ArrayList<>();
            for (int x = 0; x < n; x++) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities.add(new Tuple(x, start, end));
                in.nextLine();
            }

            activities.sort(new TupleComparator());

            int jamieLast = -1;
            int cameronLast = -1;
            boolean impossible = false;
            for (Tuple activity : activities) {
                int start = activity.start;
                int end = activity.end;

                if (start >= jamieLast) {
                    activity.setPerson("J");
                    jamieLast = end;
                } else if (start >= cameronLast) {
                    activity.setPerson("C");
                    cameronLast = end;
                } else {
                    impossible = true;
                    break;
                }
            }

            activities.sort(new TupleIndexComparator());

            for (Tuple activity : activities) {
                result.append(activity.person);
            }

            if (impossible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + result.toString());
            }
        }
    }

    static class Tuple {
        final int index;
        final int start;
        final int end;
        String person;
        Tuple(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        void setPerson(String person) {
            this.person = person;
        }
    }

    static class TupleComparator implements Comparator<Tuple> {
        @Override
        public int compare(Tuple o1, Tuple o2) {
            if (o1.start < o2.start) {
                return -1;
            } else if (o1.start > o2.start) {
                return 1;
            }
            return 0;
        }
    }

    static class TupleIndexComparator implements Comparator<Tuple> {
        @Override
        public int compare(Tuple o1, Tuple o2) {
            if (o1.index < o2.index) {
                return -1;
            } else if (o1.index > o2.index) {
                return 1;
            }
            return 0;
        }
    }
}