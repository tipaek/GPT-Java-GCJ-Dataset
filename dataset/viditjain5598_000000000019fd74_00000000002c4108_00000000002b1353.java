import java.util.*;
import java.math.*;

public class Pascal{
	static int nCr(int n, int k){
		int ans = 1;
		if(k > n-k){
			k = n-k;
		}
		for(int i=0; i<k; i++){
			ans *= (n-i);
			ans /= (i+1);
		}
		return ans;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int tt=1; tt<=T; tt++){
			int n = in.nextInt();
			System.out.println("Case #" + tt + ": ");
			if(n<=501){
				for(int i=1; i<=n; i++){
					if(n==501 && i==3){
						System.out.println("3 2");
						n = 499;
						//continue;
					}
					System.out.println(i + " 1");
				}
			}
			else if(n<=1000){
				int i = 1;
				boolean flag = true;
				while(i<500 && n>0){
					if(i==1){
						System.out.println(i + " 1");
						n--;
						i++;
					}
					else if(n>(i-1)){
						System.out.println(i + " 2");
						n -= (i-1);
						i++;
						//continue;
					}else{
						if(flag){
							i--;
							flag=false;
						}
						System.out.println(i + " 1");
						i++;
						n -= 1;
					}
					//i++;
				}
			}
			// else{
			// 	while(n>0){

			// 	}
			// }
		}
	}
}