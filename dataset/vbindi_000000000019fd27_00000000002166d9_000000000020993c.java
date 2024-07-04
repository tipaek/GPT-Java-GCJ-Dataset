import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++){

            int k = 0;
            int r = 0;
            int c = 0;

            int n = in.nextInt();

            int[][] square = new int[n][n];

            for (int x = 0; x < n; x++){
                for (int y = 0; y < n; y++){
                    square[x][y] = in.nextInt();
                }
            }

            for (int a = 0; a < square.length; a++){
                Integer[] rows = new Integer[square[0].length];
                for (int b = 0; b < square[0].length; b++){
                    // diagonal sum detection
                    if (a==b)
                        k = k + square[a][b];

                    // determine rows with duplicates
                    rows[b] = square[a][b];
                }
                if (!isDistinct(rows)){
                    r++;
                }
            }

            for (int b = 0; b < square[0].length; b++){
                Integer[] cols = new Integer[square.length];
                for (int a = 0; a < square.length; a++){
                    // determine columnss with duplicates
                    cols[a] = square[a][b];
                }
                if (!isDistinct(cols)){
                    c++;
                }
            }

            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }

    public static boolean isDistinct(Integer arr[]){
        Set<Integer> s = new HashSet<Integer>(Arrays.asList(arr));
        return (s.size() == arr.length);
    }
}
