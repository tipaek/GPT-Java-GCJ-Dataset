
import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main (String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int test =1; test<=T;test++){
			st  = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			long ans =0;
			Dancer[][] dancers = new Dancer[R][C];
			for(int i=0;i<R;i++){
				st  = new StringTokenizer(br.readLine());
				for(int j=0;j<C;j++){
					dancers[i][j] = new Dancer(Integer.parseInt(st.nextToken()));
				}
			}
			for(int i=0;i<R;i++){
				for(int j=0;j<C;j++){
					if(i+1<R){
						dancers[i][j].down = dancers[i+1][j];
					}
					if(i>0){
						dancers[i][j].up = dancers[i-1][j];
					}
					if(j+1<C){
						dancers[i][j].right = dancers[i][j+1];
					}
					if(j>0){
						dancers[i][j].left = dancers[i][j-1];
					}
				}
			}
			boolean[][] dying = new boolean[R][C];
			boolean done = false;
			while(!done){
				int counter =0;
				for(int i=0;i<R;i++){
					Arrays.fill(dying[i], false);
				}
				for(int i=0;i<R;i++){
					for(int j=0;j<C;j++){
						if(dancers[i][j].isAlive){
							ans+=dancers[i][j].skill;
							if(dancers[i][j].average()>dancers[i][j].skill){
								dying[i][j]=true;
								counter++;
							}
						}
					}
				}
				for(int i=0;i<R;i++){
					for(int j=0;j<C;j++){
						if(dying[i][j]){
							dancers[i][j].isAlive=false;
							if(dancers[i][j].left!=null){
								dancers[i][j].left.right=dancers[i][j].right;
							}
							if(dancers[i][j].right!=null){
								dancers[i][j].right.left = dancers[i][j].left;
							}
							if(dancers[i][j].up!=null){
								dancers[i][j].up.down = dancers[i][j].down;
							}
							if(dancers[i][j].down!=null){
								dancers[i][j].down.up = dancers[i][j].up;
							}
						}
					}
				}
				if(counter==0){
					done =true;
				}
			}
			
			
			System.out.println("Case #"+test + ": "+ans);
		}
			
		
	}
}
class Dancer{
	public Dancer up;
	public Dancer down;
	public Dancer left;
	public Dancer right;
	public int skill;
	public boolean isAlive;
	
	public Dancer(int s){
		up=null;
		down=null;
		left=null;
		right=null;
		skill = s;
		isAlive = true;
	}
	public double average(){
		double num=0;
		double sum=0;
		if(this.up!=null){
			sum+= up.skill;
			num+=1;
		}
		if(this.down!=null){
			sum+= down.skill;
			num+=1;
		}
		if(this.left!=null){
			sum+= left.skill;
			num+=1;
		}
		if(this.right!=null){
			sum+= right.skill;
			num+=1;
		}
		if(num==0) return this.skill;
		else return sum/num;
	}
}