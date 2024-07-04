package project;

import java.util.*;

 class testing {
	
	 static String test(int i) {
		 Scanner sc =new Scanner(System.in);
	    	int r=0,c=0;
	    	int trace=0;
	    		int matrix=sc.nextInt();
	    		int[][] mn= new int[matrix][matrix];
	    		for(int j=0;j<matrix;j++) {
	    			for(int k=0;k<matrix;k++) {
	    				mn[j][k]=sc.nextInt();
	    				if(j==k) {
	    					trace+=mn[j][k];
	    				}
	    			}
	    		}
	    		for(int m=0;m<matrix;m++) {
	    		for(int j=0;j<matrix;j++) {
	    			for(int k=j+1;k<matrix;k++) {
	    				if(mn[m][j]==mn[m][k]) {
	    				r++;
	    				k=j=matrix;
	    				}
	    			}
	    		}
	    		}
	    		for(int m=0;m<matrix;m++) {
	        		for(int j=0;j<matrix;j++) {
	        			for(int k=j+1;k<matrix;k++) {
	        				if(mn[j][m]==mn[k][m]) {
	        				c++;
	        				k=j=matrix;
	        				}
	        			}
	        		}
	    		
	    		}
	    	return "Case #"+i+": "+trace+" "+r+" "+c;
	 }
	public static void main(String arg[])
    {
		
		Scanner sc =new Scanner(System.in);
    	int t=sc.nextInt();
    	String[] re=new String[t];
    	for(int i=0;i<t;i++) {
    		re[i]=test(i+1);
    	}
    	for (String string : re) {
			System.out.println(string);
		}
    }
}
