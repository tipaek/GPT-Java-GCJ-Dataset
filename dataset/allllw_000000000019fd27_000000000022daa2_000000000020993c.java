import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String args[]) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int num = Integer.parseInt(in.next());
        int count = 0;
        List<int[]> result = new ArrayList<>();
        while(count < num){
            int size = Integer.parseInt(in.next());
            int[][] matrix = new int[size][size];
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            result.add(calculate(matrix));
            count++;
        }

        for(int i = 0; i < result.size(); i++){
            System.out.println("Case #" + (i + 1) + ": " + result.get(i)[0] + " " + result.get(i)[1] + " " + result.get(i)[2]);
        }
        return;
    }

    private static int[] calculate(int[][] matrix){
        int size = matrix.length;
        int trace = 0;
        for(int i = 0; i < size; i++){
            trace += matrix[i][i];
        }
        int row = 0;
        int col = 0;
        for(int i = 0; i < size; i++){
            Set<Integer> r = new HashSet<>();
            for(int j = 0; j < size; j++){
                if(r.contains(matrix[i][j])){
                    row++;
                    break;
                }
                r.add(matrix[i][j]);
            }
        }
        for(int i = 0; i < size; i++){
            Set<Integer> c = new HashSet<>();
            for(int j = 0; j < size; j++){
                if(c.contains(matrix[j][i])){
                    col++;
                    break;
                }
                c.add(matrix[j][i]);
            }
        }
        return new int[]{trace, row, col};
    }


}
