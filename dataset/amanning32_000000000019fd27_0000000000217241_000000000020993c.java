import java.util.Scanner;

class Solution {
    private static int[] calculate(int[][] arr) {
        int[] result = new int[3];
        
        // calculate trace
        for (int i = 0; i < arr.length; i++) {
            result[0] += arr[i][i];
        }
        
        // check rows
        for (int i = 0; i < arr.length; i++) {
            int[] check = new int[arr.length];
            
            for (int j = 0; j < arr.length; j++) {
                if (check[arr[i][j] - 1] == 1) {
                    result[1]++;
                    break;
                }
                check[arr[i][j] - 1] = 1;
            }
        }
        
        // check columns
        for (int i = 0; i < arr.length; i++) {
            int[] check = new int[arr.length];
            
            for (int j = 0; j < arr.length; j++) {
                if (check[arr[j][i] - 1] == 1) {
                    result[2]++;
                    break;
                }
                check[arr[j][i] - 1] = 1;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTests = scan.nextInt();
        
        for (int i = 1; i <= numTests; i++) {
            int numLines = scan.nextInt();
            
            int[][] array = new int[numLines][numLines];
            for (int j = 0; j < numLines; j++) {
                for (int k = 0; k < numLines; k++) {
                    array[j][k] = scan.nextInt();
                }
            }
            
            int[] result = calculate(array);
            System.out.println("Case #" + i + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
    }
}