import java.io.*;
import java.util.*;
class Solution{
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        int no = 0;
        while(no < testCase){
            no++;
            String input = scanner.next();
            int depth = 0;
            StringBuilder builder = new StringBuilder();
            for(int i = 0;i < input.length();i++){
                int cur = input.charAt(i)-'0';
                while(depth > cur){
                    builder.append(')');
                    depth--;
                }
                while(depth < cur){
                    builder.append('(');
                    depth++;
                }
                builder.append(input.charAt(i));
            }
            while(depth > 0){
                builder.append(')');
                depth--;
            }
            System.out.println("Case #"+no+": "+ builder.toString());
        }
    }
}