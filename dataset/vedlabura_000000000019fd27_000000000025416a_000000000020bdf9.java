

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution {

    
	public static void main (String[] args) throws java.lang.Exception{
	    
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int  i =0; i<t;i++){
           
           int n = in.nextInt();
           
           ArrayList<Integer> Cstart = new ArrayList<Integer>();
           ArrayList<Integer> Cend = new ArrayList<Integer>();
           ArrayList<Integer> Jstart = new ArrayList<Integer>();
           ArrayList<Integer> Jend = new ArrayList<Integer>();
           
           StringBuilder ans = new StringBuilder(); 
           int flagimp = 0;
           
           for(int  j =0;j<n;j++){
               int start = in.nextInt();
               int end = in.nextInt();
               int flagc =0;
               int flagj=0;
               
               for(int k =0; k<Cstart.size();k++){
                   if((start>=Cstart.get(k) && start<Cend.get(k)) || (end>Cstart.get(k) && end<=Cend.get(k)) ){
                       flagc=1;
                   }
               }
               
               for(int k =0; k<Jstart.size();k++){
                   if((start>=Jstart.get(k) && start<Jend.get(k)) || (end>Jstart.get(k) && end<=Jend.get(k))) {
                       flagj=1;
                   }
               }
               
               if(flagc==0){
                   ans.append("C");
                   Cend.add(end);
                   Cstart.add(start);
               }
               else if(flagj==0){
                ans.append("J");
                Jend.add(end);
                Jstart.add(start);
               }
               else flagimp=1;
           }
           

           if(flagimp==1) System.out.println("Case #"+(i+1) + ":"+ " IMPOSSIBLE");
           else{
               System.out.println("Case #"+(i+1) + ":"+ " "+ans);
           }
            
        }
	}
}
