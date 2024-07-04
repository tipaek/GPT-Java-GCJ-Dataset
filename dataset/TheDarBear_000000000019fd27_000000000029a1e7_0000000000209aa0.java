import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception
	{
		new Solution().run();
	}
	
	int[][] square;
	
	public void run() throws Exception
	{
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(file.readLine());
	loop:
		for(int z = 0;z<T;z++)
		{
			st = new StringTokenizer(file.readLine());
			int N = Integer.parseInt(st.nextToken());
			int sum = Integer.parseInt(st.nextToken());
			int[] diag = makeDiag(sum, N);
			if(diag == null)
			{
				System.out.printf("Case #%d: IMPOSSIBLE%n",z+1);
				continue loop;
			}
			square = new int[N][N];
			for(int i = 0;i<square.length;i++)
			{
				for(int j = 0;j<square.length;j++)
				{
					square[i][j] = ((i+j)%N)+1;
				}
			}
			int[] rep = new int[N];
			for(int i = 0;i<square.length;i++) {
				rep[i] = square[i][i];
				square[i][i] = diag[i];
			}
			for(int i = 0;i<square.length;i++)
			{
				if(rep[i] == diag[i])
					continue;
				for(int j = 0;j<square.length;j++)
					if(i!= j && square[i][j] == diag[i])
					{
						square[i][j] = rep[i];
					}
			}
			tabuSearch(square);
			System.out.printf("Case #%d: POSSIBLE%n",z+1);
			for(int[] in: square) {
				for(int i = 0;i<in.length;i++)
				{
					System.out.print(in[i]);
					if(i != in.length - 1)
						System.out.print(" ");
				}
				System.out.println();
			}
		
			
		}
	}
	
	/*public boolean tryFill(int[][] square, int[] diag, int index)
	{
		int[][] res = new int[square.length*2+2][square.length*2+2];
		node[] nodes = new node[square.length*2+2];
		for(int i = 0;i<nodes.length;i++)
			nodes[i] = new node(i);
		for(int i = 0;i<square.length;i++)
		{
			boolean[] occ = new boolean[square.length];
			for(int j = 0;j<index-1;j++)
				occ[square[index][i]-1] = true;
			if(index == i)
			{
				for(int j = 0;j<index;j++)
					occ[square[j][j]-1] = true;
				for()
			}else {
				for(int j = 0;j<occ.length;j++)
				{
					if(!occ[j])
					{
						nodes[i].con.add(square.length+j);
						nodes[square.length+j].con.add(i);
						res[i][square.length + j] = 1;
					}
				}
			}		
		}
	}*/
	
	private class node{
		
		public ArrayList<Integer> con;
		int id;
		public node(int id)
		{
			this.id = id;
			this.con = new ArrayList<Integer>();
		}
	}
	
	public void tabuSearch(int[][] square)
	{
		//how many times does r+1 appear in col c
		while(true)
		{
			int[][] occ = new int[square.length][square.length];
			boolean flag = false;
			for(int i = 0;i<square.length;i++)
			{
				for(int j = 0;j<square.length;j++)
				{
					occ[square[i][j]-1][j]++;
					if(occ[square[i][j]-1][j] == 2)
						flag = true;
				}
			}
			if(!flag)
				return;
			
			//row, c1, c2
			ArrayList<int[]> moves = new ArrayList<int[]>();
			for(int i = 0;i<square.length;i++)
			{
				for(int j = 0;j<square.length;j++)
				{
					for(int k = j+1;k<square.length;k++)
					{
						if(j != i && k != i)
						{
							moves.add(new int[] {i,j,k});
						}
					}
				}
			}
			int best = -2;
			int bestIndex =-1; 
			for(int i = 0;i<moves.size();i++)
			{
				int[] move = moves.get(i);
				int r = move[0];
				int c1 = move[1];
				int c2 = move[2];
				int elem1 = square[r][c1];
				int elem2 = square[r][c2];
				int diff = 0;
				if(occ[elem1-1][c2] == 0)
					diff++;
				if(occ[elem2-1][c1] == 0)
					diff++;
				if(occ[elem1-1][c1] == 1)
					diff--;
				if(occ[elem2-1][c2] == 1)
					diff--;
				if(diff == 2) {
					bestIndex = i;
					break;
				}
				if(diff > best)
				{
					bestIndex = i;
					best = diff;
				}
			}
			if(Math.random()>.3)
			{
				int[] move = moves.get(bestIndex);
				makeSwap(move[0], move[1], move[2]);
			}else {
				int[] move = moves.get((int)(Math.random()*moves.size()));
				makeSwap(move[0], move[1], move[2]);
			}	
		}
	}
	
	public void makeSwap(int r, int c1, int c2)
	{
		int save = square[r][c1];
		square[r][c1] = square[r][c2];
		square[r][c2] = save;
	}
	
	public int[][] clone(int[][] square)
	{
		int[][] ret = new int[square.length][];
		for(int i = 0;i<square.length;i++)
			ret[i] = square[i].clone();
		return ret;
	}
	
	public int[] makeDiag(int goal, int N)
	{
		if(goal > N*N)
			return null;
		if(goal < N)
			return null;
		if(goal == N)
		{
			int[] ret = new int[N];
			Arrays.fill(ret, 1);
			return ret;
		}
		if(goal == N*N)
		{
			int[] ret = new int[N];
			Arrays.fill(ret, N);
			return ret;
		}
		if(goal == N+1)
		{
			return null;
		}
		if(goal == N*N-1)
		{
			return null;
		}
		int[] diag = new int[N];
		int sum = N*N;
		Arrays.fill(diag, N);
		int index = 0;
		while(sum != goal)
		{
			diag[index]--;
			if(diag[index]==1)
				index++;
			sum--;
		}
		if(index == 0)
		{
			diag[index]++;
			diag[index+1]--;
		}
		if(index == N-1)
		{
			diag[index]--;
			diag[index - 1]++;
		}
		return diag;
	}
	
}
