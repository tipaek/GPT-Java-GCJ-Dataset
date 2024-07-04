import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    static boolean printLatin(int[][] arr, int k) {

        int n = arr[0].length;
        float val = k / n;
        int l = n +1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = (i + j) % n + 1;
            }
        }

        int total = 0;
        for(int i = 0; i < n; i++) {
            total += arr[i][i];
        }

        if(total == k) {
            return true;
        } else {
            return false;
        }
    }

    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int m = 1;
        int n, k;
        String[] temp;
        String str;
        int[][] arr;

        while (t > 0) {
            temp = br.readLine().split(" ");
            n = Integer.parseInt(temp[0]);
            k = Integer.parseInt(temp[1]);

            arr = new int[n][n];
            if(printLatin(arr, k)) {
                str = "POSSIBLE";
                System.out.println("Case #"+ m + ": " + str);
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println();
                }
            } else {
                str = "IMPOSSIBLE";
                System.out.println("Case #"+ m + ": " + str);
            }


            t--;
            m++;
        }
    }
}
