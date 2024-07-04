import java.util.*;
import java.io.*;
public class Solution{


	public static int trace(int mat[][],int n){
	
	int trace=0;
	 for(int i = 0; i < n; i++){
                
				trace+=mat[i][i];
				
            }
			return trace;
	
	}
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int loop = 1;
        
        while(loop <= t){
            
            int n = in.nextInt();
            
            int mat[][] = new int[n][n];
            
            for(int i = 0; i < n; i++){
                for(int j=0;j<n;j++){
				mat[i][j]=in.nextInt();
				}
            }
           
			int r=0,c=0;
			for(int i=0;i<n;i++){
			HashSet<Integer> row= new HashSet<>();
		   boolean rdone=false;
				for(int j=0;j<n;j++){
				if(row.contains(mat[i][j])){
				
				rdone=true;
				break;
				}
				
					row.add(mat[i][j]);
					
				
				}
				if(rdone) r++;
			}
			
			for(int i=0;i<n;i++){
			HashSet<Integer> col= new HashSet<>();
			boolean cdone=false;
				for(int j=0;j<n;j++){
				if(col.contains(mat[j][i])){
				
				cdone=true;
				break;
				
				}
				
					col.add(mat[j][i]);
				
				}
				if(cdone) c++;
			}
            
            
            System.out.println("Case #"+loop+": "+trace(mat,n)+" "+r+" "+c);
            loop += 1;
        }
    }
}