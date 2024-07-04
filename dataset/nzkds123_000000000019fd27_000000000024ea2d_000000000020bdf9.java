import java.io.*;
import java.util.*;
import java.lang.Math;


public class Solution {

	public static void main(String[] args) {		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//		Number of test cases
        int T = in.nextInt();
        
        int startAct1 = 0, startAct2 = 0, endAct1 = 0, endAct2 = 0;
        int tempNextStart = 0, tempNextEnd = 0;
        for (int i = 1; i < T + 1; ++i) {        	
        	boolean []markedRes; //result: True for Cameron and False for Jamie
        	boolean impossible = false;
        	int[][] grid;
        	int[][] sortedGrid;
        	
        	int[] index; //for QuickSort
        	int[] tempStart; //for QuickSort
        	
        	int A = in.nextInt(); //activities;
    		grid = new int [2][A];
    		sortedGrid = new int [2][A];
    		
    		for (int k = 0; k < A; ++k) {
    			grid[0][k] = in.nextInt();
    			grid[1][k] = in.nextInt();
    		}
    		
    		tempStart = new int [A];
    		index = new int [A];
    		for (int k = 0; k < A; ++k) {
    			index[k] = k;
    			tempStart[k] = grid[0][k];
    		}
    		
    		sort(tempStart, 0, A-1, index);
    		
    		//sortedGrid by startTime
    		for (int k = 0; k < A; ++k) {
    			sortedGrid[0][k] = grid[0][index[k]];
    			sortedGrid[1][k] = grid[1][index[k]];
    		}
    		
    		
    		markedRes = new boolean[A];
    		for (int k = 0; k < A; ++k) {
    			if (k == 0) {
    				markedRes[index[k]]= true;
    				startAct1 = sortedGrid[0][k];
    				endAct1 = sortedGrid[1][k];
    			} else {
    				tempNextStart = sortedGrid[0][k];
    				tempNextEnd = sortedGrid[1][k];
    				
    				if (tempNextStart >= endAct1) {
    					markedRes[index[k]] = true;
    					startAct1 = tempNextStart;
    					endAct1 = tempNextEnd;
    				} else if (tempNextStart >= endAct2) {
    					//Not neccessary
//    					markedRes[index[k]] = false
    					
    					startAct2 = tempNextStart;
    					endAct2 = tempNextEnd;
    				} else {
    					impossible = true;
    					break;
    				}
    			}
    		}
    		
			if (impossible) //invalid case
	        	System.out.println("Case #"+ i + ": IMPOSSIBLE");
			else {
	    		//valid case
	    		System.out.print("Case #"+ i + ": ");
	    		for (int k = 0; k < A; ++k) {
	    			System.out.print(markedRes[k] == true ? 'C' : 'J');
	    		}
	    		System.out.println();
			}
        	
  
    		//Released memory
            for (int j = 0; j < 2; ++j) {
            	grid[j] = null;
            	sortedGrid[j] = null;
            }
            grid = null;
            sortedGrid = null;
            tempStart = null;
            index = null;
            markedRes = null;
            impossible = false; //important
            startAct1 = 0;
            startAct2 = 0;
            endAct1 = 0;
            endAct2 = 0;
            tempNextStart = 0;
            tempNextEnd = 0;
        }
        
        in.close();
	}
	
	/* This function takes last element as pivot, 
    places the pivot element at its correct 
    position in sorted array, and places all 
    smaller (smaller than pivot) to left of 
    pivot and all greater elements to right 
    of pivot */
 static int partition(int arr[], int low, int high, int index[]) 
 { 
     int pivot = arr[high];  
     int i = (low-1); // index of smaller element 
     for (int j=low; j<high; j++) 
     { 
         // If current element is smaller than the pivot 
         if (arr[j] < pivot) 
         { 
             i++; 

             // swap arr[i] and arr[j] 
             int temp = arr[i]; 
             arr[i] = arr[j]; 
             arr[j] = temp; 
             
             //swap index
             int tempIndex = index[i];
             index[i] = index[j];
             index[j] = tempIndex;
         } 
     } 

     // swap arr[i+1] and arr[high] (or pivot) 
     int temp = arr[i+1]; 
     arr[i+1] = arr[high]; 
     arr[high] = temp; 
     
     //swap index
     int tempIndex = index[i+1];
     index[i+1] = index [high];
     index[high] = tempIndex;

     return i+1; 
 } 


 /* The main function that implements QuickSort() 
   arr[] --> Array to be sorted, 
   low  --> Starting index, 
   high  --> Ending index */
static void sort(int arr[], int low, int high, int index[]) 
 { 
     if (low < high) 
     { 
         /* pi is partitioning index, arr[pi] is  
           now at right place */
         int pi = partition(arr, low, high, index); 

         // Recursively sort elements before 
         // partition and after partition 
         sort(arr, low, pi-1, index); 
         sort(arr, pi+1, high, index); 
     } 
 } 

}
