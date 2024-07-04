import java.util.*;

public class Solution {
    

    public static void main(String [] args ) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for(int tt=0;tt<t;tt++) {

		   int x = scanner.nextInt();
		   int y = scanner.nextInt();
		   String m = scanner.next();
		   char [] mm = m.toCharArray();

		   int first = 0;
		   int n = m.length();
		   int cnt = 1;
		   int ans = -1;
		   while(first<n) {
			  if(mm[first]=='S') {
				  y--;
			  }
			  else if(mm[first]=='N') {
				  y++;
			  }	   

			  if(Math.abs(x)+Math.abs(y)<=cnt) {
				ans = cnt;
				break;
			  }
			  cnt++;
			  first++;
		   }
		   
		   if(ans>0) {
			System.out.println("CASE #"+(tt+1) + ": "+ ans);
		   }	
		   else {
			   System.out.println("CASE #"+(tt+1) + ": "+ "IMPOSSIBLE");
		   }
        }

    }
}
