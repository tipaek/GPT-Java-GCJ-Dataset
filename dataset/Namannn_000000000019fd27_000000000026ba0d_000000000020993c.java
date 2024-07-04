import java.io.*;
import java.util.*;

class Vesti{
    int t,n;
    void pro(){
        Scanner scan = new Scanner(System.in);
        t = scan.nextInt();
		int[] trace = new int[t];
		int[] row = new int[t];
		int[] col = new int[t];
		String sr;
        for(int i=1;i<=t;i++){
            n = scan.nextInt();
			int[][] m = new int[n][n];
			trace[i-1] = 0;
			row[i-1] = 0;
			col[i-1] = 0;
			String[] sc = new String[n];
			boolean[] colc = new boolean[n];
			Arrays.fill(colc, Boolean.FALSE);
			Arrays.fill(sc, "");
			/*for(int z=0;z<n;z++){
				sc[z]="";
				colc[z]=false;
			}*/
            for(int j=0;j<n;j++){
				sr="";
				boolean rowc = false;
				for(int k=0;k<n;k++){
					m[j][k]=scan.nextInt();
					/*if(j==0&&k==0){
						//sc[k]="";
						//colc[k]=false;
					}*/
					if(!rowc){
						if(sr.contains(String.valueOf(m[j][k]))){
							row[i-1]++;
							rowc=true;
						}
					}
					if(!colc[k]){
						if(sc[k].contains(String.valueOf(m[j][k]))){
							col[i-1]++;
							colc[k]=true;
						}
					}
					sr=sr+String.valueOf(m[j][k]);
					sc[k]=sc[k]+String.valueOf(m[j][k]);
					if(j==k)
						trace[i-1] += m[j][k];
					
				}
            }
			
        }
		for(int i=0;i<t;i++){
			System.out.println("Case #"+t+" :"+trace[i]+" "+row[i]+" "+col[i]);
		}
        
    }
}
class Vestii{
		public static void main(String args[]){
			Vesti v = new Vesti();
			v.pro();
		}
}