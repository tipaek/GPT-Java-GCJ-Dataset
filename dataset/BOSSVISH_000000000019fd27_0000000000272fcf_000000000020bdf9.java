

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

class task{
	int start;
	int end;
	int pos;
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
				curr.pos=j;
				arr[j]=curr;
			}
			Arrays.sort(arr, new comp());
			int C=-1;
			int J=-1;
			boolean poss=true;
			char ans[]=new char[n];
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
					ans[temp.pos]='C';
				}
				else if(J==-1){
					J=temp.end;
					ans[temp.pos]='J';
				}
				else{
					poss=false;
					break;
				}
			}
			String ansStr="";
			if(!poss){
				ansStr="IMPOSSIBLE";
			}
			else{
				for(char k:ans){
					ansStr+=k;
				}
			}
			System.out.println("Case #"+i+": "+ansStr);
		}
	}
}
