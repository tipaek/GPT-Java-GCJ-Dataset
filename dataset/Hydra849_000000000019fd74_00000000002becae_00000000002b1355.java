import java.util.*;
import java.io.*;
public class Solution{
	public static void main(String[]args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		for(int i=1;i<=t;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			
			Dancer [][]dancers = new Dancer[r][c];
			for(int j=0;j<r;j++) {
				String[]sc = bf.readLine().split(" ");
				
				for(int k=0;k<c;k++) {
					
					dancers[j][k]= new Dancer(Integer.parseInt(sc[k]));
					
				}
			}
			int interest=0;
			boolean going=true;
			do {
				for(int j=0;j<r;j++) {
					for(int k=0;k<c;k++) {
						if(dancers[j][k].active) {
							interest+=dancers[j][k].skill;
						}
					}
				}
				int changes=0;
				for(int j=0;j<r;j++) {
					for(int k=0;k<c;k++) {
						if(dancers[j][k].active) {
							
						
						dancers[j][k].setAve(findNeighborAverage(dancers,j,k));
						if(dancers[j][k].skill<dancers[j][k].neighAve) {
							changes++;
							
						}
						}
						}
				}
				for(int j=0;j<r;j++) {
					for(int k=0;k<c;k++) {
						
						if(dancers[j][k].skill<dancers[j][k].neighAve) {
							dancers[j][k].active=false;
							
						}
					}
				}
				
				if(changes==0) {
					going=false;
				}
				
			}while(going);
			
			
			System.out.println("Case #"+i+": "+interest);
			
			
	      
	        
	        
	       
		}
	}
		public static double findNeighborAverage(Dancer[][]a, int r, int c) {
			int sum=0;
			double count=1;
			for(int i=0;i<a.length;i++) {
				if(i!=r&&a[i][c].active) {
					sum+=a[i][c].skill;
					count++;
				}
			}
			for(int i=0;i<a[r].length;i++) {
				if(i!=c&&a[r][i].active) {
					sum+=a[r][i].skill;
					count++;
				}
			}
			sum+=a[r][c].skill;
			
			return sum/count;
			
			
		}
	
	
}
class Dancer{
	boolean active;
	int skill;
	double neighAve;
	public Dancer(int a) {
		skill=a;
		active=true;
	}
	void setAve(double a){
		neighAve=a;
	}
}