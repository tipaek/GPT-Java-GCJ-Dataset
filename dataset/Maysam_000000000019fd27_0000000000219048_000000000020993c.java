import javax.swing.JFrame;
import java.util.Scanner;
import java.awt.Container;
public class test {

	public static void main(String[] args) {

		Scanner input=new Scanner(System.in);
		int number = input.nextInt();
		int printing[][]=new int[number][3];
		for (int M=0;M<number;M++) {
			int size=input.nextInt();
			int m[][]=new int [size][size];
			int rr,rc,sum;
			boolean flagr=false;
			boolean flagc=false;
			rr=rc=sum=0;
			int compare=0;
			for(int i=0;i<size;i++) 
				for(int j=0;j<size;j++)
					m[i][j]=input.nextInt();
				
			
			for(int s=0;s<size;s++)sum+=m[s][s];
			
			for(int i=0;i<size;i++) 
				for(int j=0;j<size;j++) {
					compare=m[i][j];
					
					for(int k=j+1;k<size;k++) 
						if(compare == m[i][k]) {rr+=1;flagr=true;break;}
						
					
					
				if(flagr) {flagr=false;break;}
				}
			
			for(int i=0;i<size;i++) 
				for(int j=0;j<size;j++) {
					compare=m[j][i];
					
					for(int k=j+1;k<size;k++) 
						if(compare == m[k][i]) {rc+=1;flagc=true;break;}
					
					
					if(flagc) {flagc=false;break;}
					
				}
					
			
			
		printing[M][0]=sum;
		printing[M][1]=rr;
		printing[M][2]=rc;
		
		
		}
		for(int I=0;I<number;I++)
			System.out.printf("Case #%d: %d %d %d\n",I,printing[I][0],printing[I][1],printing[I][2]);
}

}