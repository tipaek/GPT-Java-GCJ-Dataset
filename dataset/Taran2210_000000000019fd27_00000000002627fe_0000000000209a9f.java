
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		
		for(int i =1;i<=T;i++){
			String a = s.next();
			int[] arr = new int[a.length()];
			int k =0;
			for(char c : a.toCharArray()){
				arr[k++] = Integer.parseInt(Character.toString(c));
			}
			
			StringBuilder sb = new StringBuilder();
			
			int prev=0 , curr=0 , end=0;
			
			for(int j = 0; j<arr.length;j++){
				curr = arr[j];
				if(prev<curr){
					for(k=0;k<curr-prev;k++){
						sb.append("(");
					}
				}
				else{
					for(k=0;k<prev-curr;k++){
						sb.append(")");
					}
				}
				
				sb.append(arr[j]);
				
				prev=curr;
				
			}
			
			for(k=0;k<prev-end;k++){
				sb.append(")");
			}
			
			
			System.out.println("Case #"+i+": "+sb.toString());
		}
	}

}
