import java.util.*;
public class Solution{
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		int T= sc.nextInt();
		sc.nextLine();
		for(int t=0;t<T;t++){
			String s= sc.nextLine();
			String res="";
			int open=0;
			for(int i=0;i<s.length();i++){
				int k= Integer.parseInt(s.charAt(i)+"")-open;
				for(int j=0;j<k;j++){
					res+="(";
				}
				if(k<0){
					for(int j=0;j<-k;j++){
						res+= ")";
					}
				}
				open= Integer.parseInt(s.charAt(i)+"");
				res+=s.charAt(i);
			}
			for(int i=0;i<open;i++){
				res+= ")";
			}
			System.out.println("Case #"+(t+1)+": "+res);
		}
	}
}