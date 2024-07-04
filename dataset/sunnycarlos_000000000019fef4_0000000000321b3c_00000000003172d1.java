import java.util.*;
import java.io.*;
import java.awt.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        StringBuilder sb=new StringBuilder();
        int t = sc.nextInt();
        for (int test = 1; test <= t; test++) {
            sb.append("Case #"+test+": ");
            int N=sc.nextInt(),D=sc.nextInt();
            Long arr[]=new Long[N];
            HashSet<Long> set=new HashSet<>();
            for (int i=0;i<N;i++){
                arr[i]=sc.nextLong();
                set.add(arr[i]);
            }

            if (D==2){
                Arrays.sort(arr);
                boolean foo=false;
                for (int i=0;i<N-1;i++){
                    if (arr[i].equals(arr[i+1])){
                        foo=true;
                        break;
                    }
                }
                if (foo)sb.append(0);else sb.append(1);

            }else if(D==3){
                Arrays.sort(arr);
                boolean z3=false,z2=false;
                for (int i=0;i<N;i++){
                    if (i+2<N && arr[i].equals(arr[i+1]))z2=true;
                    if (i+2<N && arr[i].equals(arr[i+1]) && arr[i].equals(arr[i+2]))z3=true;
                }
                if (z3)sb.append(0);
                else if (z2)sb.append(1);
                else {
                    boolean z1=false;
                    for(int i=0;i<N;i++){
                        if (set.contains(2*arr[i])){
                            z1=true;
                            break;
                        }
                    }
                    if (z1)sb.append(1);
                    else sb.append(2);
                }
            }
            if (test!=t)sb.append("\n");
        }
        System.out.print(sb);
    }
    static int find(int a, int b, int x, int y){
        return Math.abs(a-x)+Math.abs(b-y);
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
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
    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }
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