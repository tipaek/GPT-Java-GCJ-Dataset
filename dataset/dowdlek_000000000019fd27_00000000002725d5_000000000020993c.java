import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int s;
        String[] line;
        StringBuilder sb = new StringBuilder();
        int[][] matrix;
        Set<Integer> rowSet;
        Set<Integer> colSet;
        int r;
        int c;
        int trace;

        for (int i = 0; i < n; i++) {
            sb.append("Case #").append(i+1).append(": ");
            s = Integer.parseInt(reader.readLine());
            matrix = new int[s][s];
            r = 0;
            c = 0;
            trace = 0;


            for (int j = 0; j < s; j++) {
                line = reader.readLine().split(" ");
                for (int k = 0; k < line.length; k++) {
                    matrix[j][k] = Integer.parseInt(line[k]);
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            for (int j = 0; j < s; j++) {
                rowSet = new HashSet<>();
                for(int k = 0; k < s; k++) {
                    if (rowSet.contains(matrix[j][k])) {
                        r++;
                        break;
                    } else {
                        rowSet.add(matrix[j][k]);
                    }
                }
            }

            for (int j = 0; j < s; j++) {
                colSet = new HashSet<>();
                for(int k = 0; k < s; k++) {
                    if (colSet.contains(matrix[k][j])) {
                        c++;
                        break;
                    } else {
                        colSet.add(matrix[k][j]);
                    }
                }
            }
            sb.append(trace).append(' ').append(r).append(' ').append(c).append('\n');




        }

        System.out.println(sb.toString());



    }
}
