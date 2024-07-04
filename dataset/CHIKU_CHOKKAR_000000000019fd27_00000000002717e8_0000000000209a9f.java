import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
public class solutions{
    
    private static Scanner sc;
    static int tn=1;
    public static void main(String[] args){
        
        sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            
            solve();
        }
    }
    private static void solve()
    {
        String S=sc.nextline();
        
        StringBuilder sb=new StringBuilder();
        char[] chars=S.toCharArray();
        
        int num=0;
        int brackets=0;
        int first=Character.getNumericValue(chars[0]);
        num=first;
        brackets=first;
        for(int i=0;i<first;i++){
            
            sb.append("(");
        }
        sb.append(first);
        
        for(int i=1;i<chars.length;i++){
            int d=Character.getNumericValue(chars[i]);
            if(d==num){
                sb.append(d);
            }else if(d>num){
                sb.append("(");
                sb.append(d);
                brackets++;
            }else{
                int diff=num-d;
                for(int j=0;j<diff;j++)
                {
                    sb.append(")");
                    brackets--;
                }
                
                sb.append(d);
                
            }    
            num=Character.getNumericValue(chars[i]);
        }
        while(brackets-->0){
            sb.append(")");
        }   
          
                
            
        
        
        system.out.println("Case #"+ (tn++) + sb.toString());
        
         
    }
}