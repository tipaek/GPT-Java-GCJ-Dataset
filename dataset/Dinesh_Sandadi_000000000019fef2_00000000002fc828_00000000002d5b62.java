import java.util.*;

public class Solution {
    class Point{
        int x;
        int y;
        Point parent;
        Character dir;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
            this.parent = null;
            this.dir = null;
        }
        @Override
        public boolean equals(Object other){
            if(other == null)
                return false;
            Point o1 = (Point)other;
            return o1.x == this.x && o1.y == this.y;
        }
    }
    private String bfs(int x, int y){
        if(x + y == 0)
            return "IMPOSSIBLE";
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(0, 0));
        int jump = 1;
        Point dest = null;
        Set<Point> visited = new HashSet<>();
        while(!que.isEmpty()){
            int sz = que.size();
            int offset = 1 << (jump - 1);
            boolean found = false;
            for(int i = 0; i < sz; i++){
                Point curr = que.poll();
                visited.add(curr);
                if(curr.x == x && curr.y == y) {
                    dest = curr;
                    found = true;
                }
//                if(curr.x > x && curr.y > y)
//                    continue;

                Point p1 = new Point(curr.x + offset, curr.y);
                p1.parent = curr;
                p1.dir = 'E';
                Point p2 = new Point(curr.x - offset, curr.y);
                p2.parent = curr;
                p2.dir = 'W';
                Point p3 = new Point(curr.x, curr.y + offset);
                p3.parent = curr;
                p3.dir = 'N';

                Point p4 = new Point(curr.x, curr.y -offset);
                p4.parent = curr;
                p4.dir = 'S';
                if(!visited.contains(p1)){
                    visited.add(p1);
                    que.add(p1);
                }
                if(!visited.contains(p2)){
                    que.add(p2);
                    visited.add(p2);
                }
                if(!visited.contains(p3)){
                    que.add(p3);
                    visited.add(p3);
                }
                if(!visited.contains(p4)){
                    que.add(p4);
                    visited.add(p4);
                }
            }
            if(found)
                break;
            jump++;
        }

        StringBuilder ans = new StringBuilder();
        while(dest != null && dest.dir != null){
            ans.insert(0, dest.dir);
            dest = dest.parent;
        }
        return ans.length() == 0? "IMPOSSIBLE" : ans.toString();
    }

    private void pa(String ans, int T){
        System.out.println("Case #" + T + ": "+ ans);
        return ;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution s1 = new Solution();
        int T = Integer.parseInt(sc.nextLine());
        int count = 1;
        while(count <= T){
            String[] ws = sc.nextLine().split("\\s");
            int x = Integer.parseInt(ws[0]);
            int y = Integer.parseInt(ws[1]);
            String ans = s1.bfs(x, y);
            s1.pa(ans, count);
            count++;
        }
    }
}
