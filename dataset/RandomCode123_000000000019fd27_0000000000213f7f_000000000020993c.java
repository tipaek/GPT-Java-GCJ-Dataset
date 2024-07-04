import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            int size = in.nextInt();
            in.nextLine();
            int trace = 0;
            int row = 0;
            int col = 0;
            int[][] array = new int[size][size];
            for (int k = 0; k < size; k++){
                String s = in.nextLine();
                String[] arr = s.split(" ");
                ArrayList<Integer> rowRepeat = new ArrayList<Integer>();
                boolean flag = false;
                for(int st = 0; st < size; st ++){
                    int nextInt = Integer.parseInt(arr[st]);
                    if(!flag) {
                        if (rowRepeat.contains(nextInt)) {
                            row = row + 1;
                            flag = true;
                        }
                        rowRepeat.add(nextInt);
                    }
                    array[k][st] = nextInt;
                }
                trace = trace + array[k][k];
                rowRepeat.clear();
            }

            for(int k =0; k <size; k++){
                ArrayList<Integer> colRepeat = new ArrayList<Integer>();
                boolean flag = false;

                for(int st = 0; st < size; st++){
                    int nextInt = array[st][k];
                    if(!flag) {
                        if (colRepeat.contains(nextInt)) {
                            col = col + 1;
                            flag = true;
                        }
                        colRepeat.add(nextInt);
                    }
                }
                colRepeat.clear();
            }

            System.out.println("Case #" + i + ": " + trace + " " + row + " " + col);
        }
    }
}