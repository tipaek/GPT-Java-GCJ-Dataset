import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int t = Integer.parseInt(inp.nextLine());
        int k=t;
        while (k-- > 0) {
            int n = Integer.parseInt(inp.nextLine());
            int arr[][] = new int[n][n];
            int trace = 0;
            for (int i=0; i<n; i++){
                String[] s = inp.nextLine().split(" ");
                for (int j=0; j<n; j++) {
                    arr[i][j] = Integer.parseInt(s[j]);
                    if (i == j) trace += arr[i][j];
                }
            }
            
            int rows=0, cols=0;
            for (int i=0; i<n; i++) {
                int ro[] = new int[n+1];
                for (int j=0; j<n; j++) {
                    if (ro[arr[i][j]] > 0) {
                        rows++; break;
                    }
                    ro[arr[i][j]]++;
                }
            }
            for (int i=0; i<n; i++) {
                int ro[] = new int[n+1];
                for (int j=0; j<n; j++) {
                    if (ro[arr[j][i]] > 0) {
                        cols++; break;
                    }
                    ro[arr[j][i]]++;
                }
            }
            System.out.println("Case #" + (t-k) + ": "+ trace + " " + rows + " " + cols);
        }
    }
}