package com;
import java.util.Scanner;
class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int test=1;test<=testcase;test++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			String s = sc.nextLine().trim();
			char[] ch = s.toCharArray();
			Pair position = new Pair(x,y);
			int res=0;
			for(int i=0;i<ch.length;i++){
				position  = position(ch[i],position);
				int j = i+1;
				if((mode(position.x) + mode(position.y))<=j){
					res=j;
					break;
				}
			}
			if(res!=0)
				System.out.println("Case #" + test + ": " + res);
			else
				System.out.println("Case #" + test + ": IMPOSSIBLE");
		}
		sc.close();
	}
	
	static Pair position(char c, Pair pos){
		if(c=='N'){
			pos.y+=1;
		}else if(c=='S'){
			pos.y-=1;
		}else if(c=='E'){
			pos.x+=1;
		}else{
			pos.x-=1;
		}
		return pos;
	}
	
	static int mode(int n){
		return (n>=0?n:-n);
	}
}
class Pair{
	int x;
	int y;
	Pair(int x, int y){
		this.x=x;
		this.y=y;
	}
}