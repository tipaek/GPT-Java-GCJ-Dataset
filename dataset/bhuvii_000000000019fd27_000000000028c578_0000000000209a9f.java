import java.util.*;

class Solution{
    
    public static void getOpenPren(int n, StringBuilder builder){
        for(int i=0;i<n;i++)
                builder.append("(");
    }
    
    public static void getClosedPren(int n, StringBuilder builder){
        for(int i=0;i<n;i++)
                builder.append(")");
    }
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int k=1;k<=testCase;k++){
            
            String str = sc.next();
            StringBuilder builder = new StringBuilder();
            
            int firstDigit = str.charAt(0) - '0';
            getOpenPren(firstDigit, builder);
            
            builder.append(str.charAt(0));
            //System.out.println(builder.toString());
                
            // Start scanning the string
            
            for(int i=1;i<str.length();i++){
                int prevDigit = str.charAt(i-1)-'0';
                int currDigit = str.charAt(i)-'0';
                
                if(prevDigit>currDigit){
                    getClosedPren(prevDigit-currDigit, builder);
                }
                
                else if(prevDigit<currDigit){
                    getOpenPren(currDigit-prevDigit, builder);
                }
                
                builder.append(str.charAt(i));
            }
            
            getClosedPren(str.charAt(str.length()-1) - '0', builder);
            System.out.println("Case #"+k+": "+builder.toString());
            
            
        }
        
    }
}