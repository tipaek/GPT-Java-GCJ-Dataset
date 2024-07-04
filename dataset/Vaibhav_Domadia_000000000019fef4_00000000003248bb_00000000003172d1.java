import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
                int n = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                long[] a = new long[n];
                st = new StringTokenizer(br.readLine());
                HashMap<Long, Integer> hm = new HashMap<>();
                for(int i=0 ; i<n ; i++) {
                    a[i] = Long.parseLong(st.nextToken());
                    if(hm.containsKey(a[i])) {
                        hm.compute(a[i], (x, y) -> y+1);
                    }
                    else hm.put(a[i], 1);
                }

                int ans = p-1;

                if(p == 1) {
                    ans = 0;
                }
                else if(p == 2) {
                    for(Map.Entry<Long, Integer> ent: hm.entrySet()) {
                        if(ent.getValue() >= 2) {
                            ans = 0;
                            break;
                        }
                    }
                }
                else {
                    for(int i=0 ; i<n ; i++) {
                        int equal = 0;
                        long elem = a[i];
                        long big = 0;
                        for(int j=0 ; j<n ; j++) {
                            if(i != j) {
                                if(a[j] == elem) {
                                    equal++;
                                }
                                else if(a[j] == elem*2) {
                                    ans = Math.min(ans, 1);
                                }
                                else if(a[j] > elem) {
                                    big += a[j]/elem;
                                }
                            }
                        }

                        if(equal >= 2) {
                            ans = Math.min(ans, 0);
                        }
                        else if(equal == 1) {
                            if(big > 0) {
                                ans = Math.min(ans, 1);
                            }
                        }
                    }
                }



                pw.println("Case #" + testCase + ": " + ans);
            }
        }
        finally {
            pw.flush();
            pw.close();
        }
    }
}
