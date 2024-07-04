import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    
    static PrintWriter out;

    public static void main(String[] args)  {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        out = new PrintWriter(System.out);
        for (int t = 1; t <= count; t++) {
            out.print("Case #" + t + ": ");
            solve(s, out);
        }
        out.close();
    }

    static void solve(Scanner sc, PrintWriter out) {

        int r = sc.nextInt();
        int s = sc.nextInt();
        int rs = r * s;

        char[] cs = new char[rs];
        for(int i=0; i<r; i++) {
            for(int j=0; j<s; j++) {
                cs[j*r + i] = (char)('1' + i);
            }
        }
        String start = new String(cs);
        char[] cg = new char[rs];
        for(int i=0; i<r; i++) {
            for(int j=0; j<s; j++) {
                cg[j + i * s] = (char)('1' + i);
            }
        }
        String goal = new String(cg);
        //out.println(start + "->" + goal);

        Queue<State> q = new LinkedList<>();
        State root = new State(null, -1, -1, start);
        q.add(root);
        Set<String> visited = new HashSet<>();
        visited.add(start);

        State last = null;
        OUTER: while(!q.isEmpty()) {
            State state = q.poll();
            for(int a = 1; a < rs; a++) {
                for(int b = 1; a + b <= rs; b++) {
                    String ss = state.s;
                    String next = ss.substring(a, a+b) + ss.substring(0, a) + ss.substring(a+b);
                    if(visited.contains(next)) continue;
                    visited.add(next);
                    State nextState = new State(state, a, b, next);
                    if(next.equals(goal)) {
                        last = nextState;
                        break OUTER;
                    }
                    q.add(nextState);
                }
            }
        }

        List<String> list = new ArrayList<>();
        while(last != root) {
            list.add(last.a + " " + last.b);
            last = last.prev;
        }

        out.println(list.size());
        for(int i=list.size()-1; i>=0; i--) {
            out.println(list.get(i));
        }
    }

    static class State {
        State prev;
        int a;
        int b;
        String s;
        State(State prev, int a, int b, String s) {
            this.prev = prev;
            this.a = a;
            this.b = b;
            this.s = s;
        }

    }

}
