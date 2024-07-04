/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.HashSet;
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
        
        
        int test_case=sc.nextInt();
        
        int[][] result= new int[test_case][3];
        
        for(int e=0;e<test_case;e++)
        {
            
        
        
       // System.out.println("Enter the size of matrix");
        int size=sc.nextInt();
        int[][] arr = new int[size][size];
        int sum=0;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                arr[i][j]=sc.nextInt();
                if(i==j)
                    sum= sum+arr[i][j];
            }
        }
                
        
         int row=0;
       // HashSet<Integer> h = new HashSet<Integer>(); 
        for(int i=0;i<size;i++)
        {    HashSet<Integer> h = new HashSet<Integer>();
            for(int j=0;j<size;j++)
            {
                   
                    if(h.add(arr[i][j]))
                    {
                        
                    }
                    else
                    {
                        row++;
                        break;
                    }
            }
        }
        
        
        
        int column=0;
         for(int i=0;i<size;i++)
        {HashSet<Integer> w = new HashSet<Integer>(); 
            for(int j=0;j<size;j++)
            {   
                   
                   
                    if(w.add(arr[j][i]))
                    {
                        
                    }
                    else
                    {
                        column++;
                        break;
                    }
            }
        }
         
        
        result[e][0]=sum;
        result[e][1]=row;
        result[e][2]=column;
        
        
        }
        
        
        for(int c=1;c<test_case+1;c++)
        {
            System.out.println("Case #"+c+": "+result[c-1][0]+" "+result[c-1][1]+" "+result[c-1][2]);
            
            
        }
        
        
    }
    
}
