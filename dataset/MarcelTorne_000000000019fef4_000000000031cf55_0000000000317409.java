  
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i=1;i<=t;++i) {
			int x = in.nextInt();
			int y = in.nextInt();
			String path = in.next();
			int sol = findSolution(x,y,path);
			if(sol<=0) {
				System.out.println("Case #"+i+": "+"IMPOSSIBLE");
			}else {
				System.out.println("Case #"+i+": "+sol);
			}
			
		}
	}
	public static int findSolution(int x, int y, String path) {
		
		if(x==0&&y==0) {
			return 0;
		}
		if(path.isEmpty()) {
			return -1;
		}
		switch(path.charAt(0)) {
		case 'N':{
			y++;
		}
		case 'S':{
			y--;
		}
		case 'W':{
			x++;
		}
		case'E':{
			x--;
		}
		}
		//System.out.println(path.charAt(0));
		//System.out.println(x+" "+y);
		String nextPath = path.substring(1);
		int standing =  findSolution(x,y,nextPath);
		//System.out.println(path.charAt(0)+" "+standing);
		int upx =findSolution(x-1,y,nextPath);
		
		int downx = findSolution(x+1,y,nextPath);
		
		//System.out.println(closerx);
		int upy = findSolution(x,y-1,nextPath);
		
		int downy = findSolution(x,y+1,nextPath);
		
		if(standing==-1&&upx==-1&&downx==-1&&upy==-1&&downy==-1) {
			return -1;
		}
		if(standing==-1) {
			standing = Integer.MAX_VALUE;
		}
		if(upx == -1) {
			upx = Integer.MAX_VALUE;
		}
		if(downx == -1) {
			downx = Integer.MAX_VALUE;
		}
		if(upy == -1) {
			upy = Integer.MAX_VALUE;
		}
		if(downy == -1) {
			downy = Integer.MAX_VALUE;
		}
		int sol = 1+Math.min(standing, Math.min(Math.min(upx,downx), Math.min(upy, downy)));
		return sol;
		}
	}
	

