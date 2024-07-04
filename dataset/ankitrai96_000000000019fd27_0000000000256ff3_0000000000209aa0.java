import java.util.*;
public class Solution
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		int test_cases = sc.nextInt();
		
		for(int t=0;t<test_cases;t++){
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    
		    if(k%n!=0){
		        System.out.println("Case #"+(t+1)+": IMPOSSIBLE ");
		    }else{
		        
		        int d = k/n;
                System.out.println("Case #"+(t+1)+": POSSIBLE ");
                int m=d+1;    
	            for(int i=0;i<n;i++){
	            m=m-1;
	            for(int j=0;j<n;j++){
	                System.out.print(((m%n==0)?n:(m%n))+" ");
                    m++;
	            }
	            System.out.println();
	        }
                
		    }
		    
		    
		}
		
	}
}
