
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution {


    public static void main(String[] args){

        Transpose tr = Transpose.get();
        tr.start(new Transpose.Test(){
            @Override
            void onTest(int i,int T) {
                int[] ix = tr.nextIntArray();
                int N = ix[0];
                int K = ix[1];
                if(K%N!=0){
                    tr.addCase(i,"IMPOSSIBLE");
                }else{
                    tr.addCase(i,"POSSIBLE");
                    int t = K/N;
                    int[][] matrix = new int[N][N];
                    for (int j = 0; j < N; j++) {
                        int[] row = new int[N];
                        String rt = "";
                        for (int k = 0; k < N; k++) {
                            row[k] = roundInt(k+t-j,N);
                            if(row[k]==0) row[k] = N;
                            rt+=row[k]+"";
                            if(k!=N-1) rt+=" ";
                        }
                        tr.addLine(rt);
                        matrix[j] = row;
                    }

                }
            }
        });
        tr.flush();
    }


    public static int roundInt(int i, int N){
        return i%N;
    }
}


class Transpose {
    BufferedReader br;

    String queue = "";

    int T = -1;
    int TE = -1;
    public static Transpose get(){
        return new Transpose();
    }

    private Transpose(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String nextLine(){
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int nextInt(){
        return Integer.parseInt(nextLine());
    }

    public double nextDouble(){
        return Double.parseDouble(nextLine());
    }
    public String[] nextStringArray(){
        try {
            return br.readLine().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[]{};
    }
    public int[] nextIntArray(){
        String[] ss = nextStringArray();
        int[] sx = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            sx[i] = Integer.parseInt(ss[i]);
        }
        return sx;
    }

    public void start(Test t){
        int[] ts = nextIntArray();
        T = ts[0];
        if(ts.length>1){
            TE = ts[1];
        }
        for (int i = 1; i <= T; i++) {
            t.onTest(i,T);
        }
    }

    public Transpose add(String s){
        queue+=s;
        return this;
    }

    public Transpose addCase(int i, String s){
        addLine("Case #"+i+": "+s);
        return this;
    }

    public Transpose addLine(String s){
        return add(s+"\n");
    }

    public void print(String s){
        System.out.print(s);
    }

    public void println(String s){
        System.out.println(s);
    }
    public void printCase(int i,String s){
        println("Case #"+i+": "+s);
    }

    public void flush(){
        if(!queue.isEmpty())
            System.out.print(queue);
        queue = "";
    }

    /*complete.Insert custom functions here*/

    static abstract class Test{
        abstract void onTest(int i,int T);
    }
}
