import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(br.readLine());
        for (int x = 0; x < cases; x++) {

            int size = Integer.parseInt(br.readLine());
            int[][] square = new int[size][size];
            int trace=0;
            int repRows=0;
            int repCols=0;


            for (int r = 0; r < size; r++) {

                String raw = br.readLine();
                String[] line = raw.split(" ");
                int[] boardRow = new int[size];
                ArrayList<Integer> uniqR = new ArrayList<Integer>();
                boolean found = false;

                for (int j = 0; j < size; j++)
                    boardRow[j] = Integer.parseInt(line[j]);

                for (int c = 0; c < size; c++) {
                    square[r][c] = boardRow[c];

                    if (!found && uniqR.indexOf(square[r][c]) == -1) {
                        uniqR.add(square[r][c]);
                        }
                    else if  (!found){
                        repRows++;
                        found = true;
                    }
                    if (r == c)
                        trace += boardRow[c];
                }

            }

            for (int r=0; r<size; r++) {
                boolean found = false;
                ArrayList<Integer> uniqC = new ArrayList<Integer>();
                for (int c=0; c<size; c++) {
                    if (uniqC.indexOf(square[c][r]) == -1)
                        uniqC.add(square[c][r]);
                    else {
                        repCols++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+x+1+": "+trace+" "+repRows+" "+repCols);
        }
    }
}