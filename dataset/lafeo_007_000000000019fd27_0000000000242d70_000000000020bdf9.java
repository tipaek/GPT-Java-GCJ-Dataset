
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CJSolution1 {

    public static int[] convertArr(int[] arr){
        int[] ret = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            ret[i+1] = arr[i];
        }
        return ret;
    }

    public static void main(String[] args){
        Transpose tr = Transpose.get();
        tr.start(new Transpose.Test(){
            @Override
            void onTest(int i,int T) {
                int N = tr.nextInt();
                int[][] matrix = new int[N+1][N+1];
                for (int j = 1; j <=N; j++) {
                    matrix[j] = convertArr(tr.nextIntArray());
                }

                int trace = 0;
                for (int j = 1; j <= N; j++) {
                    trace+=matrix[j][j];
                }
                int r = 0;
                for (int j = 1; j <=N; j++) {
                    ArrayList<Integer> tr = new ArrayList<>();
                    for (int k = 1; k <= N; k++) {
                        if(tr.contains(new Integer(matrix[j][k]))){
                            r++;
                            break;
                        }else tr.add(matrix[j][k]);
                    }
                }
                int c = 0;
                for (int j = 1; j <=N; j++) {
                    ArrayList<Integer> tr = new ArrayList<>();
                    for (int k = 1; k <= N; k++) {
                        if(tr.contains(new Integer(matrix[k][j]))){
                            c++;
                            break;
                        }else tr.add(matrix[k][j]);
                    }
                }

                tr.addCase(i,trace+" "+r+" "+c);

            }
        });
        tr.flush();
    }
}


//Transpose code here
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

    /*Insert custom functions here*/

    static abstract class Test{
        abstract void onTest(int i,int T);
    }
}
