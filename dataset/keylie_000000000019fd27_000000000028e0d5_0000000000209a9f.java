import java.lang.*;
import java.util.*;

public class Solution{
    
    
    
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        
        int numberOfCases = Integer.parseInt(in.nextLine());
        
        String withoutPar;
        String withPar;
        String open = "(";
        String close = ")";
        
        int actualPar;
        int temp, temp2, actualParOpen;
        
        for(int i = 1; i <= numberOfCases; i++){
            
            StringBuffer result = new StringBuffer();
            withoutPar = in.nextLine();
            actualParOpen = 0;
            
            for(int j = 0; j < withoutPar.length() ; j++){
                
                temp = Character.getNumericValue(withoutPar.charAt(j));
                temp2 = temp - actualParOpen;
                actualParOpen = actualParOpen + temp2;
                
                if(temp2 > 0){
                    for(int k= 0; k < temp2; k++)
                        result.append(open);
                }
                else if(temp2 < 0){
                    for(int l=0; l < temp2*-1; l++)
                        result.append(close);
                }
                    
                    
                result.append(temp);
            }
            
            for(int m=0; m < actualParOpen; m++)
                result.append(close);
            
            System.out.println("Case #" + i + ": " + result.toString());
            
            
        }
        
    }
}