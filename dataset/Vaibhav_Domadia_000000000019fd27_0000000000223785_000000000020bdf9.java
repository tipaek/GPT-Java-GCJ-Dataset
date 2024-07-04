import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);
        
        try {
            int t = Integer.parseInt(br.readLine());
            for(int zx = 1 ; zx<=t ; zx++) {
                int n = Integer.parseInt(br.readLine());
                Pair[] p = new Pair[2*n];

                char[] assign = new char[n];

                for(int i=0 ; i<n ; i++) {
                    st = new StringTokenizer(br.readLine());
                    int time = Integer.parseInt(st.nextToken());
                    p[i] = new Pair(time, 0, i);
                    time = Integer.parseInt(st.nextToken());
                    p[n+i] = new Pair(time, 1, i);
                }

                Arrays.sort(p, (o1, o2) -> o1.time==o2.time ? o2.type-o1.type : o1.time-o2.time);

                boolean possible = true;
                int curr = 0;
                boolean j = false;
                boolean c = false;
                for(int i=0 ; i<2*n ; i++) {
                    if(p[i].type == 0) {
                        curr++;
                        if(!j) {
                            j = true;
                            assign[p[i].ind] = 'J';
                        }
                        else if(!c) {
                            c = true;
                            assign[p[i].ind] = 'C';
                        }

                        if(curr > 2) {
                            possible = false;
                            break;
                        }
                    }
                    else {
                        curr--;
                        if(assign[p[i].ind] == 'J') {
                            j = false;
                        }
                        else {
                            c = false;
                        }
                    }
                }

                if(possible) {
                    pw.print("Case #" + zx + ": ");
                    pw.println(assign);
                }
                else {
                    pw.println("Case #" + zx + ": " + "IMPOSSIBLE");
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
    int time;
    int type;
    int ind;
    Pair(int a, int b, int c) {
        time = a;
        type = b;
        ind = c;
    }
}
