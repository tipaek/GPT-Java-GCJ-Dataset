import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	static ArrayList<ArrayList<Integer>> C = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> J = new ArrayList<>();
	static	ArrayList<ArrayList<Integer>> mat=new ArrayList<>();
	public static void main (String[] args) {
		
		int T;
		
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		ArrayList<ArrayList<Integer>> org=new ArrayList<>();
		for(int t=1;t<=T;t++){
			int N=sc.nextInt();
			
			String op="";
			
			
			for(int i=0;i<N;i++) {
				ArrayList<Integer> temp=new ArrayList<>();
				int st=sc.nextInt();
				int et=sc.nextInt();
				temp.add(st);
				temp.add(et);
				mat.add(temp);
				org.add(temp);
			}
			//System.out.println(mat);
			sort(mat);
			//System.out.println(mat);
			
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
			//System.out.println(C);
			//System.out.println(J);
			String outp="";
			if(!op.equals("IMPOSSIBLE")) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(org.get(i).get(0)==mat.get(j).get(0) && org.get(i).get(1)==mat.get(j).get(1))
						{
							outp=outp+op.charAt(j);
						}
					}
				}
				
			}
			else {
				outp=op;
			}
				System.out.println("Case #"+t+": " +outp);
			C.clear();
			J.clear();
			mat.clear();
			org.clear();
		}
	}
	
	static void sort(ArrayList<ArrayList<Integer>> temp) {
		for(int i=0;i<temp.size()-1;i++) {
			for(int j=i+1;j<temp.size();j++) {
				if(temp.get(i).get(0)>temp.get(j).get(0)) {
					ArrayList<Integer> tmp=temp.get(j);
					temp.set(j,temp.get(i));
					temp.set(i,tmp);
				}
			}
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