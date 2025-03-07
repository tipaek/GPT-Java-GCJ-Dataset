import java.util.Random;
import java.util.Scanner;
import java.io.StringWriter;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        
        for (int currentTest = 0; currentTest < testCases; currentTest++) {
            Random random = new Random();
            
            for (int i = 0; i < 300; i++) {
                int x = -5 + random.nextInt(10);
                int y = -5 + random.nextInt(10);
                
                StringWriter writer = new StringWriter();
                writer.write(x + " " + y);
                System.out.println(writer.toString());
                writer.flush();
                
                String response = scanner.nextLine();
                if ("CENTER".equals(response) || "WRONG".equals(response)) {
                    break;
                }
            }
        }
    }
}