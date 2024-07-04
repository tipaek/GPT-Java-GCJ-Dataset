import java.util.Scanner;
public class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int t= sc.nextInt();
	    int x=1;
	    while(t>0){
	        int n =sc.nextInt();
	        int[][] a = new int[n][n];
	        for(int i=0;i<n;i++){
	            for(int j=0;j<n;j++){
	            a[i][j] = sc.nextInt();
	            }
	        }
	        int k=0;
	        for(int i=0;i<n;i++){
	            k+=a[i][i];
	        }
	        int f1=0,f2=0;
	        int r=0,c=0;
	        for(int i=0;i<n;i++){
	            for(int j=0;j<n-1;j++){
	                for(int z=j+1;z<n;z++){
	                    if(a[i][j]==a[i][z]){
	                        f1=1;
	                        
	                    }
	                    if(a[j][i]==a[z][i]){
	                        f2=1;
	                        
	                    }
	                }
	            }
	            if(f1==1){
	                r++;
	                f1=0;
	            }
	            if(f2==1){
	                c++;
	                f2=0;
	            }
	        }
	        
	        System.out.println("Case #"+x+": "+k+" "+r+" "+c);
	        x++;
	        t--;
	    }
	}
}
