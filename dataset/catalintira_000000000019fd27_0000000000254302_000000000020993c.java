import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.


        for (int i = 1; i <= t; ++i) {
            Map<Integer, ArrayList<Integer>> colsMap = new HashMap<>();
            int k = 0, r = 0, c = 0;
            int n = in.nextInt();

            for(int row = 0; row < n; ++row) {
                boolean rowCounted = false;
                boolean[] onRow = new boolean[n + 1];

                for(int col = 0; col < n; ++col) {
                    int currentNumber = in.nextInt();

                    if(onRow[currentNumber]) {
                        if(!rowCounted) {
                            r++;
                        }
                        rowCounted = true;
                    } else {
                        onRow[currentNumber] = true;
                    }

                    ArrayList<Integer> toAdd;

                    if(colsMap.containsKey(col)) {
                        toAdd = colsMap.get(col);
                    } else {
                        toAdd = new ArrayList<>();
                    }
                    toAdd.add(currentNumber);
                    colsMap.put(col, toAdd);

                    if(row == col) {
                        k += currentNumber;
                    }
                }

            }

            for(Integer key : colsMap.keySet()) {
                boolean[] values = new boolean[n + 1];
                ArrayList<Integer> list = colsMap.get(key);
                boolean colCounted = false;

                for(int index = 0; index < list.size(); ++index) {
                    int number = list.get(index);
                    if(values[number]) {
                        if(!colCounted) {
                            c++;
                        }
                        colCounted = true;
                    } else {
                        values[number] = true;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }
}
