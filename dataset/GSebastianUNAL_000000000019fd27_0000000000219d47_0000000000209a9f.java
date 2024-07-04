import java.util.Scanner;


public class Solution {

  
    public static void main(String[] args) {

       Scanner scan= new Scanner(System.in);
       int T =scan.nextInt();
       scan.nextLine();
      
        
       for(int t=1; t<=T; t++){
           
           String S=scan.nextLine();
           
           
           String vector []  =new String [S.length()];
          
           for(int i=0; i<S.length(); i++){
               vector [i]=String.valueOf(S.charAt(i));
           }
           
          String parenthesis="";
           
          for(int i=0; i<S.length(); i++){
          
              if(i+1!=S.length()){
                  
                  int count=0;  
                  for(int j=i; j<S.length(); j++){
                      
                      if(vector [i].equals( vector [j])){
                          count++;
                           
                      } else{
                          break;
                      }
                       
                  }
                  
                  for(int p=0; p < Integer. parseInt(vector [i]); p++){
                    parenthesis=parenthesis+"(";
                    }
                  
                  for(int p=0; p < count; p++){
                   parenthesis=parenthesis+vector [i];
                   
                    }
                  
                  for(int p=0; p < Integer.parseInt(vector [i]); p++){
                    parenthesis=parenthesis+")";
              }
                 i=i+count-1;
          
              }else{
                  for(int p=0; p < Integer. parseInt(vector [i]); p++){
                    parenthesis=parenthesis+"(";
              }
              parenthesis=parenthesis+vector [i];
                for(int p=0; p < Integer.parseInt(vector [i]); p++){
                    parenthesis=parenthesis+")";
              }
              }
          }
          
      
          
           
           
            System.out.println("Case #"+t+": "+ parenthesis);
       }
       
       
     
         
       
        scan.close();
       }
  
        
    }