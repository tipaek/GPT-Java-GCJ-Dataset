import java.util.*;
class vestigium {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		        int x=s.nextInt();
		        int n,k = 0,r=0,c=0,r_i,c_i,flag1,flag2,g,row,col,a[][]=new int[100][100];
		        for(int i=1;i<=x;i++){
		            n=s.nextInt();
		            for(r_i=0;r_i<n;r_i++) {
		            	for(c_i=0;c_i<n;c_i++) {
		            		a[r_i][c_i]=s.nextInt();
		            	}
		            }
		            k=0;r=0;c=0;
		            flag1=0;flag2=0;g=0; row=a[0][0];col=a[0][0];
		            for(r_i=0;r_i<n;r_i++) {
		            	k+=a[r_i][r_i];
		            	for(c_i=0;c_i<n-1;c_i++) {
		            
		            		if(row==a[r_i][c_i+1]) {
		            	        flag1=1;
		            	        r++;
		            	        break;}
		            	        if(flag==0 && c_i+1==n-1){
		            	        row=a[r_i][++g];
		            	        c_i=g;}
		            	       
		            	}
		            g=0;
		            	for(c_i=0;c_i<n-1;c_i++) {
		            
		            		if(col==a[c_i+1][r_i]){
		            			flag2=1;
		            			c++;
		            	        break;}
		            	        if(flag==0 && c_i+1==n-1){
		            	        row=a[++g][r_i];
		            	        c_i=g;}
		            	       
		            			
		            		
		            	}
		            	
		            	
		            }
		            
		            System.out.println("Case #" + x+": "+ k+ " "+ r+ " " +c);
		            
		        }
	 	}

}
