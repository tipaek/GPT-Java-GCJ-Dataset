import java.util.Scanner;
import java.util.Arrays;
import java.math.BigInteger;
public class Solution{
public int N;
public int[] debut;
public int[] fin;
public Solution(int n){
	this.N = n;
	 debut = new int[n];
       fin = new int [n];
}
//<>

public static int[] iSort(Task[] ttab){
	int[] tmp = new int[ttab.length];
	int[] copy = new int[ttab.length];
	for(int i=0;i<ttab.length;i++){tmp[i] = ttab[i].start;}
	for(int i=0;i<ttab.length;i++){copy[i] = ttab[i].start;}
	Arrays.sort(tmp);
	int k=0;
	int[] tab = new int[ttab.length];
	for(int i=0;i<ttab.length;i++){
	for(int j=0;j<ttab.length;j++){	
		if(tmp[i]==copy[j] && copy[j]!=-1 ){
			tab[k]=j; copy[j]=-1; k++; break;
		}
	}
}
return tab;
}

public static String solve(Solution sol){
	Task[] tab = new Task[sol.debut.length];
	int[] tmp = new int[sol.debut.length];
	String s ="";
	String res="";
	Task C = new Task(0,0);
	Task J = new Task(0,0);
	for(int i=0;i<sol.debut.length;i++){
		tab[i]=new Task(sol.debut[i],sol.fin[i]);
	}
		tmp = iSort(tab);
		for(int i=0;i<tab.length;i++){
			if(C.end<=tab[tmp[i]].start){C=tab[tmp[i]];s+='C';}else{
				if(J.end<=tab[tmp[i]].start){J=tab[tmp[i]];s+='J';}else{
					return "IMPOSSIBLE";
				}
			}
		}
		for(int i=0;i<tab.length;i++){
			for(int j=0;j<tab.length;j++){
				if(tmp[j]==i){
					res+=s.charAt(j); break;}
			}
		}
		return res;
}
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	int T = s.nextInt();
	Solution[] tab = new Solution[T];
	for(int i=0;i<T;i++){
			int tmp = s.nextInt();
			tab[i] = new Solution(tmp);
			for(int j=0;j<tab[i].N;j++){
				tab[i].debut[j] = s.nextInt();
				tab[i].fin[j] = s.nextInt();
			}

	}
	for(int i=0; i<T;i++){
		System.out.println("Case #"+(i+1)+": "+solve(tab[i]));
	}
}


public static final class Task{
		public int start;
		public int end;
		public Task(int start,int end){
			this.start = start;
			this.end = end;
		}
	}
}