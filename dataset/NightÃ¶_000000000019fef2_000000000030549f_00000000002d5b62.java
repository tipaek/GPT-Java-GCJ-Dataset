import java.util.*;

public class Solution {
    private void evaluate(int R, int C, int t){
        if (Math.abs(R) % 2 == Math.abs(C) % 2) {
            System.out.println("Case #"+t+": IMPOSSIBLE");
            return;
        }

        PriorityQueue<Position> pq = new PriorityQueue<>();
        Position start = new Position();

        for(Position next: start.createNext()){
            if (next.i == R && next.j == C) {
                System.out.println("Case #"+t+": "+ next.sb.toString());
                return;
            }
            if ((Math.abs(R) % 2 ==  Math.abs(next.i) % 2 ) && (Math.abs(C) % 2 == Math.abs(next.j) % 2 ) ) {
                pq.offer(next);
            }
        }

        HashSet<String> visited = new HashSet<>();
        while (! pq.isEmpty()){
            Position curr = pq.poll();
            if (curr.i == R && curr.j == C) {
                System.out.println("Case #"+t+": "+ curr.sb.toString());
                return;
            }
            for(Position next: curr.createNext()){
                if (next.i == R && next.j == C) {
                    System.out.println("Case #"+t+": "+ next.sb.toString());
                    return;
                }
                if (!visited.contains(next.i+"/"+next.j)
                        &&  curr.coef /3  <= Math.max(Math.abs(next.i - R), Math.abs(next.j - C))
                ) pq.offer(next);
                //System.out.println(next.i+ ", "+next.j);
            }
            visited.add(curr.i+"/"+curr.j);
        }
        System.out.println("Case #"+t+": IMPOSSIBLE");
    }

    private static class Position implements Comparable<Position>{
        static char[] dir = {'E','N','W','S'};
        static int[] dirR = new int[]{1,0,-1,0};
        static int[] dirC = new int[]{0,1,0,-1};
        StringBuilder sb ;
        int i, j, coef;
        public Position(){
            sb = new StringBuilder();
            i = 0;
            j = 0;
            coef = 1;
        }

        public LinkedList<Position> createNext(){
            LinkedList<Position> res = new LinkedList<>();
            for(int i=0; i<4; i++){
               Position p = new Position();
               p.sb.append(sb.toString());
               p.sb.append(dir[i]);
               p.i = this.i + coef * dirR[i];
               p.j = this.j + coef * dirC[i];
               p.coef = this.coef * 2;
               res.add(p);
            }
            return res;
        }

        @Override
        public int compareTo(Solution.Position o) {
            return coef - o.coef;
        }
    }

    public static void main(String []args){
        Solution sol = new Solution();
        Scanner stdin = new Scanner(System.in);

        int T = stdin.nextInt();

        for(int t=1; t<=T; t++){
            int R = stdin.nextInt();
            int C = stdin.nextInt();
            stdin.nextLine();
            sol.evaluate(R, C, t) ;
        }
    }
}

