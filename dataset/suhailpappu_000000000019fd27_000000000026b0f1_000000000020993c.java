import java.io.*;
import java.util.*;

class Solution {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int p=1;
		
		for(int i=0;i<t;i++){
		    
		    int n = sc.nextInt();
		    int m[][] = new int[n][n];
		    int sum=0;
		    int row=0,col=0,rowC=0,colC=0,q=0;
		    
		    for(int j=0;j<n;j++){
		        for(int k=0;k<n;k++){
		            m[j][k] = sc.nextInt();
		        }
		    }
		    
		    for(int j=0;j<n;j++){
		        sum+=m[j][j];
		        
		        
		    }
		    int check[] = new int[n];
		    for(int j=0;j<n;j++){
		        
		        for(int k=0;k<n;k++){
		           
		            check[q] = m[j][k];
		            q++;

		        }
		       
		        if(duplicates(check,n)){
		                row++;
		        }
		        q=0;
		        check = new int[n];
		    }
		    check = new int[n];
		    q=0;
		    
		    for(int j=0;j<n;j++){
		        
		        for(int k=0;k<n;k++){
		            check[q] = m[k][j];
		            q++;

		        }
		         if(duplicates(check,n)){
		                col++;
		        }
		        q=0;
		        check = new int[n];
		        
		    }
		    System.out.println("Case #"+p+":"+" "+sum+" "+row+" "+col);
		    p++;
		    
		    
		}
		
		
	}
    	public static boolean duplicates (int [] x, int numElementsInX ) {
            Set<Integer> set = new HashSet<Integer>();
            for ( int i = 0; i < numElementsInX; ++i ) {
                if ( set.contains( x[i])) {
                    return true;
                }
                else {
                    set.add(x[i]);
                }
            }
        return false;
    }
}