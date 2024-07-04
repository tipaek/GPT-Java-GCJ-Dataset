import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	static ArrayList<ArrayList<Integer>> C = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> J = new ArrayList<>();
	public static void main (String[] args) {
		
		int T;
		
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		
		for(int t=1;t<=T;t++){
			int N=sc.nextInt();
			ArrayList<ArrayList<Integer>> mat=new ArrayList<>();
			String op="";
			
			
			for(int i=0;i<N;i++) {
				ArrayList<Integer> temp=new ArrayList<>();
				int st=sc.nextInt();
				int et=sc.nextInt();
				temp.add(st);
				temp.add(et);
				mat.add(temp);
			}
			
			for(int i=0;i<N;i++) 
			{
				boolean b1=assign(mat.get(i),C);
				if(b1)
					op=op+"C";
				
				else {
					b1=assign(mat.get(i),J);
					if(b1)
						op=op+"J";
					else {
						op="IMPOSSIBLE";
						break;
					}
				}	
			}
			C.clear();
			J.clear();
			mat.clear();
			System.out.println("Case d#"+t+": "+op);
			
		}
	}
	static boolean assign(ArrayList<Integer> task_i, ArrayList<ArrayList<Integer>> temp) {
		if(temp.isEmpty()) {
			temp.add(task_i);
			return true;
		}
		else {
			for(int t_i=0 ; t_i<temp.size() ; t_i++) {
				if(task_i.get(0) < temp.get(t_i).get(1) && task_i.get(1) > temp.get(t_i).get(0) ) {
					return false;
				}
			}
			temp.add(task_i);
			return true;
		}
		
	}
}