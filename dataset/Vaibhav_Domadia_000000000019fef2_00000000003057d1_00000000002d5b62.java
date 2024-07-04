import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
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
                else if(Math.abs(x%2) == 0 && Math.abs(y%2) == 0) {
                    poss = false;
                }
                else {
                    if(x%2 == 1) {
                        boolean ysign = true;
                        long xt = x;
                        long yt = y;
                        if(y < 0) {
                            ysign = false;
                            yt = -y;
                        }

                        int[] a = new int[31];
                        int[] b = new int[31];
                        for(int i=0 ; i<31 ; i++) if((xt & (1<<i)) != 0) a[i] = 1;
                        for(int i=0 ; i<31 ; i++) if((yt & (1<<i)) != 0) b[i] = 1;

                        int[] c = new int[31];
                        for(int i=0 ; i<31 ; i++) {
                            c[i] = a[i] + b[i];
                            if(c[i] == 2) poss = false;
                        }

                        int last = 0;
                        for(int i=0 ; i<31 ; i++) {
                            if(c[i] == 1) last = i;
                        }

                        for(int i=0 ; i<=last ; i++) if(c[i] == 0) poss = false;

                        if(poss) {
                            for(int i=0 ; i<=last ; i++) {
                                if(a[i] == 1) {
                                    ans += 'E';
                                }
                                else {
                                    if(ysign) ans += 'N';
                                    else ans += 'S';
                                }
                            }
                        }
                        else {
                            poss = true;
                            xt++;
                            ans += 'W';
                            a = new int[31];
                            for(int i=0 ; i<31 ; i++) if((xt & (1<<i)) != 0) a[i] = 1;

                            c = new int[31];
                            for(int i=0 ; i<31 ; i++) {
                                c[i] = a[i] + b[i];
                                if(c[i] == 2) poss = false;
                            }

                            last = 0;
                            for(int i=0 ; i<31 ; i++) {
                                if(c[i] == 1) last = i;
                            }

                            for(int i=1 ; i<=last ; i++) if(c[i] == 0) poss = false;

                            for(int i=1 ; i<=last ; i++) {
                                if(a[i] == 1) {
                                    ans += 'E';
                                }
                                else {
                                    if(ysign) ans += 'N';
                                    else ans += 'S';
                                }
                            }
                        }

                    }
                    else if(x%2 == -1) {
                        boolean ysign = true;
                        long xt = -x;
                        long yt = y;
                        if(y < 0) {
                            ysign = false;
                            yt = -y;
                        }

                        int[] a = new int[31];
                        int[] b = new int[31];
                        for(int i=0 ; i<31 ; i++) if((xt & (1<<i)) != 0) a[i] = 1;
                        for(int i=0 ; i<31 ; i++) if((yt & (1<<i)) != 0) b[i] = 1;

                        int[] c = new int[31];
                        for(int i=0 ; i<31 ; i++) {
                            c[i] = a[i] + b[i];
                            if(c[i] == 2) poss = false;
                        }

                        int last = 0;
                        for(int i=0 ; i<31 ; i++) {
                            if(c[i] == 1) last = i;
                        }

                        for(int i=0 ; i<=last ; i++) if(c[i] == 0) poss = false;

                        if(poss) {
                            for(int i=0 ; i<=last ; i++) {
                                if(a[i] == 1) {
                                    ans += 'W';
                                }
                                else {
                                    if(ysign) ans += 'N';
                                    else ans += 'S';
                                }
                            }
                        }
                        else {
                            poss = true;
                            xt++;
                            ans += 'E';
                            a = new int[31];
                            for(int i=0 ; i<31 ; i++) if((xt & (1<<i)) != 0) a[i] = 1;

                            c = new int[31];
                            for(int i=0 ; i<31 ; i++) {
                                c[i] = a[i] + b[i];
                                if(c[i] == 2) poss = false;
                            }

                            last = 0;
                            for(int i=0 ; i<31 ; i++) {
                                if(c[i] == 1) last = i;
                            }

                            for(int i=1 ; i<=last ; i++) if(c[i] == 0) poss = false;

                            for(int i=1 ; i<=last ; i++) {
                                if(a[i] == 1) {
                                    ans += 'W';
                                }
                                else {
                                    if(ysign) ans += 'N';
                                    else ans += 'S';
                                }
                            }
                        }
                    }
                    else if(y%2 == 1) {
                        boolean xsign = true;
                        long xt = x;
                        long yt = y;
                        if(x < 0) {
                            xsign = false;
                            xt = -x;
                        }

                        int[] a = new int[31];
                        int[] b = new int[31];
                        for(int i=0 ; i<31 ; i++) if((xt & (1<<i)) != 0) a[i] = 1;
                        for(int i=0 ; i<31 ; i++) if((yt & (1<<i)) != 0) b[i] = 1;

                        int[] c = new int[31];
                        for(int i=0 ; i<31 ; i++) {
                            c[i] = a[i] + b[i];
                            if(c[i] == 2) poss = false;
                        }

                        int last = 0;
                        for(int i=0 ; i<31 ; i++) {
                            if(c[i] == 1) last = i;
                        }

                        for(int i=0 ; i<=last ; i++) if(c[i] == 0) poss = false;

                        if(poss) {
                            for(int i=0 ; i<=last ; i++) {
                                if(a[i] == 1) {
                                    if(xsign) ans += 'E';
                                    else ans += 'W';
                                }
                                else {
                                    ans += 'N';
                                }
                            }
                        }
                        else {
                            poss = true;
                            yt++;
                            ans += 'S';
                            b = new int[31];
                            for(int i=0 ; i<31 ; i++) if((yt & (1<<i)) != 0) b[i] = 1;

                            c = new int[31];
                            for(int i=0 ; i<31 ; i++) {
                                c[i] = a[i] + b[i];
                                if(c[i] == 2) poss = false;
                            }

                            last = 0;
                            for(int i=0 ; i<31 ; i++) {
                                if(c[i] == 1) last = i;
                            }

                            for(int i=1 ; i<=last ; i++) if(c[i] == 0) poss = false;

                            for(int i=1 ; i<=last ; i++) {
                                if(a[i] == 1) {
                                    if(xsign) ans += 'E';
                                    else ans += 'W';
                                }
                                else {
                                    ans += 'N';
                                }
                            }
                        }
                    }
                    else if(y%2 == -1) {
                        boolean xsign = true;
                        long xt = x;
                        long yt = -y;
                        if(x < 0) {
                            xsign = false;
                            xt = -x;
                        }

                        int[] a = new int[31];
                        int[] b = new int[31];
                        for(int i=0 ; i<31 ; i++) if((xt & (1<<i)) != 0) a[i] = 1;
                        for(int i=0 ; i<31 ; i++) if((yt & (1<<i)) != 0) b[i] = 1;

                        int[] c = new int[31];
                        for(int i=0 ; i<31 ; i++) {
                            c[i] = a[i] + b[i];
                            if(c[i] == 2) poss = false;
                        }

                        int last = 0;
                        for(int i=0 ; i<31 ; i++) {
                            if(c[i] == 1) last = i;
                        }

                        for(int i=0 ; i<=last ; i++) if(c[i] == 0) poss = false;

                        if(poss) {
                            for(int i=0 ; i<=last ; i++) {
                                if(a[i] == 1) {
                                    if(xsign) ans += 'E';
                                    else ans += 'W';
                                }
                                else {
                                    ans += 'S';
                                }
                            }
                        }
                        else {
                            poss = true;
                            yt++;
                            ans += 'N';
                            b = new int[31];
                            for(int i=0 ; i<31 ; i++) if((yt & (1<<i)) != 0) b[i] = 1;

                            c = new int[31];
                            for(int i=0 ; i<31 ; i++) {
                                c[i] = a[i] + b[i];
                                if(c[i] == 2) poss = false;
                            }

                            last = 0;
                            for(int i=0 ; i<31 ; i++) {
                                if(c[i] == 1) last = i;
                            }

                            for(int i=1 ; i<=last ; i++) if(c[i] == 0) poss = false;

                            for(int i=1 ; i<=last ; i++) {
                                if(a[i] == 1) {
                                    if(xsign) ans += 'E';
                                    else ans += 'W';
                                }
                                else {
                                    ans += 'S';
                                }
                            }
                        }
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
