import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

class Solution
{ 

        public static void main(String [] args) 
        { 
            Scanner input=new Scanner(System.in);
            int test=input.nextInt();
            for(int i=0;i<test;i++) {
            	System.out.print("Case #"+(i+1)+": ");
            	int n=input.nextInt();
            	int[][] arr=new int[n][3];
            	for(int j=0;j<n;j++) {
            		int x=input.nextInt();
            		int y=input.nextInt();
            		int[] abc=new int[3];
            		abc[0]=x;
            		abc[1]=y;
            		abc[2]=j;
            		arr[j]=abc;
            	}
            	arr=sortbyColumn(arr,0);
            	int a=0;
            	int b=0;
            	int flag1=0;
            	int[] index=new int[n];
            	for(int j=0;j<arr.length;j++) {
            		if(a<=arr[j][0]) {
            			a=arr[j][1];
            			index[arr[j][2]]=0;
            		}else if(b<=arr[j][0]) {
            			b=arr[j][1];
            			index[arr[j][2]]=1;
            		}else {
            			flag1=1;
            			System.out.print("IMPOSSIBLE");
            			break;
            		}
            	}
            	a=0;b=0;
            	if(flag1==0) {
            		for(int j=0;j<n;j++) {
                		if(index[j]==1) {
                			a=arr[j][1];
                			System.out.print("C");
                		}else {
                			b=arr[j][1];
                			System.out.print("J");
                		}
                	}
            	}
            	System.out.println();
            }
            }
        public static int[][] sortbyColumn(int arr[][], int col) 
        { 

            Arrays.sort(arr, new Comparator<int[]>() { 
              public int compare(final int[] entry1,  
                                 final int[] entry2) { 
      
                if (entry1[col] > entry2[col]) 
                    return 1; 
                else
                    return -1; 
              } 
            });
        int[][] j=arr;
        return arr;
        }
 }


 