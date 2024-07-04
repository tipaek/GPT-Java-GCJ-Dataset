import java.util.*;
class Solution{

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int testcase=1;
		while(testcase<=t) {
			int n=sc.nextInt();
			int a[][]= new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					a[i][j]=sc.nextInt();
				}
			}
			int sumOfDiagonals=0;
			int i=0;
			while(i<n) {
				int j=i;
				sumOfDiagonals+=a[i][j];
				i++;
			}
			int noOfDuplicatesInRow=0;
			for(int k=0;k<n;k++){
				HashMap<Integer,Boolean> map=new HashMap<>();
				for(int z=0;z<n;z++) {
					if(!map.containsKey(a[k][z])) {
						map.put(a[k][z],true);
					}else {
						noOfDuplicatesInRow++;
						break;
					}
				}
			}
			int noOfDuplicatesInColumn=0;
			for(int k=0;k<n;k++){
				HashMap<Integer,Boolean> map=new HashMap<>();
				for(int z=0;z<n;z++) {
					if(!map.containsKey(a[z][k])) {
						map.put(a[z][k],true);
					}else {
						noOfDuplicatesInColumn++;
						break;
					}
				}
			}
			
			System.out.println("Case#"+testcase+": "+sumOfDiagonals+" "+ noOfDuplicatesInRow+" "+ noOfDuplicatesInColumn);
			testcase++;
		}

	}

}