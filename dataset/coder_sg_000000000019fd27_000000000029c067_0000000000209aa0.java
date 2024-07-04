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
                
                if(currRow == currCol)
                    return startFilling(currCell+1, n, k, rows, cols);
                
                else {
                    for(int i = 1; i <= n; i++) {
                        if(!rows[currRow][i] && !cols[currCol][i]) {
                            int temp = square[currRow][currCol];
                            square[currRow][currCol] = i;
                            rows[currRow][i] = true;
                            cols[currCol][i] = true;
                            boolean done = startFilling(currCell+1, n, k, rows, cols);
                            if(done)
                                return true;
                            square[currRow][currCol] = temp;
                            rows[currRow][i] = false;
                            cols[currCol][i] = false;
                        }
                    }
                }

            return false;
        }
        
        public static void possibleLatinSquares(int n, int k, int tC) {
            if(allPossiblePerm.size() == 0) {
                System.out.println("Case #"+tC+": IMPOSSIBLE\n");
                return;
            }

            for(int permIndex = 0; permIndex < allPossiblePerm.size(); permIndex++) {
                ArrayList<Integer> diagonal = allPossiblePerm.get(permIndex);

                square = new int[n][n];
                boolean[][] rows = new boolean[n][n+1];
                boolean[][] cols = new boolean[n][n+1];
                
                int d = 0;

                for(int j = 0; j < n; j++) {
                    int digit = diagonal.get(d);
                    square[j][j] = digit;
                    rows[j][digit] = true;
                    cols[j][digit] = true;
                    d++;
                }
        
                boolean isPossible = startFilling(0, n, k, rows, cols);

                if(isPossible) {
                    System.out.println("Case #"+tC+": POSSIBLE");
                    // StringBuilder out = new StringBuilder();
                    for(int i = 0 ; i < n; i++) {
                        for(int j = 0; j < n; j++) {
                            System.out.print(square[i][j]+" ");
                        }
                        System.out.println();
                    }
                    //sb.append(out);
                    return;
                }
            }
            System.out.println("Case #"+tC+": IMPOSSIBLE");
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
            // System.out.println(sb);
    } 
}
