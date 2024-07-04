import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

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
	    int size =sc.nextInt();
	    int[][] row = new int[size][size];
        int k=0;
        for(int i=0;i<row.length;i++){
            for(int j=0;j<row[i].length;j++){
                row[i][j] = sc.nextInt();
                
                if(i==j){
                    k+=row[i][j];
                }
            }
        }
        int r = solveR(row);
        int c = solveC(row);
        
        System.out.println("Case #" + (tn++)+": " + k + " "+r+" "+ c);
		

}
    private static int solveR(int[][] row){
        int res=0;
        for(int i=0;i<row.length;i++){
            Set<Integer> set = new HashSet<>();
            
            for(int j=0;j<row[i].length;j++){
                if(set.contains(row[i][j])){
                    res++;
                    break;
                }
                set.add(row[i][j]);
            }
        }
        return res;
    }
    private static int solveC(int[][] row){
        int res=0;
        for(int i=0;i<row.length;i++){
            Set<Integer> set = new HashSet<>();
            
            for(int j=0;j<row[i].length;j++){
                if(set.contains(row[j][i])){
                    res++;
                    break;
                }
                set.add(row[j][i]);
            }
        }
        return res;
    }
}

