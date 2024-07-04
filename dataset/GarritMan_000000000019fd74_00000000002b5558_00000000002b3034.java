import java.util.Scanner;
import java.util.Arrays;
public class Solution{
	public static void main(String[] args){
		//System.out.println(Arrays.toString(array));
		//System.out.println(Arrays.deepToString(deepArray));
		
		Scanner in =new Scanner(System.in);
		
		int T=Integer.parseInt(in.nextLine());
		
		for(int i=0;i<T;i++){
			
			int n=Integer.parseInt(in.nextLine());
			
			String[] P=new String[n];
			
			for(int j=0;j<n;j++){
				P[j]=in.nextLine();
			}
			
			
			System.out.println("Case #"+(i+1)+": "+solve2(P));
		}
	}
	
	public static String solve(String[] P){
		String ans="";
		
		int maxL=0;
		int maxP=0;
		int minL=101;
		int minP=0;
		for(int i=0;i<P.length;i++){
			int l=P[i].length();
			if(l>maxL){
				maxL=l;
				maxP=i;
			}
			
			if(l<minL){
				minL=l;
				minP=i;
			}
			
		}
		
		String s1=P[maxP].substring(P[maxP].length() - P[minP].length()+1);
		
		String s2=P[minP].substring(1);
		
		boolean test=true;
		
		
		
		return s1+" "+s2;
	}
	
	public static String solve2(String[] P){
		String ans="";
		
		int maxL=0;
		String maxP="";
		int minL=101;
		String minP="";
		for(int i=0;i<P.length;i++){
			int l=P[i].length();
			if(l>maxL){
				maxL=l;
				maxP=P[i];
			}
			
			if(l<minL){
				minL=l;
				minP=P[i];
			}			
		}
		
		for(int i=0;i<P.length;i++){
			P[i]=fillStars(P[i],maxL);
			
		}
		//System.out.println(Arrays.toString(P));
		
		boolean test=true;
		for(int i=maxL-1;i>=0;i--){
			for(int j=0;j<P.length;j++){
				if(maxP.charAt(i) != P[j].charAt(i) && P[j].charAt(i) != '*'){
					test=false;
					break;
				}
			}
		}
		
		if(test){
			ans=maxP.substring(1);;
		}else{
			ans="*";
		}
		
		return ans;
	}
	
	public static String fillStars(String x,int N){
		String ans=x;
		
		
		int n=N-x.length();
		//System.out.println(n);
		for(int i=0;i<n;i++){
			ans="*"+ans;
		}
		
		return ans;
		
	}
	
	
}