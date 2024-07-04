import java.util.*;
class Sums
{
	int [] arr;
	public Sums(int [] a )
	{
		arr = a;
	}
}
public class Solution {
	static ArrayList<Sums> list = new ArrayList<Sums>();
	static int k;
	static void CombinationRepetitionUtil(int chosen[], int arr[], 
            int index, int r, int start, int end) { 
        // Since index has become r, current combination is  
        // ready to be printed, print  
        if (index == r) { 
        	int temp = 0;
        	int [] my_arr = new int[r];
            for (int i = 0; i < r; i++) { 
                my_arr[i] =  arr[chosen[i]]; 
                temp += my_arr[i];
            } 
            if(temp == k)
            {
	            Sums s = new Sums(my_arr);
	            list.add(s);
            }
            return; 
        } 
  
        // One by one choose all elements (without considering  
        // the fact whether element is already chosen or not)  
        // and recur  
        for (int i = start; i <= end; i++) { 
            chosen[index] = i; 
            CombinationRepetitionUtil(chosen, arr, index + 1, 
                    r, i, end); 
        } 
        return; 
    } 
  

    static void CombinationRepetition(int arr[], int n, int r) { 
        
        int chosen[] = new int[r + 1]; 
  
    
        CombinationRepetitionUtil(chosen, arr, 0, r, 0, n - 1); 
    } 
  
// Driver program to test above functions  
    public static void main(String[] args) { 
    	
    	Scanner sc = new Scanner(System.in);
    	int t = sc.nextInt();
    	for(int z = 0 ; z < t ; z++ )
    	{
    		int n = sc.nextInt();
    		k = sc.nextInt();
    		
    		int[] a= new int[n];
    		for(int i = 0 ; i< n ; i++ )
    		{
    			a[i] = i+1;
    		}
    		list.clear();
    		CombinationRepetition(a, n, n);
    		boolean result = false;
    		for(int l = 0 ; l < list.size() ; l++ )
    		{
    			int[] arr = list.get(l).arr;
    			int[][] matrix = new int[n][n];
    			for(int i = 0 ; i < n ; i++ )
    			{
    				matrix[i][i] = arr[i];
    			}
    			
    			
    			result = solveSudoku(matrix);
    			 
    			
    			if(result) {
    				System.out.println("Case #"+ (z+1)+": POSSIBLE");
    				for (int i=0; i<n; i++) {
        				for (int j=0; j<n; j++) {
        					System.out.print(matrix[i][j]+" ");
        				}
        				System.out.print("\n");
        			}	
        			
    				break;
    			}
    			
    			
    		}
    		if(!result )
    		{
    			System.out.println("Case #"+ (z+1)+": IMPOSSIBLE");
    		}
    		 
    	}
    	sc.close(); 
    } 
    
    public static boolean solveSudoku(int[][] matrix){
    	 
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix.length; j++) {
				if (matrix[i][j]==0) {
					boolean result = false;
					int k = 1;
					while(!result){
						if (k==matrix.length +1){
							matrix[i][j] = 0;
							return false;
						}
						matrix[i][j] = k;
						k++;
						result = testRow(matrix,i,j)&&testColumn(matrix,i,j);
						if (!result)
							continue;
						result = solveSudoku(matrix);
					}
				}
			}
		}
		return true;
	}
 
	public static boolean testRow(int[][] matrix, int i,int j){
		int key = matrix[i][j];
 
		for (int k=0; k<matrix.length; k++) {
			if (k==j)
				continue;
			if (key==matrix[i][k])
				return false;
		}
 
		return true;
	}
 
	public static boolean testColumn(int[][] matrix, int i, int j){
 
		int key = matrix[i][j];
 
		for (int k=0; k<matrix.length; k++) {
			if (k==i)
				continue;
			if (key==matrix[k][j])
				return false;
		}
		
		return true;
	}
     

}
