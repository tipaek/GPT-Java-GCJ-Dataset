import java.util.Scanner;

public class solution {
	 public static void main(String args[])
	 {
		 int k,n,i,j;
		 
		 Scanner input = new Scanner(System.in); 
		  k = input.nextInt();
		  int[][] cases = new int[k][3]; 
		 for(int g=0;g<k;g++) {
		int T=0,r=0,c=0,check=0;
		 n = input.nextInt();
		 if(n<2) {
			 System.out.println("Invalid input");	 
		 }
		 else {
		 
		 int[][] m = new int[n][n];
		     
		     for(i=0;i<n;i++)
		     { 
		      for(j=0;j<n;j++)
		      { 
		          m[i][j] = input.nextInt();
		     }
		 }
		 
		     for(i=0;i<n;i++) { 
		        for(j=0;j<n;j++)  { 
	
		        	if(i==j){
	                	 T += m[i][j];	 }
		     }
		 }
		 
		     for(i=0;i<n;i++) { 
			        for(j=0;j<n;j++)  { 
			        for(int q=1;q<n;q++) {	
		            if(j+q<n) {
			        	if( m[i][j] ==  m[i][j+q] && check != 5){
		                	  r++;check=5;  	 }}}
			    
			     }
			        check=0;   
			 }
		     
		     
		     for(j=0;j<n;j++) { 
			        for(i=0;i<n;i++)  { 
			        	 for(int q=1;q<n;q++) {	  	
		            if(i+q<n) {
			        	if( m[i][j] ==  m[i+q][j] && check!=3 ){
		                	  c++;check=3; }}}
			     }
			       check=0; 
			 }
			      
		   }
		 cases[g][0]=T;
		 cases[g][1]=r;
		 cases[g][2]=c;
		 }
		 for(int y=0;y<cases.length;y++) {
			 System.out.println("case #"+(y+1)+": "+cases[y][0]+" "+cases[y][1]+" "+cases[y][2]);
		 }
		 
		 
	 }
}
