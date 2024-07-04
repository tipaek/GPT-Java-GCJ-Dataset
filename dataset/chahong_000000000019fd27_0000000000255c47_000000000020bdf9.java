import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = sc.nextInt();
		int maxschedule=0;
		boolean cokay = true;
		boolean jokay = true;
		boolean possible = true;
		for(int i=0; i<n;i++){
			int t = sc.nextInt();
			int schedule[][] = new int[t][2];
			Map<Integer, Integer> dict = new HashMap<>();
		    for(int j=0;j<t;j++){
		        schedule[j][0]=sc.nextInt();
		        schedule[j][1]=sc.nextInt();
		        dict.put(schedule[j][0], j);
		        maxschedule = Math.max(maxschedule,schedule[j][1]);
		       
		    }
		    Arrays.sort(schedule,new Comparator<int[]>(){
		        @Override
		        public int compare(int[] c1, int[] c2){
		            return c1[0]-c2[0];
		        }
		        
		    });
		    char[] work=new char[t];
		    work[dict.get(schedule[0][0])]='C';
		    int cbefore =schedule[0][1];
		    int jbefore =0;
		    cokay = false;
		    jokay = true;
		    int position = 1;
		    possible = true;
		    
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
		                    possible = false;
		                    break NEXT;
		                }
		                else{
		                    jokay = false;
		                    jbefore = schedule[position][1];
		                    work[dict.get(schedule[position][0])]='J';
		                }
		            }
		            else{
		                cokay = false;
		                cbefore = schedule[position][1];
		                work[dict.get(schedule[position][0])]='C';
		            }
		            position++;
		            k--;
		            if(t==position){
		                break NEXT;
		            }
		        }
		  
		        
		    }
		    String result;
		    if(possible) {
		    	result =new String(work);
		    }
		    else {
		    	result = "IMPOSSIBLE";
		    }
		    
		    System.out.println("Case #" + (i+1) + ": " +(result));
		    
		}
		
		

	}
		

}