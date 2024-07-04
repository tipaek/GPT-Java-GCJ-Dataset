import java.util.*;

class Main
{
	public static void main (String[] args){
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		int c =1;
		while(t-- >0){
			int n= scn.nextInt();
			int[][] arr = new int[n][n];
			int row = 0;
			int col = 0;
			int dig = 0;
			
			for(int i=0;i<n;i++){
				boolean found = false;
				HashMap<Integer,Integer> map = new HashMap<>();
				for(int j=0;j<n;j++){
					arr[i][j] = scn.nextInt();
					if(map.containsKey(arr[i][j]) && found == false){row++;
					found = true;}
					else map.put(arr[i][j], 1);
				}
			}
			for(int i=0;i<n;i++){
				dig += arr[i][i];
			}
			for(int i=0;i<n;i++){
				HashMap<Integer,Integer> map = new HashMap<>();
				for(int j=0;j<n;j++){
					if(map.containsKey(arr[j][i])){
						col++;
						break;
					}else map.put(arr[j][i],1);
				}
			}
			
			System.out.println("Case #" +c+": "+dig+" "+row+" "+col);
			c++;
		}
		scn.close();
	}
}