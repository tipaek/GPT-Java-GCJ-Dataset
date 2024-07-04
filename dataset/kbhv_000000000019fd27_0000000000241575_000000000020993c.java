import java.util.Scanner;
class Main{
    static Scanner s =new Scanner(System.in);
    
    
    
    static int trace(int [][] M) {
    	int k=0;
    	for(int i=0;i<M.length;i++) {
    		for(int j=0;j<M.length;j++){
    			if(i==j) {
    				k=k+M[i][j];
    			}
    		}
    	}
    	return k;
    }
    
    static int rows(int [][] M) {
    	int r=0;
    	
    	for(int i=0;i<M.length;i++) {
    		int flag=0;
    		for(int j=0;j<M.length;j++) {
    			for(int k=j+1;k<M.length;k++) {
    				if(M[i][j]==M[i][k]) {
    					flag=1;
    				}
    			}
    		}
    		if(flag==1) {
    			r=r+1;
    		}
    	}

    	return r;
    }
    
    static int cols(int [][] M) {
    	int c=0;
    	
    	for(int i=0;i<M.length;i++) {
    		int flag=0;
    		for(int j=0;j<M.length;j++) {
    			for(int k=j+1;k<M.length;k++) {
    				if(M[j][i]==M[k][i]) {
    					flag=1;
    				}
    			}
    		}
    		if(flag==1) {
    			c=c+1;
    		}
    	}
    	
    	return c;
    }
    
    public static void main(String [] args){
        int T=s.nextInt();
        
        int k[]=new int [T];
        int r[]=new int [T];
        int c[]=new int [T];
        for(int l=1;l<=T;l++) {
            int N=s.nextInt();
            
            int [][] M = new int[N][N];
            for (int i = 0; i < N; i++) {
            	for (int j = 0; j < N; j++){
            		int value = s.nextInt();
            		
            	}
            }
          
             k[l-1]=trace(M);
             r[l-1]=rows(M);
             c[l-1]=cols(M);
            
          
        }
        for(int i=1;i<=T;i++) {
        	System.out.println("Case #"+i+": "+k[i-1]+" "+r[i-1]+" "+c[i-1]);
        }
}
    
}
