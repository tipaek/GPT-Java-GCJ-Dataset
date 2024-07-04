import java.util.Scanner;

public class Solution{
	public static void main(String[] args){
		Scanner in =new Scanner(System.in);
		
		int T=Integer.parseInt(in.nextLine());
		
		for(int i=0;i<T;i++){
			String line=in.nextLine();
			int N=Integer.parseInt(line.split(" ")[0]);
			int D=Integer.parseInt(line.split(" ")[1]);
			
			String[] pieces=in.nextLine().split(" ");
			
			int mxcnt=-1;
			
			for(int z=0;z<pieces.length;z++){
				int P=Integer.parseInt(pieces[z]);
				int cnt=0;
				for(int a=0;a<pieces.length;a++){
					if(a==z){
						
					}else{
						if(Integer.parseInt(pieces[a])==P){
							cnt++;
						}
					}
				
				}
				
				if(cnt>mxcnt){
					mxcnt=cnt;
				}
			}
			
			int finalAns=-1;
			if(mxcnt==D){
				finalAns=0;
			}else if(mxcnt==D-1){
				finalAns=1;
			}else if(mxcnt==D-2){
				finalAns=2;
			}else if(mxcnt==D-3){
				finalAns=3;
			}
			
			
			
			System.out.println("Case #"+(i+1)+": "+finalAns);
		}
	}
	
	
}