import java.util.Scanner;

public class Solution{
    
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int j=0; j<T; j++){
            
            String s = sc.next();
            StringBuilder build = new StringBuilder();
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '1' || s.charAt(i) == '2'  || s.charAt(i) == '3' || s.charAt(i) == '4' || s.charAt(i) == '5' || s.charAt(i) == '6' || s.charAt(i) == '7' || s.charAt(i) == '8'  || s.charAt(i) == '9')
                {
                     if( i==0 || s.charAt(i-1) != s.charAt(i)) {
                         for(int k=0; k<Character.getNumericValue(s.charAt(i)); k++){
                             if(i >0  && s.charAt(i-1) == ')')
                             continue;
                                build.append('(');
                         }
                         
                    
                        build.append(s.charAt(i));
                        
                    }
                    else if(s.charAt(i-1)==')'|| s.charAt(i-1) == s.charAt(i))
                        build.append(s.charAt(i));
                        
                  if(i==s.length()-1 || s.charAt(i) != s.charAt(i+1)){
                       for(int k=0; k<Character.getNumericValue(s.charAt(i)); k++){
                        build.append(')');
                       }
                    }
                    
                }
                else
                {
                    build.append(s.charAt(i));
                }
               
                    
                
            }
       
              System.out.println("Case #"+(j+1)+":"+" "+build.toString());
        }
    }
}