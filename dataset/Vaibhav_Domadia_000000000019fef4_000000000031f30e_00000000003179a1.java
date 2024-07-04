import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);
        
        try {
            int t = Integer.parseInt(br.readLine());
            for(int testCase = 1 ; testCase <= t ; testCase++) {

                int u = Integer.parseInt(br.readLine());
                Pair[] p = new Pair[10000];
                for(int i=0 ; i<10000 ; i++) {
                    st = new StringTokenizer(br.readLine());
                    int val = Integer.parseInt(st.nextToken());
                    String s = st.nextToken();
                    p[i] = new Pair(val, s);
                }

                Arrays.sort(p, (o1, o2) -> o1.val-o2.val);

                char[] ans = new char[10];
                HashSet<Character> hs = new HashSet<>();
                if(p[0].val == 1) {
                    hs.add(p[0].s.charAt(0));
                    ans[1] = p[0].s.charAt(0);
                }
                int j=2;
                for(int i=1 ; i<10000 ; i++) {
                    if(p[i].val == j && j<10) {
                        char x = p[i].s.charAt(0);
                        if(!hs.contains(x)) {
                            hs.add(x);
                            ans[j] = x;
                            j++;
                        }
                    }
                    else {
                        String z = p[i].s;
                        for(int e=0 ; e<z.length() ; e++) {
                            if(!hs.contains(z.charAt(e))) {
                                ans[0] = z.charAt(e);
                                break;
                            }
                        }
                    }
                }

                pw.print("Case #" + testCase + ": ");
                pw.println(ans);
            }
        }
        finally {
            pw.flush();
            pw.close();
        }
    }
}

class Pair {
    int val;
    String s;
    Pair(int a, String b) {
        val = a;
        s = b;
    }
}
