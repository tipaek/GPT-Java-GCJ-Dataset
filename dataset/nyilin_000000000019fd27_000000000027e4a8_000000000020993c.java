import java.util.*;
import java.io.*;
class squarematrix {
  public static void main(String[] args)throws IOException {
    BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
    int ttt=Integer.parseInt(in.readLine());
    int t=0;
				if(ttt>0 && ttt<=100)
				{
					t=ttt;
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
				else
				{
					break;
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
            
            
          
          
	 }
	 for(int i=0;i<trace.length;i++)
	 {
		 System.out.println("Case #"+(i+1)+":"+" "+trace[i]+" "+row[i]+" "+col[i]);
	 }
	 
	
	
	 
	
   
  }
  static int countIdenticalRows(int mat[][]) 

    { 

  

        int count = 0; 

  

        for (int i = 0; i < mat.length; i++) { 

  

            // HashSet for current row 

            HashSet<Integer> hs = new HashSet<>(); 

  

            // Traverse the row 

            for (int j = 0; j < mat[i].length; j++) { 

  

                // Add all the values of the row in HashSet 

                hs.add(mat[i][j]); 

            } 

  

            // Check if size of HashSet = 1 

            if (hs.size() == 1) 

                count++; 

        } 

  

        return count; 

    } 
    
     static int countIdenticalCols(int rat[][]) 

    { 

  

        int count = 0; 

  

        for (int i = 0; i < rat.length; i++) { 

  

            // HashSet for current row 

            HashSet<Integer> hs = new HashSet<>(); 

  

            // Traverse the row 

            for (int j = 0; j < rat[i].length; j++) { 

  

                // Add all the values of the row in HashSet 

                hs.add(rat[j][i]); 

            } 

  

            // Check if size of HashSet = 1 

            if (hs.size() == 1) 

                count++; 

        } 

  

        return count; 

    } 
}
