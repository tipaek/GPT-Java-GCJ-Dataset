import java.util.*;
import java.io.*;

class Solution{
  public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int test = Integer.parseInt(br.readLine());
      Set<Integer> s=new HashSet<Integer>();
      char[] input;
      StringBuilder sb ;
      int i,j,k,l,no,x,y;
      char last;
      for( i = 1 ; i <= test ; i++){
        input = br.readLine().toCharArray();
        sb = new StringBuilder("");

        if(input[0] == '1'){
         sb.append("(1");
           s.add(1);
           }
          else if(input[0] == '2')
           {
         sb.append("((2");
           s.add(2);
           }
         else   if(input[0] == '3'){
   
         sb.append("(((3");
           s.add(3);
           }
         else   if(input[0] == '4'){
           
         sb.append("((((4");
           s.add(4);
           }
        else    if(input[0] == '5'){
              
         sb.append("(((((5");
           s.add(5);
           }
         else   if(input[0] == '6')
            {
              s.add(6);
           
         sb.append("((((((6");
           }
        else   if(input[0] == '7'){
             
           
         sb.append("(((((((7");
           s.add(7);
           }
        else   if(input[0] == '8'){
             
           
         sb.append("((((((((8");
           s.add(8);
           }
          else if(input[0] == '9'){
             
           
         sb.append("(((((((((9");
          s.add(9);
           } 
           
       else if(input[0]=='0'){
         
         sb.append('0');
         s.add(1);
           }

         for(j = 1 ; j < input.length ; j++){
             l=sb.length();
            
             x=sb.charAt(l-1)-'0';
             y=input[j]-'0';
            if(x==y){
              sb.append(y);
              s.add(y);}
              
              else if(x>y){
                  no=x-y;
                  for(k=0;k<no;k++)
                  sb.append(")");
                  sb.append(y);
                  s.add(y);
                }
                else if(x<y){
                  int no2=Collections.max(s);
                  if(no2>y){
                    no2=no2-y;
                    for(k=0;k<no2;k++)
                    sb.append("(");
                      sb.append(y);
                      s.add(y);
                    
                    
                  }
                  else if(no2<=y)
                  {
                    for( k=0;k<x;k++)
                  sb.append(")");
                  for( k=0;k<y;k++)
                  sb.append("(");
                    sb.append(y);
                    s.add(y);
                  }
                  
                  
                }
              }
              l=sb.length();
              x=sb.charAt(l-1)-'0';
              for(k=0;k<x;k++)
              sb.append(")");
           System.out.println("Case #"+(i)+": "+sb);
         System.out.println(s+""+Collections.max(s));
      }
  }
}