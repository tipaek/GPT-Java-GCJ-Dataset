import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfTests = sc.nextInt();
        sc.nextLine(); // Consume the newline character left after nextInt()
        
        for (int t = 1; t <= noOfTests; t++) {
            String str = sc.nextLine();
            StringBuilder finalStr = new StringBuilder();
            int currentDepth = 0;
            
            for (char c : str.toCharArray()) {
                int num = Character.getNumericValue(c);
                
                while (currentDepth < num) {
                    finalStr.append("(");
                    currentDepth++;
                }
                
                while (currentDepth > num) {
                    finalStr.append(")");
                    currentDepth--;
                }
                
                finalStr.append(c);
            }
            
            while (currentDepth > 0) {
                finalStr.append(")");
                currentDepth--;
            }
            
            System.out.println("Case #" + t + ": " + finalStr.toString());
        }
        
        sc.close();
    }
}