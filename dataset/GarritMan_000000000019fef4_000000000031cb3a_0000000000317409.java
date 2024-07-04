import java.util.Scanner;

public class Solution{
	public static void main(String[] args){
		Scanner in =new Scanner(System.in);
		
		int T=Integer.parseInt(in.nextLine());
		
		for(int i=0;i<T;i++){
			String line=in.nextLine();
			
			int X=Integer.parseInt(line.split(" ")[0]);
			int Y=Integer.parseInt(line.split(" ")[1]);
			
			String[] path=line.split(" ")[2].split("");
			
			System.out.println("Case #"+(i+1)+": "+solve(path,X,Y));
		}
		
		//Check after each step how long does it take peppur to get there.
		//How long does it take me to get there
		//If my time less than or equal to peppers time. Then we meet after peppers time to get there
		//Compare end min time
	}
	
	public static String solve(String[] path,int X,int Y){
		
		int pepperTime=0;		
		int minTime=2000;
		
		int myTime=2000;
		
		for(int i=0;i<path.length;i++){
			pepperTime++;
			if(path[i].equals("N")){
				Y+=1;
			}else if (path[i].equals("S")){
				Y-=1;
			}else if (path[i].equals("E")){
				X+=1;
			}else if (path[i].equals("W")){
				X-=1;
			}
			
			myTime=timeToPepp(X,Y);
			
			if(myTime<=pepperTime){
				if(pepperTime<minTime){
					minTime=pepperTime;
				}
			}
		}
		
		String ans;
		if(minTime==2000){
			ans="IMPOSSIBLE";
		}else{
			ans=minTime+"";
		}
		
		return ans;
		
	}
	
	public static int timeToPepp(int X,int Y){
		int XX= X<0?(-1)*X:X;
		int YY= Y<0?(-1)*Y:Y;
		
		return XX+YY;
	}
}