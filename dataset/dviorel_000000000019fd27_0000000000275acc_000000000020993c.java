import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        for (int q = 1; q <= t; q++){
            int n = Integer.parseInt(sc.next());
            int[] arr = new int[n * n];
            int k = 0, r = 0, c = 0;
            for(int i = 0; i < n; i++){
                boolean[] rows = new boolean[n + 1];
                for(int j = 0; j < n; j++) {
                    int index = i *n + j;
                    arr[index] = Integer.parseInt(sc.next());
                    if (i == j ){
                        k += arr[i *n + j];
                    }
                    if (!rows[n] && rows[arr[index] - 1]){
                        r++;
                        rows[n] = true;
                    }
                    rows[arr[index] - 1] = true;
                }
            }
            for(int i = 0; i < n; i++){
                boolean[] cols = new boolean[n];
                for(int j = 0; j < n; j++){
                    int index = j * n + i;
                    if(cols[arr[index] - 1]){
                        c++;
                        cols[arr[index] - 1] = true;
                        break;
                    }
                    cols[arr[index] - 1] = true;
                }
            }
            System.out.printf("Case #%d: %d %d %d%n", q, k, r ,c);
        }
    }
}
