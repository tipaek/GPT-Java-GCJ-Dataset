import java.util.*;

class Codejam_Vestigium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int tcases=Integer.parseInt(sc.nextLine());
		for(int i=1;i<=tcases;i++)
		{
			int size=Integer.parseInt(sc.nextLine());
			int mat[][]=new int[size][size];
			for(int j=0;j<size;j++)
			{
				int ix=0;
				String[] sarr=sc.nextLine().split(" ");
				for(String s:sarr)
				{
					mat[j][ix]=Integer.parseInt(s);
					ix++;
				}
			}
			//printMat(mat, size);
			System.out.println("Case #"+i+": "+checkMat(mat, size));
			
		}
	}
	
	public static String checkMat(int[][] mat,int size)
	{
		String res="";
		Set<Integer> set=new HashSet<Integer>();
		int d=0,r=0,c=0;
		for(int i=0;i<size;i++)
			d+=mat[i][i];
		//detect rows
		for(int i=0;i<size;i++)
		{
			set.clear();
			for(int j=0;j<size;j++)
				set.add(mat[i][j]);
			if(set.size()!=size) r++;
		}
		
		//detect cols
		for(int i=0;i<size;i++)
		{
			set.clear();
			for(int j=0;j<size;j++)
				set.add(mat[j][i]);
			if(set.size()!=size) c++;
		}
		
		res=d+" "+r+" "+c;
		return res;
				
	}
	
	public static void printMat(int[][] mat,int size){
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++)
				System.out.print(mat[i][j]+" ");
			System.out.println("");
		}
	}

}
