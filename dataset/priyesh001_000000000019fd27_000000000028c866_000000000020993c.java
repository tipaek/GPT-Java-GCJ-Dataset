import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

class Solution {

    public void solve() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int caseNo = 1;
        while (t-- > 0) {
            int n = in.nextInt();
            int arr[][] = new int[n+1][n+1];
            for (int i = 0; i < n; i++) {
                for(int j=0;j<n;j++) {
                    arr[i][j] = in.nextInt();
                }
            }
            int row = 0,col=0, trace = 0;
            for (int i = 0; i < n; i++) {
                int rowCheck = 1, colCheck = 1;
                HashSet<Integer> rowset = new HashSet<>();
                HashSet<Integer> colset = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if(rowCheck==1) {
                        if ( rowset.contains(arr[i][j]) ) {
                            row++;
                            rowCheck=0;
                        } else
                            rowset.add(arr[i][j]);
                    }

                    if(colCheck==1) {
                        if ( colset.contains(arr[j][i]) ) {
                            col++;
                            colCheck=0;
                        } else
                            colset.add(arr[j][i]);
                    }

                    if(i==j){
                        trace+=arr[i][j];
                    }
                }
            }
            System.out.println("Case #"+caseNo++ +": "+trace+" "+row+" "+col);
        }
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        solver.solve();
    }
}