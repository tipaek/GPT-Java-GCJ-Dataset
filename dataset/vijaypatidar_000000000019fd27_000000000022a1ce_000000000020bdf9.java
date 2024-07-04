import java.util.Scanner;

public class Solution {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String res = "";
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] arr= new int[N][3];

            for (int i=0;i<N;i++){
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }

            String result ="";
            for (int i = 0; i < arr.length; i++) {
                if (isSafe(1,arr,i)) {
                    result += "C";
                } else if (isSafe(2,arr,i)) {
                    result += "J";
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }

            res += "Case #" + t + ": " + result;
            if (t != T) res += "\n";
        }
        System.out.print(res);
    }

    private  static boolean isSafe(int p,int[][] ar,int job){
        int start = ar[job][0];
        int end = ar[job][1];

        for (int[] ints : ar) {
            if (ints[2] == p && (start >= ints[0] && start < ints[1]||end > ints[0] && end <= ints[1])) {
                return false;
            }
        }
        ar[job][2]=p;
        return true;
    }
}