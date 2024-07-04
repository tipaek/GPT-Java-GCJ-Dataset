import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Solution
{
    private static Scanner sc;
    static int tn =1;
	public static void main(String[] args) {
	    sc= new Scanner(System.in);
	    int t=sc.nextInt();
	    sc.nextLine();
	    while(t--> 0){
	        sol();
	    }
	}
	private static void sol(){
	    int size=sc.nextInt();
	    int[][] mat=new int[size][size];
	    int k=0;
	    for(int i=0;i<mat.length;i++){
	        for(int j=0;j< mat[i].length;j++)
	        {
	            mat[i][j]=sc.nextInt();
	            if(i==j){
	                k+=mat[i][j];
	            }
	            }
	            
	        }
	        int rs=r(mat);
	        int cs=c(mat);
	        System.out.println("Case #" + (tn++) +": "+ k + " " + rs + " " + cs);
	    }
	private static int r(int[][] mat){
	    int res=0;
	    for(int i=0;i<mat.length;i++){
	        Set<Integer> set= new HashSet<>();
	       for(int j=0;j< mat[i].length;j++){
	           if(set.contains(mat[i][j])){
	               res++;
	               break;
	           }
	           set.add(mat[i][j]);
	       }
	    }
	    return res;
	}
		private static int c(int[][] mat){
	    int res=0;
	     for(int i=0;i<mat.length;i++){
	        Set<Integer> set= new HashSet<>();
	       for(int j=0;j< mat[i].length;j++){
	           if(set.contains(mat[j][i])){
	               res++;
	               break;
	           }
	           set.add(mat[j][i]);
	       }
	    }
	    return res;
	}
}
