import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int numCases = Integer.parseInt(reader.readLine());
        for (int caseN = 1; caseN <= numCases; caseN++) {
            int size = Integer.parseInt(reader.readLine());
            int[][] square = new int[size][size];
            for (int i = 0; i < size; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                for (int j = 0; j < size; j++) {
                    square[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += square[i][i];
            }
            int repRows = 0;
            int repCols = 0;
            for (int i = 0; i < size; i++) {
                HashSet<Integer> vals = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    if (vals.contains(square[i][j])) {
                        repRows++;
                        break;
                    }
                    vals.add(square[i][j]);
                }
                vals.clear();
                for (int j = 0; j < size; j++) {
                    if (vals.contains(square[j][i])) {
                        repCols++;
                        break;
                    }
                    vals.add(square[j][i]);
                }
            }
            writer.println("Case #" + caseN + ": " + trace + " " + repRows + " " + repCols);
        }
        reader.close();
        writer.close();
    }
}