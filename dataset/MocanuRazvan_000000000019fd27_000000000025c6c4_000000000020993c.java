import java.util.*;

public class Solution{

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nr = scanner.nextInt();
		Integer n[] = new Integer[100];
		Integer a[][][] = new Integer[100][100][100];

		for (int i=0;i<nr;i++) {
			n[i]=scanner.nextInt();
			for (int j=0;j<n[i];j++) {
				for(int k=0;k<n[i];k++) {
					a[i][j][k]= scanner.nextInt();
				}
			}
		}

		scanner.close();
		Integer diag[]=new Integer[100];
		for (int i=0;i<nr;i++) {
			diag[i]=0;
		}

		Integer numbers[][]=new Integer[200][100];

		Integer lines[]=new Integer[100];
		Integer cols[]=new Integer[100];
		for (int i=0;i<nr;i++) {

			int oklin=0;
			int okcol=0;

			for(int g=0;g<n[i];g++) {
				lines[g]=0;
				cols[g]=0;
			}

			for(int g=0;g<2*n[i];g++) {
				for (int h=0;h<n[i];h++) {
					numbers[g][h]=h+1;
				}
			}

			for (int j=0;j<n[i];j++) {
				for(int k=0;k<n[i];k++) {
					if(j==k)diag[i]+=a[i][j][k];
					for (int f=0;f<n[i];f++) {
						if(a[i][j][k]==numbers[j][f]) {
							numbers[j][f]=0;
						}
						if(a[i][j][k]==numbers[n[i]+k][f]) {
							numbers[n[i]+k][f]=0;
						}

					}

				}
			}

			for (int j=0;j<2*n[i];j++) {
				int l=0,c=0;
				for(int k=0;k<n[i];k++) {
					if(numbers[j][k]!=0&&j<n[i])l++;
					if(numbers[j][k]!=0&&j>=n[i])c++;
				}
				if (l>0)oklin++;
				if (c>0)okcol++;
			}
			int i1=i+1;
			System.out.println("Case #"+i1+": "+diag[i]+" "+oklin+" "+okcol);
		}

	}

}
