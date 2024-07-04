import java.util.HashMap;
import java.util.Scanner;
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 

        int numberOfTestCases = scanner.nextInt();

        for(int i = 1; i <= numberOfTestCases; i++){
            int latinSquareSize = scanner.nextInt();

            int[][] latinSquare = new int[latinSquareSize][latinSquareSize];
            
            for (int row = 0; row < latinSquareSize; row++) {
                for (int column = 0; column < latinSquareSize; column++) {
                    latinSquare[row][column] = scanner.nextInt();
                }
            }

            Solution solution = new Solution();
            System.out.println("Case #" + i + ": " + solution.findTrace(latinSquare) + " " + solution.findRowDuplicate(latinSquare) + " " + solution.findColDuplicate(latinSquare));
        }

    }

    public int findTrace(int[][] latinSquare){
        int trace = 0;
        for(int i = 0; i < latinSquare.length; i++){
            // System.out.println(latinSquare[i][i]);
            trace += latinSquare[i][i];
        }

        return trace;
    }

    public int findRowDuplicate(int[][] latinSquare){
        int duplicates = 0;


        for (int row = 0; row < latinSquare.length; row++) {
            HashMap<Integer, Integer> hash = new HashMap<>();

            for (int col = 0; col < latinSquare[row].length; col++){
                if(hash.containsKey(latinSquare[row][col])){
                    duplicates++;
                    break;
                }
                hash.put(latinSquare[row][col], latinSquare[row][col]);
            }
        }


        return duplicates;
    }

    public int findColDuplicate(int[][] latinSquare){
        int duplicates = 0;

        for (int row = 0; row < latinSquare[0].length; row++) {
            HashMap<Integer, Integer> hash = new HashMap<>();

            for (int col = 0; col < latinSquare.length; col++){
                if(hash.containsKey(latinSquare[col][row])){
                    duplicates++;
                    break;
                }
                hash.put(latinSquare[col][row], latinSquare[col][row]);
            }
        }


        return duplicates;
    }


}