import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);
        
        try {
            int t = Integer.parseInt(br.readLine());
            for(int testCase = 1 ; testCase <= t ; testCase++) {
                st = new StringTokenizer(br.readLine());
                long x = Long.parseLong(st.nextToken());
                long y = Long.parseLong(st.nextToken());
                boolean poss = true;
                String ans = "";
                if(Math.abs(x%2) == 1 && Math.abs(y%2) == 1) {
                    poss = false;
                }
                else {
                    LinkedList<Pair> ll = new LinkedList<>();

                    ll.add(new Pair(0, 0, 0, new StringBuffer()));
                    while(!ll.isEmpty()) {
                        Pair p = ll.poll();
                        if(p.x == x && p.y == y) {
                            ans = p.sb.toString();
                            break;
                        }

                        if(p.l == 31) {
                            poss = false;
                            break;
                        }

                        ll.add(new Pair( p.x - (1<<(p.l)), p.y , p.l+1, new StringBuffer(p.sb).append('W')));
                        ll.add(new Pair( p.x + (1<<(p.l)), p.y , p.l+1, new StringBuffer(p.sb).append('E')));
                        ll.add(new Pair( p.x , p.y + (1<<(p.l)) , p.l+1, new StringBuffer(p.sb).append('N')));
                        ll.add(new Pair( p.x , p.y - (1<<(p.l)) , p.l+1, new StringBuffer(p.sb).append('S')));
                    }
                }

                if(poss) {
                    pw.println("Case #" + testCase + ": " + ans);
                }
                else {
                    pw.println("Case #" + testCase + ": " + "IMPOSSIBLE");
                }

            }
        }
        finally {
            pw.flush();
            pw.close();
        }
    }
}

class Pair {
    long x;
    long y;
    int l;
    StringBuffer sb;
    Pair(long a, long b, int c,  StringBuffer t) {
        x = a;
        y = b;
        sb = t;
        l = c;
    }
}
