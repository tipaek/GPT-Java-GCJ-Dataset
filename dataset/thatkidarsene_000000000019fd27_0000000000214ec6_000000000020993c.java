import java.util.Scanner;
import java.util.ArrayList;
import java.math.BigInteger;
public class Solution{
	private int[][] tab;
	public Solution(int N){
		this.tab = new int[N][N];
	}

//<>
	public static boolean check(int[] tab){
		for(int i=0;i<tab.length;i++)
		for(int j=0;j!=i;j++)
			if(tab[i]==tab[j])
				return true;
		return false;
	}
public static int[] solve(int[][] tab){
		int[] res = new int[3];
		res[0]=0;
		res[1]=0;
		res[2]=0;
		int[] tmp = new int[tab.length];
	for(int i=0;i<tab.length;i++){
		res[0]+=tab[i][i];
		for(int j=0;j<tab.length;j++){
			tmp[j] = tab[i][j];	 
}
	if(check(tmp)){res[1]++;}
	}
for(int i=0;i<tab.length;i++){
		for(int j=0;j<tab.length;j++){
		tmp[j] = tab[j][i];	
	}
	if(check(tmp)){res[2]++;}
	}
return res;
	
}
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	int T  = s.nextInt();
	int N=0;
	ArrayList<int[][]> list = new ArrayList<int[][]>();
	for(int i=0;i<T;i++){
		System.out.println("case "+i);
			N = s.nextInt();
			list.add(new int [N][N]);
	for(int p=0;p<N;p++){
		System.out.println("FILLING ROW "+p);
		for(int j=0;j<N;j++){
			System.out.println("FILLING ROW "+p+" COLUMN "+j);
			  list.get(i)[p][j] = s.nextInt();
	}
}
}
	for(int i=0; i<T;i++){
		int n=0;
		System.out.println("Case #"+(i+1)+": "+solve(list.get(i))[0]+" "+solve(list.get(i))[1]+" "+solve(list.get(i))[2]);
	}
}
}