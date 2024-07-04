import java.math.*;
import java.util.*;
import java.io.*;
import static java.lang.Math.*;
import static java.lang.Integer.*;
import static java.lang.Long.*;
import static java.lang.System.*;


public class Solution {
    static int curK;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int T = parseInt(br.readLine());

        for (int z=0;z<T;z++) {
            String[] ss = br.readLine().trim().split("\\s+");
            int K = parseInt(ss[0]);
            curK = K;
            int N = parseInt(ss[1]);
            Sector[] c = new Sector[N];
            ss = br.readLine().trim().split("\\s+");
            int[] X = new int[N];
            for (int i=0;i<N;i++) X[i] = parseInt(ss[i]);
            ss = br.readLine().trim().split("\\s+");
            int[] TM = new int[N];
            for (int i=0;i<N;i++) TM[i] = parseInt(ss[i]);
            for (int i=0;i<N;i++) {
                c[i] = new Sector(TM[i], X[i], X[(i+1)%N], K);
            }
            for (int i=0;i<N;i++) {
                c[i].setLeftReq(c[(i+N-1)%N]);
                c[i].setRightReq(c[(i+1)%N]);
            }
            boolean changed = true;
            while (changed) {
                changed = false;
                for (int i=0;i<N;i++) {
                    changed |= c[i].constrictLeft(c[(i+N-1)%N]);
                    changed |= c[i].constrictRigh(c[(i+1)%N]);
                }
            }
            int ans = 0;
            for (int i=0;i<N;i++) {
                ans += c[i].resolve();
            }
            out.println("Case #" + (z+1)+ ": " + ans);
        }
    }

    static class Sector {
        int t;
        int st, en, len;
        int K;

        Req left, right;

        Sector(int a, int b, int c, int K) {
            t = a;
            st = b;
            en = c;
            len = (c > b ? c - b : c + K - b);
            this.K = K;
        }

        void setLeftReq(Sector other) {
            if (other.len >= this.len) {
                left = new Req(st, en);
            } else {
                left = new Req(st, (st+other.len) % K);
            }
        }

        void setRightReq(Sector other) {
            if (other.len >= this.len) {
                right = new Req(st, en);
            } else {
                right = new Req((en + K - other.len) % K, en);
            }
        }

        boolean constrictLeft(Sector other) {
            if (other.right.len < left.len) {
                left = new Req(st, (st+other.len) % K);
                return true;
            }
            return false;
        }

        boolean constrictRigh(Sector other) {
            if (other.left.len < right.len) {
                right = new Req((en + K - other.len) % K, en);
                return true;
            }
            return false;
        }

        int resolve() {
            if (left.intersect(right)) return 1;
            return 2;
        }
    }

    static class Req {
        int st, en, len;

        Req(int a, int b) {
            st = a;
            en = b;
            len = b > a ? b - a : b + curK - a;
        }

        boolean intersect(Req other) {
            int a = st;
            int b = en > st ? en : en + curK;
            int c = other.st;
            int d = other.en > other.st ? other.en : other.en + curK;
            // out.println(a+ " " + b + " " + c + " " + d);
            return !(b <= c || a >= d);
        }
    }
}
