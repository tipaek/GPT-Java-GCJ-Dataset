import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = scan.nextInt();

            int k = 0;
            int r = 0;
            int c = 0;

            int[][] nums = new int[N][N];
            for (int i = 0; i < N; i++) {
                boolean[] unique = new boolean[N];
                boolean found = false;
                for (int j = 0; j < N; j++) {
                    int a = scan.nextInt();
                    nums[i][j] = a;
                    if (i == j) {
                        k += a;
                    }
                    if(unique[a-1]){
                        found = true;
                    }else{
                        unique[a-1] = true;
                    }
                }
                if (found) {
                    r++;
                }
            }

            for (int i = 0; i < N; i++) {
                boolean[] unique = new boolean[N];
                for (int j = 0; j < N; j++) {
                    int a = nums[j][i];
                    if(unique[a-1]){
                        c++;
                        break;
                    }else{
                        unique[a-1] = true;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
        }

        scan.close();

    }
}