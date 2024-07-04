import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    
	public static void main (String[] args) throws java.lang.Exception{
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int test = 1;test<=t;test++){
            check:{
            int n = sc.nextInt();
            int [][] jobs = new int[n][3];
            char [] person = new char[n];
            for(int i = 0;i<n;i++){
                jobs[i][0] = sc.nextInt();
                jobs[i][1] = sc.nextInt();
                jobs[i][2] = i;
            }
            Arrays.sort(jobs, new Comparator<int[]>() { 
              @Override 
              public int compare(final int[] entry1, final int[] entry2) { 
                    if (entry1[0] > entry2[0]) 
                        return 1; 
                    else
                        return -1; 
                } 
            });
            
            /*for (int i = 0; i < n; i++) { 
                for (int j = 0; j < 3; j++) 
                    System.out.print(jobs[i][j] + " "); 
                System.out.println(); 
            }*/
            
            // C = 0, J = 1.
    
            person[jobs[0][2]] = 'C';
            //int busy = 0;
            int [] end = new int[]{jobs[0][1], 0};
            char [] assign = new char[]{'C','J'};
            int flag = 0;
            
            for(int i = 1;i<n;i++){
                if(jobs[i][0] < end[0] && jobs[i][0] < end[1]){
                    System.out.println("Case #"+test+": IMPOSSIBLE");
                    flag = 1;
                    continue;
                }
                if(jobs[i][0] >= end[0]){
                    person[jobs[i][2]] = 'C';
                    end[0] = jobs[i][1];
                }
                else if(jobs[i][0] >= end[1]){
                    person[jobs[i][2]] = 'J';
                    end[1] = jobs[i][1];
                }
            }
            if(flag == 0){
                System.out.print("Case #"+test+": ");
                for (int i = 0; i < n; i++) { 
                    System.out.print(person[i]); 
                }
                System.out.println();
                
            }
        }
        }
	}
}