//package competitve_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Random; 
public class Solution {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int test=input.nextInt();
		int i=0;
		while(test>0) {
			test--;
			int x=input.nextInt();
			int y=input.nextInt();
			System.out.print("Case #"+(i+1)+": ");
			int a=finder(0,0,x,y,0);
			System.out.println();
			i++;
		}
		
	}
	static int finder(int a,int b,int x,int y,int i) {
		if(x%2==0||y%2==0) {
			if(x==0&y%2==0) {
				System.out.print("IMPOSSIBLE");
				return 0;
			}else if(x%2==0&y==0) {
				System.out.print("IMPOSSIBLE");
				return 0;
			}else if(x%2==0&y%2==0) {
				System.out.print("IMPOSSIBLE");
				return 0;
			}else if(x!=0&y!=0&x%2==0||y%2==0) {
				System.out.print("IMPOSSIBLE");
				return 0;
			}
		}
		if(x==0) {
			if(y<0) {
				int tempy=y-1;
				int itr=find2(tempy);
				for(int i1=0;i1<itr;i1++) {
					System.out.print("S");
				}
				return 1;
			}else {
				int tempy=y+1;
				int itr=find2(tempy);
				for(int i1=0;i1<itr;i1++) {
					System.out.print("N");
				}
				return 1;
			}
		}else if(y==0) {
			if(x<0) {
				int tempx=x-1;
				int itr=find2(tempx);
				for(int i1=0;i1<itr;i1++) {
					System.out.print("W");
				}
				return 1;
				//return south(x,y,a,b,Math.pow(2, i+1));
			}else {
				int tempx=x+1;
				int itr=find2(tempx);
				for(int i1=0;i1<itr;i1++) {
					System.out.print("E");
				}
				return 1;
			}
		}
		else {
			int tempx=x;
			int tempy=y;
			if(x<0) {
				tempx-=1;
			}else if(x>0) {
				tempx+=1;
			}
			if(y<0) {
				tempy-=1;
			}else if(y>0) {
				tempy+=1;
			}
			if(tempx<0) {
				int itr=find2(tempx);
				for(int i1=0;i1<itr;i1++) {
					System.out.print("W");
				}
				if(tempy<0) {
					int itr1=find2(tempy);
					for(int i2=0;i2<itr1;i2++) {
						System.out.print("S");
					}
				}
				else {
					int itr1=find2(tempy);
					for(int i2=0;i2<itr1;i2++) {
						System.out.print("N");
					}
				}
				return 1;
			}else {
				int itr=find2(tempx);
				for(int i1=0;i1<itr;i1++) {
					System.out.print("E");
				}
				if(tempy<0) {
					int itr1=find2(tempy);
					for(int i2=0;i2<itr1;i2++) {
						System.out.print("S");
					}
				}
				else {
					int itr1=find2(tempy);
					for(int i2=0;i2<itr1;i2++) {
						System.out.print("N");
					}
				}
				return 1;
			}
			
		}
	}
	static int find2(int a) {
		int x=1;
		int i=0;
		if(a<0) {
			a=a*(-1);
		}
		while(a!=x) {
			i++;
			x=x*2;
		}
		return i;
	}


}
