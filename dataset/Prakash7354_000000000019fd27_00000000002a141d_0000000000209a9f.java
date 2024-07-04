import java.util.*;
import java.io.*;

class Solution{
  public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      char[] input;
      StringBuilder sb ;
      int i , j;
      char last;
      
      for( i = 1 ; i <= test ; i++){
      	
        input = br.readLine().toCharArray();
        sb = new StringBuilder("");

        if(input[0] == '1')
         sb.append("(1");
         else if(input[0] == '2')
         sb.append("((2");
         else if(input[0] == '3')
         sb.append("(((3");
     else if(input[0] == '4')
         sb.append("((((4");
     else if(input[0] == '5')
         sb.append("(((((5"); 
      else if(input[0] == '6')
         sb.append("((((((6"); 
     else if(input[0] == '7')
         sb.append("(((((((7");
         else if(input[0] == '8')
         sb.append("((((((((8"); 
    else if(input[0] == '9')
         sb.append("(((((((((9");
    else if(input[0]=='0')
         sb.append("0");
     
     else
     	sb.append("");

         for(j = 1 ; j < input.length ; j++){
           if(input[j] == '1' && input[j - 1] == '1')
             sb.append("1");
           else if(input[j] == '1' && input[j - 1] == '0')
             sb.append("(1");
          else if(input[j] == '0' && input[j - 1] == '1')
             sb.append(")0");
          else if(input[j] == '0' && input[j - 1] == '0')
             sb.append("0");

         else if(input[j] == '0' && input[j - 1] == 0)
             sb.append("0");
          else if(input[j] == 0 && input[j - 1] == '0')
             sb.append("");
          if(input[j] == '2' && input[j - 1] == '2')
             sb.append('2');
           else if(input[j] == '0' && input[j - 1] == '2')
             sb.append("))0");
          else if(input[j] == '2' && input[j - 1] == '1')
             sb.append(")((2");
         else if(input[j] == '2' && input[j - 1] == '0')
             sb.append("((2");
          else if(input[j] == '1' && input[j - 1] == '2')
             sb.append("))(1");

           else if(input[j] == '3' && input[j - 1] == '3')
             sb.append('3');
            else if(input[j] == '0' && input[j - 1] == '3')
             sb.append(")))0");
           else if(input[j] == '3' && input[j - 1] == '1')
             sb.append(")(((3");
         else if(input[j] == '3' && input[j - 1] == '0')
             sb.append("(((3");
          else if(input[j] == '1' && input[j - 1] == '3')
             sb.append(")))(1");
           else if(input[j] == '2' && input[j - 1] == '3')
             sb.append(")))((2");
          else if(input[j] == '3' && input[j - 1] == '2')
             sb.append("))(((3");

          else if(input[j] == '4' && input[j - 1] == '4')
             sb.append('4');
          else if(input[j] == '0' && input[j - 1] == '4')
             sb.append("))))0");
          else if(input[j] == '4' && input[j - 1] == '0')
             sb.append("((((4");
          else if(input[j] == '4' && input[j - 1] == '1')
             sb.append(")((((4");
         else if(input[j] == '1' && input[j - 1] == '4')
             sb.append("))))(1");
          else if(input[j] == '2' && input[j - 1] == '4')
             sb.append("))))((2");
          else if(input[j] == '4' && input[j - 1] == '2')
             sb.append("))((((4");
          else if(input[j] == '3' && input[j - 1] == '4')
             sb.append("))))(((3");
          else if(input[j] == '4' && input[j - 1] == '3')
             sb.append(")))((((4");

           else if(input[j] == '5' && input[j - 1] == '5')
             sb.append('5');
          else if(input[j] == '0' && input[j - 1] == '5')
             sb.append(")))))0");
          else if(input[j] == '5' && input[j - 1] == '0')
             sb.append("(((((5");
          else if(input[j] == '5' && input[j - 1] == '1')
             sb.append(")(((((5");
         else if(input[j] == '1' && input[j - 1] == '5')
             sb.append(")))))(1");
          else if(input[j] == '2' && input[j - 1] == '5')
             sb.append(")))))((2");
          else if(input[j] == '5' && input[j - 1] == '2')
             sb.append("))(((((5");
          else if(input[j] == '3' && input[j - 1] == '5')
             sb.append(")))))(((3");
          else if(input[j] == '5' && input[j - 1] == '3')
             sb.append(")))(((((5");
         else if(input[j] == '4' && input[j - 1] == '5')
             sb.append(")))))((((4");
          else if(input[j] == '5' && input[j - 1] == '4')
             sb.append("))))(((((5");
            
             else if(input[j] == '6' && input[j - 1] == '6')
             sb.append('6');
          else if(input[j] == '0' && input[j - 1] == '6')
             sb.append("))))))0");
          else if(input[j] == '6' && input[j - 1] == '0')
             sb.append("((((((6");
          else if(input[j] == '6' && input[j - 1] == '1')
             sb.append(")((((((6");
         else if(input[j] == '1' && input[j - 1] == '6')
             sb.append("))))))(1");
          else if(input[j] == '2' && input[j - 1] == '6')
             sb.append("))))))((2");
          else if(input[j] == '6' && input[j - 1] == '2')
             sb.append("))((((((6");
          else if(input[j] == '3' && input[j - 1] == '6')
             sb.append("))))))(((3");
          else if(input[j] == '6' && input[j - 1] == '3')
             sb.append(")))((((((6");
          else if(input[j] == '4' && input[j - 1] == '6')
             sb.append("))))))((((4");
          else if(input[j] == '6' && input[j - 1] == '4')
             sb.append("))))((((((6");
          else if(input[j] == '6' && input[j - 1] == '5')
             sb.append(")))))((((((6");
          else if(input[j] == '5' && input[j - 1] == '6')
             sb.append("))))))(((((5");

          else if(input[j] == '7' && input[j - 1] == '7')
             sb.append('7');
          else if(input[j] == '0' && input[j - 1] == '7')
             sb.append(")))))))0");
          else if(input[j] == '7' && input[j - 1] == '0')
             sb.append("(((((((7");
          else if(input[j] == '7' && input[j - 1] == '1')
             sb.append(")(((((((7");
         else if(input[j] == '1' && input[j - 1] == '7')
             sb.append(")))))))(1");
          else if(input[j] == '2' && input[j - 1] == '7')
             sb.append(")))))))((2");
          else if(input[j] == '7' && input[j - 1] == '2')
             sb.append("))(((((((7");
         else if(input[j] == '3' && input[j - 1] == '7')
             sb.append(")))))))(((3");
          else if(input[j] == '7' && input[j - 1] == '3')
             sb.append(")))(((((((7");
          else if(input[j] == '4' && input[j - 1] == '7')
             sb.append(")))))))((((4");
          else if(input[j] == '7' && input[j - 1] == '4')
             sb.append("))))(((((((7");
          else if(input[j] == '7' && input[j - 1] == '5')
             sb.append(")))))(((((((7");
          else if(input[j] == '5' && input[j - 1] == '7')
             sb.append(")))))))(((((5");
          else if(input[j] == '7' && input[j - 1] == '6')
             sb.append("))))))(((((((7");
          else if(input[j] == '6' && input[j - 1] == '7')
             sb.append(")))))))((((((6");

          else if(input[j] == '8' && input[j - 1] == '8')
             sb.append('7');
          else if(input[j] == '0' && input[j - 1] == '8')
             sb.append("))))))))0");
          else if(input[j] == '8' && input[j - 1] == '0')
             sb.append("((((((((8");
          else if(input[j] == '8' && input[j - 1] == '1')
             sb.append(")((((((((8");
         else if(input[j] == '1' && input[j - 1] == '8')
             sb.append(")))))))(1");
          else if(input[j] == '2' && input[j - 1] == '8')
             sb.append(")))))))((2");
          else if(input[j] == '8' && input[j - 1] == '2')
             sb.append("))((((((((8");
          else if(input[j] == '3' && input[j - 1] == '8')
             sb.append("))))))))(((3");
          else if(input[j] == '8' && input[j - 1] == '3')
             sb.append(")))((((((((8");
          else if(input[j] == '4' && input[j - 1] == '8')
             sb.append("))))))))((((4");
          else if(input[j] == '8' && input[j - 1] == '4')
             sb.append("))))((((((((8");
          else if(input[j] == '8' && input[j - 1] == '5')
             sb.append(")))))((((((((8");
          else if(input[j] == '5' && input[j - 1] == '8')
             sb.append(")))))))(((((5");
          else if(input[j] == '8' && input[j - 1] == '6')
             sb.append("))))))((((((((8");
          else if(input[j] == '6' && input[j - 1] == '8')
             sb.append(")))))))((((((6");
          else if(input[j] == '8' && input[j - 1] == '7')
             sb.append(")))))))((((((((8");
          else if(input[j] == '7' && input[j - 1] == '8')
             sb.append("))))))))(((((((7");

          else if(input[j] == '9' && input[j - 1] == '9')
             sb.append('9');
          else if(input[j] == '0' && input[j - 1] == '9')
             sb.append(")))))))))0");
          else if(input[j] == '9' && input[j - 1] == '0')
             sb.append("(((((((((9");   
             else if(input[j] == '9' && input[j - 1] == '1')
             sb.append(")(((((((((9");
         else if(input[j] == '1' && input[j - 1] == '9')
             sb.append(")))))))))(1");  
              else if(input[j] == '2' && input[j - 1] == '9')
             sb.append(")))))))))((2");
          else if(input[j] == '9' && input[j - 1] == '2')
             sb.append("))(((((((((9");  
             else if(input[j] == '3' && input[j - 1] == '9')
             sb.append(")))))))))(((3");
          else if(input[j] == '9' && input[j - 1] == '3')
             sb.append(")))(((((((((9");  
          else if(input[j] == '4' && input[j - 1] == '9')
             sb.append(")))))))))((((4");
          else if(input[j] == '9' && input[j - 1] == '4')
             sb.append("))))(((((((((9");
         else if(input[j] == '9' && input[j - 1] == '5')
             sb.append(")))))(((((((((9");
          else if(input[j] == '5' && input[j - 1] == '9')
             sb.append(")))))))))(((((5");
          else if(input[j] == '9' && input[j - 1] == '6')
             sb.append("))))))(((((((((9");
          else if(input[j] == '6' && input[j - 1] == '9')
             sb.append(")))))))))((((((6");
        else if(input[j] == '9' && input[j - 1] == '7')
             sb.append(")))))))(((((((((9");
          else if(input[j] == '7' && input[j - 1] == '9')
             sb.append(")))))))))(((((((7");
         else if(input[j] == '9' && input[j - 1] == '8')
             sb.append("))))))))(((((((((9");
          else if(input[j] == '8' && input[j - 1] == '9')
             sb.append(")))))))))((((((((8");

         else
     	sb.append("");
         }

         if(input[j - 1] == '1')
           sb.append(")");
         else if(input[j-1]=='2')
         	sb.append("))");
         else if(input[j - 1] == '3')
           sb.append(")))");
       else if(input[j-1]=='4')
         	sb.append("))))");
          else if(input[j - 1] == '5')
           sb.append(")))))");
        else if(input[j - 1] == '6')
           sb.append("))))))");
        else if(input[j - 1] == '7')
           sb.append(")))))))");
        else if(input[j - 1] == '8')
           sb.append("))))))))");
        else if(input[j - 1] == '9')
           sb.append(")))))))))");
       else
     	sb.append("");
       
        
           System.out.println("Case #" + i + ": " + sb);
           
      }
  }
}