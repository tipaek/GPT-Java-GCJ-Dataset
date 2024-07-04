

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vestigium {
    public static void main(String[] args) {
        
        Input input = ReadFile();
        int c = 0;
        for (Integer[][] array : input.arrays) {
            System.out.println(LatinSquares(array, ++c));
        }
        
      
    }


    static class Input {
        int testCase;
        List<Integer[][]> arrays = new ArrayList<>();
    }

    static Input ReadFile() {
        Input input = new Input();
        try {
            int dim = 0;

            File file = new File("input.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            int i = 0, j = 0;
            String st;

            boolean firstLine = true;
            boolean isMatrixDim = false;

            Integer[][] arr = new Integer[1][1];

            while ((st = br.readLine()) != null) {
                if (firstLine) {
                    input.testCase = Integer.parseInt(st);
                    input.arrays = new ArrayList<>();
                    firstLine = false;
                    isMatrixDim = true;
                } else if (isMatrixDim) {
                    dim = Integer.parseInt(st);
                    arr = new Integer[dim][dim];
                    input.arrays.add(arr);
                    isMatrixDim = false;
                } else {
                    for (String s : st.split(" ")) {
                        arr[i][j++] = Integer.parseInt(s);
                    }
                    if (j == dim) {
                        i++;
                        j = 0;
                    }
                    if (i == dim) {
                        i = 0;
                        j = 0;
                        isMatrixDim = true;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return input;
    }

    static String LatinSquares(Integer[][] arr, int c) {
        Map<Integer, List<Map<Integer, Integer>>> clasification = new HashMap<>();
        int k = 0;
        int repeatCol = 0;
        int repeatRow = 0;
        for (int i = 0; i < arr.length; i++) {
            k += arr[i][i];

            for (int j = 0; j < arr[i].length; j++) {
                if (!clasification.containsKey(arr[i][j])) {
                    List<Map<Integer, Integer>> maps = new ArrayList<>(2);
                    Map<Integer, Integer> cols = new HashMap<>();
                    cols.put(j, 1);

                    Map<Integer, Integer> rows = new HashMap<>();
                    rows.put(i, 1);
                    maps.add(rows);
                    maps.add(cols);
                    clasification.put(arr[i][j], maps);
                } else {
                    List<Map<Integer, Integer>> maps = clasification.get(arr[i][j]);
                    Map<Integer, Integer> rows = maps.get(0);
                    Map<Integer, Integer> cols = maps.get(1);

                    if (rows.containsKey(i))
                        repeatRow = repeatRow + 1;
                    else
                        rows.put(i, 1);

                    if (cols.containsKey(j))
                        repeatCol = repeatCol + 1;
                    else
                        cols.put(j, 1);
                }
            }
        }
        if (repeatCol > arr.length) repeatCol = arr.length;
        if (repeatRow > arr.length) repeatRow = arr.length;

        return "Case " + c + "#: " + k + " " + repeatRow + " " + repeatCol;
    }
}
