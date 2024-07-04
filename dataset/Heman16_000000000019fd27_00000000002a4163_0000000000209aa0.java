/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author maheshwh
 */
public class Solution{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        Scanner sc = new Scanner(System.in);
        
        //System.out.println("Enter the number of test cases");
        int t=sc.nextInt();
        
        String[] result = new String[t]; 
        for(int h=0;h<t;h++)
        {
          //  System.out.println("Enter the input n");
            
            int n=sc.nextInt();
            
            int[] y = new int[n];
         
        
            //System.out.println("Enter the input sum");
            int int_su=sc.nextInt();
            
             for(int i=0;i<n;i++)
          {
               y[i]=i+1;      
            
          }
            boolean b=false;
            
            b = fun(y,n,int_su ,h);
            
            
            
            if(b==true)
            {
                result[h]="POSSIBLE";
                
            }
            else
            {
            
            
             for(int i=0;i<n;i++)
             { 
                 
              if(b==false)   
              {  y= rotate(y,1);
                  //System.out.println("rotate ");
                  //for(int k=0;k<y.length;k++)
                  //System.out.print(" "+y[k]);
                  //System.out.println(" ");
                  b = fun(y,n,int_su,h);
              }
              else
              {
                  result[h]="POSSIBLE";
                  break;
              }
                 
                 
             }
             
             
             
            
            
            
            
            
            }
            
            
            if(b==false)
             { System.out.println("Case #"+h+": IMPOSSIBLE");
                result[h]="IMPOSSIBLE";  
             }
            
        }
        
      //  for(int i=0;i<result.length;i++)
       // System.out.println(result[i]);
  /*      
        for(int i=1;i<result.length;i++)
    {
        System.out.println("Case #"+(i+1)+": "+result[i]);
    }
    */    
        
        
    }

    private static boolean fun(int[] y,int n,int input_sum,int h) {
        
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++)
        {
            
            
            arr[0][i]=y[i];
            
            
        }
        
        
        
        
        for(int i=1;i<n;i++)
        {
            
            for( int j=0;j<n;j++)
            {
                
            
                 int[] aaaa= new int[n];
                 
                 
                 for(int w=0;w<n;w++)
                 {
                     aaaa[w]=arr[i-1][w];
                 }
                // for(int w=0;w<n;w++)
                 //{ //System.out.println("aaaa");
                  //   System.out.print(" "+aaaa[w]);
                    // System.out.println("");
                 //}
                 
                 
                 int[] c =rotate(aaaa,1);
                 
                 for(int k=0 ;k<n;k++ )
                 arr[i][k]=c[k];
                  
                 
                 
                 
                 
                 
            }
            
            
            
        }
        
        int sum=0;
        
         for(int i=0;i<n;i++)
        {
            
            for( int j=0;j<n;j++)
            {
                 //System.out.print(" "+arr[i][j]);
                 if(i==j)
                  sum= sum+arr[i][j];   
                 
            }
            //System.out.println("");
        }
            
         
         if(sum ==input_sum)
         {  System.out.println("Case #"+h+": POSSIBLE");
             for(int i=0;i<n;i++)
             { for(int j=0;j<n;j++)
                 {
                     System.out.print(arr[i][j]+" ");
                 }
                 System.out.println("");
             }   
             
            return true;
         }
         
        
        
        
        
        
        
        
        return false;
    }

    private static int[] rotate(int[] arr, int w) {
       
        
            int[] aa = new int[w];
        
        int d=0;
        for(int i=((arr.length)-w);i<arr.length;i++  )
        {
            aa[d]=arr[i];
            d++;
        }
        int[] aaa=new int[arr.length];
        int l=0;
        for(int i=w;i<arr.length;i++)
        {
            aaa[i]=arr[l];
            l++;
        }
        
        for(int i=0;i<w;i++)
        {
            aaa[i]=aa[i];
        }
        
        return aaa;
        
        
    }
    
}
