import java.util.*;
public class Solution {
	public static void main(String []args){
		Scanner s = new Scanner(System.in);
		int tt = s.nextInt();
		for(int test=1; test<=tt; test++) {
			int n = s.nextInt();
			int sum=0;
			if(n<501) {
				
			
			System.out.println("Case #"+test);
			for(int i=0; i<n; i++) {
				if(sum==n) {
					break;
				}
				int j=i+1;
				System.out.println(j+" "+j);
				sum+=j;
			}
			}else {
				System.out.println("Case #"+test);
				System.out.println("1 1");
				System.out.println("2 2");
				System.out.println("3 2");
				System.out.println("3 3");
				sum=5;
				for(int i=3; i<n; i++) {
					if(sum>=n) {
						break;
					}
					int j=i+1;
					System.out.println(j+" "+j);
					sum+=1;
				}
			}
		
			
		}
        
	}
}