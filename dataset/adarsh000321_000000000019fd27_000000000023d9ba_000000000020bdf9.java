import java.awt.*;
import java.io.*;
import java.util.*;

public class Solution {
    static Point p[];
    static int n;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        StringBuilder ans = new StringBuilder();
        for (int tst = 1; tst <= t; tst++) {
            StringBuilder sb = new StringBuilder();
            sb.append("Case #" + tst + ": ");
            n=sc.nextInt();
            p=new Point[n];
            for (int i=0;i<n;i++){
                p[i]=new Point(sc.nextInt(),sc.nextInt());
            }
            Arrays.sort(p, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    if (o1.x==o2.x){
                        return o1.y-o2.y;
                    }
                    return o1.x-o2.x;
                }
            });
            char a[]=new char[n];
            Arrays.fill(a,'0');
            a[0]='J';
            Point prev=p[0];
            for (int i=1;i<n;i++){
                if (!intersects(p[i],prev)){
                    a[i]='J';
                    prev=p[i];
                }
            }
            for (int j=0;j<n;j++){
                if (a[j]=='0')a[j]='C';
            }
            if (ok(a))sb.append(String.valueOf(a));
            else sb.append("IMPOSSIBLE");
            sb.append("\n");
            ans.append(sb);

        }
        System.out.print(ans);
    }
    static boolean ok(char a[]){
        for (int i=0;i<a.length;i++){
            if (a[i]=='C'){
                for (int j=0;j<a.length;j++){
                    if (i==j)continue;
                    if (a[j]=='C'){
                        if (intersects(p[i],p[j]))return false;
                    }
                }
            }
        }
        for (int i=0;i<a.length;i++){
            if (a[i]=='J'){
                for (int j=0;j<a.length;j++){
                    if (i==j)continue;
                    if (a[j]=='J'){
                        if (intersects(p[i],p[j]))return false;
                    }
                }
            }
        }
        return true;
    }
    static boolean intersects(Point p1, Point p2) {
        return (p1.x > p2.x && p1.x < p2.y) || ((p1.y > p2.x && p1.y < p2.y));
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}