import java.util.*;
public class codejam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int test=scan.nextInt();
		int i=0,j=0,k=0;
		int sum=0,cflag=0,ccount=0,rflag=0,rcount=0;
		int[][] matrix;
		HashSet<Integer> ele1=new HashSet<Integer>();
		HashSet<Integer> ele2=new HashSet<Integer>();
		
		for(k=0;k<test;k++) {
			int n=scan.nextInt();
			matrix=new int[n][n];
			sum=0;rcount=0;ccount=0;
			for(i=0;i<n;i++) {
				for(j=0;j<n;j++) {
					matrix[i][j]=scan.nextInt();
					}
				}
			for(i=0;i<n;i++) {
				rflag=0;cflag=0;
				for(j=0;j<n;j++) {
					
					if(i==j) {
						sum+=matrix[i][j];
					}
					if(ele1.add(matrix[i][j])){
						
					}
					else{
						
						rflag=1;
					}
					if(ele2.add(matrix[j][i])){
						
					}
					else {
						
						cflag=1;
					}
					
						
					}
				
				if(rflag==1) {
					rcount+=1;
				}
				if(cflag==1) {
					ccount+=1;
				}
				ele1.clear();
				ele2.clear();
				
				
			}
			System.out.println("case #"+(k+1)+":"+sum+" "+rcount+" "+ccount);
			
		}
		
		scan.close();
	}
	
}
