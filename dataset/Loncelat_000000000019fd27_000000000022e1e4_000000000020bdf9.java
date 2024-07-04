import java.io.*;
import java.util.*;
class Solution {
    static Scanner sc;
    static void testcase(int no) {

        int n = sc.nextInt();

        char o[] = new char[n];
        Activity act[] = new Activity[n];
        Activity cam = new Activity(-1000, -1000, -1);
        Activity jamie = cam;

        for (int i = 0; i < n; i++) {
            act[i] = new Activity(sc.nextInt(), sc.nextInt(), i);
        }

        Arrays.sort(act);

        for (int i = 0; i < n; i++) {

            if (act[i].start >= cam.end) {
                cam = act[i];
                o[act[i].id] = 'C';
            }
            else if (act[i].start >= jamie.end) {
                jamie = act[i];
                o[act[i].id] = 'J';
            }
            else {
                System.out.printf("Case #%d: IMPOSSIBLE\n", no);
                return;
            }

        }

        System.out.printf("Case #%d: %s\n", no, new String(o));



    }
    public static void main(String args[]) {
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            testcase(i + 1);
        }
    }
}

class Activity implements Comparable<Activity> {
    int start, end, id;
    public Activity(int a, int b, int c) {
        start = a;
        end = b;
        id = c;
    }

    @Override
    public int compareTo(Activity a) {
        return Integer.compare(start, a.start);
    }
}