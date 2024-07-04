import java.util.*;

public class testing {

	public static void main(String arg[])
    {
    	Scanner sc =new Scanner(System.in);
    	int r=0,c=0;
    	int trace=0;
    	int t=sc.nextInt();
    	for(int i=1;i<=t;i++) {
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
    		System.out.println("Case #"+i+": "+trace+" "+r+" "+c);
    	}
    }
}