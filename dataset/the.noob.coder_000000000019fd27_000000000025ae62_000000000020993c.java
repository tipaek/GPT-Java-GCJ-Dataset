import java.util.*;

public class Main{
    public static void main() {
        Scanner sc = new Scanner(System.in);
        Solver solver = new Solver();
        
        int testCase = sc.nextInt();
        
        for (int i=0; i< testCase; i++) {
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];
            for (int row=0;row< size; row++) {
                for (int col=0; col< size; col++) {
                    matrix[row][col] = sc.nextInt();
                }
            }
            System.out.println(solver.solve(matrix, size, i));
        }
    }
}

class Solver{
    public String solve(int[][]matrix, int size, int caseNumber) {
        return "Case #"+caseNumber+": "+trace(matrix,size)+" "+row(matrix,size)+" "+column(matrix,size);
    }
    
    int row(int[][]matrix, int size) {
        int count =0;

        for (int rowInd =0; rowInd< size; rowInd++) {
            Set set = new HashSet();
            boolean repeat = false;

            for (int col=0; col< size; col++) {
                Integer intger = new Integer(matrix[rowInd][col]);
                if(set.contains(integer)) {
                    repeat = true;
                    break;
                }
                else {
                    set.add(integer);
                }
            }
            if (repeat) {
                count++;
            }
        }

        return count;        
    }
    
    int column(int[][]matrix, int size) {
        int count =0;

        for (int colInd =0; colInd< size; colInd++) {
            Set set = new HashSet();
            boolean repeat = false;

            for (int row=0; row< size; row++) {
                Integer intger = new Integer(matrix[row][colInd]);
                if(set.contains(integer)) {
                    repeat = true;
                    break;
                }
                else {
                    set.add(integer);
                }
            }
            if (repeat) {
                count++;
            }
        }

        return count;
    }
    
    int trace(int[][]matrix, int size) {
        int sum = 0;
        for(int i=0;i<size;i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
}