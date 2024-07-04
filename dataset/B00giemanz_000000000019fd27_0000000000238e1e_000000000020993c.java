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
			sol();
		}
	}
	private static void sol(){
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
        int r = actionR(row);
        int c = actionC(row);
        
        System.out.println("Case #" + (tn++)+": " + k + " "+r+" "+ c);
		

}
    private static int actionR(int[][] row){
        int result=0;
        for(int i=0;i<row.length;i++){
            Set<Integer> set = new HashSet<>();
            
            for(int j=0;j<row[i].length;j++){
                if(set.contains(row[i][j])){
                    result++;
                    break;
                }
                set.add(row[i][j]);
            }
        }
        return result;
    }
    private static int actionC(int[][] row){
        int result=0;
        for(int i=0;i<row.length;i++){
            Set<Integer> set = new HashSet<>();
            
            for(int j=0;j<row[i].length;j++){
                if(set.contains(row[j][i])){
                    result++;
                    break;
                }
                set.add(row[j][i]);
            }
        }
        return result;
    }
}

