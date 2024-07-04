import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int t = scan.nextInt();
        
        for(int i = 1; i<=t ; i++){
            String s = scan.next();
            char[] ch = s.toCharArray();
            ArrayList<Character> cal = new ArrayList<Character>();
            for (char c : ch) {
                cal.add(c);
                
            }
            int p = 0;
            for(int j = 0; j < cal.size() ; j++){
                if (Character.getNumericValue(cal.get(j))>p){
                    int times = Character.getNumericValue(cal.get(j))-p;
                    for(;times > 0;times--){
                    cal.add(j, '(');
                    j++;
                    p++;
                    
                    }
                }else if(Character.getNumericValue(cal.get(j))<p){
                    int times = p-Character.getNumericValue(cal.get(j));
                    for(;times > 0;times--){
                    cal.add(j, ')');
                    j++;
                    p--;
                    }
                }
            }
            for(; p>0 ; p--){
                cal.add(')');
            }
            System.out.print("Case #" + i+ ": " );
            for(char c : cal){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}