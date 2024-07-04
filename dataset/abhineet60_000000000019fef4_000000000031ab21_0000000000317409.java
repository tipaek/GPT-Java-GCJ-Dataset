
import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) throws IOException {
	   // Scanner s = new Scanner(System.in);
	   // int t = s.nextInt();
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    
	    for(int i_t = 1;i_t<=t;i_t++){
	        String a[] = br.readLine().split(" ");
	        int x = Integer.parseInt(a[0]);
	        int y = Integer.parseInt(a[1]);
	        String s = a[2];
	        
	        
	        int ans = 0;
	        
	        for(int i = 0;i<s.length();i++){
	            int pos = Math.abs(x)+Math.abs(y);
	            
	            if(pos<=i){
	                ans = i;
	                break;
	            }
	            char ch = s.charAt(i);
	            if(ch=='N') y++;
	            else if(ch=='S') y--;
	            else if(ch=='E') x++;
	            else x--;
	            
	        }
	        if(ans!=0)
	        System.out.println("Case #"+i_t+": "+ans);
	        else
	        {
	           int pos = Math.abs(x)+Math.abs(y);
	           if(pos<=s.length()) System.out.println("Case #"+i_t+": "+s.length());
	           else System.out.println("Case #"+i_t+": IMPOSSIBLE");
	        }
	        
	        
	        
	        
	        
	    }
	}
}