
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) throws IOException {
        Scanner inp = new Scanner(System.in);
        int test = inp.nextInt();
        ArrayList<int[][]> numarr = new ArrayList<>();
        ArrayList<Integer> traces = new ArrayList<>();
        for (int i = 0; i < test; i++) {
            int n = inp.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0;
            for (int m = 0; m < arr.length; m++) {
                for (int p = 0; p < arr[0].length; p++) {
                    arr[m][p] = inp.nextInt();
                    if (m == p) {
                        trace += arr[m][m];
                    }
                }
            }
            traces.add(trace);
            numarr.add(arr);
        }
        for (int i = 0; i < numarr.size(); i++) {
            int mat[][] = numarr.get(i);
            int r, c;
            r = c = 0;
            for (int t = 0; t < mat.length; t++) {
                int[] arr = mat[t];
                for (int j = 0; j < arr.length; j++) {
                    boolean breaker = false;
                    int e = arr[j];
                    for (int k = j + 1; k < arr.length; k++) {
                        System.out.println((r == arr[k]) + " " + r + " " + arr[k]);
                        if (e == arr[k]) {
                            r++;
                            breaker = true;
                            break;
                        }
                    }
                    if (breaker) {
                        break;
                    }
                }
            }
            boolean breaker = false;
            for (int j = 0; j < mat.length; j++) {
                int[] col = new int[mat.length];
                for (int k = 0; k < col.length; k++) {
                    col[k] = mat[k][j];
                }
                for (int k = 0; k < col.length; k++) {
                    int e = col[k];
                    for (int l = k + 1; l < col.length; l++) {
                        if (e == col[l]) {
                            c++;
                            breaker = true;
                            break;
                        }
                    }
                    if (breaker) {
                        break;
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + traces.get(i) + " " + r + " " + c);
        }
    }
}
