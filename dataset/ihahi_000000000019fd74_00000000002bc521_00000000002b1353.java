import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    static int[] dx = {1,0,-1};
    static int[] dy = {0,1,1};

    static List<List<Map<Long, Place>>> bxes = new ArrayList<>();
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<500;i++){
            List<Map<Long, Place>> bxline = new ArrayList<>();
            for(int j=0;j<500;j++){
                bxline.add(new HashMap<>());
            }
            bxes.add(bxline);
        }
        int T = sc.nextInt();
        for(int t=1;t<=T;t++){
            System.out.println("Case #" + t + ":");
            long N = sc.nextLong();
            solve(N);
        }
    }
    private static void solve(long N){
        int r=0;
        PriorityQueue<State> pq = new PriorityQueue<State>(Comparator.comparingLong(p->-p.val));
        pq.add(new State(1, 0, 0));
        while(!pq.isEmpty()){
            State s= pq.poll();
            //System.out.println(s);
            if(s.val > N){
                continue;
            }
            if(s.val == N){
                printPath(s);
                break;
            }
            for(int d=0;d<3;d++) {
                int tx = s.bx+dx[d];
                int ty = s.by+dy[d];
                if(tx < 0 || ty < 0){continue;}
                State tst = new State(s.val + comb(tx, ty), tx, ty);
                tst.bef = s;
                pq.add(tst);
            }
        }
    }

    private static void printPath(State s){
        Stack<State> st = new Stack<>();
        st.add(s);
        while(!(st.peek().bx == 0 && st.peek().by == 0)){
            st.push(st.peek().bef);
        }
        while(!st.isEmpty()){
            State n = st.pop();
            System.out.println(n.bx+1 + " " + (n.by+1));
        }
    }

    private static long comb(int a, int b){
        a = a+b;
        long ans =1;
        for(int k=0;k<b;k++){
            ans *= (a-k);
        }
        for(int k=1;k<=b;k++){
            ans /= k;
        }
        return ans;
    }

    private static class Place{
        int x;
        int y;
        Place(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    private static class State{
        long val;
        int bx;
        int by;
        State bef;
        State(long val, int x, int y){
            this.val = val;
            this.bx = x;
            this.by = y;
        }
        @Override
        public String toString(){
            return this.bx + " " + this.by + " " + this.val;
        }
    }
}
