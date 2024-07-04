
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class example {

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
                    arr[m][p] = inp.nextInt();;
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
            boolean breaker = true;
            for (int k = 0; k < mat[0].length; k++) {
                for (int l = 0; l < mat[0].length; l++) {
                    for (int j = l+1; j < mat[0].length; j++) {
                        if (mat[k][l] == mat[k][j]) {
                            r = k;
                            c=j;
                            breaker = false;
                            break;
                        }
                    }
                    if (!breaker) {
                        break;
                    }
                }
                if (!breaker) {
                    break;
                }
            }
           
            if(breaker)
            {
            for (int k = 0; k < mat[0].length; k++) {
                for (int l = 0; l < mat[0].length; l++) {
                    for (int j = l+1; j < mat[0].length; j++) {
                        System.out.println((mat[l][k] == mat[j][k])+" "+mat[j][k]+" j="+j+" k="+k);
                        if (mat[l][k] == mat[j][k]) {
                            c = j;
                            breaker = false;
                            break;
                        }
                    }
                    if (!breaker) {
                        break;
                    }
                }
                if (!breaker) {
                    break;
                }
            }
        }
            System.out.println("Case #" + (i + 1) + ": " + traces.get(i) + " " + r + " " + c);
        }
    }
}
