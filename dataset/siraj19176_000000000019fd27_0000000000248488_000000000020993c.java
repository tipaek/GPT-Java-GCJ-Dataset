import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++) {
			int n=sc.nextInt();
			int arr[][]=new int[n][n];
			int trace=0;
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					arr[j][k]=sc.nextInt();
					if(j==k)
						trace=trace+arr[j][k];
				}
			}
			int row=0;
			int column=0;
			int a[]=new int[n+5];
			for(int r=0;r<n;r++) {
				for(int c=0;c<n;c++) {
					int temp=arr[r][c];
					if(a[temp]==0) {
						a[temp]+=1;
						continue;
					}
					else {
						row++;
						break;
					}
				}
				a=new int[n+5];
			}
			a=new int[n+5];
			for(int r=0;r<n;r++) {
				for(int c=0;c<n;c++) {
					int temp=arr[c][r];
					if(a[temp]==0) {
						a[temp]+=1;
						continue;
					}
					else {
						column++;
						break;
					}
				}
				a=new int[n+5];
			}
			System.out.print("Case #"+(i+1)+":"+" "+trace+" "+row+" "+column);
			System.out.println();
		}
		sc.close();

	}

}
