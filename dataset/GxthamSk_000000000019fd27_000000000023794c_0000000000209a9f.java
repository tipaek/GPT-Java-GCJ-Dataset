import java.util.*;
import java.io.*;
public class Solution {
       public static String answer(String s){
            StringBuilder sb = new StringBuilder();
            Stack<Character> stackPre = new Stack<>();
            Stack<Integer> stackPost = new Stack<>();
            for(char i: s.toCharArray()){
              stackPre.push(i);
            }

            while(!stackPre.isEmpty()){
              char e = stackPre.pop();
              int number = Integer.parseInt(String.valueOf(e));
              if(number == 0){
                sb.insert(0,number);
                stackPost.push(number);
                continue;
              }
              if(stackPost.isEmpty()){
                stackPost.push(number);
                StringBuilder out = new StringBuilder();
                if(number > 0 && number <= 9){ //check stack
                      out.append(number);
                      for(int i = 0; i < number; i++){
                        out.insert(0, '(');
                        out.append(')');
                  }
                }
                sb.insert(0,out);
              }else{
                int b = stackPost.peek();
                if(b == 0){
                  sb.insert(0, "("+number+")");
                }
                else if(number == b){
                  sb.insert(number, number);
                }else if(number > b)
                {
                  int i = 0;
                  while(!Character.isDigit(sb.charAt(i))){
                    i++;
                  }
                  StringBuilder temp = new StringBuilder();
                  temp.append(number);
                  for(int c = 0; c < number-i; c++){
                    temp.insert(0,'(');
                    temp.append(')');
                  }
                  sb.insert(i, temp);
                  
                }else if(number < b){
                  sb.insert(number, number);
                }

                stackPost.push(number);
              }   

              System.out.println(sb);
            }
            return sb.toString();
         //prepend it
      } 
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

      
        
        for (int i = 1; i <= t; ++i) {
          String n = in.next();
          //int m = in.nextInt();

          String ans = answer(n);
          System.out.println("Case #" + i + ": " + ans);
        }
        
      }
    }