import java.io.*;
import java.util.*;

/**
 * KickStart 2017 Practice Round Problem A: Country Leader
 * Check README.md for explanation.
 */
public class Solution {
	private static Scanner sc;
	static int tn = 1;
    public static void main(String[] args){
        sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t--> 0){
			solve();
		}

    }
	private static void solve(){
		int n = sc.nextInt();
		int[][] mat = new int[n][2];
		int[][] matSorted = mat.clone();
		char[] chars = new char[n];
		boolean impo = false;
		Map<int[],Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		char person = 'J';
		
		Stack<int[]> JStack = new Stack<>();
		Stack<int[]> CStack = new Stack<>();
		
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[i].length;j++){
				mat[i][j] = sc.nextInt();
				
			}
			map.put(mat[i],i);
			
		}
		Arrays.sort(matSorted, new Comparator<int[]>(){
			
			@Override
			public int compare(int[] a,int[] b){
				return a[0] - b[0];
				
			}
		});
		for(int i=0;i<matSorted.length;i++){
			chars[map.get(matSorted[i])] = person;
			if(i < matSorted.length - 1 && doesOverlap(matSorted[i], matSorted[i+1])){
				if(person == 'J'){
				JStack.push(matSorted[i]);
				//sb.append(person);
				person = getPerson(person);
				if(!CStack.isEmpty()&&doesOverlap(CStack.peek(),matSorted[i+1])){
					impo = true;
					break;
			}
			}else{
				CStack.push(matSorted[i]);
				//sb.append(person);
				person = getPerson(person);
				if(!JStack.isEmpty()&&doesOverlap(JStack.peek(),matSorted[i+1])){
					impo = true;
					break;
			}
			
			
		}
			}else{
				if(person == 'J'){
					
					JStack.push(matSorted[i]);
				}else{
					CStack.push(matSorted[i]);
					
				}
			}
		/*for(int i=0;i<mat.length;i++){
			if(i < mat.length - 1 && doesOverlap(mat[i], mat[i+1])){
				
				if(person == 'J'){
					JStack.push(mat[i]);
					sb.append(person);
					
				}else{
					
					CStack.push(mat[i]);
					sb.append(person);
				}
				person = getPerson(person);
			}else{
				
				if(person == 'J'){
					JStack.push(mat[i]);
					sb.append(person);
					
				}else{
					
					CStack.push(mat[i]);
					sb.append(person);
				}
			}
			
		}*/
		
		
	}
	System.out.println("Case #"+(tn++)+": "+(impo? "IMPOSSIBLE":new String(chars)));
	}
	public static char getPerson(char p){
		
		return p == 'J'?'C':'J';
		
	}
	public static boolean doesOverlap(int[] a,int[] b){
		return a[1]>b[0];
		
	}



}
class Pair{
	int first,second;
	public Pair(int first, int second){
		
		this.first = first;
		this.second = second;
		
	}
}