import java.util.*;
import java.lang.*; 
class Solution{

   int printRepeating(int arry[], int size) 
    { 
       for(int i=0;i<size;i++){
       	for(int j = i+1;j<size;j++){
       		if(arry[i]==arry[j])
       			return 1;
       	 }
       }
       return 0;        
    }
	public static void main(String[] args) {
		Scanner sam = new Scanner(System.in);
		int t = sam.nextInt();
		Solution ram = new Solution();
		for(int r=1;r<=t;r++)
		{
			int n = sam.nextInt();
			int a [][] = new int [n][n];
			int sum = 0;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					a[i][j] = sam.nextInt();
					if(i==j)
						sum +=a[i][j];
				}
			}
			int q=0,w=0;
			int arr [] = new int [n];
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					arr[j] = a[i][j];
				}
			 	w+= ram.printRepeating(arr,n);
			}
			for(int i=0;i<n;i++){

				for(int j=0;j<n;j++){
					arr[j] = a[j][i];
				}
			 	q+= ram.printRepeating(arr,n);
			}
			System.out.println("Case #"+r+": "+sum+" "+w+" "+q);
		}
	}

}