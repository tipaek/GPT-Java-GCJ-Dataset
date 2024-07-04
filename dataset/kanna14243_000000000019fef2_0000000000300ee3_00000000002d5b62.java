import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static boolean found = false;
    public static String result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTests = sc.nextInt();
        int i = 1;
        while (i <= numTests) {
            found = false;
            int x = sc.nextInt();
            int y = sc.nextInt();
            Queue<Data> queue = new LinkedList<>();
            Data data = new Data(x, y, 1, new StringBuilder());
            queue.add(data);
            while (!queue.isEmpty()) {
                Data data1 = queue.poll();
                if ((data1.x != 0 && data1.step > Math.abs(data1.x)) || (data1.y != 0 && data1.step > Math
                        .abs(data1.y)) || found) {
                    continue;
                }
                if (data1.x == 0 && data1.y == 0) {
                    found = true;
                    result = data1.sb.toString();
                }
                if (x != 0) {
                    StringBuilder sbe = new StringBuilder(data1.sb);
                    sbe.append('E');
                    queue.add(new Data(data1.x - data1.step, data1.y, data1.step * 2, sbe));
                    StringBuilder sbw = new StringBuilder(data1.sb);
                    sbw.append('W');
                    queue.add(new Data(data1.x + data1.step, data1.y, data1.step * 2, sbw));
                }
                if (y != 0) {
                    StringBuilder sbn = new StringBuilder(data1.sb);
                    sbn.append('N');
                    queue.add(new Data(data1.x, data1.y - data1.step, data1.step * 2, sbn));
                    StringBuilder sbs = new StringBuilder(data1.sb);
                    sbs.append('S');
                    queue.add(new Data(data1.x, data1.y + data1.step, data1.step * 2, sbs));
                }
            }
            if (found) {
                System.out.println("Case #" + (i) + ": " + result);
            } else {
                System.out.println("Case #" + (i) + ": " + "IMPOSSIBLE");
            }
            i++;
        }
    }
    public static class Data {
        int x;
        int y;
        int step;
        StringBuilder sb;

        Data(int x, int y, int step, StringBuilder sb) {
            this.x = x;
            this.y = y;
            this.step = step;
            this.sb = sb;

        }
    }
}
