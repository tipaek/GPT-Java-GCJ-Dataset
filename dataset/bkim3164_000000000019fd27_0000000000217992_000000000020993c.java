import java.util.*;
import java.io.*;

class Solution{
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.print("Case #" + (i+1) + ": ");
            solve(in);
            System.out.println();
        }
        in.close();

    }
    static void solve(Scanner in){
        int number = in.nextInt();
        int rowrepeat = 0;
        int columnrepeat = 0;
        int diagonal = 0;
        int[] array = new int[number];
        int[] diagonalA = new int[number];
        int[][] matrix = new int[number][number];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                matrix[i][j] = in.nextInt();
                array[j] = matrix[i][j];
                diagonalA[i] = matrix[i][i];
            
            }
            Arrays.sort(array);
            f1: for (int j = 0; j < array.length-1; j++) {
                if(array[j] == array[j+1]){
                    rowrepeat += 1;
                    break f1;
                }
            }
            f2: for (int r = 0; r < number; r++) {
                if(set.contains(matrix[r][i])){
                    columnrepeat++;
                    break f2;
                }
                else{
                set.add(matrix[r][i]);
                }
            }
            set.clear();
            

        }
        for (int i = 0; i < number; i++) {
            diagonal += diagonalA[i];
        }
        System.out.println(diagonal + " " + rowrepeat + " " + columnrepeat);

    }

}
