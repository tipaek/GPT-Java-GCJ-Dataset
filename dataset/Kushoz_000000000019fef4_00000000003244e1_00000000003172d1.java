import java.io.*;
import java.util.*;
import java.lang.*;
public class Solution{
           public static int getInteger(String s){return Integer.parseInt(s);} 
           public static Long getLong(String s){return Long.parseLong(s);} 
           public static String[] getString(BufferedReader br)throws Exception{return br.readLine().split(" ");}
	
	     public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                 int test =  getInteger(br.readLine());
                     int cases=1;

                 while(test-->0){
                 String[] nd =  getString(br);

                 int n =  getInteger(nd[0]);
                 int d = getInteger(nd[1]);

                 long[] arr= new long[n];
                 HashMap<Long,Long> freq  =new HashMap<>(); 
                 long maxfreq= 1;
                 String[] data = getString(br);
                 if(d==2 ||  d==3){
                  
                  for(int i=0;i<n;i++){
                  	arr[i]=getLong(data[i]);
                  	if(!freq.containsKey(arr[i])){
                            freq.put(arr[i],1l);

                  	}else{
                  		freq.put(arr[i],freq.get(arr[i])+1);
                  		if(freq.get(arr[i])>maxfreq){
                  			maxfreq=freq.get(arr[i]);
                  		}
                  	}
                  }


                  if(d==2){

                  	if(maxfreq>=2){
                  		System.out.println("Case #"+cases+": "+0);
                  	}
                  	else{
                  		System.out.println("Case #"+cases+": "+1);                  		
                  	}
                  }
                  else if(d==3){

                  	if(maxfreq>=3){
                 	System.out.println("Case #"+cases+": "+0);

                  }
                  else if(maxfreq==1){
               System.out.println("Case #"+cases+": "+2);                  		                  	
                  }
                  else{
              System.out.println("Case #"+cases+": "+2);                  		
                  }

                 }
                 

                 }
                 else{
                     System.out.println("Case #"+cases+": "+3);
                 }
                 cases+=1;
                  	}
             }
         }

