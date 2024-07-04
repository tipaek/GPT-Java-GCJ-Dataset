        import java.util.*;
        import java.io.*;
        import java.lang.*;
         
         
        class test2{
          public static void main (String [] args) throws IOException
          {
           
        	  
        	  try {
        		  Scanner sc=new Scanner(System.in);
        		  int t=sc.nextInt();
        		  
        		  
        		  for(int i=0;i<t;i++)
        		  {
        		      int n=sc.nextInt();
        		      int[][] a=new int[n][n];
        		      int tr=0,pr=0,pc=0;
        		      for(int j=0;j<n;j++)
        		      {
        		          for(int k=0;k<n;k++)
        		          {
        		              a[j][k]=sc.nextInt();
        		              if(j==k)
        		              tr=tr+a[j][k];
        		              
        		          }

        		      }
        		      
        		      
        		      
        		      for(int j=0;j<n;j++)
        		      {
        		          int r=0;
        		          for(int k=0;k<n;k++)
        		          {
        		              int l;
        		              for(l=k+1;l<n;l++)
        		              {
        		                  if(a[j][l]==a[j][k])
        		                  {
        		                      r++;
        		                      break;
        		                  }
        		              }
        		              if(r>0)
        		              break;
        		              
        		          }
        		          pr=pr+r;
        		      }
        		      
        		      for(int j=0;j<n;j++)
        		      {
        		          int c=0;
        		          for(int k=0;k<n;k++)
        		          {
        		              int l;
        		              for( l=k+1;l<n;l++)
        		              {
        		                  if(a[l][j]==a[k][j])
        		                  {
        		                      c++;
        		                      break;
        		                  }
        		              }
        		              if(c>0)
        		              break;
        		              
        		          }
        		          pc=pc+c;
        		      }
        		      
        		      System.out.println("Case #"+(i+1)+": "+tr+" "+pr+" "+pc);
                      
        		  }
        	  }	 
        	  
        	  catch (Exception e) {
        		return;
        	}
         
        }
         
        }  