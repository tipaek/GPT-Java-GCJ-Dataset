import java.util.*;

public class Solution{
	private static Scanner sc;
	static int tn = 1;
	public static void main(String[] args){
		sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t-- > 0){
			solve();
		}
	}
	private static void solve(){
		int n = sc.nextInt();
		int[][] mat = new int[n][2];
		int[][] SortedMatrix = mat.clone();
		char per = 'J';
		char[] chars = new char[n];
		Stack<int[]> JS = new Stack<>();
		Stack<int[]> CS = new Stack<>();
		boolean impossible = false;
		Map<int[] , Integer> map = new HashMap<>();
		
		for(int i=0;i< mat.length; i++){
			for(int j=0;j<mat[i].length;j++){
				mat[i][j] = sc.nextInt();
				
			}
			map.put(mat[i],i);
		}
		Arrays.sort(SortedMatrix, new Comparator<int[]>(){
			@Override
			public int compare(int[] a,int[] b){
				return a[0] - b[0];
			}
		});
		for(int i=0;i<SortedMatrix.length;i++){
		    chars[map.get(SortedMatrix[i])] = per;
		    if(i < SortedMatrix.length - 1 && Overlap(SortedMatrix[i] , SortedMatrix[i+1])){
		     if(per == 'J'){
		         JS.push(SortedMatrix[i]);
		         per = getper(per);
		         if(!CS.isEmpty() && Overlap(CS.peek(),SortedMatrix[i+1])){
		             impossible = true;
		             break;
		         }
		     }
		     else{
		         CS.push(SortedMatrix[i]);
		         per = getper(per);
		         if(!JS.isEmpty() && Overlap(JS.peek(),SortedMatrix[i+1]) ){
		             impossible = true;
		             break;
		         }
		     }
		    }
		     else{
		         if (per == 'J'){
		             JS.push(SortedMatrix[i]);
		         } else{
		             CS.push(SortedMatrix[i]);
		         }
		     }
		    }
		    
		    System.out.println("Case #"+ (tn++) + ": " + (impossible ? "IMPOSSIBLE" : new String(chars)));
		}
		private static char getper(char p){
		    return p == 'J' ? 'C' : 'J' ;
		}
		private static boolean Overlap(int[] a,int[] b){
		    return a[1] > b[0];
		}
	}
