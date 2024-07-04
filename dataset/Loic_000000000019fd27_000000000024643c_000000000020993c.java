
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Solution {

    public static void main(String[] args) {
        Solver solver = new Solver(args);

    }

}

 class Solver {


    public Solver(String args[]) {
        int howManyMatrix = Integer.parseInt(args[0]);

        for (int i = 1, ii = 0; ii < howManyMatrix; i++, ii++) {
            int lineMatrix = Integer.parseInt(args[i]);
            int[][] matrix = new int[lineMatrix][lineMatrix];

            for (int j = 0; j < lineMatrix; j++) {
                ++i;
                String[] line = args[i].split(" ");
                matrix[j] = StringArrToIntArr(line);
            }
            eachMatrix(matrix, ii);
        }

    }

    public int[] StringArrToIntArr(String[] s) {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }

    private void eachMatrix(int[][] matrix, int which) {
        fff(matrix, which);
    }

     public static void fff(int[][] matrix, int which) {
         int sumDiag = 0;
         int lineR = 0;
         int colR = 0;

         HashMap<String, List<Integer>> colRM = new HashMap();
         HashMap<String, Boolean> cc = new HashMap<>();

         for (int i = 0; i < matrix.length; i++) {
             List<Integer> rowR = new ArrayList<>();
             boolean moreOneLine = false;
             for (int j = 0; j < matrix[i].length; j++) {
                 if (!colRM.keySet().contains(j + "")) {
                     List a = new ArrayList<>();
                     a.add(matrix[i][j]);
                     colRM.put(j + "", a);
                 } else {
                     if (!colRM.get(j + "").contains(matrix[i][j])) {
                         List<Integer> jj = colRM.get(j + "");
                         jj.add(matrix[i][j]);
                         colRM.put(j + "", jj);
                     } else {
                         cc.put(j + "", true);
                     }
                 }

                 if (!rowR.contains(matrix[i][j])) {
                     rowR.add(matrix[i][j]);
                 } else {
                     moreOneLine = true;
                 }

                 if (i == j) {
                     sumDiag += matrix[i][j];
                 }
             }
             if (moreOneLine) {
                 lineR++;
             }
         }

         if(cc.isEmpty()){

         }else {
             for (int i = 0; i < matrix.length; i++) {
                 if (new Boolean(true).equals(cc.get(i + ""))) {
                     colR++;
                 }
             }
         }

         System.out.println("Case #" + (which + 1) + ": " + sumDiag + " " + lineR + " " + colR);
     }
 }