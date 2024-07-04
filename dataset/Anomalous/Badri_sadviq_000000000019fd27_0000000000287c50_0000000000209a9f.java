import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            String str = sc.next();
            int len = str.length();
            char[] ch = str.toCharArray();

            for (int j = 0; j < len; j++) {
                if (ch[j] == '1') {
                    System.out.print("(" + ch[j] + ")");
                } else {
                    System.out.print(ch[j]);
                }
            }
            System.out.println(); // To move to the next line after each string
        }
        
        sc.close();
    }
}