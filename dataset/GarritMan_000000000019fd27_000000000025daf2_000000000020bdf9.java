import java.util.Scanner;

public class Solution{
	public static void main(String[] args){
		Scanner in =new Scanner(System.in);
		
		int T=Integer.parseInt(in.nextLine());
		
		for(int i=0;i<T;i++){
			int N=Integer.parseInt(in.nextLine());
			
			int[][] act=new int[N][3];
			
			for(int j=0;j<N;j++){
				String[] line=in.nextLine().split(" ");
				act[j][0]=Integer.parseInt(line[0]);
				act[j][1]=Integer.parseInt(line[1]);
				act[j][2]=j;
			}
			
			System.out.println("Case #"+(i+1)+": "+solve2(act));
		}
	}
	
	public static String solve2(int[][] act){
		String ans="";
		
		int[][] actSort=new int[act.length][act[0].length+1];
		for(int i=0;i<act.length;i++){
			actSort[i][0]=act[i][0];
			actSort[i][1]=act[i][1];
			actSort[i][2]=act[i][2];
		}
		
		java.util.Arrays.sort(actSort, new java.util.Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[1], b[1]);
			}
		});
		
		//printArr(actSort);
		
		int[] cx=new int[2];
		cx[0]=-1;
		cx[1]=-1;
		int[] jx=new int[2];
		jx[0]=-1;
		jx[1]=-1;
		
		for(int i=0;i<actSort.length;i++){
			int[] acti=actSort[i];
			
			if(cx[1]<=acti[0] && jx[1]<=acti[0]){
				if(cx[1]>jx[1]){
					cx[0]=acti[0];
					cx[1]=acti[1];
					acti[3]=0;
				}else{
					jx[0]=acti[0];
					jx[1]=acti[1];
					acti[3]=1;
				}
			}else if(cx[1] <=acti[0]){
				cx[0]=acti[0];
				cx[1]=acti[1];
				acti[3]=0;
			}else if(jx[1]<=acti[0]){
				jx[0]=acti[0];
				jx[1]=acti[1];
				acti[3]=1;
			}else{
				return "IMPOSSIBLE";
			}
			
		}
		
		for(int i=0;i<act.length;i++){
			for(int j=0;j<act.length;j++){
				if(actSort[j][2]==i){
					if(actSort[j][3]==0){
						ans+="C";
					}else{
						ans+="J";
					}
				}
			}
		}
		
		
		
		return ans;
	}
	
	public static void printArr(int[][] mat){
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[i].length;j++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
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