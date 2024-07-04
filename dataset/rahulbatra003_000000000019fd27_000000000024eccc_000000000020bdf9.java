import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int k=0; k<T; k++) {
            int N = in.nextInt();
			int[] arr = new int[N];
			int[] dep = new int[N];
            for(int i=0; i<N; i++) {
            	arr[i] = in.nextInt();
            	dep[i] = in.nextInt();
            }
            Arrays.sort(arr); 
			Arrays.sort(dep); 
			   int plat_needed = 1, result = 1; 
			   int i = 1, j = 0;
               int flag=1;
               StringBuilder sb = new StringBuilder();
				char ch1 = 'C', ch2='J';
				int t1=0,t2=0;
				sb.append(ch1);
				t1=1;
			   while (i < N && j < N) 
			   { 
			      if (arr[i] < dep[j]) 
			      { 
			          	
			          if(t1==1 && t2==1) {
			             System.out.println("Case #"+(k+1)+": IMPOSSIBLE");
			             flag=0;
			             break;
			          } else if(t1==1) {
      			          sb.append(ch2);
      			          t2=1;
			          } else {
			              sb.append(ch1);
      			          t1=1;
			          }
			          	i++;
			      } else 
			      {   if(t2==1) {
			          t2=0;
			        } else {
			          t1=0;
			        }
			          j++; 
			      } 
			   } 
			   if(flag==1) {
			     System.out.println("Case #"+(k+1)+": "+sb.toString());
			   }
			             
        }
    }
}