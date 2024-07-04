import java.util.Scanner;

public class Solution {
    
    public static String nesting(char[] arr) {
        StringBuilder ans = new StringBuilder();
        int prev = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i] - '0';
            
            if (i == 0) {
                for (int j = 0; j < val; j++) {
                    ans.append('(');
                }
            } else {
                int diff = val - prev;
                if (diff > 0) {
                    for (int j = 0; j < diff; j++) {
                        ans.append('(');
                    }
                } else {
                    for (int j = 0; j < -diff; j++) {
                        ans.append(')');
                    }
                }
            }
            
            ans.append(arr[i]);
            prev = val;
        }
        
        for (int j = 0; j < prev; j++) {
            ans.append(')');
        }
        
        return ans.toString();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int s = 1; s <= t; s++) {
            String input = sc.next();
            char[] arr = input.toCharArray();
            String ans = nesting(arr);
            System.out.println("Case #" + s + ": " + ans);
        }
        
        sc.close();
    }
}