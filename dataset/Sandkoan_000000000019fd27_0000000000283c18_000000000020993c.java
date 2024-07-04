import java.util.*;
import java.io.*;
class Solution{
   public static void main(String[] args)throws IOException {
    BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
    int ttt=Integer.parseInt(in.readLine());
    int t=0;
				if(ttt>0 && ttt<=100)
				{
					t=ttt;
				}
				else
				{
				    System.out.println("beyond input limit");
				}
    	int[]trace=new int[t];
		int[]row=new int[t];
		int[]col=new int[t];
    int[]sizes=new int[t];
    for(int c=0;c<t;c++)
    {
		int hhh=Integer.parseInt(in.readLine());
		if(hhh>1 && hhh<=100)
				{
					sizes[c]=hhh;
				}
		else{
		     System.out.println("beyond input limit");
		}
		int[][]sqMat=new int[sizes[c]][sizes[c]];
		for(int l=0;l<sizes[c];l++)
		{
			String nums=in.readLine();
			String[]eles=nums.split(" ");
			for(int e=0;e<sizes[c];e++)
			{
				int ggg=Integer.parseInt(eles[e]);
				if(ggg>=1 && ggg<=100)
				{
					sqMat[l][e]=ggg;
				}
				else{
				     System.out.println("beyond input limit");
				}
				}
 
		}
 
		row[c]=countIdenticalRows(sqMat);
		col[c]=countIdenticalCols(sqMat);
 
 
 
 
 
 
 
 
            trace[c]=0;
 
 
		    for (int i = 0; i <sizes[c]; i++) 
		    {
			   trace[c]= trace[c]+sqMat[i][i];		
            }
 
            	 System.out.println("Case #"+(c+1)+":"+" "+trace[c]+" "+row[c]+" "+col[c]);
 
 
	 }
 
 
 
 
 
 
 
 
 
  }
  static int countIdenticalRows(int mat[][]) 
 
    { 
 
 
 
        int gggg = 0; 
 
 
 
        for (int i = 0; i < mat.length; i++) { 
 
 
 
            // HashSet for current row 
 
            HashSet<Integer> hs = new HashSet<>(); 
 
 
 
            // Traverse the row 
 
            for (int j = 0; j < mat[i].length; j++) { 
 
 
 
                // Add all the values of the row in HashSet 
 
                hs.add(mat[i][j]); 
 
            } 
 
 
 
            // Check if size of HashSet = 1 
 
            if (hs.size() != mat.length) 
 
                gggg=gggg+1; 
 
        } 
 
 
 
        return gggg; 
 
    } 
 
     static int countIdenticalCols(int rat[][]) 
 
    { 
 
 
 
        int count = 0; 
 
 
 
        for (int i = 0; i < rat.length; i++) { 
 
 
 
            // HashSet for current row 
 
            HashSet<Integer> hs = new HashSet<>(); 
 
 
 
            // Traverse the row 
 
            for (int j = 0; j < rat.length; j++) { 
 
 
 
                // Add all the values of the row in HashSet 
 
                hs.add(rat[j][i]); 
 
            } 
 
 
 
            // Check if size of HashSet = 1 
 
            if (hs.size() !=rat.length) 
 
                count++; 
 
        } 
 
 
 
        return count; 
 
    } 
}