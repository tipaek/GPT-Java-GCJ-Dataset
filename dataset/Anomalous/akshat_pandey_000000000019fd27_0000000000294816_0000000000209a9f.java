import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        String[] str = new String[T];
        
        for (int t = 0; t < T; t++) {
            str[t] = scanner.nextLine();
        }
        
        for (int t = 0; t < T; t++) {
            String S = str[t];
            StringBuilder p = new StringBuilder();
            int num = 0, braces = 0;
            
            for (int i = 0; i < S.length(); i++) {
                num = S.charAt(i) - '0';
                int temp = num - braces;
                
                while (temp != 0) {
                    if (temp > 0) {
                        p.append("(");
                        temp--;
                    } else if (temp < 0) {
                        p.append(")");
                        temp++;
                    }
                }
                
                p.append(S.charAt(i));
                braces = num;
            }
            
            while (braces > 0) {
                p.append(")");
                braces--;
            }
            
            System.out.println("Case #" + (t + 1) + ": " + p.toString());
        }
        
        scanner.close();
    }
}