import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(b.readLine().trim());
        for(int i=0;i<tc;i++) {
            Solution bp = new Solution();
            System.out.println("Case #"+(i+1)+": "+bp.balance(b.readLine().trim()));
        }
    }

    public String balance(String input){
        int open = 0;
        StringBuilder result = new StringBuilder();
        for(int i=0;i<input.length();i++){
            int no = input.charAt(i) - '0';
            if(open < no){
                while(open < no) {
                    result.append('(');
                    open++;
                }
            }
            else if(open > no){
                while(open > no) {
                    result.append(')');
                    open--;
                }
            }
            result.append(no);
        }
        while (open != 0){
            result.append(')');
            open--;
        }
        return result.toString();
    }
}
