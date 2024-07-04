import java.util.Scanner;

class Soluction {
	public static int diagonal(int [][] arr){
		int sum=0;
		for(int i=0;i<arr.length;i++){
		sum=sum+arr[i][i];
		}
		return sum;
    }

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int cas=sc.nextInt();
                String [] ou=new String[cas];
		for(int i=0;i<cas;i++){
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
		ou[i]="Case #"+i+": "+dia+" "+row+" "+col;

	}
         for(int i=0;i<cas;i++){
           System.out.println(ou[i]);}

}

	private static int row_num(int[][] arr) {
		int count=0;
		for(int k=0;k<arr.length;k++) {
	label:	for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr[0].length;j++) {
				if(arr[k][i]==arr[k][j]) {
					count++;
					//System.out.println(k+" "+i+" "+j);
					break label;
			}
			}
		}
		}
		return count;
	}

	private static int coloumn(int[][] arr) {
		int count=0;
		for(int k=0;k<arr.length;k++) {
	label:	for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr[0].length;j++) {
				if(arr[i][k]==arr[j][k]) {
					count++;
					//System.out.println(k+" "+i+" "+j);
					break label;
			}
			}
			
		}
		}
		return count;
	}
}
