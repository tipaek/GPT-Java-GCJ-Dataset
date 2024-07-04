import java.util.Scanner;

public class Solution{
	public static void main(String[] args){
		Scanner in =new Scanner(System.in);
		
		int T=Integer.parseInt(in.nextLine());
		
		for(int i=0;i<T;i++){
			int N=Integer.parseInt(in.nextLine());
			
			int[][] act=new int[N][2];
			
			for(int j=0;j<N;j++){
				String[] line=in.nextLine().split(" ");
				act[j][0]=Integer.parseInt(line[0]);
				act[j][1]=Integer.parseInt(line[1]);
			}
			
			System.out.println("Case #"+(i+1)+": "+solve(act));
		}
	}
	
	public static String solve(int[][] act){
		String ans="";
		
		
		int[] psum=new int[24*60 +1 ];
		
		for(int i=0;i<act.length;i++){
			
			psum[act[i][0]]++;
			psum[act[i][1]]--;
		}
		
		for(int i=1;i<psum.length;i++){
			psum[i]+=psum[i-1];
		}
		
		int maxP=0;
		for(int i=0;i<psum.length;i++){
			if(psum[i]>maxP){
				maxP=psum[i];
			}
		}
		
		if(maxP>2){
			return "IMPOSSIBLE";
		}
		
		boolean cbusy=false;
		boolean jbusy=false;
		int cdoing=-1;
		int jdoing=-1;
		
		String[] ansArr=new String[act.length];
		
		for(int i=0;i<act.length;i++){
			
		}
		
		for(int i=0;i<psum.length;i++){
			for(int j=0;j<act.length;j++){
				if(act[j][0]==i){
					if(!cbusy){
						cbusy=true;
						cdoing=j;
						//ans+="C";
						ansArr[j]="C";
					}else{
						jbusy=true;
						//ans+="J";
						jdoing=j;
						ansArr[j]="J";
					}
				}
				if(act[j][1]==i){
					if(cdoing==j){
						cbusy=false;
						cdoing=-1;
					}else{
						jbusy=false;
						jdoing=-1;
					}
				}
				
				
				
			}
		}
		
		for(int i=0;i<ansArr.length;i++){
			ans+=ansArr[i];
		}
		
		
		return ans;
	}
}