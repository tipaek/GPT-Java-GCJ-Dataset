import java.util.*;
import java.lang.*;
class Solution{
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int numTest=s.nextInt();
        String ans[]=new String[numTest];
        for(int i=1;i<=numTest;i++){
           // System.out.println("test number"+i);
            int numTasks=s.nextInt();
            int flag=0;
            int busy[][]=new int[2][2];//busy from and to
            int startEnd[][]=new int[numTasks][3];
            int temp[][]=new int[2*numTasks][2];
            int k=0;
            for(int j=0;j<numTasks;j++){
                startEnd[j][0]=s.nextInt();//Start
                startEnd[j][1]=s.nextInt();//End
                startEnd[j][2]=j;
                temp[k][0]=startEnd[j][0];
                temp[k][1]=0;
                k++;
                temp[k][0]=startEnd[j][1];
                temp[k][1]=-1;
                k++;
            }
            int sum=0;
           /*System.out.println("temp Before sorting:");
            for(int u=0;u<temp.length;u++){
                System.out.println(temp[u][0]);
                System.out.println(temp[u][1]);
            }*/
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

           /* System.out.println("temp After sorting:");
            for(int u=0;u<temp.length;u++){
                System.out.println(temp[u][0]);
                System.out.println(temp[u][1]);
            }*/
            for(int l=0;l<k-1;l++){
                if(temp[l][0]==temp[l+1][0] && temp[l][1]==0 && temp[l+1][1]==-1){
                    temp[l][1]=-1;
                    temp[l+1][1]=0;
                }
            }
            for(int l=0;l<k;l++){
                if(temp[l][1]==0){//Corresponding to start time
                    sum=sum+1;
                }
                else{//Corresponding to end time
                    sum=sum-1;
                }

                if(sum>2){
                    //System.out.println("Impossible as sum>2");
                    ans[i-1]="IMPOSSIBLE";
                    flag=1;
                    break;

                }
            }


            if(flag==0){
                /*System.out.println("startEnd before sorting:");
                for(int u=0;u<startEnd.length;u++){
                    System.out.println(startEnd[u][0]);
                    System.out.println(startEnd[u][1]);
                }*/
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
                /*System.out.println("startEnd after sorting:");
                for(int u=0;u<startEnd.length;u++){
                    System.out.println(startEnd[u][0]);
                    System.out.println(startEnd[u][1]);
                }*/
                char[] tempAns=new char[numTasks];
                for(int j=0;j<numTasks;j++) {
                    /*System.out.println("case"+i+"task:"+j);

                    System.out.println("C busy start:"+busy[0][0]);
                    System.out.println("C busy end:"+busy[0][1]);
                    System.out.println("J busy start:"+busy[1][0]);
                    System.out.println("J busy end:"+busy[1][1]);*/
                    if (busy[0][1] <= startEnd[j][0]) {
                        //If C is free at start time of task
                        busy[0][0] = startEnd[j][0];//start of C's time
                        busy[0][1] = startEnd[j][1];//End of C's time
                        tempAns[startEnd[j][2]] = 'C';
                        /*    System.out.println("Added C");*/

                    } else if (busy[1][1] <= startEnd[j][0]) {
                        //If J is free at the start time of task
                        busy[1][0] = startEnd[j][0];//start of C's time
                        busy[1][1] = startEnd[j][1];//End of C's time
                        tempAns[startEnd[j][2]] = 'J';
                        // System.out.println("Added J");
                    } else {
                        //System.out.println("Impossible because no one is free");
                        ans[i - 1] = "IMPOSSIBLE";
                        break;
                    }
                }
                ans[i-1]=String.valueOf(tempAns);

            }
            else{

                continue;
            }
        }
        for(int i=0;i<numTest;i++){
            System.out.println("Case #"+(i+1)+": "+ans[i]);
        }


    }
}