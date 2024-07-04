import java.util.*;
import java.io.*;
  public class Main {
    public static void main ( String args[] ) {
Scanner sc = new Scanner(System.in);
      FastReader sc = new FastReader();
      PrintWriter out = new PrintWriter (System.out); 
      int t = sc.nextInt(); 
      int x =1 ; 
      while (t>0) {
    	t = t-1 ;
    	  int n = sc.nextInt(); 
    	  int [][]a = new int [n][n]; 
    	  for (int i = 0 ; i < n ; i++) {
    		  for (int j = 0 ; j < n ; j++) {
    			  a[i][j]= sc.nextInt(); 
    		  }
    	  }
    	  int trace  = 0 ; 
    	  for (int i = 0 ; i < n ; i++)
    		  trace+= a[i][i];
    	  int row = 0 ; 
    	  int col = 0 ; 
    	  for (int i = 0 ; i < n ; i++) {
    		  HashSet h = new HashSet<Integer>(); 
    		  HashSet h2 = new HashSet<Integer>(); 
    		  for (int j = 0 ; j < n ; j++) {
    			  h.add(a[i][j]);
    			  h2.add(a[j][i]); 
    		  }
    		  if (h.size()!= n )
    			  row++; 
    		  if (h2.size()!=n)
    			  col++;
    	  }
    	   
    	  out.println("Case"+" "+"#"+x +":" +" " +  trace+" "+row+" "+col);
    	  x= x+1; 
    		  
      }
      out.println();
      out.close(); 
      }
     }
