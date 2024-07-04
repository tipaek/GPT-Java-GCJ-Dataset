import java.util.*;
import java.lang.Math; 
import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.lang.*;
import java.util.Arrays; 


public class Solution
{
	public static void main(String[] args) {
		//System.out.println("Hello World");
		Scanner sc = new Scanner(System.in); //System.in is a standard input stream 
        int T = sc.nextInt();              
        int N;
        int D;
        int [] array;
        for(int t = 1 ; t<= T; t++){
            System.out.print("Case #"+t+": ");
        
            N = sc.nextInt();
            array = new int[N];
            D = sc.nextInt();
            for(int j = 0; j<N; j++){
                array[j] = sc.nextInt();
            }
            
            
            int temp;
           for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
             if (array[j] < array [j - 1]) {
              temp = array[j];
              array[j] = array[j - 1];
              array[j - 1] = temp;
             }
            }
           }
           
           int size = array.length;
           int most_index =0;
           int most_size = 1;
           int cur_size = 1;
           int most_num = array[0];
           int num = most_num;
           int cur;
             for (int i = 1; i < size; i++) {
                 cur = array[i];
                 if(cur == num){
                     cur_size++;
                     if((cur_size > most_size) ){
                    // if((cur_size > most_size) && (array.length-i >=D)){

                         most_size = cur_size;
                         most_index = i;
                         num = cur;
                     }
                     
                 }
                 else{
                     cur_size = 1;
                     num = cur;
                 }
     //System.out.println(array[size-i-1]);
     
     
   }
                //   System.out.println("D: "+D);
                //                  System.out.println("most_size: "+most_size);
                //                                                   System.out.println("most_index: "+most_index);
                                    

                //System.out.println("char"+ array[most_index]);
              // System.out.println(Arrays.binarySearch(array,55));
                int r =0;
                int ans = D - most_size;
                int m =2;
                int sum = most_size;
                if(sum+m-1< D){
                while((m*array[most_index] <= array[size-1]) && sum<= D){
                if(Arrays.binarySearch(array,m*array[most_index])>=0){
                    // System.out.println("^^^^^");
                    //      System.out.println("r:"+r+"m:"+m);

                    r+=m-1;
                    sum +=m;
                    ans--;
                    if(sum+m+1 > D){
                        break;
                    }
                    m = m+1;
                }
                }
                }
                ans = r+ D - sum;
               System.out.println(ans);

   
       
	}
	}
	

}



  




