/**
 * ******* Created on 17/11/19 12:35 PM *******
 */

import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    public static final int MAX = (int) (1e5+10);
    public static final int MOD = (int) (1e9+7);
    public static final int Inf = (int) (1e9+10);
    private static final double eps = (double) (1E-9);


    private void solve() throws IOException {
        int testCases = reader.nextInt();

        for (int cases = 1; cases <= testCases; cases++) {
            writer.print("Case #" + cases + ": ");
            long x = reader.nextInt();
            long y = reader.nextInt();
            if(x ==0 && y==0){
                writer.println();
                continue;
            }
            if(! (( Math.abs(x) %2 ==1 &&  Math.abs(y) %2 ==0)||(  Math.abs(x) %2 ==0 &&  Math.abs(y) %2 ==1) ) ){
                writer.println("IMPOSSIBLE");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            int[] pos = new int[35];
            long disx = Math.abs(x);
            long disy = Math.abs(y);
            boolean flag =true;
            for(int i=30;i>=0;i--){
                if(pos[i]!=0)continue;
                if( (disx &(1L<<i)) !=0 && (disy &(1L<<i)) !=0){
                    if(pos[i+1]!=0){
                        flag=false;
                        break;
                    }
                    if(disx > disy) {
                        pos[i+1]=1;
                        pos[i]=2;
                        pos[i-1]=-1;
                    }else{
                        pos[i+1]=2;
                        pos[i]=1;
                        pos[i-1]=-2;
                    }

                    disy -=(1<<i);
                    disx -=(1<<i);

                }else if( (disx &(1L<<i)) !=0 && (disy &(1L<<i)) ==0){
                    pos[i]=1;
                    disx -=(1<<i);
                }else if( (disx &(1L<<i)) ==0 && (disy &(1L<<i)) !=0){
                    pos[i]=2;
                    disy-=(1<<i);
                }
            }
            int idx =32;
            while(idx >=0 && pos[idx]==0)idx--;
            while(idx >0){
                if(pos[idx]==0){
                    int idxy=idx;
                    while(idxy >=0 && pos[idxy]==0)idxy--;
                    if(!(idx-idxy ==1 || idxy ==0) ){
                        flag =false;
                    }
                    pos[idx] = pos[idxy];
                    pos[idxy] = -pos[idx];
                    while(idxy >=0 && idx != idxy) {
                        pos[idxy] = -pos[idx];
                        idxy++;
                    }
                }
                idx--;
            }
            for(int i=0;i<30;i++){
                if(pos[i]==0)continue;
                if(Math.abs(pos[i])%2==1){
                    if(pos[i]>0){
                        if(x >0)sb.append("E");
                        else sb.append("W");
                    }else{
                        if(x >0)sb.append("W");
                        else sb.append("E");
                    }
                }else{
                    if(pos[i]>0){
                        if(y >0)sb.append("N");
                        else sb.append("S");
                    }else{
                        if(y >0)sb.append("S");
                        else sb.append("N");
                    }
                }
            }
            if(flag)
                writer.println(sb.toString());
            else
                writer.println("IMPOSSIBLE");
        }
    }

    public static int getItself(int itself, int dummy) {
        return itself;
    }
    public void swap(int a, int b) {
        a = getItself(b, b = a);
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
