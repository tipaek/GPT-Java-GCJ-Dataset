import java.util.Scanner;

class Solution {
    private static String calculate(int[][] arr) {
        String result = "";
        
        boolean[] C = new boolean[24 * 60];
        boolean[] J = new boolean[24 * 60];
        
        for (int[] task : arr) {
            boolean canC = true;
            boolean canJ = true;
            
            for (int i = task[0]; i < task[1]; i++) {
                if (C[i] == true) canC = false;
                if (J[i] == true) canJ = false;
            }
            
            if (canC) {
                for (int i = task[0]; i < task[1]; i++) {
                    C[i] = true;
                }
                result += "C";
            } else if (canJ) {
                for (int i = task[0]; i < task[1]; i++) {
                    J[i] = true;
                }
                result += "J";
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTests = scan.nextInt();
        
        for (int i = 1; i <= numTests; i++) {
            int numActivities = scan.nextInt();
            
            int[][] array = new int[numActivities][2];
            for (int j = 0; j < numActivities; j++) {
                for (int k = 0; k < 2; k++) {
                    array[j][k] = scan.nextInt();
                }
            }
            
            String result = calculate(array);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}