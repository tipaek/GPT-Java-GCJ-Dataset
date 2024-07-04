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
             if(i==0){
                 for(int p=0; p < Integer. parseInt(vector [i]); p++){
                    parenthesis=parenthesis+"(";
                    }
                 
    
             }
              parenthesis=parenthesis+vector [i];
             if( Integer. parseInt(vector [i])> Integer. parseInt(vector [i+1])){
                  for(int p=0; p < Integer. parseInt(vector [i])-Integer. parseInt(vector [i+1]); p++){
                    parenthesis=parenthesis+")";
                    }
             }else if(Integer. parseInt(vector [i])<Integer. parseInt(vector [i+1])){
                 
                 for(int p=0; p < Integer. parseInt(vector [i+1])-Integer. parseInt(vector [i]); p++){
                    parenthesis=parenthesis+"(";
                    }
             }
              }else{
                  
                  if(S.length()==1){
                      for(int p=0; p < Integer. parseInt(vector [i]); p++){
                    parenthesis=parenthesis+"(";
                    }
                   }
                  parenthesis=parenthesis+vector [i];
                  if(Integer. parseInt(vector [i])!=0){
                       for(int p=0; p < Integer.parseInt(vector [i]); p++){
                    parenthesis=parenthesis+")";
                  }
                 
              }
              }
                
             
                
              
              
              

          }
          
      
          
           
           
            System.out.println("Case #"+t+": "+ parenthesis);
       }
       
       
     
         
       
        scan.close();
       }
  
        
    }