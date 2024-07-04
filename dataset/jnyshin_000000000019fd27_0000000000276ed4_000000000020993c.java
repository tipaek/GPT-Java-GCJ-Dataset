//package codejam;
import java.util.Scanner;
public class Vestigium {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        int current = 0;
        while (current < t){
            int n = input.nextInt();
            int[][] matrix = new int[n][n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = input.nextInt();
                    if (i == j) sum += matrix[i][j];
                }
            }
            System.out.println("case #" + (current+1) +" : " + sum + " " + r_repeated(matrix) +
                    " "+ c_repeated(matrix));
            current ++;
        }

    }
    public static int r_repeated(int[][] arr){
        int r = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++){
            int[] row = new int[n];
            for (int j = 0; j < n; j++) {
                row[j] = arr[i][j];
            }
            if (match(row)) r++;
        }
        return r;
    }

    public static int c_repeated(int[][] arr){
        int c = 0;
        int n = arr.length;
        for (int j = 0; j < n; j++){
            int[] column = new int[n];
            for (int i = 0; i < n; i++) {
                column[i] = arr[i][j];
            }
            if (match(column)) c++;
        }
        return c;
    }

    public static boolean match(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) return true;
            }
        }
        return false;
    }
}
