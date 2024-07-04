import java.util.*;
import java.io.*;

class Task implements Comparable<Task> {

    int start;
    int end;
    char owner;
    int index;

    public Task(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public char getOwner() {
        return owner;
    }

    public void setOwner(char owner) {
        this.owner = owner;
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
                tasks.add(new Task(st, en, j));
            }

            Collections.sort(tasks);

            StringBuffer r = new StringBuffer(n);
            for (int j = 0; j < n; j++)
                r.append(' ');

            tasks.get(0).setOwner('C');

            for (int j = 1; j < n; j++) {
                boolean intersect = false;
                for (int k = 0; k < j; k++) {
                    if (tasks.get(k).getOwner() == 'C' && isIntersect(tasks.get(j), tasks.get(k))) {
                        intersect = true;
                        break;
                    }
                }
                if (!intersect)
                    tasks.get(j).setOwner('C');
                else {
                    intersect = false;
                    for (int k = 0; k < j; k++) {
                        if (tasks.get(k).getOwner() == 'J' && isIntersect(tasks.get(j), tasks.get(k))) {
                            intersect = true;
                            break;
                        }
                    }
                    if (!intersect)
                        tasks.get(j).setOwner('J');
                    else {
                        r = new StringBuffer("IMPOSSIBLE");
                        break;
                    }
                }
            }

            if (!r.toString().equals("IMPOSSIBLE"))
                for (int j = 0; j < n; j++)
                    r.setCharAt(tasks.get(j).getIndex(), tasks.get(j).getOwner());

            System.out.println("Case #" + i + ": " + r);
        }
    }
}

