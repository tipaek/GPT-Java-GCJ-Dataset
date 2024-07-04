import java.util.Scanner;

public class Solution {
    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        for (int counter = 0; counter < n; counter++) {
            String input = in.nextLine();
            int currentLevel = 0;
            char[] inputArray = input.toCharArray();
            System.out.print("Case #" + (counter + 1) + ": ");
            
            for(char c: inputArray){
                int value = c - 48;
                while(value > currentLevel){
                    System.out.print("(");
                    currentLevel++;
                }
                while(value < currentLevel){
                    System.out.print(")");
                    currentLevel--;
                }
                System.out.print(c);
            }
            while(currentLevel > 0){
                System.out.print(")");
                currentLevel--;
            }
            System.out.println();
        }
    }
}
