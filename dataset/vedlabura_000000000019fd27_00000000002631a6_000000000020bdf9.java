

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
           
           int[] jindex= new int[n];
           int[] cindex= new int[n];
           
           for(int j=0;j<n;j++){
               jindex[j]=-1;
               cindex[j]=-1;
           }
           
           int flagimp = 0;
           
           for(int  j =0;j<n;j++){
               int start = in.nextInt();
               int end = in.nextInt();
               int flagc =0;
               int flagj=0;
               
               ArrayList<Integer> ind = new ArrayList<Integer>();
               
               for(int k =0; k<Cstart.size();k++){
                   if((start>=Cstart.get(k) && start<Cend.get(k)) || (end>Cstart.get(k) && end<=Cend.get(k)) ){
                       flagc=1;
                       ind.add(k);
                   }
               }
               
               for(int k =0; k<Jstart.size();k++){
                   if((start>=Jstart.get(k) && start<Jend.get(k)) || (end>Jstart.get(k) && end<=Jend.get(k))) {
                       flagj=1;
                   }
               }
               
               
               if(flagc==1 && flagj==1){
                       for(int h =0; h<ind.size();h++){
                           for(int k =0; k<Jstart.size();k++){
                                if((Cstart.get(h)>=Jstart.get(k) && Cstart.get(h)<Jend.get(k)) || (Jend.get(h)>Jstart.get(k) && Jend.get(h)<=Jend.get(k))) {
                                    flagimp=1;
                                }
                                else{
                                    Jstart.add(Cstart.get(h));
                                    Jend.add(Cend.get(h));
                                    jindex[Cstart.size()-1]=cindex[h];
                                }
                            }
                       }
                       
                       for(int h =0; h<ind.size();h++){
                           Cend.remove(h);
                           Cstart.remove(h);
                           cindex[h]=-1;
                       }
                       if(flagimp!=1){
                           flagc=0;
                       }
                       
                   }
               
               if(flagc==0){
                   for(int k =0; k<Cstart.size();k++){
                   if((start>=Cstart.get(k) && start<Cend.get(k)) || (end>Cstart.get(k) && end<=Cend.get(k)) ){
                       flagc=1;
                   }
               }
               }
               
               
               
               if(flagc==0){
                   Cend.add(end);
                   Cstart.add(start);
                   cindex[Cstart.size()-1]=j;
               }
               else if(flagj==0 && flagc==1){
                    Jend.add(end);
                    Jstart.add(start);
                    jindex[Jstart.size()-1]=j;
               }
               else if(flagc==1 && flagj==1) flagimp=1;
           }
           

           if(flagimp==1) System.out.println("Case #"+(i+1) + ":"+ " IMPOSSIBLE");
           else{
               
               StringBuilder ans = new StringBuilder();
               Arrays.sort(jindex);
               Arrays.sort(cindex);
               int ji =0;
               int ci=0;
              
              
              for(int d =0;d<2*n;d++){
                  if(ji<n && (ci>=n || jindex[ji]<=cindex[ci]))
                         if(jindex[ji]==-1) ji++;
                         else {
                             ans.append("J");
                             ji++;
                         }
                    else if(ci<n && (ji>=n || cindex[ci]<=jindex[ji]))
                        if(cindex[ci]==-1) ci++;
                        else{
                            ans.append("C");
                            ci++;
                        }
              }

            
               System.out.println("Case #"+(i+1) + ":"+ " "+ans);
           }
            
        }
	}
}
