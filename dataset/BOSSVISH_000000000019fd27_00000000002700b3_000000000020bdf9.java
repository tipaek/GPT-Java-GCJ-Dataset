

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

class task{
	int start;
	int end;
}
class comp implements Comparator<task>{

	@Override
	public int compare(task arg0, task arg1) {
		return arg0.start-arg1.start;
	}
	
}
public class Solution {
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=1;i<=t;i++){
			int n=s.nextInt();
			task arr[]=new task[n];
			for(int j=0;j<n;j++){
				task curr=new task();
				curr.start=s.nextInt();
				curr.end=s.nextInt();
				arr[j]=curr;
			}
			Arrays.sort(arr, new comp());
			int C=-1;
			int J=-1;
			String ans="";
			for(int j=0;j<n;j++){
				task temp=arr[j];
				if(C!=-1&&C<=temp.start){
					C=-1;
				}
				if(J!=-1&&J<=temp.start){
					J=-1;
				}
				if(C==-1){
					C=temp.end;
					ans+="C";
				}
				else if(J==-1){
					J=temp.end;
					ans+="J";
				}
				else{
					ans="IMPOSSIBLE";
					break;
				}
			}
			System.out.println("Case #"+i+": "+ans);
		}
	}
}
