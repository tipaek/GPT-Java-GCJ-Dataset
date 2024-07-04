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
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of test cases");
        int test=sc.nextInt();
        
        String[] result = new String[test];
        
        
        for(int i=0;i< test;i++)
        {
            
            String str_num= sc.next();
           
            
            
                    
            int num_lenth= str_num.length();
            
            
            int[][] arr = new int[2][num_lenth];
            for(int j=0;j<num_lenth;j++)
            {
                arr[0][j]=Character.getNumericValue(str_num.charAt(j)); 
                
                
            }
            
            
            
            
            
         
            
            
            
            for(int j=0;j<num_lenth-1;j++)
         { 
                arr[1][j]=arr[0][j+1]- arr[0][j] ;
                
               
               
          }
            
            arr[1][num_lenth-1]= -arr[0][num_lenth-1];
            
             
            
             String fina_str="";
              for(int j=0;j< arr[0][0];j++)
                fina_str += "(" ; 
            
              
             
             for(int w=0;w<num_lenth-1;w++)
         {
             fina_str += ""+arr[0][w];
             if(arr[1][w]<0)
             {
                 for(int j=0;j< Math.abs(arr[1][w]);j++)
                 {
                      fina_str += ")" ;
                 }
                 
             }
             else
             {   
                    
                 for(int j=0;j< arr[1][w];j++)
                 {
                      fina_str += "(" ;
                 }
             
                 
              
             
         }
            
            
            
        }
             
             fina_str += arr[0][num_lenth-1];
         for(int j=0;j<arr[0][num_lenth-1];j++)
                 fina_str += ")" ;
             
             
        
            
            result[i]= fina_str;
    
    
    
    }
    
    for(int i=0;i<result.length;i++)
    {
        System.out.println("Case #"+(i+1)+": "+result[i]);
    }
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
