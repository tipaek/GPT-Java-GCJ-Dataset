import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vestigium {

    private static int T;
    private static List<int[][]> arrays = new ArrayList<>();

    private static int noOfRepeatRows(int[][] arr, int N){
        int t = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {
                int temp = arr[i][j];
                int check = 0;
                for (int k = j + 1; k < N; k++)
                    if (temp == arr[i][k]) {
                        check++;
                        break;
                    }
                if (check != 0) {
                    t++;
                    break;
                }
            }
        }
        return t;
    }

    private static int noOfRepeatCols(int[][] arr, int N) {
        int t = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++) {
                int temp = arr[j][i];
                int check = 0;
                for (int k = j + 1; k < N; k++)
                    if (temp == arr[k][i]) {
                        check++;
                        break;
                    }
                if (check != 0) {
                    t++;
                    break;
                }
            }
        }
        return t;
    }

    private static int trace(int[][] arr,int N){
        int t = 0;
        for(int i=0;i<N;i++)
            t+=arr[i][i];
        return t;
    }

    private static void readData(String[] lines){
        T = Integer.parseInt(lines[0]);
        int lineNo=1;
        for(int i=0;i<T;i++) {
            int N = Integer.parseInt(lines[lineNo++]);
            int[][] xs = new int[N][N];
            for (int j = 0; j < N; j++) {
                String a = lines[lineNo++];
                for (int k = 0; k < N; k++)
                    xs[j][k] = Integer.parseInt("" + a.charAt(k));
            }
            arrays.add(xs);
        }
    }

    private static void getData(){
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int i=0;i<T;i++) {
            int N = sc.nextInt();
            int[][] xs = new int[N][N];
            for (int j = 0; j < N; j++)
                for (int k = 0; k < N; k++)
                    xs[j][k] = sc.nextInt();
            arrays.add(xs);
        }
    }

    private static void printFile(int[] traces,int[] cols, int[] rows){
        for(int t=0;t<T;t++)
            System.out.println("Case #1: "+traces[t]+" "+rows[t]+" "+cols[t]);
    }


    public static void main(String[] args){
        //readData(args);
        getData();
        int[] traces = new int[T];
        int[] cols = new int[T];
        int[] rows = new int[T];
        for(int t=0;t<T;t++){
            traces[t]=trace(arrays.get(t),arrays.get(t).length);
            cols[t] = noOfRepeatCols(arrays.get(t),arrays.get(t).length);
            rows[t] = noOfRepeatRows(arrays.get(t),arrays.get(t).length);
        }
        printFile(traces,cols,rows);
    }
}
