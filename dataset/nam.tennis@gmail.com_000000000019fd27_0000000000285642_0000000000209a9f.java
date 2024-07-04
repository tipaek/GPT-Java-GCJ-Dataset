    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // num of tests
        in.nextLine(); //go to next line as test data is not in the current line, it only has the test number and we already read that.
        for (int i = 1; i <= t; ++i) {
          String s = in.nextLine(); //read S
          int openBraceCount = 0;
          String s1 = "";
          Stack<Character> stack = new Stack<Character>();
          
        for (char c: s.toCharArray()) {
            int d = Integer.parseInt(String.valueOf(c));
            
            //balance open braces if there's not enough
            if(d>openBraceCount){
                int diff = d-openBraceCount;
                for(int j=0;j<diff;j++){
                    stack.push('(');
                    openBraceCount++;
                }
            }
            
            //balanced close braces if there's not enough
            if(d<openBraceCount){
                int diff = openBraceCount-d;
                for(int j=0;j<diff;j++){
                    stack.push(')');
                    openBraceCount--;
                }
            }
            
            if(d==openBraceCount){
                stack.push(c);
            }
        }
        
        if(openBraceCount>0){
            for(int j=0;j<openBraceCount;j++){
                    stack.push(')');
            }
        }
        
        while(!stack.isEmpty()){
            s1 += stack.pop();
        }
        
        String s2 = new StringBuilder(s1).reverse().toString();
            
        System.out.println("Case #" + i + ": "+ s2);
        }
      }
      
      
    }
