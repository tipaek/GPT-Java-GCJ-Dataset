import java.io.*;
public class Solution{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t=Integer.parseInt(br.readLine());
		int kse=0;
		while(t>0){
			int n=Integer.parseInt(br.readLine());
			int[][] a=new int[n][n];
			int cs=0;
			while(n>0){
				String m=br.readLine();
				String[] m1=m.split(" ");
				for(int i=0;i<m1.length;i++){
					a[cs][i]=Integer.parseInt(m1[i]);
				}
				n--;
				cs++;
			}
			int ts=0;
			int row=0;
			int column=0;
			for(int i=0;i<a.length;i++){
				boolean flag1=false;
				boolean flag2=false;
				for(int j=0;j<a.length;j++){
					if(i==j) {
						ts+=a[i][j];
					}
					int cl=a[j][i];
					int rw=a[i][j];
					for(int k=j+1;k<a.length&&flag1==false;k++){
						if(rw==a[i][k]) {
							row++;
							flag1=true;
						}
					}
					for(int k=j+1;k<a.length&&flag2==false;k++){
						if(cl==a[k][i]) {
							column++;
							flag2=true;
						}
					}
				}
			}
			t--;
			kse++;
			bw.write("case #"+kse+": "+ts+" "+row+" "+column+"\n");
		}
		br.close();
		bw.close();
	}
}