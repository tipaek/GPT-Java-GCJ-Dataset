import java.util.HashMap;
import java.util.Scanner;

//Google CodeJam Vestigium
public class Solution {

    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int tc = in.nextInt();
        for(int c = 1; c <= tc; c++) {
            int n = in.nextInt();
            int[][] array = new int[n][n];
            populateArray(array, n);
            int trace = calcTrace(array, n);
            int rowDuplicates = calcRowDups(array, n);
            int columnDuplicates = calcColumnDups(array, n);
            System.out.println("Case #" + c + ": " + trace + " " + rowDuplicates + " " + columnDuplicates);
            //reset
            array = null;
        }
    }

    private static int calcRowDups(int[][] array, int n) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int duplicates = 0;
        for (int row = 0; row < n; row++) {
            for(int i = 0; i < n; i++) {
                int key = array[row][i];
                if (map.containsKey(key)) {
                    duplicates++;
                    break;
                } else {
                    map.put(key, true);
                }
            }
            map.clear();
        }
        return duplicates;
    }

    private static int calcColumnDups(int[][] array, int n) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        int duplicates = 0;
        for (int col = 0; col < n; col++) {
            for(int i = 0; i < n; i++) {
                int key = array[i][col];
                if (map.containsKey(key)) {
                    duplicates++;
                    break;
                } else {
                    map.put(key, true);
                }
            }
            map.clear();
        }
        return duplicates;
    }

    private static int calcTrace(int[][] array, int n) {
        int trace = 0;
        for(int i = 0; i < n; i++) {
            trace += array[i][i];
        }
        return trace;
    }

    private static void populateArray(int[][] array, int n) {
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j++) {
                int x = in.nextInt();
                array[i][j] = x;
            }
        }
    }

}
