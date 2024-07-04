import java.util.*;
import java.io.*;

class Pair {
    int start, end, index;

    Pair(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

class SortByIndex implements Comparator<Pair> {
    @Override
    public int compare(Pair a, Pair b) {
        return Integer.compare(a.index, b.index);
    }
}

class SortByStart implements Comparator<Pair> {
    @Override
    public int compare(Pair a, Pair b) {
        return Integer.compare(a.start, b.start);
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int q = 1; q <= testCases; q++) {
            int len = scanner.nextInt();
            System.out.print("Case #" + q + ": ");
            List<Pair> activities = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                activities.add(new Pair(scanner.nextInt(), scanner.nextInt(), i));
            }

            Collections.sort(activities, new SortByStart());
            char[] output = new char[len];
            output[activities.get(0).index] = 'C';
            int cameronEnd = activities.get(0).end;
            int jamieEnd = 0;
            boolean possible = true;

            for (int i = 1; i < len; i++) {
                int start = activities.get(i).start;

                if (cameronEnd <= start) {
                    output[activities.get(i).index] = 'C';
                    cameronEnd = activities.get(i).end;
                } else if (jamieEnd <= start) {
                    output[activities.get(i).index] = 'J';
                    jamieEnd = activities.get(i).end;
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                for (char c : output) {
                    System.out.print(c);
                }
                System.out.println();
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}