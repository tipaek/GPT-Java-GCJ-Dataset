 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i=1;i<=t;++i) {
			int x = in.nextInt();
			int y = in.nextInt();
			String path = in.next();
			int sol = findSolutionPos(0,0,x,y,path);
			if(sol<=0) {
				System.out.println("Case #"+i+": "+"IMPOSSIBLE");
			}else {
				System.out.println("Case #"+i+": "+sol);
			}
			
		}
	}
public static int findSolutionPos(int myposx, int myposy, int x, int y, String path) {
		//System.out.println(myposx+" "+myposy);
		//System.out.println(x+" "+y);
		if(x==myposx&&y==myposy) {
			return 0;
		}
		if(path.isEmpty()) {
			return -1;
		}
		switch(path.charAt(0)) {
			case 'N':{
				y++;
				break;
			}
			case 'S':{
				y--;
				break;
			}
			case 'W':{
				x--;
				break;
			}
			case'E':{
				x++;
				break;
			}
		}
		
		String nextPath = path.substring(1);
		int standing =  findSolutionPos(myposx,myposy,x,y,nextPath);
		int upx =findSolutionPos(myposx-1,myposy,x,y,nextPath);
		int downx = findSolutionPos(myposx+1,myposy,x,y,nextPath);
		int upy = findSolutionPos(myposx,myposy-1,x,y,nextPath);
		int downy = findSolutionPos(myposx,myposy+1,x,y,nextPath);
		
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
			x--;
		}
		case'E':{
			x++;
		}
		}
		System.out.println(path.charAt(0));
		System.out.println(x+" "+y);
		String nextPath = path.substring(1);
		int standing =  findSolution(x,y,nextPath);
		//System.out.println(path.charAt(0)+" "+standing);
		int upx =findSolution(x-1,y,nextPath);
		System.out.println(upx);
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
	

