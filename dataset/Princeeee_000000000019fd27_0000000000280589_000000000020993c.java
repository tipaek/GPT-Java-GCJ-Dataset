
import java.util.*;
import java.io.*;

class Main {
    static int count=1;
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int f = 0; f < t; f++)
        {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            check(arr,n);

        }
	// write your code here
    }
    static void check(int[][] arr,int n)
    {
        int k = 0;
        int row = 0;
        int col = 0;
        //List<Set<Integer>> forRow=new ArrayList();
        for (int i = 0; i < n; i++) {
            Set<Integer> forCol = new HashSet<>();
            Set<Integer> forRow=new HashSet<>();
            for (int j = 0; j < n; j++) {

                if (i == j) {
                    k += arr[i][j];
                }
                if (!forRow.add(arr[i][j])) {
                    row++;
                    //forRow.remove(arr[i][j]);

                }
                if (!forCol.add(arr[j][i])) {
                    col++;
                    //forCol.remove(arr[i][j]);
                }

            }
        }
        row=row>n?n:row;
        col=col>n?n:col;
        System.out.println("Case #" + count + ":" + " " + k + " " + row + " " + col);
        count++;
    }
}
