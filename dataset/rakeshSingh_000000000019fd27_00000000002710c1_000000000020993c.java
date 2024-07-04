import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		int caseN=1;
		StringTokenizer st;
		while(t-->0){
	       
			int n=Integer.parseInt(br.readLine());
			int k=0,r=0,c=0;
			int arr[][]=new int[n][n];
			
			for(int i=0;i<n;i++){
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++){
					
					arr[i][j]=Integer.parseInt(st.nextToken());
					if(i==j){
						k+=arr[i][j];
					}
				}
			}
		  
		    r=solveForRow(arr,n);
		    c=solveForCol(arr,n);
		  
		    out.println("Case #"+(caseN++)+": "+k+" "+r+" "+c);
		    //caseN++;
			
		}
		out.flush();
		out.close();
		

	}

	private static int solveForCol(int[][] arr, int n) {
		// TODO Auto-generated method stub
		HashSet<Integer> set;
		int repCols=0;
		for(int i=0;i<n;i++){
			set=new HashSet<>();
			for(int j=0;j<n;j++){
				int num=arr[j][i];
				if(set.contains(num)){
					repCols++;
					break;
				}
				
				set.add(num);
				
			}
		}
		
		
		return repCols;
	}

	private static int solveForRow(int[][] arr,int n) {
		// TODO Auto-generated method stub
		HashSet<Integer> set;
		int repRows=0;
		for(int i=0;i<n;i++){
			set=new HashSet<>();
			for(int j=0;j<n;j++){
				int num=arr[i][j];
				if(set.contains(num)){
					repRows++;
					break;
				}
				
				set.add(num);
				
			}
		}
		
		
		return repRows;
	}

}
