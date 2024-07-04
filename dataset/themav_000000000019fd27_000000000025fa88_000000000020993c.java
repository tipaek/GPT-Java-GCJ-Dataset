import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int T = s.nextInt();// number of cases
		
		for(int k =1;k<=T;k++) {			
			int N = s.nextInt();//number of rows to input
			int arr[][]= new int[N][N];
			for(int i =0;i<N;i++) {
				for(int j =0;j<N;j++) {
					arr[i][j]= s.nextInt();
				}
			}
			helper(arr,k);
		}
//		s.close();
	}
	private static void helper(int arr[][],int caseNumber) {
		HashSet<Integer>currentRow =new HashSet<>();
		HashSet<Integer>currentColumn=new HashSet<>();
		int k,c,r;
		k=c=r=0;
		//for checking repetition in rows
		for(int i=0;i<arr.length;i++) {
			k+=arr[i][i];//sum of diagonal
			for(int j =0 ;j<arr[i].length;j++) {	
				if(currentRow.contains(arr[i][j])) {
					r++;
					break;
					
				}
				else {
					currentRow.add(arr[i][j]);
				}
				
				
			}
			currentRow.clear();
		}
		//checking repetition in columns
		for(int i=0;i<arr.length;i++) {
			for(int j =0;j<arr.length;j++) {
				if(currentColumn.contains(arr[j][i])) {
					c++;
					break;
				}
				else {
					currentColumn.add(arr[j][i]);
				}
			}
			currentColumn.clear();
		}
		System.out.println("Case #"+caseNumber+":"+k+" "+r+" "+c);
		
	}

}
