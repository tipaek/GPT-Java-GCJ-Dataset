import java.util.*;

public class Solution {
    public static class Pair{
        long x;
        long y;
        int len;
        String path;

        public Pair(long a, long b, int c, String d){
            this.x = a;
            this.y = b;
            this.len = c;
            this.path = d;
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int a = 1; a <= T; a++){
            long x = sc.nextInt();
            long y = sc.nextInt();

            Queue<Pair> q = new LinkedList<Pair>();
            Pair start = new Pair(0,0, 0, "");
            q.add(start);

            int len = -1;
            String path = "";
            int ct = -1;

            while(!q.isEmpty()){
                Pair next = q.remove();
                if (next.x == x && next.y == y){
                    len = next.len;
                    path = next.path;
                    break;
                }

                if (next.len > 8){
                    System.out.println("IMPOSSIBLE");
                    break;
                }


                Pair p1 = new Pair (next.x, next.y + (1 << next.len), next.len + 1, next.path + "N");
                Pair p2 = new Pair (next.x, next.y - (1 << next.len), next.len + 1, next.path + "S");
                Pair p3 = new Pair (next.x + (1 << next.len), next.y, next.len + 1, next.path + "E");
                Pair p4 = new Pair (next.x - (1 << next.len), next.y, next.len + 1, next.path + "W");
                q.add(p1);
                q.add(p2);
                q.add(p3);
                q.add(p4);

            }

            if (!path.equals("")) System.out.println(path);

        }
    }
}
