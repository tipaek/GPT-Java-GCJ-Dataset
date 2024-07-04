import java.util.HashSet;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int testCases = s.nextInt();
		int x = 1;
		int k = 0;
		int r = 0;
		int c = 0;	
		while(testCases>0) {
			int n = s.nextInt();
			int[][] array = new int[n][n];				
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					array[i][j] = s.nextInt();
				}
			}
			
			for(int i=0;i<n;i++) {
				k+= array[i][i];
			}			
			HashSet<Integer> setRow = new HashSet<Integer>();
			HashSet<Integer> setColumn = new HashSet<Integer>();
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(setRow.contains(array[i][j])) {
						r+=1;
						break;
					}else {
						setRow.add(array[i][j]);
					}					
				}
				setRow.clear();
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {	
					if(setColumn.contains(array[j][i])) {
						c+=1;
						break;
					}else {
						setColumn.add(array[j][i]);
					}	
					
				}
				setColumn.clear();
			}
			
			System.out.println("Case #"+x+": "+ k +" "+r +" "+c);
			testCases--;
			x++;
			k = 0;
			r = 0;
			c = 0;
		}		
	}

}
