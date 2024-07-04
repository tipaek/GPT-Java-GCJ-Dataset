import java.util.*;

public class q1 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int cases = 0;
        if(scanner.hasNextLine()) {
            cases = Integer.parseInt(scanner.nextLine());
        }
        for(int i = 0; i < cases; i++) {
            int size = Integer.parseInt(scanner.nextLine());
            int[][] mat = new int[size][size];
            for(int j = 0; j < size; j++) {
                String[] curr = scanner.nextLine().split(" ");
                for(int k = 0; k < curr.length; k++) {
                    mat[j][k] = Integer.parseInt(curr[k]);
                }
            }
            System.out.println("Case #" + Integer.toString(i+1) + ": " + output(mat));
        }
    }

    public static String output(int[][] mat) {
        int trace = 0;
        int rowRep = 0;
        int colRep = 0;
        HashSet<String> colVals = new HashSet<String>();
        HashSet<Integer> colCheck = new HashSet<Integer>();
        for(int i = 0; i < mat.length; i++) {
            HashSet<Integer> rowVals = new HashSet<Integer>();
            boolean foundRep = false;
            for(int j = 0; j < mat[i].length; j++) {
                int curr = mat[i][j];
                if(i == j)
                    trace += curr;
                if(colVals.contains(Integer.toString(j) + "," + Integer.toString(curr)) && !colCheck.contains(j)) {
                    colRep++;
                    colCheck.add(j);
                }
                else
                    colVals.add(Integer.toString(j) + "," + Integer.toString(curr));
                if(rowVals.contains(curr) && !foundRep) {
                    rowRep++;
                    foundRep = true;
                }
                else
                    rowVals.add(curr);
            }
        }
        return Integer.toString(trace) + " " + Integer.toString(rowRep) + " " + Integer.toString(colRep);
    }
    
}