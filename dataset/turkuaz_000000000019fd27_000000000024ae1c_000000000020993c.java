import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);

        int test_cases = k.nextInt();

        for(int i = 0; i < test_cases; i++) {
            int n = k.nextInt();
            int[][] matrix = new int[n][n];
            for(int j = 0; j < n; j++) {
                for(int l = 0; l < n; l++) {
                    matrix[j][l] = k.nextInt();
                }
            }
            check(matrix);
        }
    }


    public static void check(int ar[][]) {
        int n = ar.length;
        int sumOfDiogonal = 0;
        int cnt = 1;
        int tmp = 1;
        int[] tmpAr = new int[n];
        for (int i = 0; i < n; i++) {
            tmpAr = ar[i].clone();
            bubbleSort(tmpAr);
            for (int j = 0; j < n; j++) {

                if (j > 0) {
                    if (tmpAr[j] == tmpAr[j - 1]) {
                        tmp++;
                    }
                }
                if (i == j) {
                    sumOfDiogonal += (int) ar[i][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmpAr[j] = ar[j][i];
                //System.out.println(ar[j][i]);
            }
            bubbleSort(tmpAr);
            

            for (int k = 0; k < n; k++) {
                if (k > 0) {
                    if (tmpAr[k] == tmpAr[k - 1]) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(sumOfDiogonal);
        if (cnt == 1) {
            cnt = 0;
        }
        if (tmp == 1) {
            tmp = 0;
        }
        System.out.println(tmp);
        System.out.println(cnt);
    }
    
    static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


}
