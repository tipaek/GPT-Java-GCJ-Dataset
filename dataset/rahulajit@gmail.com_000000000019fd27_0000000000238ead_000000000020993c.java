
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Rahul Ajit on 4/4/2020.
 */
public class Solution {

    public Set<Integer> colSet = new HashSet<>();
    public boolean isColDuplicate = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for(int i=1; i<=testCases; i++) {
            String output = "Case #" + i + ": ";
            int n = scanner.nextInt();
            int sum = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            Map<Integer, Solution> colMap = new HashMap<>();
            for(int row=0; row<n; row++) {
                boolean isRowDuplicate = false;
                Set<Integer> rowSet = new HashSet<>();
                for(int col=0; col<n; col++) {
                    int val = scanner.nextInt();
                    if(!isRowDuplicate) {
                        if(!rowSet.contains(val)) {
                            rowSet.add(val);
                        } else {
                            isRowDuplicate = true;
                            rowDuplicates++;
                        }
                    }
                    if(!colMap.containsKey(col)) {
                        Solution s = new Solution();
                        s.colSet.add(val);
                        colMap.put(col, s);
                    } else {
                        Solution s = colMap.get(col);
                        if(!s.isColDuplicate) {
                            if(!s.colSet.contains(val)) {
                                s.colSet.add(val);
                            } else{
                                s.isColDuplicate = true;
                                colDuplicates++;
                            }
                        }
                    }
                    if(row == col) {
                        sum += val;
                    }
                }
            }
            output = output + sum + " " + rowDuplicates + " " + colDuplicates;
            System.out.println(output);
        }
        scanner.close();
    }
}
