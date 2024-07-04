import java.util.*;
class CJQR1
{
    int addDiagonal(int matrix[][],int len)
    {
    	int sumD = 0;
    	for(int i=0;i<len;i++)
    		sumD += matrix[i][i];
    	return sumD;
    }
    int findRepCol(int matrix[][],int len)
    {
    	int repCol=0,col=0,i=0;
    	Set<Integer> hash_Set = new HashSet<Integer>();
    	while(i<len)
    	{
    		for(int tr=0;tr<len;tr++)
    			hash_Set.add(matrix[tr][col]);
    		if(hash_Set.size()!=len)
    			repCol++;
    		hash_Set.clear();
    		col++;
    		i++;
    	}
    	return repCol;
    }
    int findRepRow(int matrix[][],int len)
    {
    	int repRow=0,row=0,i=0;
    	Set<Integer> hash_Set = new HashSet<Integer>();
    	while(i<len)
    	{
    		for(int tr=0;tr<len;tr++)
    			hash_Set.add(matrix[row][tr]);
    		if(hash_Set.size()!=len)
    			repRow++;
    		hash_Set.clear();
    		i++;
    		row++;
    	}
    	return repRow;
    }
    public static void main(String args[])
    {
		CJQR1 cj = new CJQR1();
		Scanner sc = new Scanner(System.in);
		int matrix[][],tcase,n;
		tcase = sc.nextInt();
		for(int t=0;t<tcase;t++)
		{
			n = sc.nextInt();
			matrix = new int[n][n];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
					matrix[i][j] = sc.nextInt();
			}
			System.out.println("Case: #"+(t+1)+": "+cj.addDiagonal(matrix,n)+" "+cj.findRepRow(matrix,n)+" "+cj.findRepCol(matrix,n));
		}
    }
}