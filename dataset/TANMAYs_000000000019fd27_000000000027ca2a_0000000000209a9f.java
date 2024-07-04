import java.util.*;

public class Solution{
	public static String fun(String s, int n){
		String x="";
		for (int i=0; i<n; i++)
			x=x+"(";
		x=x+s;
		for (int i=0; i<n; i++)
			x=x+")";
		
		return x;
	}
	
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        
        for (int t=1; t<=test; t++){
            if (t!=1)
                System.out.println();
            
            String s = sc.next();
            int n = s.length();
            String x="";
            int i=0;
            while (i<n){
            	int j=i+1;
            	while (j<n){
            		if (s.charAt(i)!=s.charAt(j))
            			break;
        			j++;
            	}
            	int y = (int)s.charAt(i)-48;
            	x=x+fun(s.substring(i, j), y);
            	i=j;
            }
            
            System.out.print("Case #"+t+": "+x);
        }
        
    }
}