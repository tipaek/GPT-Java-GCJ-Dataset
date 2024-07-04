import java.util.*;
import java.io.*; 
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  char[] chars = new char[1];
  
  while(in.hasNext()){
      String string = in.next();
       chars =string.toCharArray(); 
      break;
  }
  
 
  
  while(in.hasNext()){
      int opened = 0;
       String resultString = "";
      int testCase = 1;
       String string = in.next();
       chars =string.toCharArray(); 
  for(int i = 0; i < chars.length; i++){
      int value = Character.getNumericValue(chars[i]);
     // System.out.println(chars[i]);
      if(value != 0){
          if(opened == 0){
              for(int j = 0; j < value; j++){
       //           System.out.println("open "+j);
                  resultString+="(";
                  opened++;
              }
              resultString+=chars[i];
             // resultString += 
          }
          else{
              if(opened > value){
                  for(int j = 0; j <= Math.abs(opened-value); j++){
                      resultString+=")";
                      opened--;
                  }
                   // System.out.println("sum1:"+chars[i]);
                  resultString+=chars[i];
              }
              else if(opened < value){
                  for(int j = 0; j < Math.abs(opened-value); j++){
                      resultString+="(";
                     
                     // opened++;
                  }
                  //System.out.println("sum2:"+chars[i]);
                  resultString+=chars[i];
                  for(int j = 0; j < Math.abs(opened-value); j++){
                      resultString+=")";
                     // opened++;
                  }
              }
              else if(opened == value){
                  //System.out.println("sum3:"+chars[i]);
                  resultString+=value;
              }
          }
          
          
          
          
      }else{
          if(opened > 0){
              for(int k = 0; k< opened; k++){
                  resultString+=")";
                  opened--;
              }
          }
          resultString+=0;
      }
  }
  
  for(int i = 0; i< opened; i++){
      resultString+=")";
  }
  System.out.println("Case #"+testCase+": "+resultString);
  testCase++;
  }
  //System.out.println(resultString);
  //System.out.println(chars);
   //System.out.println(in.nextInt());
  }
  
    
}