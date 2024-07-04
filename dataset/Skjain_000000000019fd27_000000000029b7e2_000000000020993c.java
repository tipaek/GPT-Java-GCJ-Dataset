import java.util.Scanner;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
class Test {
    
    
    public static void main(String s1[]) {
       Scanner sc = new Scanner(System.in);
	        
		 int t = sc.nextInt();
	     //System.out.println(t);
	     
	     if (t == 0)
	     {
	         System.out.println("Case #" + (0) +" " + ":" + " " + 0 + " " + 0 +" " + 0);
	         return;
	     }
	     
	     for (int i = 0 ; i < t; i++) {
	    	 
	    	 int n = sc.nextInt();
	    	 int m[][] = new int[n][n];
	    	 
	    	 for (int j = 0 ; j < n ; j++) {
	    		 for (int k = 0 ; k < n ; k++) {
		    		m[j][k] =  sc.nextInt();
		    	 } 
	    	 }
	    	 
	    	 int x = 0;
	    	 int r = 0;
	    	 int c = 0;
	    	 
	    	 for (int j = 0 ; j < n ; j++) {
	    		 Set<Integer> s = new HashSet();
	    		 
	    		 for (int k = 0 ; k < n ; k++) {
		    		if (s.contains(m[j][k])) {
		    			r++;
		    			break;
		    		} else {
		    			s.add(m[j][k]);
		    		}
		    	 } 
	    	 }
	    	 
	    	 for (int j = 0 ; j < n ; j++) {
	    		 Set<Integer> s = new HashSet();
	    		 
	    		 for (int k = 0 ; k < n ; k++) {
		    		if (s.contains(m[k][j])) {
		    			c++;
		    			break;
		    		} else {
		    			s.add(m[k][j]);
		    		}
		    	 } 
	    	 }

	    	 for (int j = 0 ; j < n ; j++) {
	    		 x += m[j][j];
	    	 }
	    	 
	    	 
	    	 System.out.println("Case #" + (i+1) +" " + ":" + " " + x + " " + r +" " + c);
	     }
    }
}