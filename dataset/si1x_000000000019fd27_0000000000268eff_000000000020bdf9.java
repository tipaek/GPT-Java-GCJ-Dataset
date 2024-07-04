import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    static StringTokenizer st;
    static BufferedReader br;
    static PrintWriter pw;

    static String nextToken() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        int i = nextInt();
        List<Pair> list;
        for (int j = 0; j < i; j++) {
            int size = nextInt();
            list = new ArrayList<>();
            for(int l = 0; l < size; l++){
                int a = nextInt();
                int b = nextInt();
                list.add(new Pair(a,b,l));
            }
            Collections.sort(list);
            Pair[] pairs = new Pair[size];
            pairs = list.toArray(pairs);
            int J = 0;
            int C = 0;
            int current = 1;
            String[] result = new String[size];
            result[pairs[J].c] = "J";
            while(current != size &&pairs[J].y <= pairs[current].x){
                J = current;
                result[pairs[current].c] = "J";
                current++;
            }
            if (current < pairs.length) {
                C = current;
                result[pairs[current].c] = "C";
                current++;
                for (int l = current; l < size; l++) {
                    if (pairs[J].y <= pairs[l].x) {
                        if (l != C) {
                            result[pairs[l].c] = "J";
                            J = l;
                        }
                    }
                    if (pairs[C].y <= pairs[l].x) {
                        if (l != J) {
                            result[pairs[l].c] = "C";
                            C = l;
                        }
                    }
                }
            }
            current = 0;
            boolean check = false;
            while (current != size){
                if(result[current] == null) {
                    check = true;
                    break;
                }
                current++;
            }
            //System.out.println(Arrays.toString(result));
            if(check){
                System.out.println("\n" + "Case #" + (j + 1) + ":" + ' ' + "IMPOSSIBLE");
            }
            else {
                System.out.println("\n" + "Case #" + (j + 1) + ":" + ' ' + Arrays.stream(result).reduce("", (acc, x) -> acc + x));
            }
        }
        pw.close();
    }

    static class Pair implements Comparable<Pair> {
        int x;
        int y;
        int c;

        public Pair(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        @Override
        public int compareTo(Pair o) {
            if (o.x != x) return Integer.compare(x, o.x);
            return Integer.compare(y, o.y);
        }
    }
}
