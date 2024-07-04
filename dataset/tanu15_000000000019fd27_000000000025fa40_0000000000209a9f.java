import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i < t; i++){
            String str = sc.nextLine();
            nestingParantheses(str, i+1);
        }
    }
    
    public static void nestingParantheses(String str, int testCaseNum){
        String result = new String();
        int openBracket = 0;
        
        for(int num = 0; num < str.length(); num++){
            int currentNum = str.charAt(num) - '0';
                if(openBracket > currentNum){
                    int closingBracketCount = openBracket - currentNum;
                    for(int j = 0; j < closingBracketCount; j++){
                        result += ')';
                        openBracket -= 1;
                    }
                }
                else{
                    int count = currentNum - openBracket;
                    for(int i = 0; i < count; i++){
                        result += '(';
                        openBracket += 1;
                    }
                }
            result += currentNum;
        }
        
        for(int k = 0; k < openBracket; k++){
            result += ')';
        }
        
        System.out.println("Case #"+testCaseNum+": "+result.toString());
    }
}