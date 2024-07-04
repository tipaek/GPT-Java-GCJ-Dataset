import java.util.Scanner;
import java.util.HashMap;
import java.lang.StringBuilder;
public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int cases = Integer.parseInt( in .nextLine());
        String input = null;
         StringBuilder output = new StringBuilder("*");

        for (int noOfCases = 0; noOfCases < cases; noOfCases++) {
            StringBuilder startPattern = null;
            StringBuilder endPattern = null;
            output = null;
            int patterns = Integer.parseInt( in.nextLine());
             for (int noOfPatterns = 0; noOfPatterns < patterns; noOfPatterns++){
                input = String.valueOf(in .nextLine());
                if(output== null || !output.toString().equals("*")){
                if(input.startsWith("*")){
                    String subString = input.substring(1, input.length());
                
                    if(endPattern == null){
                      endPattern= new StringBuilder(subString);
                      if(startPattern!= null) output = new StringBuilder(startPattern).append( endPattern);
                      else output = endPattern;
                    }
                    else if( subString.length() > endPattern.length()){
                        int diff = subString.length()- endPattern.length();
                         if(subString.substring(diff, subString.length()).equals(endPattern.toString())){
                         
                            endPattern = new StringBuilder(subString);
                             if(startPattern!= null) output = new StringBuilder(startPattern).append( endPattern);
                               else output = endPattern;
                         }
                          else output = new StringBuilder("*");
                    }
                    else if( subString.length() < endPattern.length()){
                        int diff =  endPattern.length()- subString.length();
                         if(endPattern.toString().endsWith(subString)){
                            
                         }
                          else output = new StringBuilder("*");
                    }
                    else if(!subString.equals(endPattern.toString()) )
                    output = new StringBuilder("*");
                    
                    if(!output.toString().equals("*") && startPattern != null ){
                        if(startPattern.toString().contains(endPattern.toString()))
                         output = new StringBuilder(startPattern);
                        else if(endPattern.toString().contains(startPattern.toString()))
                         output = new StringBuilder(endPattern);
                    }
                }
                
                else if(input.endsWith("*")){
                    String subString = input.substring(0, input.length()-1);
                    if(startPattern == null){
                      startPattern= new StringBuilder(subString);
                      
                       if(endPattern!= null) output = new StringBuilder(startPattern).append( endPattern);
                         else output = startPattern;
                
                    }
                    else if( subString.length() > startPattern.length()){
                        int diff = subString.length()- startPattern.length();
                         if(subString.substring(0, subString.length()-diff).equals(startPattern.toString())){
                             
                            startPattern = new StringBuilder(subString);
                            if(endPattern!= null) output = new StringBuilder(startPattern).append( endPattern);
                              else output = startPattern;
                         }
                          else output = new StringBuilder("*");
                    }
                    else if( subString.length() < startPattern.length()){
                        int diff =  startPattern.length()- subString.length();
                        
                         if(startPattern.toString().startsWith(subString)){
              
                         }
                          else output = new StringBuilder("*");
                    }
                    else if(!subString.equals(startPattern.toString()) )
                    output = new StringBuilder("*");
                    
                     if(!output.toString().equals("*") && endPattern != null ){
                        if(startPattern.toString().contains(endPattern.toString()))
                         output = new StringBuilder(startPattern);
                        else if(endPattern.toString().contains(startPattern.toString()))
                         output = new StringBuilder(endPattern);
                    }
                    

             
             }
             else{
               

               
                int index = input.indexOf("*");
                                
                String startSubString = input.substring(0, index);
                
                 String endSubString = input.substring(index+1, input.length());
                    if(endPattern == null){
                      endPattern= new StringBuilder(endSubString);
                    
                    }
                    else if( endSubString.length() > endPattern.length()){
                        int diff = endSubString.length()- endPattern.length();
                         if(endSubString.substring(diff, endSubString.length()).equals(endPattern.toString())){
                         
                            endPattern = new StringBuilder(endSubString);
                               
                         }
                          else output = new StringBuilder("*");
                    }
                    else if( endSubString.length() < endPattern.length()){
                        int diff =  endPattern.length()- endSubString.length();
                         if(endPattern.toString().endsWith(endSubString)){
                            
                         }
                          else{
                              output = new StringBuilder("*");
                              continue;
                          } 
                    }
                    else if(!endSubString.equals(endPattern.toString()) ){
                    output = new StringBuilder("*");
                    continue;
                    }

                    if(startPattern == null){
                      startPattern= new StringBuilder(startSubString);
                      
                       if(endPattern!= null) output = new StringBuilder(startPattern).append( endPattern);
                         else output = startPattern;
                
                    }
                    else if( startSubString.length() > startPattern.length()){
                        int diff = startSubString.length()- startPattern.length();
                         if(startSubString.substring(0, startSubString.length()-diff).equals(startPattern.toString())){
                             
                            startPattern = new StringBuilder(startSubString);
                            if(endPattern!= null) output = new StringBuilder(startPattern).append( endPattern);
                              else output = startPattern;
                         }
                          else output = new StringBuilder("*");
                    }
                    else if( startSubString.length() < startPattern.length()){
                        int diff =  startPattern.length()- startSubString.length();
                        
                         if(startPattern.toString().startsWith(startSubString)){
              
                         }
                          else output = new StringBuilder("*");
                    }
                    else if(!startSubString.equals(startPattern.toString()) )
                    output = new StringBuilder("*");

               
                   
                  
                 
             }
            }
        }
            
        System.out.println("Case " + "#"+(noOfCases+1)+": " + output);

        }
        

    }
}