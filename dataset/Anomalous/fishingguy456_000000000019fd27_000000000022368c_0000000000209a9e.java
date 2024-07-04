import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int b = sc.nextInt();
        
        for (int j = 0; j < t; j++) {
            StringBuilder s = new StringBuilder();
            
            for (int i = 1; i <= b; i++) {
                System.out.println(i);
                System.out.flush();
                s.append(sc.next());
            }
            
            System.out.println(s.toString());
            System.out.flush();
            
            String s1 = sc.next();
            if (s1.equals("N")) {
                break;
            }
        }
    }
}