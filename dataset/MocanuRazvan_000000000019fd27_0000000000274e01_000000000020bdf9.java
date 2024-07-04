
import java.util.Scanner;

public class Solution{
	static void bubbleSort(Integer[] a1,Integer[] a2,int length) 
	{  
		for (int i = 0; i < length; i++) 
			for (int j = 0; j < length-i-1; j++) 
				if (a1[j] > a1[j+1]) 
				{ 
					int temp = a1[j]; 
					a1[j] = a1[j+1]; 
					a1[j+1] = temp; 

					temp=a2[j];
					a2[j]=a2[j+1];
					a2[j+1]=temp;
				}
	} 

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nr = scanner.nextInt();
		Integer n[]=new Integer[100];
		Integer a1[][]=new Integer[100][1000];
		Integer a2[][]=new Integer[100][1000];
		Integer a1aux[][]=new Integer[100][1000];
		Integer a2aux[][]=new Integer[100][1000];
		String act[][]=new String[100][1000];
		String actaux[][]=new String[100][1000];


		for( int i=0;i<nr;i++) {
			n[i]= scanner.nextInt();
			for(int j=0;j<n[i];j++) {
				a1[i][j]=scanner.nextInt();
				a2[i][j]=scanner.nextInt();
				a1aux[i][j]=a1[i][j];
				a2aux[i][j]=a2[i][j];
				act[i][j]=" ";
				actaux[i][j]=" ";
			}
		}


		scanner.close();



		for (int i=0;i<nr;i++) {
			int length=0;
			for (int j=0;j<n[i];j++) {
				if(a1[i][j]!=null)length++;
			}
			bubbleSort(a1[i],a2[i],length);
		}

		for( int i=0;i<nr;i++) {
			int i1=i+1;
			System.out.print("Case #"+i1+": ");

			int cbegin=-1;
			int cend=-1;
			int jbegin=-1;
			int jend=-1;
			int ok=1;
			for(int j=0;j<n[i];j++) {
				if (a1[i][j]>=cend&&a1[i][j]<a2[i][j]) {
					cbegin=a1[i][j];
					cend=a2[i][j];
					act[i][j]="C";
				}
				else if(a1[i][j]>=jend&&a1[i][j]<a2[i][j]) {
					jbegin=a1[i][j];
					jend=a2[i][j];
					act[i][j]="J";
				}
				else ok=0;
			}


			if (ok==0)System.out.println("IMPOSSIBLE");
			else {
				for(int j=0;j<n[i];j++) {
					for (int k=0;k<n[i];k++) {
						if(a1aux[i][j]==a1[i][k])System.out.print(act[i][k]+"");

					}

				}
				if(i!=nr-1)System.out.println("");
			}
		}

	}

}
