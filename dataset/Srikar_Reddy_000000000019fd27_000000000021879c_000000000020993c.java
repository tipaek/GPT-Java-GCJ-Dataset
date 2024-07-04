
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int trace= 0;
        int rep_rows=0;
        int rep_cols = 0;
        boolean row_flag = false;
        boolean col_flag = false;
        int testc = sc.nextInt();

        for(int i=0;i<testc;i++) {
            rep_cols = 0;
            rep_rows = 0;
            trace = 0;
            int sqr = sc.nextInt();

            ArrayList<Integer> colz = new ArrayList<Integer>();
            for (int s = 0; s < sqr; s++) {
                ArrayList<Integer> rowz = new ArrayList<Integer>();

                row_flag = false;
                col_flag = false;

                int[] inputNumbers = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

                for (int k = 0; k < inputNumbers.length; k++) {

                    int n = inputNumbers[k];

                    if (s == k) {
                        trace = trace + n;
                    }


                    if (colz.contains(n) && !col_flag) {
                        rep_cols++;
                        col_flag = true;
                    } else {
                        colz.add(n);
                    }

                    if (rowz.contains(n) && !row_flag) {
                        rep_rows++;
                        row_flag = true;
                    } else {
                        rowz.add(n);
                    }

                }



            }
            System.out.println("Case #" + testc + ": " + trace + " " + rep_rows + " " + rep_cols);
        }

        }
    }

