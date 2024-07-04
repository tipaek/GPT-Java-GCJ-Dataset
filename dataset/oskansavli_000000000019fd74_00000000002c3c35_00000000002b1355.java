
import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int ti = 1; ti <= t; ++ti) {
            int r = in.nextInt();
            int c = in.nextInt();
            int[][] m = new int[r][c];
            int[][] m2 = new int[r][c];
            for (int i=0; i<r; i++) {
                for (int j=0; j<c; j++) {
                    m[i][j] = in.nextInt();
                }
            }

            int totalInterest = 0;
            boolean hasElimination = false;
            do {
                hasElimination = false;
                int interest = 0;
                for (int i=0; i<r; i++) {
                    for (int j = 0; j < c; j++) {
                        int v = m[i][j];
                        if (v > 0) {
                            interest += v;
                            int numNeighbours = 0;
                            int sum = 0; // sum of neighbours
                            // upper neighbour
                            for (int k=i-1; k>=0; k--) {
                                if (m[k][j] != 0) {
                                    numNeighbours++;
                                    sum += m[k][j];
                                }
                            }
                            // lower neighbour
                            for (int k=i+1; k<r; k++) {
                                if (m[k][j] != 0) {
                                    numNeighbours++;
                                    sum += m[k][j];
                                }
                            }
                            // left neighbour
                            for (int k=j-1; k>=0; k--) {
                                if (m[i][k] != 0) {
                                    numNeighbours++;
                                    sum += m[i][k];
                                }
                            }
                            // right neighbour
                            for (int k=j+1; k<c; k++) {
                                if (m[i][k] != 0) {
                                    numNeighbours++;
                                    sum += m[i][k];
                                }
                            }
                            if ((float)sum/numNeighbours > v) {
                                hasElimination = true;
                                m2[i][j] = 0;
                            } else {
                                m2[i][j] = v;
                            }
                        }
                    }
                }
                totalInterest += interest;
                m = m2;
            } while (hasElimination);
            
            System.out.println("Case #" + ti + ": " + totalInterest);
        }
    }
}
