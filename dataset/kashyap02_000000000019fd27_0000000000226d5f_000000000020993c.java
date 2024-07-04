import java.util.*;
class Solution {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++){
            int N = sc.nextInt();
            int A[][] = new int[N][N];
            int row = 0, column = 0, trace = 0, count = 0;
            for (int j = 0; j < N; j++){
                HashSet<Integer> h = new HashSet<Integer>();
                int flagRow = 0;
                count = 0;
                for (int k = 0; k < N; k++){
                    A[j][k] = sc.nextInt();
                    if(h.contains(A[j][k]) == true && flagRow == 0)
                        count++;

                    if(h.contains(A[j][k]) == false)
                        h.add(A[j][k]);

                    if(j == k)
                        trace += A[j][k];
                }
                if(count != 0)
                    row++;
                h.clear();
            }

            for (int j = 0; j < N; j++){
                HashSet<Integer> h = new HashSet<Integer>();
                int flagColumn = 0;
                count = 0;
                for (int k = 0; k < N; k++){
                    if(h.contains(A[k][j]) == true && flagColumn == 0)
                        count++;

                    if(h.contains(A[k][j]) == false)
                        h.add(A[k][j]);
                }
                if(count != 0)
                    column++;
                h.clear();
            }

            System.out.print("Case #" + i + ": " + trace + " " + row + " " + column);
            System.out.println();

        }
    }
}
