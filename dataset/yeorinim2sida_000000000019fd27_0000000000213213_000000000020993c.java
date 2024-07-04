import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private final static int INIT_CAPACITY = 1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.next());
        
        Set<Integer> dup = new HashSet<>(INIT_CAPACITY);
        for(int tc = 1; tc <= T ; tc++) {
            int N = Integer.parseInt(sc.next());
            int [][] square = new int[N][N];
            for(int ir = 0; ir < N ; ir++) {
                for (int ic = 0; ic < N; ic++) {
                    square[ir][ic] = Integer.parseInt(sc.next());
                }
            }
            
            int k = diagonalSum(square);
            int r = rowDup(dup, square);
            int c = colDup(dup, square);
            System.out.printf("Case #%d: %d %d %d\n", tc, k, r, c);
        }
    }
    static int diagonalSum(int[][] sq) {
        int sum = 0;
        for (int i = 0; i < sq.length; i++) {
            sum += sq[i][i];
        }
        return sum;
    }
    static int rowDup(Set<Integer> dup, int[][] square) {
        int nDups = 0;
        for (int ir = 0; ir < square.length; ir++) {
            dup.clear();
            for (int ic = 0; ic < square.length; ic++) {
                if(dup.contains(square[ir][ic])) {
                    nDups ++;
                    break;
                } else {
                    dup.add(square[ir][ic]);
                }
            }
            
        }
        return nDups;
    }
    
    static int colDup(Set<Integer> dup, int[][] square) {
        int nDups = 0;
        for (int ic = 0; ic < square.length; ic++) {
            dup.clear();
            for (int ir = 0; ir < square.length; ir++) {
                if(dup.contains(square[ir][ic])) {
                    nDups ++;
                    break;
                } else {
                    dup.add(square[ir][ic]);
                }
            }
        }
        return nDups;
    }
}