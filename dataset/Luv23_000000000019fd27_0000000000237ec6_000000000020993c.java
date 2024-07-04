import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
			Scanner sc= new Scanner(System.in);    
			int t= sc.nextInt();  
			int n= sc.nextInt();  
			int trace=0;
			int col=0;
			int row=0;
			int flag =0;
			int flag1=0;
			
			for(int i=0;i<t;i++) {
				
				int [][] max=new int[n][n];
				
				for(int a=0; a<n;a++) {
					for(int b=0;b<n;b++) {
						max[a][b] = sc.nextInt(); 
						for(int r=0;r<b;r++) 
							if(max[a][b]==max[a][r] && flag==0) {
								row+=1;
								flag=1;
							}
						if(a==b)
							trace+=max[a][b];
					}
					flag=0;
				}
				
					for(int y=0;y<n;y++)
						for(int c=1;c<n;c++) 
							if(max[0][y]==max[c][y] ) {
								col+=1;
								break;
							}
							
					System.out.println("Case #"+(i+1)+":" +" "+trace+" "+row+" "+col);		
			}
			
			
		

	}

}
