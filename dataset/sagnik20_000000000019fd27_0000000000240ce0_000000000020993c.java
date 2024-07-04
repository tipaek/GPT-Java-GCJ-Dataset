import java.util.*;
class Abc{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(),x=1;
		int num[][]=new int[100][100];
		for (int a=0;a<t;a++){
			int n=sc.nextInt();
			int k=0;
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					num[i][j]=sc.nextInt();
					if(i==j)
						k+=num[i][j];
				}
			}
			int r=dup_r(num,n);
			int c=dup_c(num,n);
			System.out.println("Case #"+(x++)+": "+k+" "+r+" "+c);
		}
	}

	static int dup_r(int a[][],int n){
		int r=0;
		for(int k=0;k<n;k++){
			for(int i=0,j=i+1; i<n-1;j++,i++){
				if(a[k][i]==a[k][j]){
					r++;
					break;
				}
			}
		}
		return r;
	}

	static int dup_c(int a[][],int n){
		int c=0;
		for(int k=0;k<n;k++){
			for(int i=0,j=i+1; i<n;j++,i++){
				if(a[i][k]==a[j][k]){
					c++;
					break;
				}
			}
		}
		return c;
	}
}
