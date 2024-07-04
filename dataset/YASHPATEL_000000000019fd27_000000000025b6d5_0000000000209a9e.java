import java.util.Scanner;

public class Solution {
	
	static int b,samepair,diffpair;
	static int[] a=new int[100];
	static Scanner s=new Scanner(System.in);
	
	
	static int qry(int i){
		System.out.print(i+1);
		//Scanner s=new Scanner(System.in);
		int ans=s.nextInt();
		return ans;
		
	}
	
	public static void findpair(int i){
		//i b-1-i
		a[i]=qry(i);
		a[b-1-i]=qry(b-1-i);
		if(samepair==-1 && a[i]==a[b-1-i])
			samepair=i;
		if(diffpair==-1 && a[i]!=a[b-1-i])
			diffpair=i;
	}
	
	public static void findchange(){
		boolean comp=true;
		if(samepair!=-1 && a[samepair]!=qry(samepair))
			comp=false;
		boolean rev=comp;
		if(diffpair!=-1 && a[diffpair]!=qry(diffpair))
			rev=!comp;
		if(comp)
			for(int i=0;i<b;++i){
				if(a[i]=='+')
					a[i] ='-';
				else
					a[i]='+';
			}
		if(rev)
			for(int i=0;i<b/2;++i){
				int temp=a[i];
				a[i]=a[b-1-i];
				a[b-1-i]=temp;
			}
	}
	public static void solve(){
		samepair = -1;
		diffpair = -1;
		int c=0;
		for(;c<5;++c){
			findpair(c);
		}
		findchange();
		while(c<b/2){
			int i =0;
			for(;i<4 && c<b/2;++i,++c)
				findpair(c);
			if(i==4){
				//all 4 happened, change happened
				findchange();
			}
		}
		
		for(int i=0;i<b;++i){
			System.out.print(a[i]);
		}
		char ok;
		ok=s.next().charAt(0);
		if(ok=='N')
			System.exit(0);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=1;i<=n;++i){
			System.out.print("Case #" + i + ": ");
			solve();
		}
	}

}
