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
import java.util.HashSet;
public class Solution{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Solution t= new Solution();
        
        
        
        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter the number of test cases");
        int test=sc.nextInt();
        String[] result = new String[test];
        for(int i=0;i<test;i++)
        {    String final_res="";
           // System.out.println("Enter the number of activity");
            int act=sc.nextInt();
            int[] arr_i= new int[act*2];
            int[] arr_copy= new int[act*2];
            int g=0;
            
           // HashSet<Integer> h = new HashSet<Integer>();
            for(int j=0;j<arr_i.length;j++)
            {   int d=sc.nextInt();
                //arr_in[j]=sc.nextInt();
                
                arr_i[j]=d;
                
               /* if(h.add(d))
                {
                   arr_in[g]=d;
                   g++;
                }*/
                arr_copy[j]=d;
            }
          
                    
                  t.sort(arr_i, 0, arr_i.length-1);    
                     
                    
                    
                    
             int dup_length= removeDuplicates(arr_i, arr_i.length);      
                    
                 
       //  int dup_length= t.removeDuplicateElements(arr_i,arr_i.length);
         
      /*   
         for(int h=0;h<dup_length;h++)
         {
             System.out.println("dup   "+arr_i[h]);
         }
        */ 
         int[] arr_in= new int[dup_length]  ; 
         for(int bb=0;bb<dup_length ;bb++)
         {
             arr_in[bb]=arr_i[bb];
         }
         
         
            t.sort(arr_in, 0, arr_in.length-1);
            
           
           /* for(int j=0;j<arr_in.length;j++)
            {   System.out.println("dfffgggggggggggggggggggggggg");
                System.out.println(arr_in[j]);
            }    
            */
             int[][] arr = new int[3][dup_length];
           //sdsd   int[][] arr = new int[3][arr_in];
            for(int j=0;j<dup_length;j++)
            {
                arr[0][j]= arr_in[j];
            }    
            
            
           /*  for(int j=0;j<dup_length;j++)
            {   System.out.println("dfffgggggggggggggggggggggggg");
                System.out.println(arr[0][j]);
            } 
            */
            
            
            boolean poss=true;
            
            for(int j=0;j<arr_copy.length-1;j=j+2)
            {
                int a=arr_copy[j];
                int b=arr_copy[j+1];
                
               /* System.out.println("start time  "+a);
                System.out.println("End time     "+b);
                System.out.println("--------------");
                */
                for(int w=0;w<arr_in.length;w++)
                {     
                    if(arr_in[w]==a)
                    {   
                        int c=w+1;
                       // System.out.println("cccccccccccc"+c);
                        boolean of_c= true;
                        boolean of_j=true;
                        boolean check=true;
                        while(check==true && (of_c  || of_j))
                        {
                            if(arr[1][c]=='c' && of_c==true )
                                of_c=false;
                            if(arr[2][c]=='j' && of_j==true)
                                of_j=false;
                            //System.out.println("   arr_in[c]    "+arr_in[c]);
                            if(arr_in[c]==b)
                            {   check=false;
                              break;
                            }
                            /*
                            System.out.println("========");
                            System.out.println(" of_c"+ of_c);
                            System.out.println(" of_f"+ of_j);
                            System.out.println("+++++++++");*/
                            c++;
                        }
                        int k=w;
                         boolean p=true;
                        if(of_c==true)
                        {    //System.out.println("in ccc"); 
                           arr[1][w]='c';
                             while(p)
                             { arr[1][k]='c';
                              if(arr_in[k]==b)
                                  p=false;
                                 k++;
                                
                             } 
                             //arr[1][k+1]='c';
                             final_res += "C";
                             
                        }
                        else if(of_j==true)
                        {  // System.out.println("in jjj"); 
                           arr[2][w]='j';
                           while(p)
                             { arr[2][k]='j';
                               if(arr_in[k]==b)
                                   p=false;
                             k++;
                             }  
                           //arr[1][k+1]='j';
                           final_res += "J";
                        }
                        else
                        { poss=false;
                            //System.out.println("IMPOSSIBLE");
                                    
                        }
                        
                        
                        
                        
                    }
                    
                    
                    
                    
                    
                    
                }
                
                
                
                
                
                
                
                
                
            }
            
            
            /*
            for(int f=0 ;f<dup_length;f++)
                System.out.print (" "+arr[0][f]);
                
                System.out.println("");
                for(int f=0 ;f<dup_length;f++)
                System.out.print (" "+arr[1][f]);
                System.out.println("");
                for(int f=0 ;f<dup_length;f++)
                System.out.print (" "+arr[2][f]);
              */  
            
           
                
            
            
             if(poss==false)
            {   
                result[i]="IMPOSSIBLE";
            }    
            else
            result[i]=final_res;
            
            
            
            
            
            
            
            
            
            
        }
        
        
        for(int i=0;i<test;i++)
        {
     
        System.out.println("Case #"+(i+1)+": "+result[i]);
         }
        }
        
        
  
       
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  static int removeDuplicates(int arr[], int n) 
    { 
        // Return, if array is empty 
        // or contains a single element 
        if (n==0 || n==1) 
            return n; 
       
        int[] temp = new int[n]; 
          
        // Start traversing elements 
        int j = 0; 
        for (int i=0; i<n-1; i++) 
            // If current element is not equal 
            // to next element then store that 
            // current element 
            if (arr[i] != arr[i+1]) 
                temp[j++] = arr[i]; 
          
        // Store the last element as whether 
        // it is unique or repeated, it hasn't 
        // stored previously 
        temp[j++] = arr[n-1];    
          
        // Modify original array 
        for (int i=0; i<j; i++) 
            arr[i] = temp[i]; 
       
        return j; 
    } 
       
        
        
        
        
        
        
        
        
        
        void merge(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 
        
    
    
    
    
    
    
    
}
