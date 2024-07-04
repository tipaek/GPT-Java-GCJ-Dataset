import java.util.*;
import java.lang.*;
class Solution{
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int numTest=s.nextInt();
        String ans[]=new String[numTest];
        for(int i=1;i<=numTest;i++){
            int numTasks=s.nextInt();
            int flag=0;
            int busy[][]=new int[2][2];//busy from and to
            int startEnd[][]=new int[numTasks][2];
            int temp[][]=new int[2*numTasks][2];
            int k=0;
            for(int j=0;j<numTasks;j++){
                startEnd[j][0]=s.nextInt();//Start
                startEnd[j][1]=s.nextInt();//End
                temp[k][0]=startEnd[j][0];
                temp[k][1]=0;
                k++;
                temp[k][0]=startEnd[j][1];
                temp[k][1]=-1;
                k++;
            }
            int sum=0;
            Arrays.sort(temp, new Comparator<int[]>() { 
            
                @Override              
                // Compare values according to columns 
                public int compare(final int[] entry1,  
                                     final int[] entry2) { 
          
                    if (entry1[0] > entry2[0]) 
                        return 1; 
                    else
                        return -1; 
                    } 
            });
            for(int l=0;l<k;l++){
                if(temp[l][1]==0){//Corresponding to start time
                    sum=sum+1;
                }
                else{//Corresponding to end time
                    sum=sum-1;
                }
                if(sum>2){
                    ans[i]="IMPOSSIBLE";
                    break;
                    flag=1;
                }
            }
            
            
            if(flag==0){
                //check for overlaps by sorting on start times for tasks:
                Arrays.sort(startEnd, new Comparator<int[]>() { 
            
                    @Override              
                    // Compare values according to columns 
                    public int compare(final int[] entry1,  
                                         final int[] entry2) { 
              
                        if (entry1[0] > entry2[0]) 
                            return 1; 
                        else
                            return -1; 
                        } 
                });
                String tempAns="";
                for(int j=0;j<numTasks;j++){
                    tempAns="";
                    if(busy[0][1]<startEnd[j][0]){
                        //If C is free at start time of task
                        busy[0][0]=startEnd[j][0];//start of C's time
                        busy[0][1]=startEnd[j][1];//End of C's time
                        tempAns=tempAns+"C";
                        
                    }
                    else if(busy[1][1]<startEnd[j][0]){
                        //If J is free at the start time of task
                        busy[1][0]=startEnd[j][0];//start of C's time
                        busy[1][1]=startEnd[j][1];//End of C's time
                        tempAns=tempAns+"J";
                    }
                    else{
                        ans[i]="IMPOSSIBLE";
                        break;
                    }
                }
                ans[i]=tempAns;
            }
            else{
                continue;
            }
        }
        
        for(int i=1;i<=numTest;i++){
            System.out.println("Case "+i+": "+ ans[i-1]);
        }
    }
}
