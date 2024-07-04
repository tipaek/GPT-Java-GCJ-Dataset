import java.util.*;

public class Solution {

    public static void main(String... args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            int matrixSize = Integer.parseInt(in.nextLine());
            int [][] myArray = new int[matrixSize][matrixSize];

            for(int k=0;k<matrixSize;k++){
                String[] line = in.nextLine().trim().split(" ");
                for (int j=0; j<line.length; j++) {
                    myArray[k][j] = Integer.parseInt(line[j]);
                }
            }

            computeTrace(myArray,i);

        }
    }

    public static void computeTrace(int[][] matrix,int caseNumber){
        int k = 0,r = 0,c = 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

//        Set<Integer> diagonal = new HashSet<>();
        List<Set<Integer>> rowList = new ArrayList<>();
        List<Set<Integer>> columnList = new ArrayList<>();

        for(int i = 0; i < rows; i++){
            Set<Integer> onerow = new HashSet<>();
            for(int j = 0; j < cols; j++){
                if(i==j) k = k + matrix[i][j];
                onerow.add(matrix[i][j]);
            }
            rowList.add(onerow);
        }

        for(int i = 0; i < cols; i++){
            Set<Integer> oneColumn = new HashSet<>();
            for(int j = 0; j < rows; j++){
               oneColumn.add(matrix[j][i]);
            }
            columnList.add(oneColumn);
        }

        for (Set<Integer> a :
                rowList) {
            if(a.size()!=matrix.length) r++;
        }

        for (Set<Integer> a :
                columnList) {
            if(a.size()!=matrix.length) c++;
        }



        System.out.println("Case #" + caseNumber + ": " + k +" " +r +" " +c);


    }
}
