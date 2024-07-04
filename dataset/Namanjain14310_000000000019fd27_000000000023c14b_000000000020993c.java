import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		for(int t=0; t<test; t++)
		{
			int size = sc.nextInt();
			int trace = 0;
			int matrix[][] = new int[size][size];
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					matrix[i][j] = sc.nextInt();
					if(i==j) trace+=matrix[i][j];
				}
			}
			int r=0, c=0;
			
			for(int i=0; i<size; i++) {
				int tempArr[] = new int[size];
				int flag=1;
				for(int z=0; z<size; z++) {
					tempArr[z] = 0;
				}
				
				for(int j=0; j<size; j++) {
					tempArr[matrix[i][j]-1]=1;
				}
				for(int z=0; z<size; z++) {
					if(tempArr[z] == 0)
						{flag=0;
					     break;
						}
				}
				if(flag==1) r++;
				
			}
			
			for(int j=0; j<size; j++) {
				int tempArr[] = new int[size];
				int flag=1;
				for(int z=0; z<size; z++) {
					tempArr[z] = 0;
				}
				
				for(int i=0; i<size; i++) {
					tempArr[matrix[i][j]-1]=1;
				}
				for(int z=0; z<size; z++) {
					if(tempArr[z] == 0)
						{flag=0;
					break;
						}
				}
				if(flag==1) c++;
				
			}
			
			r=size-r;
			c=size-c;
			
			System.out.print("Case #");
			System.out.print(t+1);
			System.out.print(": " + trace + " " + r + " " + c);
			System.out.println();
			
		}
		
	}

}
