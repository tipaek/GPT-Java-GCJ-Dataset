import java.io.*;
import java.util.*;

class Codejam2 {
    public static void main(String args[])
    {
         Scanner sc=new Scanner(System.in);
                int cases,N;
	        int i,j,k, inc=1;
	//	System.out.println("Enter the number of cases");
		cases = sc.nextInt();
        while(inc<=cases)
        {  
            int rowcount=0,colcount=0,sum=0;
	//	System.out.println("Enter the number of columns:");
		N = sc.nextInt();

		int[][] mat = new int[N][N];
 
    		System.out.println("Enter the elements of the matrix") ;
    		for(i=0;i<N;i++)
    		{ 
	    		for(j=0;j<N;j++)
	    		{ 
	        		mat[i][j] = sc.nextInt();
    			}
		}
		
    		System.out.println("The elements of the matrix") ;
    		for(i=0;i<N;i++)
    		{ 
	    		for(j=0;j<N;j++)
	    		{ 
	       	 		System.out.print(mat[i][j]+"\t");
    			}
      	 		System.out.println("");
		}
                for(i=0;i<N;i++)
    		{ 
                    boolean flag=false;
	    	    for(j=0;j<N;j++)
	    		{  
                           if(!flag)
                           {
                                for(k=j; k<N-1; k++)
                                {   
                                    if( mat[i][j] == mat[i][k+1])
                                    {
                                        rowcount++;
                                        flag=true;
                                        break;
                                    }
                                }
                            }
                           else
                               break;
    			}
		}
                for(j=0;j<N;j++)
    		{ boolean flag=false;
	    		for(i=0;i<N;i++)
	    		{ 
                            if(!flag)
                           {
                                for(k=i; k<N-1; k++)
                                {   
                                    if( mat[i][j] == mat[k+1][j])
                                    {
                                        colcount++;
                                        flag=true;
                                        break;
                                    }
                                }
                            }
                           else
                               break;
    			}
		}
                
    		for(i=0;i<N;i++)
    		{ 
	    		for(j=0;j<N;j++)
	    		{ 
				if(i==j)
				{
					sum = sum + mat[i][j];
				}
    			}
		}

    		System.out.println("Case #"+inc+": " +sum+ " "+" "+rowcount+" "+colcount) ;
     
 	inc++;
        }
        
    }
}
