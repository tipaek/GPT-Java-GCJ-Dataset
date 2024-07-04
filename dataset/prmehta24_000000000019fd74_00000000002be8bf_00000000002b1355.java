import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
      Scanner Sc = new Scanner(System.in);
      int tests = Sc.nextInt();
      for(int i=0;i<tests;i++)
      {
          int rows=Sc.nextInt();
          int cols=Sc.nextInt();
          int dancefloor[][]=new int[rows][cols];
          boolean competitors[][]=new boolean[rows][cols];
          for(int j=0;j<rows;j++)
          {
              for(int k=0;k<cols;k++)
              {
                  dancefloor[j][k]=Sc.nextInt();
                  competitors[j][k]=true;
              }
          }
          int totalinterestlevel=0;
          int roundinterestlevel=0;
          boolean eliminations=true;
          //System.out.println("Reached");
          while(eliminations)
          {
			  roundinterestlevel=calcinterestlevel(dancefloor,competitors,rows,cols);
			  //System.out.println("Calculated");
			  totalinterestlevel+=roundinterestlevel;
			  int eliminated=eliminatecompetitors(dancefloor,competitors,rows,cols);
			  //System.out.println("Eliminated: "+eliminated);
			  
			  if(eliminated==0)
			  {
				eliminations=false;
			  }
              
          }
          System.out.println("Case #"+(i+1)+": "+totalinterestlevel);
      }
    }
	public static int eliminatecompetitors(int vals[][],boolean incomp[][], int r, int c)
	{
		int totaleliminations=0;
		List<Integer[]> eliminatedneighbours = new ArrayList<Integer[]>();
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
			    if(incomp[i][j]==false)
			    {
			        continue;
			    }
				List<Integer[]> compassneighbours = new ArrayList<Integer[]>();
				getcompassneighbours(compassneighbours, incomp, r, c, i, j);
				int sumofneighbours=0;
				//System.out.println(compassneighbours.size());
				for (Integer[] row : compassneighbours) 
				{
					int x=row[0];
					int y=row[1];
					sumofneighbours+=vals[x][y];
					
				}
				
				double avgofneighbours=0;
				if(compassneighbours.size()>0)
				{
				   //System.out.println("Sum: "+sumofneighbours);
				    avgofneighbours=(((double)sumofneighbours)/((double)compassneighbours.size())); 
				    //System.out.println("Avg: "+avgofneighbours);
				}
				
				if(avgofneighbours>vals[i][j])
				{
				    eliminatedneighbours.add(new Integer[] {i,j});
					totaleliminations++;
				}
			}
		}
		for (Integer[] row : eliminatedneighbours) 
		{
			int i=row[0];
			int j=row[1];
			incomp[i][j]=false;
					
		}
		return totaleliminations;
	}
	public static void getcompassneighbours(List<Integer[]> neighbours, boolean incomp[][], int r, int c, int x, int y )
	{
		for(int i=x+1;i<r;i++)
		{
			if(incomp[i][y])
			{
				neighbours.add(new Integer[] {i,y});
				break;
			}
		}
		for(int i=x-1;i>=0;i--)
		{
			if(incomp[i][y])
			{
				neighbours.add(new Integer[] {i,y});
				break;
			}
		}
		for(int i=y-1;i>=0;i--)
		{
			if(incomp[x][i])
			{
				neighbours.add(new Integer[] {x,i});
				break;
			}
		}
		for(int i=y+1;i<c;i++)
		{
			if(incomp[x][i])
			{
				neighbours.add(new Integer[] {x,i});
				break;
			}
		}
	}
	public static int calcinterestlevel(int vals[][],boolean incomp[][], int r, int c)
	{
		int total=0;
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				if(incomp[i][j])
				{
					total+=vals[i][j];
				}
			}
		}
		return total;
	}
    
}