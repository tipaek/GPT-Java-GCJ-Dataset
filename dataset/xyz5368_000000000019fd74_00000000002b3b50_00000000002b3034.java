import java.util.*;

class Compare implements Comparator<String>{
	public int compare(String s, String other){
		return -Integer.compare(s.length(), other.length());
	}
}

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0; i < t; i++){
			int s = in.nextInt();
			in.nextLine();
			String[] arr = new String[s];
			for(int j = 0; j < s; j++){
				arr[j] = in.nextLine().substring(1);
			}
			Arrays.sort(arr, new Compare());
			//System.out.println(Arrays.toString(arr));
			boolean flag = false;
			for(String str : arr){
				if(!arr[0].contains(str)){
					flag = true;
				}
			}
			if(flag){
				System.out.printf("Case #%d: *\n",i+1);
			}else
				System.out.printf("Case #%d: %s\n",i+1,arr[0]);
		}
	}

}
