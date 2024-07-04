public class MultiDim 
{
 public static void printData(int matrix[][])
    {
        for(int r = 0; r < matrix.length; r++)
        {
            for(int c = 0; c < matrix[r].length; c++)
            {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
    	 int t = sc.nextInt();
    	 while(t>0)
    	 {
    		 int size = sc.nextInt();
    		 int matrix[][] = new int[size][size];
    		 for(int r = 0; r < matrix.length; r++)
    	        {
    	            String splitLine[] = sc.nextLine().split(" ");
    	            matrix[r] = new int[splitLine.length];
    	            for(int c = 0; c < matrix[r].length; c++)
    	            {
    	                matrix[r][c] = Integer.parseInt(splitLine[c]);
    	            }
    	        }
    		 printData(matrix);
    		 t--;
    	 }
    }
}