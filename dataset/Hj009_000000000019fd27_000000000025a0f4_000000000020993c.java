import java.util.*;
import java.io.*;

class SquMatrix{
	int mat[][];	
	int sum=0;
	int N;
	int r;
	int c;
	Scanner get;
	
	
	SquMatrix(int N,Scanner get){
	this.N=N;
	this.get=get;
	this.get=get;
	mat=new int[N][N];
	boolean flag=true;
	
	for (int x=0;x<N;x++){
		
		for(int y=0;y<N;y++){
			int val=get.nextInt();
			
			
			if(flag){
			for(int k=0;k<y;k++){
				if(mat[x][k]==val){
					r++;
					flag=false;
					break;
				}
			}
			}
			
	  		
		
				mat[x][y]=val;
		
			if(x==y){
				sum+=mat[x][x];
			}
			
			
		}
		flag=true;
	}
	
	}
	
	int getSum(){
	
		return sum;
	}
	int getR(){
		
	
		
		return r;
	}
	int getC(){
		boolean flag=true;
		int newmat[][]=new int[N][N];
		for(int x=0;x<N;x++){
			for(int y=0;y<N;y++){
				int val=mat[y][x];
			if(flag){
			for(int k=0;k<y;k++){
				if(newmat[x][k]==val){
					c++;
					flag=false;
					break;
				}
			}
			}
				newmat[x][y]=val;
			}
			flag=true;
			
		}
		
		return c;
	}
}

class Code{
	public static void main(String args[]){
		 ArrayList<Integer> out=new ArrayList<>(); 
		 Scanner get= new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		 int totalCase=get.nextInt();
		 
		 for(int caseno=1;caseno<=totalCase;caseno++){
						
			int N=get.nextInt();
			SquMatrix mat=new SquMatrix(N,get);
			out.add(mat.getSum());
			out.add(mat.getR());
			out.add(mat.getC());
		 }
			
					int count=0;
		 for(int x=0;x<out.size();x+=3){
			count++;
			System.out.println("Case #"+count+": "+out.get(x)+" "+out.get(x+1) +" "+out.get(x+2));
		}		
	}
}