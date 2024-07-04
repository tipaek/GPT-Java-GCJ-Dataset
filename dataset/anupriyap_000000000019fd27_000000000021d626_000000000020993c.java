import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static class testcase {
        int n;
        int l;
        int[][] p;

        testcase() {
            this.n = 0;
            this.l = 0;
            this.p = null;
        }
    }

    public static void findTrace(int index, int size, int[][] arr1) {
        int count = 0;
        int samerow = 0;
        int samecol = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    count = count + arr1[i][j];
                }
            }
        }

        //count number of rows with duplicate elements
        for (int i = 0; i < size; i++) {
            int[] counterRow = new int[size];
            Arrays.fill(counterRow,0);
            for (int j = 0; j < size; j++) {
                if ( counterRow[arr1[i][j] - 1] == 1) {
                    samerow++;
                    break;
                }
                counterRow[arr1[i][j] - 1]++;
            }
        }

        for (int i = 0; i < size; i++) {
            int[] counterCol = new int[size];
            Arrays.fill(counterCol,0);
            for (int j = 0; j < size; j++) {
                if (counterCol[arr1[j][i] - 1] == 1) {
                    samecol++;
                    break;
                }
                counterCol[arr1[j][i] - 1]++;
            }
        }

        System.out.println(count +" " + samerow + " " + samecol);
    }

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        testcase tc[] = new testcase[t];
        int size = 0;

        for(int i = 0; i < t; i++){
            tc[i] = new testcase();
            tc[i].n = sc.nextInt();

            tc[i].p = new int[tc[i].n][tc[i].n];
            for(int k=0;k<tc[i].n;k++){
                for (int j=0;j<tc[i].n;j++){
                    tc[i].p[k][j]=sc.nextInt();
                }
            }
        }

        for(int i = 0; i < t; i++) {
            findTrace(i, tc[i].n, tc[i].p);
        }
    }
}