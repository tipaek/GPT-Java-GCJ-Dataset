import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int k = 1; k <= t; ++k) {
            String str = br.readLine();
            int len = str.length();
            int counter = 0;
            List<Character> ans = new ArrayList<>();
            
            for (int i = 0; i < len; ++i) {
                int ele = Character.getNumericValue(str.charAt(i));
                
                if (ele >= counter) {
                    for (int j = 0; j < ele - counter; j++) {
                        ans.add('(');
                    }
                    counter = ele;
                } else {
                    for (int j = 0; j < counter - ele; j++) {
                        ans.add(')');
                    }
                    counter = ele;
                }
                
                ans.add(str.charAt(i));
            }
            
            for (int i = 0; i < counter; ++i) {
                ans.add(')');
            }
            
            System.out.print("Case #" + k + ": ");
            for (char ch : ans) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}