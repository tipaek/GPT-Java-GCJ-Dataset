package teest;

public class matrix {
int x=0,k=0,r,c;
	public int trace_matrix(int [][]arr) {
		for(int i =0; i<arr.length;i++) {
			k+=arr[i][i];
		}
		return k;	
	}
	public int repeat_row(int [][]arr) {
		int temp =0;
		boolean f = false;
		for (int i=0 ; i<arr.length;i++) {
			for (int j=0;j<arr.length;j++) {
				temp=arr[i][j];
				int z=j;
				while(z<arr.length) {
					if(temp==arr[i][z]) {
						r++;
						f=true;
						break;
					}
					z++;
				}
				if(f) {
					f=false;
					break;
				}
					
			}
		}
		return c;	
	}
	public int repeat_colomn(int [][]arr) {
		int temp =0;
		boolean f = false;
		for (int i=0 ; i<arr.length;i++) {
			for (int j=0;j<arr.length;j++) {
				temp=arr[i][j];
				int z=i;
				while(z<arr.length) {
					if(temp==arr[z][j]) {
						c++;
						f=true;
						break;
					}
				}
				if(f) {
					f=false;
					break;
				}
					
			}
		}
		return c;	
	}
}
