import java.util.*;
import java.io.*;

class Task implements Comparable<Task> {

    int start;
    int end;

    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {

        return end;
    }

    @Override
    public int compareTo(Task t) {
        return this.getStart() - t.getStart();
    }
}

public class Solution {


    static boolean isIntersect(Task j, Task k) {

        return (!(k.getStart() >= j.getEnd() || j.getStart() >= k.getEnd()));
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

//        Scanner s = null;
//        try {
//            s = new Scanner (new File("test.in"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace ();
//        }
//        if (s == null)
//            return;

        int t = s.nextInt();
        for (int i = 1; i <= t; ++i) {

            int n = s.nextInt();

            ArrayList<Task> tasks = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int st = s.nextInt();
                int en = s.nextInt();
                tasks.add(new Task(st, en));
            }

            Collections.sort(tasks);

            String r = "C";

            for (int j = 1; j < n; j++) {
                boolean intersect = false;
                for (int k = 0; k < j; k++) {
                    if (r.charAt(k) == 'C' && isIntersect(tasks.get(j), tasks.get(k))) {
                        intersect = true;
                        break;
                    }
                }
                if (!intersect)
                    r += 'C';
                else {
                    intersect = false;
                    for (int k = 0; k < j; k++) {
                        if (r.charAt(k) == 'J' && isIntersect(tasks.get(j), tasks.get(k))) {
                            intersect = true;
                            break;
                        }
                    }
                    if (!intersect)
                        r += 'J';
                    else {
                        r = "IMPOSSIBLE";
                        break;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + r);
        }
    }
}

