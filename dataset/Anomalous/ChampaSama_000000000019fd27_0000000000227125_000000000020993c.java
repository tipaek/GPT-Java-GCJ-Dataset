import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        try {
            int testCases = Integer.parseInt(br.readLine());
            for (int cases = 0; cases < testCases; cases++) {
                int size = Integer.parseInt(br.readLine());
                ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
                int repeatedRowCount = 0, repeatedColumnCount = 0, trace = 0;
                boolean[] columnFlag = new boolean[size];

                for (int i = 0; i < size; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    ArrayList<Integer> row = new ArrayList<>(size);
                    boolean rowFlag = true;

                    for (int j = 0; j < size; j++) {
                        int element = Integer.parseInt(st.nextToken());
                        if (row.contains(element) && rowFlag) {
                            repeatedRowCount++;
                            rowFlag = false;
                        }
                        for (int k = 0; k < i; k++) {
                            if (matrix.get(k).get(j) == element && !columnFlag[j]) {
                                repeatedColumnCount++;
                                columnFlag[j] = true;
                            }
                        }
                        if (i == j) {
                            trace += element;
                        }
                        row.add(element);
                    }
                    matrix.add(row);
                }
                System.out.println("Case #" + (cases + 1) + ": " + trace + " " + repeatedRowCount + " " + repeatedColumnCount);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}