import java.io.*;
import java.util.*;
import java.math.*;
public class Solution {
    
    static int [] Vestigium(int arr [][], int n) {
        int [] answer = new int [3];
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += arr[i][i];
        }
        int row_count = 0;
        HashMap <Integer, Integer> row_map = new HashMap<>();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row_map.putIfAbsent(arr[row][col], 0) != null){
                    row_count++;
                    break;
                }
            }
            row_map.clear();
        }

        int col_count = 0;
        HashMap <Integer, Integer> col_map = new HashMap<>();
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                if (col_map.putIfAbsent(arr[row][col], 0) != null){
                    col_count++;
                    break;
                }
            }
            col_map.clear();
        }
        
        answer[0] = trace;
        answer[1] = row_count;
        answer[2] = col_count;
        return answer;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < t; i++){
            int n = scanner.nextInt();
            scanner.nextLine();
            int [][] arr = new int [n][n];
            for (int j = 0; j < n; j++) {
                String m [] = scanner.nextLine().split(" ");
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(m[k]);
                }
            }
            int [] answer = Vestigium(arr, n);
            System.out.println(String.format("Case #%d: %d %d %d", i+1, answer[0], answer[1], answer[2])); 
        }

    }
    
}

