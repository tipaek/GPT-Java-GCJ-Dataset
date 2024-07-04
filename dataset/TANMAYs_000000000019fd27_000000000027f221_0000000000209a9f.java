import java.util.*;

public class Solution{
	
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
            int p = 0;
            while (i<n){
            	int j=i+1;
            	while (j<n){
            		if (s.charAt(i)!=s.charAt(j))
            			break;
        			j++;
            	}
            	int y = (int)s.charAt(i)-48;
            	if (p<y){
            		for (int k=p; k<y; k++)
            			x=x+"(";
        			p=y;
            	}
            	else if (p>y){
            		for (int k=y; k<p; k++)
            			x=x+")";
            		p=y;
            	}
            	x=x+s.substring(i, j);
            	i=j;
            }
            for (int k=0; k<p; k++)
            	x=x+")";
            
            System.out.print("Case #"+t+": "+x);
        }
        
    }
}