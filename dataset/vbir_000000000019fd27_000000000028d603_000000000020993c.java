import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<Integer[][]> data = new ArrayList<>();
        int lineNr = 0;

        int testcases;
        int dim = 0;
        int column = 0;
        Integer[][] matrix = null;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] cells = line.split(" ");
            if(cells.length == 1) {
                if (lineNr == 0) {
                    testcases = Integer.parseInt(cells[0]);
                } else {
                    if(matrix != null){
                        data.add(matrix);
                    }
                    dim = Integer.parseInt(cells[0]);
                    matrix = new Integer[dim][dim];
                    column = 0;
                }
                lineNr++;
                continue;
            }
            assert(cells.length == dim);
            assert(matrix != null);

            Integer[] row = parseStringRow(cells);
            matrix[column]=row;
            column ++;
        }
        if(matrix != null){
            data.add(matrix);
        }

        String output = finishedResult(data);
        System.out.println(output);
    }

    private static Integer[] parseStringRow(String[] row){
        return Arrays.asList(row).stream().map(c->Integer.parseInt(c)).collect(Collectors.toList()).toArray(new Integer[row.length]);
    }

    private static String calculateSolution(Integer[][] A){
        int trace = 0;
        int duplicRows = 0;
        int duplicCols = 0;
        for(int i = 0; i < A.length; i++){
            Set set = new HashSet<>(Arrays.asList(A[i]));
            if(set.size()!= A[i].length){
                duplicRows++;
            }
            trace += A[i][i];

            Set<Integer> uniqueCol = new HashSet<>();
            for(int j = 0; j < A.length; j++){
                uniqueCol.add(A[j][i]);
            }
            if(uniqueCol.size() != A[i].length){
                duplicCols++;
            }
        }
        return String.format("%d %d %d", trace, duplicRows, duplicCols);
    }

    public static String finishedResult(List<Integer[][]> data){
        String output = "";
        int caseNr = 1;
        for(Integer[][] dp:data){
            output += String.format("Case #%d: %s\n", caseNr, calculateSolution(dp));
            caseNr ++;
        }
        return output;
    }
}
