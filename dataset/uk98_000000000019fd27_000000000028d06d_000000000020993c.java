import java.util.*;

class Solution{
    public static void main(String args[]){
        int t,n,i,j,k=0,r=0,c=0;
        int[][] arr;
        Scanner s = new Scanner(System.in);
        t = s.nextInt();
        while(t>0){
            n = s.nextInt();
            arr = new int[n][n];
            for(i=0;i<n;i++) {
            	for(j=0;j<n;j++) {
            		arr[i][j] = s.nextInt();
            		if(i==j) {
            			k+=arr[i][j];
            		}
            	}
            }
            
            
            
          System.out.printf("Case #%d: %d %d %d",t,k,r,c);
          t--;
        }
        
        
    }
}