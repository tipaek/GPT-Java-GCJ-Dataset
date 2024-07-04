import java.util.*;
import java.io.*;

/*
3
4
1 2 3 4
2 1 4 3
3 4 1 2
4 3 2 1
4
2 2 2 2
2 3 2 3
2 2 2 3
2 2 2 2
3
2 1 3
1 3 2
1 2 3
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= cases; ++i) {
            int n = in.nextInt();
            int countRow = 0;
            int countColumn = 0;
            int trace = 0;
            int [][] arr = new int[n][n];
            for(int x = 0;x < n;x++){
                Set<Integer> rows = new HashSet<>();
                boolean foundDuplicate = false;
                for(int y = 0;y < n;y++){
                    arr[x][y] = in.nextInt();
                    if(rows.contains(arr[x][y])){
                        foundDuplicate = true;
                    }
                    rows.add(arr[x][y]);
                    if(x == y){
                        trace += arr[x][y];
                    }
                }
                if(foundDuplicate){
                    countRow++;
                }
                rows.clear();
            }
            for(int x = 0;x < n;x++){
                Set<Integer> columns = new HashSet<>();
                boolean foundDuplicate = false;

                for(int y = 0;y < n;y++){
                    if(columns.contains(arr[y][x])){
                        foundDuplicate = true;
                    }
                    columns.add(arr[y][x]);
                }
                if(foundDuplicate){
                    countColumn++;
                }
                columns.clear();
            }


            System.out.println("Case #" + i + ": " + trace + " " + countRow + " " + countColumn);
        }
    }
}
