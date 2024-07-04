import java.util.*;
import java.io.*;
public class Solution{

	public static String solve(String P[]){
		String max = null ;
		int I = 0;
		for(int j =0;j<P.length;j++){
			String current = P[j];
			int i = current.indexOf('*');
			if(max == null){
				max = current;
				I = i;
			}else{
				String sub1 = current.substring(0,i);
				String sub2 = current.substring(i+1);
				String Sub1 = max.substring(0,I);
				String Sub2 = max.substring(I+1);
				if(sub1.contains(Sub1) || Sub1.contains(sub1)){
					if(sub1.contains(Sub1)){
						Sub1 = sub1;
					}
				}else{
					return "*";
				}
				if(sub2.contains(Sub2) || Sub2.contains(sub2)){
					if(sub2.contains(Sub2)){
						Sub2 = sub2;
					}
				}else{
					return "*";
				}
				max = Sub1 +"*"+Sub2;
				I = Sub1.length();
			}
		

		}
		I = max.indexOf('*');
		return max.substring(0,I) + max.substring(I+1);
	}
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int j = 1;
		while(j <= t){
			int n = Integer.parseInt(br.readLine());
			String[] P = new String[n];
			for(int i = 0;i<n;i++)
				P[i] = br.readLine();
			System.out.println("Case "+"#"+j+": "+solve(P));
			j++;
		}
	}
}