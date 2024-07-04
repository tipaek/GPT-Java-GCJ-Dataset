
import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tcs = in.nextInt();
        int tc = 1;
        
        while(tc <= tcs){
            int numberActivities = in.nextInt();
            
            Pair[] activities = new Pair[numberActivities];
            
            for(int i = 0; i < numberActivities; i++){
                int s = in.nextInt();
                int f = in.nextInt();
                activities[i] = new Pair(s, f, i, ' ');
            }
            
            Arrays.sort(activities, new Comparator<Pair>() { 
                @Override public int compare(Pair p1, Pair p2) 
                { 
                    return p1.s - p2.s; 
                } 
            });
            
            int JF = 0, CF = 0; 
            
            if(numberActivities > 0){
            
            	activities[0].c = 'C';
                CF = activities[0].f;
            }
         
            int flag  = 0;
            for(int i = 0; i < numberActivities; i++){
                
                if(i+1 < numberActivities){
                    
                    if(activities[i+1].s >= activities[i].f){
                    	
                    	activities[i+1].c = activities[i].c;
                        if(activities[i].c == 'J')
                            JF = activities[i+1].f;
                        else
                            CF = activities[i+1].f;
                        
                    }
                    else{
                    	
                        if(activities[i].c == 'J' && 
                            activities[i+1].s >= CF){
                        		activities[i+1].c = 'C';
                                CF = activities[i+1].f;    
                            }
                        else if(activities[i].c == 'C' && 
                            activities[i+1].s >= JF){
                        		activities[i+1].c= 'J';
                                JF = activities[i+1].f;
                            }
                        else
                        {
                        	flag = 1;
                        	break;
                        }
                        
                    }
                }
            }
            String res = "";
            if(flag == 1) {
            		res = "IMPOSSIBLE";
            	}
            else {
            	
	            	Arrays.sort(activities, new Comparator<Pair>() { 
	                    @Override public int compare(Pair p1, Pair p2) 
	                    { 
	                        return p1.i - p2.i; 
	                    } 
	                });
	            	
	            	for(int i = 0; i < numberActivities; i++){
	                    res += activities[i].c;
	                }
	            	
            }
            System.out.println("Case #"+tc+": "+res);
            tc++;
        }
    }
    
    private static class Pair{
        int s, f, i;
        char c;
        Pair(int s, int f, int i, char c){
            this.s = s;
            this.f = f;
            this.i = i;
            this.c = c;
        }
    }

}

