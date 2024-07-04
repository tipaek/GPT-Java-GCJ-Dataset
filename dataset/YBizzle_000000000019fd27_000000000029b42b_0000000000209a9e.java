import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String[] input = inputLine.split(" ");
        
        int numTests = Integer.parseInt(input[0]);
        int numBits = Integer.parseInt(input[1]);
        
        for (int i = 0; i < numTests; i++) {
            
            boolean correct = false;
            int numTry = 0;
            
            while (!correct) {
                
                char[] chunk = new char[10];
                for (int j = 0; j < 10; j++) {
                    System.out.println(j + 1);
                    char bit = scanner.nextLine().charAt(0);
                    chunk[j] = bit;
                }
                System.out.println(new String(chunk));
                
                char answer = scanner.nextLine().charAt(0);
                if (answer == 'Y') {
                     correct = true;
                }
                numTry++;
                if (numTry > 2) {
                    System.exit(0);
                }
                correct = true;
            }
        }
        scanner.close();
    }

}