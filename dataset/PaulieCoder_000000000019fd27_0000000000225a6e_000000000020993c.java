import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Vestigium{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        String result = null;
        //For each test case
        for(int test = 1; test <= T; test++){
            int N = Integer.parseInt(sc.nextLine());
            //Formina a matrix
            int[][] matrix = new int[N][N];
            for (int row = 0; row < N; row++){
                String rowString = sc.nextLine();
                String[] rowStrArr = rowString.split(" ");
                for(int col = 0; col < N; col++){
                    matrix[row][col] = Integer.parseInt(rowStrArr[col]);
                }
            }
            //Code
            //Calculate the trace
            int row = 0, col = 0;
            int trace = 0;
            while(row < N & col < N){
                trace = trace + matrix[row][col];
                row += 1;
                col += 1;
            }
            //Calculate the Non repeated rows
            int nonRepRows = 0;
            for(row = 0; row < N; row++){
                Set<Integer> rowEles = new HashSet<>();
                boolean itsNonRepRow = false;
                for(col = 0; col < N; col++){
                    if(rowEles.contains(matrix[row][col])){
                        itsNonRepRow = true;
                        break;
                    }
                    else rowEles.add(new Integer(matrix[row][col]));
                }
                if(itsNonRepRow) nonRepRows += 1;
            }
            //Calculate the Non repeated columns
            int nonRepColumns = 0;
            for(col = 0; col < N; col++){
                Set<Integer> colEles = new HashSet<>();
                boolean itsNonRepCol = false;
                for(row = 0; row < N; row++){
                    if(colEles.contains(matrix[row][col])){
                        itsNonRepCol = true;
                        break;
                    }
                    else colEles.add(new Integer(matrix[row][col]));
                }
                if(itsNonRepCol) nonRepColumns += 1;
            }
            //Form the output
            if(result == null) result = "Case #" + test + ": " + trace +" "+ nonRepRows + " " + nonRepColumns;
            else{
                result = result + "\n";
                result = result + "Case #" + test + ": " + trace +" "+ nonRepRows + " " + nonRepColumns;
            }
        }
        sc.close();
        System.out.println(result);
    }
}