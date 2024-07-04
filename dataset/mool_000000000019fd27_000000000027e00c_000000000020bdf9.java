import java.util.*;

public class Solution{
    static String seq;
	static Scanner s=new Scanner(System.in);
	public static void main(String args[]){
		int nofarr,n,sum;
		nofarr=s.nextInt();
		for(int i=0;i<nofarr;i++) {
			n=s.nextInt();
	        seq = new String();
			takeInput(n,i);

		}
	}
	static void takeInput(int n,int caseno){
		int temp,i,j,k=0;
        int mat[][] = new int[n][2];  
        for(j=0;j<n;j++) {
        	for(k=0;k<2;k++) {
        	        if (s.hasNextInt())
        	        		mat[j][k]=s.nextInt();
        	        else 
        	            s.next();
        	}
        }
        for( i = 0; i < n; i++){
            for( j = i+1; j < n; j++){
            	if(mat[i][0] > mat[j][0]){
            		temp = mat[i][0];
            		mat[i][0] = mat[j][0];
            		mat[j][0] = temp;
            		temp = mat[i][1];
            		mat[i][1] = mat[j][1];
            		mat[j][1] = temp;
                }
            }
        }
        int cameron=mat[0][1];
        seq="C";
        int jamie=0;
        for (i=1;i<n;i++) {
        	if(checkIfFree(mat[i][0],cameron)) {
        		cameron = mat[i][1];
                seq=seq.concat("C");
        	}else if(checkIfFree(mat[i][0],jamie)) {
        		jamie = mat[i][1];
                seq=seq.concat("J");
        	}else {
                seq = "IMPOSSIBLE";
                break;
        	}
        }
        	printCase(caseno+1,n,seq);
	}
	public static boolean checkIfFree(int st , int et) {
		if((st - et) >= 0) {
			return true;
		}else {
			return false;
		}
	}
	static void printCase(int n,int size,String seq){
	        System.out.println("Case #"+n+": "+seq);
	}
	      
}