import java.util.Scanner;

public class Solution{
	public static void main(String[] args){
		Scanner in =new Scanner(System.in);
		
		int T=Integer.parseInt(in.nextLine());
		
		for(int i=0;i<T;i++){
			String S=in.nextLine();
			System.out.println("Case #"+(i+1)+": "+solve(S));
		}
	}
	
	public static String solve(String S){
		String ans="";
		
		String[] Sarr=S.split("");
		
		int open=0;
		
		for(int i=0;i<Sarr.length;i++){
			int num=Integer.parseInt(Sarr[i]);
			
			if(open<num){
				int n=num-open;
				for(int p=0;p<n;p++){
					ans+="(";
					open++;
				}
				//ans+=num;
				
			}else if(num<open){
				int n=open-num;
				for(int p=0;p<n;p++){
					ans+=")";
					open--;
				}
				//ans+=num
			}
			ans+=num;
		}
		for(int i=0;i<open;i++){
			ans+=")";
		}
		
		return ans;
	}
}