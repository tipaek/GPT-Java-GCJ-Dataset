import java.io.*;
import java.util.*;
class Main {


    public static boolean ifCheckRow(int[][] arr, int r) {
        Set<Integer> set = new HashSet<>();
        for(int j = 0; j < arr[0].length; j++) {
            if(set.contains(arr[r][j]) == true) {
                return false;
            }
            set.add(arr[r][j]);
        }
        return true;
    }

    public static boolean ifCheckCol(int[][] arr, int c) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i][c]) == true) {
                return false;
            }
            set.add(arr[i][c]);
        }
        return true;
    }


    public static void getAnswer(int[][] arr, int ct) {
        boolean[] row = new boolean[arr.length];
        boolean[] col = new boolean[arr.length];
        int countRow = 0;
        int countCol = 0;
        int trace = 0;

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(i == j) {
                    trace += arr[i][j];
                }

                if(row[i] == false && ifCheckRow(arr, i) == false) {
                    countRow++;
                    row[i] = true;
                }

                if(col[i] == false && ifCheckCol(arr, j) == false) {
                    countCol++;
                    col[i] = true;
                }

            }
        }

        System.out.println("Case #" + ct + ": " + trace + " " + countRow + " " + countCol);
    } 

    public static void main(String[] args) {
        Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = -1;
        if(scn.hasNextInt()) {
            t = scn.nextInt();
        }

        int ct = 1;
        while(ct <= t) {
            int n = -1;
            if(scn.hasNextInt()) {
                n = scn.nextInt();
            }

            int[][] arr = new int[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    arr[i][j] = scn.nextInt();
                }
            }
            getAnswer(arr, ct);
            ct++;
        }
    }
}