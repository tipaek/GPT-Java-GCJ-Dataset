
import java.util.Arrays;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int v=1;
		int t = scn.nextInt();
		
		while(t-->0){
			
			int n = scn.nextInt();
			
			int s[] = new int[n];
			int e[] = new int[n];
			
			for(int i=0;i<n;i++){
				s[i] = scn.nextInt();
				e[i] = scn.nextInt();
			}
			
			Arrays.sort(s);
			Arrays.sort(e);
			
			int i=0,j=0;
			
			String ans = "";
			int cnt=0;
			int imp=0;
			while(i<n && j<n){
				if(s[i]<e[j]){
					if(cnt>=2){
						System.out.println("Case #"+v+++": "+"IMPOSSIBLE");
						imp=1;
						break;
					}
					if(cnt==1){
						ans+='J';
						cnt++;
					}
					
					if(cnt==0){
						ans+='C';
						cnt++;
					}
					
				
					i++;
				}
				else{
					cnt=0;
					j++;
				}
			}
			if(imp==0)
			System.out.println("Case #"+v+++": "+ans);
		}

	}

}
