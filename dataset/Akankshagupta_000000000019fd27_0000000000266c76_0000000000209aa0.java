import java.util.Scanner;
import java.util.HashMap;
import java.lang.StringBuilder;
public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int cases = Integer.parseInt( in .nextLine());

        for (int noOfCases = 0; noOfCases < cases; noOfCases++) {
            String[] input = in .nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            int[][] squareArray = new int[n][n];
            if (k < n) {
                System.out.print("Case #" + (noOfCases + 1) + ":  IMPOSSIBLE");
                continue;
            }
            int divider = k / n;
            int mod = k % n;

            for (int diagonal = n - 1; diagonal >= 0; diagonal--) {
                squareArray[diagonal][diagonal] = divider;
                if (mod > 0) {
                    squareArray[diagonal][diagonal] += 1;
                    mod--;
                }
            }

            fillValues(squareArray, n);

            boolean checkifDuplicate = checkDuplicate(squareArray, n);

            if (checkifDuplicate){
                System.out.println("Case #" + (noOfCases + 1) + ": IMPOSSIBLE");
              continue;
            }
            else 
            System.out.println("Case #" + (noOfCases + 1) + ": POSSIBLE");

        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                System.out.print(squareArray[row][column] + " ");
            }
            System.out.println();
        }
        }
    }

  public static boolean checkDuplicate(int[][] squareArray, int size) {
    for (int row = 0; row < size; row++) {
        HashMap < Integer, Integer > hm = new HashMap < Integer, Integer > ();
        for (int column = 0; column < size; column++) {
          if (hm.get(squareArray[row][column]) != null)
                return true;
          else hm.put(squareArray[row][column], 1);
        }
    
    }
     for (int column = 0; column < size; column++) {
        HashMap < Integer, Integer > hm = new HashMap < Integer, Integer > ();
        for (int row = 0; row < size; row++) {
          if (hm.get(squareArray[row][column]) != null)
                return true;
          else hm.put(squareArray[row][column], 1);
        }
     }
     return false;
  }


  public static void fillValues(int[][] squareArray, int n){

            
            for (int row = 0; row < n; row++) {
            int diagonalValue = squareArray[row][row];
                if (true) {
                     int temp =1;
                 for (int column = row +1 ; column < n; column++) {
                    if(temp == diagonalValue) temp =temp+1;
                    squareArray[row][column] = temp;
                    temp +=1;
                 }
                 for (int column = 0 ; column < row; column++) {
                    if(temp == diagonalValue) temp =temp+1;
                    squareArray[row][column] = temp;
                    temp +=1;
                 }
              }
            }



                    

  }
}