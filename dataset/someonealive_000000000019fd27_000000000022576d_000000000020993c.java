import java.util.Scanner;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(sc.nextLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(sc.nextLine());
            int[][] arr = new int[N][N];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int i = 0; i < N; i++) {
                String[] line = sc.nextLine().split(" ");
                for (int j = 0; j < line.length; j++) {
                    arr[i][j] = Integer.parseInt(line[j]);
                }
            }

            for (int i = 0; i < N; i++) {
                if (!checkRow(arr, i)) rowRepeats++;
                if (!checkCol(arr, i)) colRepeats++;
                trace += arr[i][i];
            }
            
            System.out.println("Case #" + (testCase) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }

    public static Boolean checkRow(int[][] arr, int row) {
        Boolean[] checked = new Boolean[arr.length + 1];
        
        for (int i = 0; i < arr.length; i++) {
            int num = arr[row][i];
            if (checked[num] == null) {
                checked[num] = true;
            } else return false;
        }
        return true;
    }

    public static Boolean checkCol(int[][] arr, int col) {
        Boolean[] checked = new Boolean[arr.length + 1];
        
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i][col];
            if (checked[num] == null) {
                checked[num] = true;
            } else return false;
        }
        return true;
    }
    
}
