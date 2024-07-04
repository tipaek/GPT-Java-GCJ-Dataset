import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		//System.out.println("test");
		int test=sc.nextInt();
		
		for(int t=0;t<test;t++){
			//System.out.println("n=?");
			int n=sc.nextInt();
			sc.nextLine();
			int[][] m=new int[n][n];
			int r=0;
			int c=0;
			for (int i=0;i<n;i++){
				//System.out.println("row "+i+"=");
				String[] s=sc.nextLine().split(" ");
				HashSet hsrow=new HashSet<Integer>();
				
				for (int j=0;j<n;j++){
					m[i][j]=Integer.parseInt(s[j]);
					hsrow.add(m[i][j]);
				}
				if(hsrow.size()<n){
					r++;
				}
				
			}
			int k=0;
			for(int i=0;i<n;i++){
				k+=m[i][i];
				HashSet hscol=new HashSet<Integer>();
				for (int j=0;j<n;j++){
					hscol.add(m[j][i]);
				}
				if(hscol.size()<n){
					c++;
				}
			}
			
			System.out.println("Case #"+(t+1)+": "+k+" "+r+" "+c);
			
		}

	}

}
