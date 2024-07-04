

import java.util.Scanner;

public class Solution{

	

	public static void main(String[] args){
	    int n,tw;
	    Scanner in=new Scanner(System.in);
	    int t=in.nextInt();
	    tw=0;
	    while(tw++<t){

	    n=in.nextInt();

	    int[][] m=new int[n][n]; 


	    for(int i=0;i<n;i++)
	    for(int j=0;j<n;j++)
	    m[i][j]=in.nextInt();

	int rc=0,cc=0;
	    for(int i=0;i<n;i++){
	    	boolean ir=false,ic=false;
	    	boolean[] r=new boolean[100],c=new boolean[100];
	    	
	    	for(int j=0;j<n;j++){
	    		if(r[m[i][j]-1]){
	    			ir=true;
	    			}
	    		r[m[i][j]-1]=true;

	    		if(c[m[j][i]-1]){
	    			if(r[m[j][i]-1])
						ic=true;
	    		}
				c[m[j][i]-1]=true;
	    	}
	    	if(ir)rc++;
	    	if(ic)cc++;

	    }
	    int trc=0;
	    for(int k=0;k<n;k++){
	    	trc+=m[k][k];
	    }
	    System.out.println("Case #"+tw+": "+trc+" "+rc+" "+cc);
        System.out.flush();
	    }

	    //return 0;
	}

	
	
	
}
