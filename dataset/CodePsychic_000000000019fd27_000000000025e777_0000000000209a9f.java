import java.util.Scanner;
import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int tcCount = in.nextInt();
        //System.out.println("tcCount= "+tcCount);
        
        for(int x=1;x<=tcCount;x++){
            in.nextLine();
            String str = in.next();
            //System.out.println(Arrays.deepToString(matrix));
            solveBrackets(x,str);
        }
        
    }
    
    
    public static void solveBrackets(int x,String str){
        //System.out.println(str);
        
        StringBuilder result = new StringBuilder();
        int open=0;
        int required=0;
        
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            required=(int)(c-'0');
            //System.out.println("required="+required);
            if(open==required)
                result.append(c);
            else if(open<required){
                while(open<required){
                    open++;
                    result.append('(');
                }
                result.append(c);
            }else if(open>required){
                while(open>required){
                    open--;
                    result.append(')');
                }
                result.append(c);
            }
            
        }
        
        while(open>0){
            open--;
            result.append(')');
        }
        
        
        System.out.println("Case #"+x+": "+result);
        
    }
    
    
    
    
    
}