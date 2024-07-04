
import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = sc.nextInt();
		int maxschedule=0;
		int before;
		String work;
		boolean cokay = true;
		boolean jokay = true;
		for(int i=0; i<n;i++){
			int t = sc.nextInt();
			int schedule[][] = new int[t][2];
		    for(int j=0;j<t;j++){
		        schedule[j][0]=sc.nextInt();
		        schedule[j][1]=sc.nextInt();
		        maxschedule = Math.max(maxschedule,schedule[j][1]);
		    }
		    Arrays.sort(schedule,new Comparator<int[]>(){
		        @Override
		        public int compare(int[] c1, int[] c2){
		            return c1[0]-c2[0];
		        }
		        
		    });
		    work = "C";
		    int cbefore =schedule[0][1];
		    int jbefore =0;
		    cokay = false;
		    jokay = true;
		    int position = 1;
		    NEXT:
		    for(int k=schedule[0][0];k<maxschedule;k++){
		        if(cbefore==k){
		            cokay = true;
		        }
		        if(jbefore==k){
		            jokay = true;
		        }
		        if(schedule[position][0]==k){
		            if(!cokay){
		                if(!jokay){
		                    work ="IMPOSSIBLE";
		                    break NEXT;
		                }
		                else{
		                    jokay = false;
		                    jbefore = schedule[position][1];
		                    work = work.concat("J");
		                }
		            }
		            else{
		                cokay = false;
		                cbefore = schedule[position][1];
		                work = work.concat("C");
		            }
		            position++;
		            if(t==position){
		                break NEXT;
		            }
		        }
		  
		        
		    }
		    System.out.println("Case #" + (i+1) + ": " +(work));
		    
		}
		

	}

}