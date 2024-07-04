import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        int caseNo=0;

        while (testCase-- > 0) {
            String string = br.readLine();
            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            sb.append("Case #"+ ++caseNo +": ");

            int close=0;
            int first = Character.getNumericValue(string.charAt(0));
            close = close+first;
            while(first-->0){
                sb.append("(");
                stack.push(')');
            }
            sb.append(string.charAt(0));

            for(int i=1; i<string.length(); i++){
                int before = Character.getNumericValue(string.charAt(i - 1));
                int curr = Character.getNumericValue(string.charAt(i));
                int diff = curr-before;
                if(diff < 0 && !stack.isEmpty()){
                    int pos = Math.abs(diff);
                    while (pos-->0)
                    sb.append(stack.pop());
                }
                if(diff ==0){
                    sb.append(string.charAt(i));
                    continue;
                }
                close = close+diff;
                while(diff-->0){
                    sb.append("(");
                    stack.push(')');
                }

                sb.append(Character.getNumericValue(string.charAt(i)));
            }

            while (close-->0){
                sb.append(')');
            }
            System.out.println(sb);
        }

    }

}
