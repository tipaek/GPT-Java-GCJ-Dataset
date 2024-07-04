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
				char ch = 'C';
				sb.append(ch);
			   while (i < N && j < N) 
			   { 
			      if (arr[i] < dep[j]) 
			      { 
			          	if(ch=='C') {
			          		ch='J';
			          	} else {
			          		ch='C';
			          	}
			          if(plat_needed>=2) {
			             System.out.println("Case #"+(k+1)+": IMPOSSIBLE");
			             flag=0;
			             break;
			          }
			          plat_needed++; 
			          i++; 
			          sb.append(ch);
			      } else 
			      { 
			      	if (arr[i] == dep[j]) {
			      		if(ch=='C') {
			          		ch='J';
			          	} else {
			          		ch='C';
			          	}
			      	}
			          plat_needed--; 
			          j++; 
			      } 
			   } 
			   if(flag==1) {
			     System.out.println("Case #"+(k+1)+": "+sb.toString());
			   }
			             
        }
    }
}