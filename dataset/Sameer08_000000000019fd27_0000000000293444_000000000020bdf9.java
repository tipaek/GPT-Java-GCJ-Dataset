import java.util.HashSet;
import java.util.Scanner;
import java.util.Arrays;

public class Solution {

	public static void main(String...ss) {
	Scanner s = new Scanner(System.in);
	int t1 = s.nextInt();
	int k = 1;
	while (t1-- != 0) {
	String output="";
	int task=s.nextInt();
	int[] arrC=new int[1441];
	int[] arrJ=new int[1441];
	
	while(task--!=0){
		
	int start=s.nextInt();
	int end=s.nextInt();
	//System.out.println(start+" "+end+" "+arrJ[start]+" "+arrJ[end]);
	if (arrJ[start]!=1&&arrJ[end]!=1){
	output=output+'J';
	Arrays.fill(arrJ, start,end,1);
	}
	else if (arrC[start]!=1&&arrC[end]!=1){
	output=output+'C';
	Arrays.fill(arrC, start,end,1);
	}
	else {output="IMPOSSIBLE";
	break;}
	}
	
	System.out.print("Case #" + k++ + ": " + output);
	System.out.println();
}
}
}