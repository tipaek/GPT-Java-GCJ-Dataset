import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int t = Integer.parseInt(sc.nextLine());
    for (int i = 1; i <= t; i++) {
        StringBuilder res = new StringBuilder(); 
        StringBuilder newSection = new StringBuilder(); 
        String str = sc.nextLine();
        
        int start = 0;
        int end = 0;
        int last_number = -1;

        for(int j = 0; j < str.length(); j++){
            char actualChar = str.charAt(j);
            int number = Character.getNumericValue(actualChar);

            // start
            if(-1 == number){
                last_number = number;
                newSection = new StringBuilder(); 
                for(int times = 0; times < number; times++){
                    newSection.append("(");
                }
                newSection.append(actualChar);

            
            }else if(last_number != number){
                for(int times = 0; times < last_number; times++){
                    newSection.append(")");
                }
                res.append(newSection.toString());

                last_number = number;
                newSection = new StringBuilder(); 
                for(int times = 0; times < number; times++){
                    newSection.append("(");
                }
                newSection.append(actualChar);
            }else{
                newSection.append(actualChar);
            }

            // se acabo
            if( j+1 == str.length()){
                for(int times = 0; times < number; times++){
                    newSection.append(")");
                }
                res.append(newSection.toString());
            }
        }

        System.out.print("Case #"+i+": "+res.toString()+"\n");
        

    }
  }
}