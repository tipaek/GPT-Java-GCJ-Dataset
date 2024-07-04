

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Vestigium {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t > 0; t--) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            int trace = 0;
            boolean flag = true;
            int r = 0;
            for (int i = 0; i < arr.length; i++) {
                String[] str = br.readLine().split("\\s+");
                HashSet<Integer> rowSet = new HashSet<>();
                flag = true;
                for (int j = 0; j < arr.length; j++) {
                    arr[i][j] = Integer.parseInt(str[j]);
                    if (!rowSet.add(arr[i][j]) && flag) {
                        flag = false;
                    }
                }
                if (flag == false) {
                    r++;
                }
                trace += arr[i][i];
            }
            int c = 0;
            for (int j = 0; j < arr.length; j++) {
                flag = true;
                HashSet<Integer> colSet = new HashSet<>();
                for (int i = 0; i < arr.length; i++) {
                    if (!colSet.add(arr[i][j]) && flag) {
                        flag = false;
                    }
                }

                if (flag == false) {
                    c++;
                }
            }
            System.out.println(trace+" "+r+" " + c);
        }
    }

}