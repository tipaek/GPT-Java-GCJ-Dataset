import java.util.Scanner;
class Soluction {
	private static int diagonal(int[][] arr){
		int sum=0;
		for(int i=0;i<arr.length;i++){
		sum=sum+arr[i][i];
		}
		return sum;
    }

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int cas=sc.nextInt();
		for(int i=1;i<=cas;i++){
		int size=sc.nextInt();
		int [][] arr =new int[size][size];
		for(int j=0;j<size;j++){
		for(int k=0;k<size;k++){
		arr[j][k]=sc.nextInt();
		}
		}
		int dia=diagonal(arr);
		int col=coloumn(arr);
		int row=row_num(arr);
		System.out.println("Case #"+i+": "+dia+" "+row+" "+col);

	}

}

	public static int row_num(int[][] arr) {
		int count=0;
		for(int k=0;k<arr.length;k++) {
	label:	for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[k][i]==arr[k][j]) {
					count++;
				//	System.out.println(k+" "+i+" "+j);
					break label;
			}
			}
		}
		}
		return count;
	}

	public static int coloumn(int[][] arr) {
		int count=0;
		for(int k=0;k<arr.length;k++) {
	label:	for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i][k]==arr[j][k]) {
					count++;
				//	System.out.println(k+" "+i+" "+j);
					break label;
			}
			}
			
		}
		}
		return count;
	}
}
