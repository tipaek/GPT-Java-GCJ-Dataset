import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	class Path{
		String path="";
		boolean possible= true;
		Path(String path, boolean possible){
			this.path = path;
			this.possible=possible;
		}
		int length() {
			return path.length();
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i=1;i<=t;++i) {
			int x = in.nextInt();
			int y = in.nextInt();
			String sol = findSolution(x,y);
			System.out.println("Case #"+i+": "+sol);
		}
	}
	static String findSolution(int x, int y) {
		String solN = findSolutionDirection('N',x,y,0,0,0);
		String solS = findSolutionDirection('S',x,y,0,0,0);
		String solE = findSolutionDirection('E',x,y,0,0,0);
		String solW = findSolutionDirection('W',x,y,0,0,0);
		if((solN.length()<=solS.length()||solS.equals("IMPOSSIBLE"))&&(solN.length()<=solE.length()||solE.equals("IMPOSSIBLE"))&&(solN.length()<=solW.length()||solW.equals("IMPOSSIBLE"))&&!solN.equals("IMPOSSIBLE")) {
			return 'N'+solN;
		}
		if((solS.length()<=solN.length()||solN.equals("IMPOSSIBLE"))&&(solS.length()<=solE.length()||solE.equals("IMPOSSIBLE"))&&(solS.length()<=solW.length()||solW.equals("IMPOSSIBLE"))&&!solS.equals("IMPOSSIBLE")) {
			return 'S'+solS;
		}
		if((solE.length()<=solS.length()||solS.equals("IMPOSSIBLE"))&&(solE.length()<=solN.length()||solN.equals("IMPOSSIBLE"))&&(solE.length()<=solW.length()||solW.equals("IMPOSSIBLE"))&&!solE.equals("IMPOSSIBLE")) {
			return 'E'+solE;
		}
		if((solW.length()<=solS.length()||solS.equals("IMPOSSIBLE"))&&(solW.length()<=solE.length()||solE.equals("IMPOSSIBLE"))&&(solW.length()<=solN.length()||solN.equals("IMPOSSIBLE"))&&!solW.equals("IMPOSSIBLE")) {
			return 'W'+solW;
		}
		return "IMPOSSIBLE";
	}
	static String findSolutionDirection(char dir, int x, int y, int fromX, int fromY, int tiro) {
		switch(dir) {
		case 'N':{
			fromY += (int)Math.pow(2, tiro);
			break;
		}
		case 'S':{
			fromY -= (int)Math.pow(2, tiro);
			break;
		}
		case 'E':{
			fromX += (int) Math.pow(2, tiro);
			break;
		}
		case 'W':{
			fromX -= (int)Math.pow(2, tiro);
			break;
		}
		
		}
		if(x==fromX&&y==fromY) {
			return "";
		}
		else if(Math.abs(fromX-x)>Math.pow(2, tiro)||Math.abs(fromY-y)>Math.pow(2,tiro)) {
			return "IMPOSSIBLE";
		}
		String solN = findSolutionDirection('N',x,y,fromX,fromY,tiro+1);
		String solS = findSolutionDirection('S',x,y,fromX,fromY,tiro+1);
		String solE = findSolutionDirection('E',x,y,fromX,fromY,tiro+1);
		String solW = findSolutionDirection('W',x,y,fromX,fromY,tiro+1);
		
		
		if((solN.length()<=solS.length()||solS.equals("IMPOSSIBLE"))&&(solN.length()<=solE.length()||solE.equals("IMPOSSIBLE"))&&(solN.length()<=solW.length()||solW.equals("IMPOSSIBLE"))&&!solN.equals("IMPOSSIBLE")) {
			return 'N'+solN;
		}
		if((solS.length()<=solN.length()||solN.equals("IMPOSSIBLE"))&&(solS.length()<=solE.length()||solE.equals("IMPOSSIBLE"))&&(solS.length()<=solW.length()||solW.equals("IMPOSSIBLE"))&&!solS.equals("IMPOSSIBLE")) {
			return 'S'+solS;
		}
		if((solE.length()<=solS.length()||solS.equals("IMPOSSIBLE"))&&(solE.length()<=solN.length()||solN.equals("IMPOSSIBLE"))&&(solE.length()<=solW.length()||solW.equals("IMPOSSIBLE"))&&!solE.equals("IMPOSSIBLE")) {
			return 'E'+solE;
		}
		if((solW.length()<=solS.length()||solS.equals("IMPOSSIBLE"))&&(solW.length()<=solE.length()||solE.equals("IMPOSSIBLE"))&&(solW.length()<=solN.length()||solN.equals("IMPOSSIBLE"))&&!solW.equals("IMPOSSIBLE")) {
			return 'W'+solW;
		}
		return "IMPOSSIBLE";
		
		
	}
}
