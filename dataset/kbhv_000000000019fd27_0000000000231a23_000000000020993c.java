import java.util.Scanner;
public class Main{
    static Scanner s =new Scanner(System.in);
    static int testTandNvalue(int T){
        if(T<1||T>100){
            System.out.println("Invalid T value. Enter Again.");
            T=s.nextInt();
            testTandNvalue(T);
        }
        else{
            return T;
        }
        return T;
        }
    
    static int testMatrixValue(int m, int N) {
    	if(m<1 || m>N){
    		System.out.println("Invalid matrix value, Enter again");
    		m=s.nextInt();
    		testMatrixValue(m,N);
    	}
    	else {
    		return m;
    	}
    	
    	return m;
    }
    
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
        testTandNvalue(T);
        for(int l=1;l<=T;l++) {
            int N=s.nextInt();
            testTandNvalue(N);
            int [][] M = new int[N][N];
            for (int i = 0; i < N; i++) {
            	for (int j = 0; j < N; j++){
            		int value = s.nextInt();
            		M[i][j] = testMatrixValue(value,N);
            	}
            }
            int k=trace(M);
            int r=rows(M);
            int c=cols(M);
            System.out.println("Case #"+l+": "+k+" "+r+" "+c);
          
        }
    }
}