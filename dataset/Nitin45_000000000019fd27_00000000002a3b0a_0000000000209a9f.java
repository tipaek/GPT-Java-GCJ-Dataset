import java.util.*;
import java.io.*;

class Solution{
  public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      
      char[] input;
      int close=0;
      StringBuilder sb ;
      int i,j,k,l,x,y;
      char last;
      for( i = 1 ; i <= test ; i++){
        input = br.readLine().toCharArray();
        sb = new StringBuilder("");

        if(input[0] == '1'){
         sb.append("(1");
           close=1;
           }
          else if(input[0] == '2')
           {
         sb.append("((2");
           close=2;
           }
         else   if(input[0] == '3'){
   
         sb.append("(((3");
           close=3;
           }
         else   if(input[0] == '4'){
           
         sb.append("((((4");
           close=4;
           }
        else    if(input[0] == '5'){
              
         sb.append("(((((5");
           close=5;
           }
         else   if(input[0] == '6')
            {
              close=6;
           
         sb.append("((((((6");
           }
        else   if(input[0] == '7'){
             
           
         sb.append("(((((((7");
           close=7;
           }
        else   if(input[0] == '8'){
             
           
         sb.append("((((((((8");
           close=8;
           }
          else if(input[0] == '9'){
             
           
         sb.append("(((((((((9");
          close=9;
           } 
           
       else if(input[0]=='0'){
         
         sb.append('0');
         close=0;
           }
           
           for(j = 1 ; j < input.length ; j++){
             x=input[j]-'0';
             y=close-x;
             if(y==0){
               sb.append(x);
               close=x;
               
             }
             else if(y<0){
               for(k=y;k<0;k++)
               sb.append("(");
                 sb.append(x);
                 close=x;
             }
             else if(y>0){
                for(k=0;k<y;k++)
               sb.append(")");
                 sb.append(x);
                 close=x;
             }
           }
           x=input[input.length-1]-'0';
            for(k=0;k<x;k++)
               sb.append(")");
               System.out.println("Case #"+(i)+": "+sb);
                 
           
         }
       } 
    }