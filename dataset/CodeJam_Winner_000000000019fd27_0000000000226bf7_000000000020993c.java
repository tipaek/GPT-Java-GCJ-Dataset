package Codejam;
import java.util.*;
public class codeJam {
	

	    public static void main(String[]args){
	        Scanner read=new Scanner(System.in);
	        int t=read.nextInt();
	        for(int i=0;i<t;i++){
	            int n=read.nextInt();
	            int matrix[][]=new int[n][n];
	            for(int j=0;j<n;j++){
	                for(int k=0;k<n;k++){
	                    matrix[j][k]=read.nextInt();
	                }
	            }
	            int trace=0;
	            int row=0;
	            int col=0;
	            for(int j=0;j<n;j++){
	            	 HashSet<Integer> hs = new HashSet<>(); 
	            	 HashSet<Integer> hs1 = new HashSet<>();
	                for(int k=0;k<n;k++){
	                		
	                	hs.add(matrix[j][k]);
	                	hs1.add(matrix[k][j]);
	                    if(j==k){
	                        trace+=matrix[j][k];
	                    
	                    }
	                    
	                }
	                if(hs.size()!=n) {
	                	row++;
	                }
	                if(hs1.size()!=n) {
	                	col++;
	                }
	                
	            }
	            System.out.print("Case #"+t+": "+trace+" "+row+" "+col);
	            
	        }
	    }
	}

