
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    class work {

        int start, end, index;
        String d;
    }

    public class myCom implements Comparator<work> {

        @Override
        public int compare(work ob1, work ob2) {
            return ob1.end >= ob2.end ? 1 : -1;
        }

    }

    public class res implements Comparator<work> {

        @Override
        public int compare(work ob1, work ob2) {
            return ob1.index > ob2.index ? 1 : -1;
        }

    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        float q = scan.nextInt();
        StringBuffer sb = new StringBuffer();
        int p = 0;
        while (q-- > 0) {
            ++p;
            int n = scan.nextInt();
            Solution cm = new Solution();
            Solution.work ob[] = new Solution.work[n];
            for (int i = 0; i < n; i++) {
                ob[i] = cm.new work();
                ob[i].index = i;
                ob[i].start = scan.nextInt();
                ob[i].end = scan.nextInt();
            }

            Arrays.sort(ob, cm.new myCom());
            int cf = 0, jf = 0;
            boolean ch = false;
            for (int i = 0; i < n; i++) {
                if (ob[i].start >= cf || ob[i].start >= jf) {
                    if (ob[i].start >= cf) {

                        cf = ob[i].end;
                        ob[i].d ="C";
                    } else if (ob[i].start >= jf) {
                        jf = ob[i].end;
                        ob[i].d = "J";
                    }
                } else {
                    ch = true;
                    break;
                }

            }
            if (ch) {
                sb.append("Case #" + p + ": IMPOSSIBLE");
            } else {
                sb.append("Case #" + p + ": ");
                Arrays.sort(ob, cm.new res());
                for (int i = 0; i < n; i++) {
                    sb.append(ob[i].d);
                }
            }
            if (q != 0) {
                sb.append("\n");
            }

        }
        System.out.println(sb);

    }

}
