import java.util.*;
import static java.lang.Math.*; 
import static java.util.Arrays.*;

import java.io.FileInputStream;

import static java.lang.Character.*;
import static java.lang.Double.*;


public class Solution {

	Scanner scan = new Scanner(System.in);
	int[][]M;
	
	
	boolean el(int x, int y) {
		int n=0;
		int s =0;
		int[][]D = {{-1,0},{1,0},{0,-1},{0,1}};
		for(int dd=0;dd<4;dd++) {
			int xx = x+D[dd][0];
			int yy = y+D[dd][1];
			while(true) {
				if(xx<0||xx>=M.length)break;
				if(yy<0||yy>=M[0].length)break;
				if(M[xx][yy]!=0) {
					n+=1;s+=M[xx][yy];
					break;
				}
				xx+=D[dd][0];
				yy+=D[dd][1];
			}
		}
		if(M[x][y]*n<s)return true;
		return false;
	}
	
	String solve() {
		int R=scan.nextInt();int C = scan.nextInt();
		M=new int[R][C];
		for(int i=0;i<R;i++)for(int j=0;j<C;j++) {
			M[i][j]=scan.nextInt();
		}
		int res=0;
		for(int round=0;;round++) {
			int r=0;
			boolean finished = true;
			int[][]MM = new int[R][C];
			for(int i=0;i<R;i++)for(int j=0;j<C;j++) {
				if(M[i][j]!=0 && el(i,j)) {
					MM[i][j]=0;finished=false;
				}
				else MM[i][j]=M[i][j];
				r+=M[i][j];
			}
			res+=r;
			M = MM;
			if(finished)break;
		}
		return ""+res;
	}
	
	public static void main(String[] args) {
		Solution me = new Solution();
		try{
			Class.forName("SlexTemplate");
			String sample =me.getClass().getName()+".in";
			me.scan = new Scanner(new FileInputStream(sample));
		}catch (Exception e) {
			System.err.println(e);
		}
		int n = me.scan.nextInt();
		for(int i=1;i<=n;i++) {
			String res = me.solve();
			System.out.format("Case #%d: %s\n", i, res);
		}
	}
}
