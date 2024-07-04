import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
    public int trace(int[][] matrix){
        int sum = 0;
        for (int i = 0; i< matrix.length; i++){
            sum+= matrix[i][i];
        }
         return sum;
    }
    public int numOfRepeatedRow(int[][] matrix){
        int count =0;
        //1Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i =0; i <matrix.length; i++){
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int j = 0; j< matrix.length; j++){
                map.put( matrix[i][j], j);
            }
            for (int j = 0; j<matrix.length; j++){
                if (map.containsKey(matrix[i][j]) && map.get(matrix[i][j] )!=j){
                    count++;
                    break;

                }
            }
            map.clear();
        }
        return count;
    }
    public int numOfRepeatedCol(int[][] matrix){
        int count =0;
        //1Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i =0; i <matrix.length; i++){
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int j = 0; j< matrix.length; j++){
                map.put( matrix[j][i], j);
            }
            for (int j = 0; j<matrix.length; j++){
                if (map.containsKey(matrix[j][i]) && map.get(matrix[j][i] )!=j){
                    count++;
                    break;

                }
            }
            map.clear();
        }
        return count;
    }
    public static void main(String args[]){
        TraceGGCJ o = new TraceGGCJ();
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] k = new int[T];
        int[] r = new int[T];
        int[] c = new int[T];
        for (int testcase =0; testcase< T ; testcase++){
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            for (int i = 0; i<N; i++){
                for (int j=0; j<N;j++){
                    matrix[i][j] = in.nextInt();
                }
            }
//            System.out.println(o.trace(matrix) + " " + o.numOfRepeatedRow(matrix) +  " " +o.numOfRepeatedCol(matrix));
            k[testcase] = o.trace(matrix);
            r[testcase] = o.numOfRepeatedRow(matrix);
            c[testcase] = o.numOfRepeatedCol(matrix);
        }

        for (int i=0; i<T;i++){
            System.out.println("Case #"+(i+1)+": " + k[i]+" "+ r[i]+ " " + c[i]);
        }

    }
}
