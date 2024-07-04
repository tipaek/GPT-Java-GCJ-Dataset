
import java.util.*;
public class Solution{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int T = Integer.parseInt(s.nextLine());
		
		for(int i=1;i<=T;i++){
			
			String line = s.nextLine();
			String[] arr = line.split(" ");
			int N = Integer.parseInt(arr[0]);
			int D = Integer.parseInt(arr[1]);
			

			String line2 = s.nextLine();
			String arr2[] = line2.split(" ");
			
			HashMap<Double,Integer> map = new HashMap<Double, Integer>();
	
			double ang[] = new double[N];
			int max=0;
			
			for(int j=0;j<N;j++){
				ang[j] = Long.parseLong(arr2[j]);
				if(map.containsKey(ang[j])){
					int val = map.get(ang[j])+1;
					max = Math.max(max, val);
					map.put(ang[j], val);
				}else{
					map.put(ang[j],1);
				}
			}
			
			int ans = 1;
			
			if(N==1) ans=D-1;
			if(D<=max){
				ans=0;
			}
			
			System.out.println("Case #"+i+": "+ans);
			
	
			
		}

	}

}
