
import java.util.*;
import java.io.*;

class Solution {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt(),t=0;
        while (t++<T) {
            int n = s.nextInt();
            int arr[][] = new int[n][n];
            int diagonal = 0;
            HashMap<Integer, Integer> num = new HashMap<>();

            for (int i = 0; i < n; i++) {
                num.put(i, 1);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int temp = s.nextInt();
                    arr[i][j] = temp;
                    if (!num.containsKey(temp)) {
                        num.put(temp, 1);
                    }
                    if (i == j) {
                        diagonal += temp;
                    }
                }
            }
//            System.out.println(num.toString());
            int Orow = 0, Ocol = 0;
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    int temp = arr[row][col];
                    if (num.containsKey(temp)) {
                        num.put(temp, num.get(temp) + 1);
                    }
                }
                for (int c = 1; c <= n; c++) {
                    if (num.get(c) > 2) {
                        Orow += 1;
                        break;
                    }
                }
//                System.out.println(num.toString());
//                System.out.println("row = " + Orow);
                for (int res = 1; res <= n; res++) {
                    num.put(res, 1);
                }
            }

            for (int col = 0; col < n; col++) {
                for (int row = 0; row < n; row++) {
                    int temp = arr[row][col];
                    if (num.containsKey(temp)) {
                        num.put(temp, num.get(temp) + 1);
                    }
                }
                for (int c = 1; c <= n; c++) {
                    if (num.get(c) > 2) {
                        Ocol += 1;
                        break;
                    }
                }
//                System.out.println(num.toString());
//                System.out.println("Ocol = " + Ocol);
                for (int res = 1; res <= n; res++) {
                    num.put(res, 1);
                }
            }
            System.out.println("Case #"+t+": "+ diagonal+" "+Orow+" "+Ocol);
//            System.out.println(Ocol);
//            System.out.println(Orow);
//            System.out.println(diagonal);

        }
    }

}
