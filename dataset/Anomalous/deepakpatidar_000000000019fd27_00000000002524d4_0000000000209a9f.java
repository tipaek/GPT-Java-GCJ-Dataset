import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            StringBuilder ans = new StringBuilder();
            String str = sc.next();
            char[] ch = str.toCharArray();
            boolean isOpen = false;
            
            for (char c : ch) {
                if (!isOpen) {
                    if (c == '0') {
                        ans.append('0');
                    } else {
                        ans.append("(1");
                        isOpen = true;
                    }
                } else {
                    if (c == '0') {
                        ans.append(")0");
                        isOpen = false;
                    } else {
                        ans.append('1');
                    }
                }
            }
            
            if (isOpen) {
                ans.append(')');
            }
            
            System.out.println(ans.toString());
        }
        
        sc.close();
    }
}