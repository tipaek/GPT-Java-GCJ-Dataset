import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int T = Integer.parseInt(sc.nextLine().trim());
        
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(sc.nextLine().trim());
            List<List<Integer>> matrix = new ArrayList<>(N);
            
            for (int row = 0; row < N; row++) {
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                List<Integer> rowData = new ArrayList<>(N);
                while (st.hasMoreTokens()) {
                    rowData.add(Integer.parseInt(st.nextToken()));
                }
                matrix.add(rowData);
            }
            
            int repX = 0;
            for (int row = 0; row < N; row++) {
                boolean[] seen = new boolean[N + 1];
                for (int col = 0; col < N; col++) {
                    int value = matrix.get(row).get(col);
                    if (seen[value]) {
                        repX++;
                        break;
                    }
                    seen[value] = true;
                }
            }
            
            int repY = 0;
            for (int col = 0; col < N; col++) {
                boolean[] seen = new boolean[N + 1];
                for (int row = 0; row < N; row++) {
                    int value = matrix.get(row).get(col);
                    if (seen[value]) {
                        repY++;
                        break;
                    }
                    seen[value] = true;
                }
            }
            
            int trace = 0;
            for (int index = 0; index < N; index++) {
                trace += matrix.get(index).get(index);
            }
            
            out.println("Case #" + (i + 1) + ": " + trace + " " + repX + " " + repY);
        }
        
        out.close();
        sc.close();
    }
}