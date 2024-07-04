import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

 class Vestigium {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases=sc.nextInt();
		for(int i=1 ;i<=testCases; i++){
		int diag =0;
		    int n = sc.nextInt();
		    int repRows =0;
		    int repCol =0;
		    int [][] mat=new int[n][n];
		    for(int row=0;row<n;row++){
		    Set<Integer> comRows =new HashSet<Integer>();
		        for(int col =0;col<n;col++){
		        int num =sc.nextInt();
		        mat[row][col] =num;
		         if(row == col){
		         diag +=num;
		         }
		         //compute rep rows
		         comRows.add(num);
		        }
		        if(comRows.size()!=n)
		        repRows++;
		        comRows =null;
		    }
		    //compute rep columns
		    for(int col=0;col<n;col++){
		    Set<Integer> comCol =new HashSet<Integer>();
		    for(int row=0;row<n;row++){
		        comCol.add(mat[row][col]);
		    }
		    if(comCol.size()!=n)
		    repCol++;
		    comCol =null;
		    }
		    System.out.println("Case #"+i+": "+diag+" "+repRows+" "+repCol);
		}

	}

}
