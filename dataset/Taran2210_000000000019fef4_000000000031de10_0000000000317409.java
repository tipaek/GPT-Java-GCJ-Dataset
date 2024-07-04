import java.util.*;
public class Solution{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int T = Integer.parseInt(s.nextLine());
		
		for(int i=1;i<=T;i++){
			
			String line = s.nextLine();
			String[] arr = line.split(" ");
			int X = Integer.parseInt(arr[0]);
			int Y = Integer.parseInt(arr[1]);
			String path = arr[2];
			
			if(X>Y){
				System.out.println("Case #"+i+": "+"IMPOSSIBLE");
				continue;
			}
			double val = (X+Y)/2;
			int ans = (int) Math.round((X+Y+1)/2);
			int dis = 0;
			
			for(int j=0;j<path.length();j++){
				if(path.charAt(j)=='N') dis-=1;
				else dis+=1;
			}
			
			if(dis>=Y){
				System.out.println("Case #"+i+": "+ans);
			}else{
				System.out.println("Case #"+i+": "+"IMPOSSIBLE");
			}
			
		}

	}

}
