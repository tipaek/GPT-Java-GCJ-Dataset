import java.util.Scanner;

public class CodeJam {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
	     Scanner s = new Scanner(System.in);
		int t,n,sum=0;
		t=s.nextInt();
		
		for(int z=0;z<t;z++) {
			sum=0;
			n=s.nextInt();
		int array[][]=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j =0;j<n;j++) {
				array[i][j]=s.nextInt();
			}
			 System.out.println();
		}
		for(int a=0;a<n;a++) {
			sum=sum+array[a][a];
		}	
		int temp,r_r=0,c_r=0,prev;
		for(int i=0;i<n;i++) {
			for(int j =0;j<n;j++) {
				temp=array[i][j];
				prev=r_r;
				for(int a=j+1;a<n;a++) {
				if(temp== array[i][a]) {
					r_r++;
					break;
				}
					}
				if(prev!=r_r) {
					break;
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				temp=array[j][i];
				prev=c_r;
				for(int a=j+1;a<n;a++) {
				if(temp== array[a][i]) {
					c_r++;
					break;
				}
					}
				if(prev!=c_r) {
					break;
				}
			}
		}	
			
			
		System.out.println("Case #"+(z+1)+": "+(sum)+" "+r_r+" "+c_r );	
		}
		
		

	}

}
