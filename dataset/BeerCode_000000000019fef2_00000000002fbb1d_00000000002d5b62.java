import java.util.*;
class Solution {
    public static void main(String[] data) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int x = in.nextInt();
            int y = in.nextInt();
            LinkedList<Info> queue = new LinkedList<Info>();
            queue.add(new Info("", 0, 0, 0));
            String best = "IMPOSSIBLE";
            while (true) {
                if (queue.size() == 0) {
                    break;
                }
                Info current = queue.removeFirst();
                if (current.x == x && current.y == y) {
                    best = current.path;
                    break;
                }
                int last = current.last * 2;
                if (last == 0) last = 1;
                if (last / 4 > Math.abs(x) + Math.abs(y)) break;
                queue.add( new Info(current.path+'E', current.x+last, current.y, last));
                queue.add( new Info(current.path+'W', current.x-last, current.y, last));
                queue.add( new Info(current.path+'N', current.x, current.y+last, last));
                queue.add( new Info(current.path+'S', current.x, current.y-last, last));
            }
            System.out.println("Case #" + t + ": " + best);
        }
    }
}
class Info {
    String path = "";
    int x;
    int y;
    int last;
    Info(String p, int x, int y, int l) {
        path = p; this.x = x; this.y = y; last = l;
    }
}