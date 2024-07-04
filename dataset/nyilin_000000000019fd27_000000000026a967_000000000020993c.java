import java.util.*;
import java.io.*;
class squarematrix {
  public static void main(String[] args)throws IOException {
    BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
    int t=Integer.parseInt(in.readLine());
    	int[]trace=new int[t];
		int[]row=new int[t];
		int[]col=new int[t];
    int[]sizes=new int[t];
    for(int c=0;c<t;c++)
    {
		sizes[c]=Integer.parseInt(in.readLine());
		int[][]sqMat=new int[sizes[c]][sizes[c]];
		for(int l=0;l<sizes[c];l++)
		{
			String nums=in.readLine();
			String[]eles=nums.split(" ");
			for(int e=0;e<sizes[c];e++)
			{
				sqMat[l][e]=Integer.parseInt(eles[e]);
				
				if(sqMat[l][e]<0 || sqMat[l][e]>sizes[c])
				{
					break;
				}
				
			}
			
		}
		int roww=0,coll=0,rcount=0,ccount=0;
		for(int i=0;i<sizes[c];i++)
		{
			for(int j=0;j<sizes[c];j++)
			{
				int temp=sqMat[i][j];
				for(int k=0;k<sizes[c];k++)
				{
					if(temp==sqMat[i][k] && j!=k)
					{
						rcount++;
					}
				}
				for(int l=0;l<sizes[c];l++)
				{
					if(temp==sqMat[l][i] && j!=l)
					{
						ccount++;
					}
				}


			}
			if(rcount>0)
				roww++;
			rcount=0;
			if(ccount>0)
				coll++;
			ccount=0;
		}
		col[c]=coll;
		row[c]=roww;
		
		
            
            
            
            
            
            
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
}
