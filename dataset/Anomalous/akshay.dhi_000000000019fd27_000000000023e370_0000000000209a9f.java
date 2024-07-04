import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());
            for (int t = 1; t <= testCases; t++) {
                String s = br.readLine();
                int level = 0;
                StringBuilder result = new StringBuilder("Case #" + t + ": ");
                
                for (int i = 0; i < s.length(); i++) {
                    int currLevel = s.charAt(i) - '0';
                    
                    while (level < currLevel) {
                        result.append("(");
                        level++;
                    }
                    while (level > currLevel) {
                        result.append(")");
                        level--;
                    }
                    result.append(s.charAt(i));
                }
                
                while (level > 0) {
                    result.append(")");
                    level--;
                }
                
                System.out.println(result);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}