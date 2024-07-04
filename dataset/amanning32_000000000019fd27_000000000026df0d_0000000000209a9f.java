import java.util.Scanner;

class Solution {
    private static String calculate(String line) {
        int last = 0;
        String result = "";
        
        for (int i = 0; i < line.length(); i++) {
            int diff = (line.charAt(i) - '0') - last;
            if (diff > 0) {
                for (int j = 0; j < diff; j++) {
                    result += "(";
                }
            } else if (diff < 0) {
                for (int j = 0; j > diff; j--) {
                    result += ")";
                }
            }
            result += line.charAt(i);
            
            last = line.charAt(i) - '0';
        }
        
        // at end add last right parens
        
        for (int i = 0; i < last; i++) {
            result += ")";
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTests = scan.nextInt();
        scan.nextLine(); // consume \n
        
        for (int i = 1; i <= numTests; i++) {
            String line = scan.nextLine();
            
            String result = calculate(line);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}