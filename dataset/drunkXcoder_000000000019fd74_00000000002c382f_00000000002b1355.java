import java.io.*;
public class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		int c1=1;
		while(c1<=t) {
			String str[]=(br.readLine()).trim().split("\\s+");
			int r=Integer.parseInt(str[0]);
			int c=Integer.parseInt(str[1]);
			int arr[][]=new int[r][c];
			int check[][]=new int[r][c];
			for(int i=0;i<r;i++) {
				 str=(br.readLine()).trim().split("\\s+");
				 for(int j=0;j<c;j++) {
					 arr[i][j]=Integer.parseInt(str[j]);
				     check[i][j]=0;
				 }
			}
			int res=0;
			boolean flag=true;
			while(flag) {
				//removing low skilled candidates
				int  sum=0;
				for(int i=0;i<r;i++) {
					 for(int j=0;j<c;j++) {
						 if(arr[i][j]!=-1)
						 sum+=arr[i][j];
					 }
				}
				res+=sum;
				int remove=0;
				for(int i=0;i<r;i++) {
					for(int j=0;j<c;j++) {
						int skill=arr[i][j];
						//top
						if(skill!=-1) {
						int temp=0;
						int cc=0;
						for(int k=i-1;k>=0;k-- ) {
							if(arr[k][j]==-1)
								continue;
							else {
									temp+=arr[k][j];
							cc+=1;	 
							break;
							}
							}
						//down
						for(int k=i+1;k<r;k++ ) {
							if(arr[k][j]==-1)
								continue;
							else {
									temp+=arr[k][j];
							 cc+=1;
							 break;
							}
							}
						//left
						for(int k=j-1;k>=0;k-- ) {
							if(arr[i][k]==-1)
								continue;
							else {
									temp+=arr[i][k];
								   cc+=1 ;
							   break;
							}
							
							}
						
						//right
						for(int k=j+1;k<c;k++ ) {
							if(arr[i][k]==-1)
								continue;
							else {
									temp+=arr[i][k];
							   cc+=1;	
							break;
							}
							}
						skill=skill*cc;
						if(temp>skill) {
							check[i][j]=1;
							remove+=1;
						}
						}
						
					}
				}
				for(int i=0;i<r;i++) {
					for(int j=0;j<c;j++) {
						if(check[i][j]==1)
							arr[i][j]=-1;
					}
				}
				//System.out.println("out of loop");
				if(remove==0)
					flag=false;
			}
			System.out.println("Case #"+c1+":"+" "+res);
			c1++;
			
		}
	}

}
