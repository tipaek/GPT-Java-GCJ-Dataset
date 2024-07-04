import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <=t; ++i) {
            int n = in.nextInt();
            int trace = 0;
            Map<Integer, Set<Integer>> rows = new HashMap<>();
            Map<Integer, Set<Integer>> columns = new HashMap<>(n);
            for (int r=0; r<n;) {
                //String inputRow = in.nextLine();
                //System.out.println("InputRow: " + inputRow);
                //String[] rowStr =inputRow.split(" ");
                for (int c=0; c<n;) {
                    //int val = Integer.parseInt(rowStr[c]);
                    int val = in.nextInt();
                    //System.out.println("row:" + r + ",column:" + c + "=" +val);
                    if(r==c) {
                        trace += val;
                    }
                    Set<Integer> col = new HashSet<>();
                    if(columns.get(c)!=null) {
                        col = columns.get(c);
                    }
                    col.add(val);
                    columns.put(c,col);

                    Set<Integer> row = new HashSet<>();
                    if(rows.get(r)!=null) {
                        row = rows.get(r);
                    }
                    row.add(val);
                    rows.put(r,row);
                    c++;
                }
                r++;
            }

            //System.out.println("row sets:" + rows);
            //System.out.println("columns sets:" + columns);
            int numRepeatedRows = 0;
            int numRepeatedCols = 0;
            for(int l=0; l<n; l++)
            {
                if(rows.get(l).size()<n){
                    numRepeatedRows++;
                }

                if(columns.get(l).size()<n){
                    numRepeatedCols++;
                }
            }

            rows = null;
            columns = null;

            System.out.println("Case #" + i + ": " + trace + " " + numRepeatedRows + " " + numRepeatedCols);
        }
    }
}