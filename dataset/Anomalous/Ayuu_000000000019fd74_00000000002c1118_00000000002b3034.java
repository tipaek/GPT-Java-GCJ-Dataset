import java.util.Scanner;
import java.util.regex.Pattern;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int k = 1; k <= t; k++) {
            int n = sc.nextInt();
            String result = "";
            
            for (int i = 0; i < n / 2; i++) {
                String str1 = sc.next().replace('*', '.');
                String str2 = sc.next().replace('*', '.');
                
                if (Pattern.matches(str1, str2)) {
                    result = str2;
                }
            }
            
            if (result.isEmpty()) {
                System.out.println("Case #" + k + ": *");
            } else {
                System.out.println("Case #" + k + ": " + result.substring(1));
            }
        }
        
        sc.close();
    }
}