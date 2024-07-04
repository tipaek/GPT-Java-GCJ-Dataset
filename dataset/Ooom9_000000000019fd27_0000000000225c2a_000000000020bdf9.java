/**
 * ******* Created  on 4/4/20 8:50 AM*******
 */

import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    private static final int MAX = (int) (1E3 + 5);
    private static final int MOD = (int) (1E9 + 7);
    private static final long Inf = (long) (1E14 + 10);
    private static final double eps = (double) (1E-9);
    class Pair{
        int a ;
        int b ;
        int c;
        Pair(int a , int b , int c){
            this.a  = a;
            this.b =b;
            this.c =c;
        }
    }
    private void solve() throws IOException {
        int tests = reader.nextInt();
        List<Pair> kidsAct =new ArrayList<>();
        char[] ans = new char[MAX];
        for(int tt=1; tt <=tests;tt++){
            int n = reader.nextInt();
            kidsAct.clear();
            for(int i=0;i<n;i++){
                kidsAct.add(new Pair(reader.nextInt(), reader.nextInt(),i));
            }
            Collections.sort(kidsAct, new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    if(o1.a !=o2.a)
                        return o1.a -o2.a;
                    else
                        return o1.b -o2.b;
                }
            });

            boolean flag = true;
            int prev =-1;
            int cnt =0;
            PriorityQueue<Pair> queue =new PriorityQueue<>(new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o1.b-o2.b;
                }
            });
            for(int i=0;i<n;i++){
                int s = kidsAct.get(i).a;

                while (!queue.isEmpty() && queue.peek().b <= s){
                    queue.poll();
                }

                if(queue.size() >1)
                    flag=false;

                if(queue.isEmpty()){
                      ans[kidsAct.get(i).c] = 'C';
                }else{
                    int val = ans[queue.peek().c] =='C'?0:1;
                    if(val==0){
                        ans[kidsAct.get(i).c]='J';
                    }else{
                        ans[kidsAct.get(i).c] = 'C';
                    }

                }
                queue.add(kidsAct.get(i));
            }
            writer.print("Case #"+tt+": ");
            if(!flag){
                writer.println("IMPOSSIBLE");
            }else{
                for(int i=0;i<n;i++)
                    writer.print(ans[i]);
                writer.println();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (Input reader = new StandardInput(); PrintWriter writer = new PrintWriter(System.out)) {
            new Solution().run();
        }
    }

    StandardInput reader;
    PrintWriter writer;

    @Override
    public void run() {
        try {
            reader = new StandardInput();
            writer = new PrintWriter(System.out);
            solve();
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    interface Input extends Closeable {
        String next() throws IOException;

        default int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        default long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        default double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        default int[] readIntArray() throws IOException {
            return readIntArray(nextInt());
        }

        default int[] readIntArray(int size) throws IOException {
            int[] array = new int[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        default long[] readLongArray(int size) throws IOException {
            long[] array = new long[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = nextLong();
            }
            return array;
        }
    }

    private static class StandardInput implements Input {
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        private StringTokenizer stringTokenizer;

        @Override
        public void close() throws IOException {
            reader.close();
        }

        @Override
        public String next() throws IOException {
            if (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                stringTokenizer = new StringTokenizer(reader.readLine());
            }
            return stringTokenizer.nextToken();
        }
    }
}
