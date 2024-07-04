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
			
			
			System.out.println("Case #"+(i+1)+": "+solve3(P));
		}
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
		System.out.println(Arrays.toString(P));
		
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
	
	public static String solve3(String[] P){
		String ans="";
		
		int maxL=0;
		String maxP="";
		int minL=101;
		String minP="";
		int maxS=0;
		
		for(int i=0;i<P.length;i++){
			int l=P[i].length();
			String temp=P[i];
			int tmpn=temp.split("\\*").length;
			//P[i]=P[i];
			if(l>maxL){
				maxL=l;
				maxP=P[i];
			}
			
			if(l<minL){
				minL=l;
				minP=P[i];
			}

			if(tmpn>maxS){
				maxS=tmpn;
			}
		}
		
		
		String[][] PP=new String[P.length][maxS];
		
		for(int i=0;i<PP.length;i++){
			P[i]=P[i]+".";
			String[] T=P[i].split("\\*");
			
			int pref=T.length-1;
			
			for(int j=0;j<maxS;j++){
				
				
				
				if(pref>=0){
					PP[i][maxS-1-j]=T[pref];
					pref--;
					
				}else{
					PP[i][maxS-1-j]="";
				}
			}
		}
		
		
		
		//System.out.println(Arrays.deepToString(PP));
		
	
		
		boolean test=true;
		
	
		
		
		String anchor="";
		
		for(int i=0;i<maxS-1;i++){
			
			anchor=PP[0][i];
			for(int j=1;j<PP.length;j++){
				anchor+=PP[j][i];
			}
			ans+=anchor;
		}

		anchor=PP[0][maxS-1];
		int i=maxS-1;
		for(int j=0; j<PP.length;j++){
			
			if(anchor.length() >= PP[j][i].length()){
				if(anchor.contains(PP[j][i])){
					anchor=anchor;
				}
				else if(anchor.length()==0 || PP[j][i].length()==0){
					anchor=anchor;
				}else{
					test=false;
					break;
				}
			}else{
				if(PP[j][i].contains(anchor)){
					anchor=PP[j][i];
				}else if(anchor.length()==0 || PP[j][i].length()==0){
					anchor=PP[j][i];;
				
				}else{
					test=false;
					break;
				}
			}
		}
		
		ans+=anchor;
		//System.out.println(anchor);		
	
		
		
		if(!test){
			return "*";
		}
		ans=ans.substring(0,ans.length()-1);
					
		return ans;
	}
	
	
	
	public static String fillStars(String x,int N){
		String ans=x;
		
		
		int n=N-x.length();
		//System.out.println(n);
		
		boolean found=false;
		
		String temp="";
		
		int f=0;
		
		for(int i=0;i<x.length();i++){
			if(x.charAt(i)=='*'){
				f=i;
			}
		}
		
		for(int i=0;i<n;i++){
			temp+='*';
		}
		
		ans=x.substring(0,f)+temp+x.substring(f);
		
		return ans;
		
	}
	
	
}