import java.util.*;
                      
public class Solution{
	static Scanner in;
     public static void main(String[] args) {		 
     in = new Scanner(System.in);
     int T = in.nextInt();
     for(int cas = 1; cas <= T; cas++){
		 solve(cas);
	 }
	 }
	 static void solve(int cas){
		 int n = in.nextInt();
		 System.out.println("Case #"+cas+": "); 
         System.out.println(1+" "+1);	
         n--;
         if(n == 0)
             return;			 
		 if(n < 501){
			 System.out.println(2+" "+2);
			 n --;
			 int r = 2;
			 while(n > 0){
			     System.out.println(r+" "+1);
			     r++;
			     n--;
			 }
			 return;
		 }

		  System.out.println(2+" "+2);
		  n--;  int row = 3;
		  while(n > 0){
			  if(n >= row - 1){
			      System.out.println(row+" "+2);
			      n -= row-1;
				  row++;
			  }
			  else
				  break;
		  }

        row--;
		  if(n > 0){
			  if(n < row){
				  while(n > 0){
			          System.out.println(row+" "+1);
				      n--;
					  row--;
			      }
		      }
			  else{
				  while(n > 0){
					  System.out.println(row+" "+1);
				      row++;
				      n--;
			      }
			  }
		  }
	 }
}
			  
			  
		 
		 
			 
			 
		 
		 