
import java.util.*;

class Solution{
    
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1;i<=t;i++){
            String s = sc.next();
            String res = "";
            for(int j = 0;j<s.length();j++){
                if(s.charAt(j) == '0') res+= "0";
                else if( j == 0 && j == s.length()-1) res +="(1)";
                else if(j==0 && s.charAt(j+1) == '0') res+="(1)";
                else if(j==0 ) res+="(1";
                else if(j == s.length()-1 && s.charAt(j-1) == '0')res +="(1)";
                else if(j == s.length()-1 )res +="1)";
                else if (s.charAt(j-1) == '0' && s.charAt(j+1) == '0')res += "(1)";
                else if(s.charAt(j-1) == '0' )res += "(1";
                else if(s.charAt(j+1) == '0' )res += "1)";
                else res += "1";
            }
            System.out.println("Case #" + i + ": " + res);
        }

    }
    
    
}
