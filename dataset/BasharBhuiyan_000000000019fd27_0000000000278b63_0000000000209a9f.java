import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        sc.nextLine();
        
        for (int i = 1; i <= t; i++){
            String S = sc.nextLine();
            char[] ch = S.toCharArray();
            
            String result = "";
            int parenthese = 0;
            for(int j = 0; j < ch.length; j++){
                int temp = Character.getNumericValue(ch[j]);
                
                while(true){
                    if(parenthese == temp){
                        break;
                    }
                    
                    if(parenthese < temp){
                        result += "(";
                        parenthese++;
                    }
                    
                    if(parenthese > temp){
                        result += ")";
                        parenthese--;
                    }
                }
                result += ch[j];
                
                
            }
            
            while(true){
                if(parenthese == 0){
                    break;
                }

                if(parenthese < 0){
                    result += "(";
                    parenthese++;
                }

                if(parenthese > 0){
                    result += ")";
                    parenthese--;
                }
            }
            
            
            System.out.println("Case #" + i + ": " +result);
        }
        
  
    }

}