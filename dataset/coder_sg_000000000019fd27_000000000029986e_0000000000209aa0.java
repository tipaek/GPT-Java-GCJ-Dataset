import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution {

        public static ArrayList<ArrayList<Integer>> allPossiblePerm;
        public static int[][] square;
        public static StringBuilder sb;

        public static boolean startFilling(int currCell, int n, int k, boolean[][] rows, boolean[][] cols) {
            if(currCell == n * n)
                return true;
            
                int currRow = currCell / n;
                int currCol = currCell % n;
                
                boolean done = false;

                if(currRow == currCol)
                    done = startFilling(currCell+1, n, k, rows, cols);
                
                else {
                    for(int i = 1; i <= n && !done; i++) {
                        if(!rows[currRow][i] && !cols[currCol][i]) {
                            square[currRow][currCol] = i;
                            rows[currRow][i] = true;
                            cols[currCol][i] = true;
                            done = startFilling(currCell+1, n, k, rows, cols);
                            rows[currRow][i] = false;
                            cols[currCol][i] = false;
                        }
                    }
                }

            return done ? true : false;
        }

        public static boolean fillSquare(int n, int k, boolean[][] rows, boolean[][] cols) {
            boolean isPossible = startFilling(0, n, k, rows, cols);
            return isPossible;
        }

        public static void possibleLatinSquares(int n, int k, int tC) {
            if(allPossiblePerm.size() == 0) {
                sb.append("Case #"+tC+": IMPOSSIBLE\n");
                return;
            }

            for(int permIndex = 0; permIndex < allPossiblePerm.size(); permIndex++) {
                ArrayList<Integer> diagonal = allPossiblePerm.get(permIndex);

                square = new int[n][n];
                boolean[][] rows = new boolean[n][n+1];
                boolean[][] cols = new boolean[n][n+1];

                for(int d : diagonal) {
                    for(int j = 0; j < n; j++) {
                        square[j][j] = d;
                        rows[j][d] = true;
                        cols[j][d] = true;
                    }
                }

                boolean isPossible = fillSquare(n, k, rows, cols);

                if(isPossible) {
                    sb.append("ase #"+tC+": POSSIBLE\n");
                    StringBuilder out = new StringBuilder();
                    for(int i = 0 ; i < n; i++) {
                        for(int j = 0; j < n; j++) {
                            out.append(square[i][j]+" ");
                        }
                        out.append("\n");
                    }
                    sb.append(out);
                    return;
                }
            }
            sb.append("Case #"+tC+": IMPOSSIBLE\n");
            return;
        } 

        public static void generateAllPerm(int currIndex, ArrayList<Integer> currPerm, int currSum, int n, int k) {
            if(currIndex == n) {
                if(currSum == k)
                    allPossiblePerm.add(new ArrayList<>(currPerm));
                return;
            }

            if(currSum > k)
                return;
            
            for(int i = 1; i <= n; i++) {
                currPerm.add(i);
                generateAllPerm(currIndex+1, currPerm, currSum+i, n, k);
                currPerm.remove(currPerm.size()-1);
            }

        }

        public static void main( String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
            for (int tC = 1; tC <= t; tC++) {
                String[] input = br.readLine().split(" ");
                int n = Integer.parseInt(input[0]);
                int k = Integer.parseInt(input[1]);
                
                // if(n * n < k) {
                //     sb.append("Case #"+tC+": IMPOSSIBLE\n");
                //     continue;
                // }

                allPossiblePerm = new ArrayList<>();

                generateAllPerm(0, new ArrayList<Integer>(), 0, n, k);
        
                possibleLatinSquares(n, k, tC);
            }
            System.out.println(sb);
    } 
}
