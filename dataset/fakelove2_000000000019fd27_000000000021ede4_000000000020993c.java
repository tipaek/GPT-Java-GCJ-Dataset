import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try {
            InputStream is = System.in;//new FileInputStream(new File(args[0])); // = System.in;
            Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)));
            int t = scanner.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
            for (int i = 1; i <= t; ++i) {
                System.out.print("Case #");
                System.out.print(i);
                System.out.print(": ");
                solve(scanner);
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int[][] a = new int[n][n];
        HashMap<Integer, Integer> map= new HashMap<>(n);

        long trace = 0;
        int row=0, col=0;

        for(int i = 0; i<n;i++)
            map.put(i+1, 0);

        for(int i = 0; i<n;i++){
            for(int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
                if(i==j)
                    trace+=a[i][j];
            }
        }

        //check row
        for(int i = 0; i < n; i++){
            //reset map
            for(int k = 0; k<n;k++)
                map.put(k+1, 0);

            //check row i
            for(int j = 0; j < n; j ++){
                int v =map.get(a[i][j]);
                if (v>0) {
                    row++;
                    break;
                }
                map.replace(a[i][j], v+1);
            }
        }


        //check col
        for(int i = 0; i < n; i++){
            //reset map
            for(int k = 0; k<n;k++)
                map.put(k+1, 0);

            //check col i
            for(int j = 0; j < n; j ++){
                int v =map.get(a[j][i]);
                if (v>0) {
                    col++;
                    break;
                }
                map.replace(a[j][i], v+1);
            }
        }
        System.out.println(trace+" "+row+ " "+col);
    }
}
