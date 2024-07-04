import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        String meh = in.nextLine();
        for(int z=1; z<=T; z++){
            String str = in.nextLine();
            //Stack<Character> s = new Stack<>();
            StringBuilder sb = new StringBuilder();
            Character ch = '0';
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == ch){
                    sb.append(str.charAt(i));
                    continue;
                }
                if(str.charAt(i)>ch){
                    for(int j=0; j<(str.charAt(i)-ch); j++){
                        sb.append('(');
                    }
                    ch = str.charAt(i);
                    i--;
                }
                else{
                    for(int j=0; j<(ch - str.charAt(i)); j++){
                        sb.append(')');
                    }
                    ch = str.charAt(i);
                    i--;
                }
            }
            if(ch>'0'){
                for(int j=0; j<(ch-'0'); j++){
                    sb.append(")");
                }
            }
            System.out.println("Case #" + z + ": " + sb.toString());
        }
        
    }
}