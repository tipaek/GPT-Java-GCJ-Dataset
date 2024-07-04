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
        int max = 0;
        int max2=0;
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
            if(tmp > max)
            {
                max = tmp;                
            }
            tmp = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmpAr[j] = ar[j][i];
                //System.out.println(tmpAr[j]);
            }
            bubbleSort(tmpAr);

            for (int k = 0; k < n; k++) {
                if (k > 0) {
                    if (tmpAr[k] == tmpAr[k - 1]) {
                        cnt++;
                    }
                }
            }
            if(cnt > max2)
            {
                max2 = cnt;                
            }
            cnt = 0;
        }

        System.out.println(sumOfDiogonal);
        if (max == 1) {
            max = 0;
        }
        if (max2 == 1) {
            max2 = 0;
        }
        //max--;
        //max2--;
        System.out.println(max);
        System.out.println(max2);

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
