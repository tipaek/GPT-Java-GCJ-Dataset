import java.util.*;

class Solution{
    
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
		
		for(int i=0;i<t;i++) {
			
			int n=sc.nextInt();
			int matrix[][]=new int[n][n];
			for(int j=0;j<n;j++){
			    for(int k=0;k<n;k++){
			        matrix[j][k]=sc.nextInt();
			    }
			}
			
			int rowc=0;
			int colc=0;
			int trace=0;
			for(int j=0;j<n;j++) {
				boolean flagr=false;
				boolean flagc=false;
				Set<Integer> row=new HashSet<>();
				Set<Integer> col=new HashSet<>();
				trace+=matrix[j][j];
				for(int k=0;k<n;k++) {
					if(flagr && flagc)
						break;
					if(!row.add(matrix[j][k]) && !flagr) {
						rowc++;
						flagr=true;
					}
					if(!col.add(matrix[k][j]) && !flagc) {
						colc++;
						flagc=true;
					}
						
				}
				
			}
			System.out.println("Case #"+(i+1)+": "+trace+" "+rowc+" "+" "+colc);
		}
    }
}