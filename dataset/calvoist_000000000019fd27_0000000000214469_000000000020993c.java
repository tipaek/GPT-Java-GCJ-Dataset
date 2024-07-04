import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 class Main {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int n =s.nextInt();
		for(int i=1; i<=n;i++) {
			int m =s.nextInt();
			int matrix [][]= new int[m][m];
			for(int j=0; j<m;j++) {
				for(int k=0;k<m;k++) {
					matrix[j][k] = s.nextInt();
				}
			}
		int trace =0;
		for(int j=0; j<m;j++) {
			for(int k=0;k<m;k++) {
				if(j==k) {
					trace = trace + matrix[j][k];
				}
			}	
		}
		int repeatedRow=0;
		
		for(int j=0; j<m;j++) {
			List <String> repeatedValue = new ArrayList<String>();
			for(int k=0;k<m;k++) {
				if(!repeatedValue.contains(matrix[j][k]+"")) {
					repeatedValue.add(matrix[j][k]+"");
				}
				else {
					repeatedRow++;
					break;
				}
				
			}
		}
		int repeatedColumn=0;
		for(int k=0;k<m;k++) {
			List <String> repeatedValue = new ArrayList<String>();
			for(int j=0; j<m;j++) {
				if(!repeatedValue.contains(matrix[j][k]+"")) {
					repeatedValue.add(matrix[j][k]+"");
				}
				else {
					repeatedColumn++;
					break;
				}
			}	
		}
		
		System.out.println("Case #"+i+": "+trace+" "+ repeatedRow+ " "+ repeatedColumn);
		}
	}
}
