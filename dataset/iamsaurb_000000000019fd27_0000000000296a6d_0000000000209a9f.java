import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc = new Scanner(System.in); 
        int T = Integer.parseInt(sc.next());
        for(int l = 1; l<=T;l++) {
            String S = sc.next();
            int i,j,prev,open = 0;
            StringBuilder str = new StringBuilder();
            j = Character.getNumericValue(S.charAt(0));
            prev = j;
            str.append(openParanthesis(j)+""+j);
            open = j;
            for(i=1;i<S.length();i++){
                j = Character.getNumericValue(S.charAt(i));
                if(j>prev) {
                    str.append(openParanthesis(j-open) +""+j);
                    open = j;
                } else if (j<prev) {
                    str.append(closeParanthesis(prev-j) +""+j);
                    open -= (prev-j);
                } else {
                    str.append(""+j);
                }
                prev = j;
            }
            str.append(closeParanthesis(open) +"");
            String S2 = str.toString();
            System.out.println("Case #"+l+": "+S2);
        }
	}
	
	static String openParanthesis(int val)
	{
	    StringBuilder str = new StringBuilder();
	    str.append("");
	    while(val-- > 0) {
	        str.append("(");
	    }
	    return str.toString();
	}
	static String closeParanthesis(int val)
	{
	    StringBuilder str = new StringBuilder();
	    str.append("");
	    while(val-- > 0) {
	        str.append(")");
	    }
	    return str.toString();
	}
}
