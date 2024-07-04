import java.util.*;
import java.io.*;

class Solution {
  public static void main(String[] args) {
    
    //System.out.println("Hello Codiva");
    
        
        Scanner s=new Scanner(System.in);
        int tc=s.nextInt();
    
    List<int[][]> list=new ArrayList<>();
        
        for(int p=0;p<tc;p++)
        {
          int n=s.nextInt();
          int[][] arr=new int[n][n];
          
          for(int i=0;i<n;i++)
          {
            for(int j=0;j<n;j++)
            {
              int num=s.nextInt();
              arr[i][j]=num;
            }
          
          
       	  }
          
          list.add(arr);
          
          //System.out.println("I am printing now");
          //for(int i=0;i<n;i++)
          //{for(int j=0;j<n;j++)
            //{System.out.print(arr[i][j]+" ");}System.out.println();}
          
          
        }
        
        int pc=1;
    
   		 for(int arr[][]:list)
        {
        
              
          int n=arr.length;
          
          int sum=0;
          for(int i=0;i<n;i++)
          {
            
          	sum+=arr[i][i];
          
       	  }
           
           int rc=0;
           for(int i=0;i<n;i++)
          { 
             ArrayList<Integer> row=new ArrayList<>();

             for(int j=0;j<n;j++)
             {
               if(row.contains(arr[i][j])) { rc++; break;}
               else row.add(arr[i][j]);
               
             }
          }
           
           
           int cc=0;
           for(int i=0;i<n;i++)
          { 
             ArrayList<Integer> row=new ArrayList<>();

             for(int j=0;j<n;j++)
             {
               if(row.contains(arr[j][i])) { cc++; break;}
               else row.add(arr[j][i]);
               
             }
          }
           
           
       		 	  
        
           
      
           
           
           
           
           System.out.println("Case #"+pc+": "+sum+" "+rc+" "+cc);
           pc++;
          
          
        }
    
    
    
    
         
    
    
  }
}