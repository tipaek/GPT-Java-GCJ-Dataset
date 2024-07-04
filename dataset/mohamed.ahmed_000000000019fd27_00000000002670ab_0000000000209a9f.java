import java.sql.PreparedStatement;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int tt = scanner.nextInt();
        for(int i = 0; i < tt; i++){
            String s = scanner.next();

            StringBuilder result= new StringBuilder();
            int no_of_parentheses = 0;

            for(int j = 0; j < s.length(); j++){
                int no = Integer.parseInt(String.valueOf(s.charAt(j)));
                if(no_of_parentheses < no) {
                    for (int k = 0; k < (no - no_of_parentheses); k++) {
                        result.append("(");
                    }
                    no_of_parentheses = no;
                }else if(no_of_parentheses > no){
                    for (int k = 0; k < (no_of_parentheses - no); k++) {
                        result.append(")");
                    }
                    no_of_parentheses -= no_of_parentheses - no;
                }
                result.append(no);
            }

            for(int j = 0; j < no_of_parentheses; j++){
                result.append(")");
            }

            System.out.println("Case #" + (i+1) + ": " + result);
        }
    }
}
