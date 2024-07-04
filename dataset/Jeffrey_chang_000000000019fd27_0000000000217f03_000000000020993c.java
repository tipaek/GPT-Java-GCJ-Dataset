import java.util.Scanner;
import java.util.HashMap;



public class Solution {
    
    static int Next(int[][] ar2, int B, Scanner scan){
        int sum = 0;
        for (int i = 0; i < B; i++) {
            sum += ar2[i][i];
        }
        return sum;
    }
    static int Next1(int[][] ar2, int B, Scanner scan){
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B; i++) {
            for (int j = 0; j < B; j++) {
                if (map.get(ar2[i][j]) == null){
                    map.put(ar2[i][j], -1);

                } else {
                    sum++;
                    break;
                }
            }
            map.clear();
        }
        return sum;
    }

    static int Next2(int[][] ar2, int B, Scanner scan){
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B; i++) {
            for (int j = 0; j < B; j++) {
                if (map.get(ar2[j][i]) == null){
                    map.put(ar2[j][i], -1);
                } else {
                    sum++;
                    break;
                }
            }
            map.clear();
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int X = 1;
        for (int i = 0; i < N; i++) {
            int J = scan.nextInt();
            int[][] ar2 = new int[J][J];
            for (int k = 0; k < J; k++) {
                for (int k2 = 0; k2 < J; k2++) {
                    ar2[k][k2] = scan.nextInt();
                }
            }
            int A = Next(ar2, J, scan);
            int B = Next1(ar2, J, scan);
            int C = Next2(ar2, J, scan);
            System.out.println("Case #" + X + ": " + A + " " + B + " " + C);
            X++;
        }



        scan.close();

        }

}
