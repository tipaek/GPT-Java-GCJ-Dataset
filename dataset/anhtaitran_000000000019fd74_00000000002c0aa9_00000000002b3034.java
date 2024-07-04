import java.util.*;
public class Solution{
	int[] factorial;
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		int T= sc.nextInt();
		for(int t=0;t<T;t++){
			int N= sc.nextInt();
			sc.nextLine();
			String[] list= new String[N];
			for(int i=0;i<N;i++){
				list[i]= sc.nextLine();
			}
			int[][] pointer= new int[N][2];
			for(int i=0;i<N;i++){
				pointer[i][0]=0;
				pointer[i][1]=list[i].length()-1; 
			}
			boolean continued = true;
			String resFront="";
			boolean invalid= false;
			String endGame="";
			boolean end=false;
			//traverse from front
			while(continued){
				continued=false;
				char pre=' ';
				for(int i=0;i<N;i++){
					if(pointer[i][0]> list[i].length()-1){
						end=true;
						endGame= list[i];
						continue;
					}
					char ch= list[i].charAt(pointer[i][0]);
					if(ch=='*') continue;
					if(pre!=' ' && pre!=ch ){
						invalid= true;
						break;
					}
					pointer[i][0]++;
					continued=true;
					pre= ch;
				}
				if(invalid) break;
				if(pre!=' ')
					resFront+=pre;
			}
			if(invalid){
				System.out.println("Case #"+(t+1)+": *");
				continue;
			}
			continued = true;
			invalid= false;
			String resBack="";
			//traverse from back
			while(continued){
				continued=false;
				char pre=' ';
				for(int i=0;i<N;i++){
					if(pointer[i][1]<=pointer[i][0]) continue;
					char ch= list[i].charAt(pointer[i][1]);
					if(ch=='*') continue;
					if(pre!=' ' && pre!=ch ){
						invalid= true;
						break;
					}
					pointer[i][1]--;
					continued=true;
					pre= ch;
				}
				if(invalid) break;
				if(pre!=' ')
					resBack= pre+resBack;
			}
			if(invalid){
				System.out.println("Case #"+(t+1)+": *");
				continue;
			}
			String resMid="";
			for(int i=0;i<N;i++){
				for(int j=pointer[i][0];j<=pointer[i][1];j++){
					char ch= list[i].charAt(j);
					if(ch!='*'){
						resMid+= ch;
					}
				}
			}
			String res="";
			if(end){
				res=endGame;
			}
			else{
				res= resFront+resMid+resBack;
			}
			System.out.println("Case #"+(t+1)+": "+res);
		}
	}
}