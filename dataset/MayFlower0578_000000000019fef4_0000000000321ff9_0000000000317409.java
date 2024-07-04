import java.util.*; 
                   
public class Solution{
	static Scanner in;
     public static void main(String[] args) {		 
         in = new Scanner(System.in);	
         int T = in.nextInt(); 
         for(int cas = 1; cas <= T; cas++)
			 solve(cas);
	 }
	 
	 static void solve(int cas){
		 int x = in.nextInt(),  y = in.nextInt();
		 String s = in.next();
		 for(int i = 1; i <= s.length(); i++){
			 char ch = s.charAt(i-1);
			 if(ch == 'E')
				 x++;
			 else if(ch == 'W')
				 x--;
			 else if(ch == 'N')
				 y++;
			 else 
				 y--;
			 if(i >= Math.abs(x) + Math.abs(y)){
				 System.out.println("Case #"+cas+": "+i);
				 return;
			 } 
	    }
		System.out.println("Case #"+cas+": IMPOSSIBLE");
	 }
	 
}
		 
			 
		 