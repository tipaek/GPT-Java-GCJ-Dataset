import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numTest = scanner.nextInt();
        
        
        for (int k = 0; k < numTest; k++) {
            int size = scanner.nextInt();
            int[][] arr = new int[size][size];
            int row = 0;
            int col = 0;
            int sum = 0;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    arr[i][j] = scanner.nextInt();
                    set.add(arr[i][j]);
                }
                if (set.size() != size) {
                    row++;
                }
                set.clear();
            }
            
            set.clear();
            for (int j = 0; j < size; j++) {
                for (int i = 0; i < size; i++) {
                    set.add(arr[i][j]);
                }
                if (set.size() != size) {
                    col++;
                }
                set.clear();
            }
            
            for (int i = 0; i < size; i++) {
                sum += arr[i][i];
            }
            System.out.println("Case #"+(k+1)+": "+sum+" "+row+" "+col);
        }
    }
}