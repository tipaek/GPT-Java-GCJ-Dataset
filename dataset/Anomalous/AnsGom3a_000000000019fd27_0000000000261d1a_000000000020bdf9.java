import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        
        for (int x = 1; x <= t; x++) {
            boolean possible = true;
            int n = input.nextInt();
            int[][] arr = new int[n][3];
            
            for (int i = 0; i < n; i++) {
                int s = input.nextInt();
                int e = input.nextInt();
                
                if (possible) {
                    if (isFree(1, s, e, arr)) {
                        arr[i][0] = 1;
                        arr[i][1] = s;
                        arr[i][2] = e;
                    } else if (isFree(2, s, e, arr)) {
                        arr[i][0] = 2;
                        arr[i][1] = s;
                        arr[i][2] = e;
                    } else {
                        possible = false;
                    }
                }
            }
            
            if (possible) {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    result.append(arr[i][0] == 1 ? 'J' : 'C');
                }
                System.out.println("Case #" + x + ": " + result);
            } else {
                System.out.println("Case #" + x + ": IMPOSSIBLE");
            }
        }
        
        input.close();
    }

    private static boolean isFree(int who, int s, int e, int[][] arr) {
        for (int[] entry : arr) {
            if (entry[0] == 0) break;
            if (entry[0] == who) {
                int aS = entry[1];
                int aE = entry[2];
                if ((s >= aS && s < aE) || (e > aS && e <= aE) || (aS >= s && aS < e) || (aE > s && aE <= e)) {
                    return false;
                }
            }
        }
        return true;
    }
}