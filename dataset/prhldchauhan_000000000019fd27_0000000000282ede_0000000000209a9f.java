import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Solution {
    private static Scanner sc;
    static int tn=1;
    
    public static void main(String[] args){
        sc= new Scanner(System.in);
        
        int t= sc.nextInt();
        sc.nextLine();
        
        while(t-->0){
            solve();
        }
    }
    private static void solve(){
        String S=sc.nextLine();
        StringBuilder sb= new StringBuilder();
        char [] chars = S.toCharArray();
        int num = 0;
        int b = 0;
        int f = Character.getNumericValue(chars[0]);
        num = f;
        b = f;
        for (int i=0;i<f;i++)
        {
            sb.append('(');
            
        }
        sb.append(f);
        
        for (int i=1;i<chars.length;i++){
            int d= Character.getNumericValue(chars[i]);
            if(d==num){
                sb.append(d);
                
            }else if(d>num){
                int diff=d-num;
                
                for (int j =0 ;j<diff;j++){
                    sb.append('(');
                    b++;
                }
                sb.append(d);
                
            }else{
                int diff=num-d;
                for (int j =0 ;j<diff;j++){
                    sb.append(')');
                    b--;
                }
                sb.append(d);
            }
            num=Character.getNumericValue(chars[i]);
        }
        while(b-->0){
            sb.append(')');
        }
        System.out.println("Case #"+(tn++)+": "+sb.toString());
    }
}