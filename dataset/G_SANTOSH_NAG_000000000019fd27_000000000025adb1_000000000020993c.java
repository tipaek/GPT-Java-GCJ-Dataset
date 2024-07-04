/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.io.*;
import java.util.*;
public class Solution
{
	public static void main(String[] args) {
		
		try{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); 
		for(int q=1;q<=t;q++){
		    int N = Integer.parseInt(br.readLine());
		    int a[][]=new int[N][N];
		    String row[]=new String[N];
		    
		    String col[]=new String[N];
		    int sum=0;
		    int c=0;
		    int r=0;
		          
		          for(int i=0;i<N;i++)
                      {
                          
                        
		    
                    for(int j=0;j<N;j++)
                        {
                         a[i][j] =Integer.parseInt(br.readLine());
                         if(i==j)
                         sum+=a[i][j];
                        
                        row[i]+=a[i][j];
                        col[j]+=a[i][j];
                        }
                      }
                      
		          
		          
		      
		      
		      for(int i=0;i<N;i++)
		      {
		          
		          char ro[]=row[i].toCharArray();
		          char co[]=col[i].toCharArray();
		          Arrays.sort(ro);
		          for(int j=0;j<N-1;j++){
		              if(ro[j]==ro[j+1])
		                  { r++;
		                   break;}
		          }
		          Arrays.sort(co);
		          for(int j=0;j<N-1;j++){
		              if(co[j]==co[j+1])
		                   {c++;
		                   break;}
		          }
		      }
		      
		      System.out.println("Case #"+q+": "+sum+" "+r+" "+c);
		}
		}
		catch(Exception e){
		    System.out.println(e);
		}
		
	}
}
