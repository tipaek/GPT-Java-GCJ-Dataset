import java.io.InputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        for( int i =1; i <= testCases; i++ ) {
            String str = sc.nextLine();
            Stack<String> stack = new Stack<>();
            int last =0;
            for( int j =0; j < str.length(); j++){
                int num = str.charAt(j) - '0';
                if( num == 0 ){
                    if( last == 1 ) {
                        stack.push(")");
                        stack.push(num+"");
                        last = 0;
                    }else {
                        last = 0;
                        stack.push(num+"");
                    }
                }else {
                    if( last == num) {
                        stack.push(num+"");
                        last = num;
                    }else{
                        stack.push("(");
                        stack.push(num+"");
                        last = num;
                    }
                }
            }
            if ( last == 1 ){
                stack.push(")");
            }

            StringBuilder stringBuilder = new StringBuilder();
            while (!stack.isEmpty()) {
                stringBuilder.append(stack.pop());
            }
            System.out.println("Case #" + i + ": "+ stringBuilder.reverse().toString());
        }
    }
}