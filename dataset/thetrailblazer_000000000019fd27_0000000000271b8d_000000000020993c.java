import java.util.Scanner;
public class LatinSquare {
	

	public static void main(String[] args) {
		int arr[][];
		
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the number of test cases you want");
		int test=scanner.nextInt();
		
		for(int m=0;m<test;m++) {
			int sum=0;
			int count=0;
			int count2=0;
		System.out.println("enter the no. of rows and columns");
		int n=scanner.nextInt();
		arr=new int[n][n];
		for(int i=0;i<n;i++){
		    for(int j=0;j<n;j++){
		        System.out.println("enter a value between 1 and"+" "+ n);
		        int num=scanner.nextInt();
		        if(num>n||num<1) {
		        	System.out.println("please enter a number between 1 and"+" "+n);
		        	j--;
		        	continue;
		        }
		        arr[i][j]=num;
		        
		    }
		}
		for(int a=0;a<n;a++){
		    for(int b=0;b<n;b++){
		        System.out.print(arr[a][b]);
		    }
		    System.out.println();
		}
		for(int x=0;x<n;x++) {
			for(int y=0;y<n;y++) {
				if(x==y) {
					sum=sum+arr[x][y];
				}
			}
		}
		
		int aa=0;
		int z=0;
		for(int s=0;s<n;s++) {
			for(int t=0;t<n;t++) {
				int temp=arr[s][t];
				for(int k=0;k<n;k++) {
					if(k==t)
						continue;
					if(temp==arr[s][k]) {
						 count++;
						 aa=1;
						break;
					}
				}
			if (aa==1){
				aa=0;
				break;
			}
				
			}
		}
		
		
		
		for(int r=0;r<n;r++) {
			for(int c=0;c<n;c++) {
				int temp2=arr[c][r];
				for(int l=0;l<n;l++) {
					if(l==c)
						continue;
					if(temp2==arr[l][r]) {
						count2++;
						z=1;
						break;
					}
				}
							
			if(z==1) {
				z=0;
				break;
			}
			}
		}
		
		System.out.println("Case #"+(m+1)+":"+" "+sum+" "+count+" "+count2);
			
}
	}

}
		

