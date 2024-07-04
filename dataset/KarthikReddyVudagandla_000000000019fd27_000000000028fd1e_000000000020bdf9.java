import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args){
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t =scan.nextInt();
        
       // System.out.println(t);
        for(int i=1;i<=t;i++) {
            int ac = scan.nextInt();
            int flag=0;
            int[][] intervals = new int[ac][4];
            StringBuilder sb = new StringBuilder();
            for (int a=0; a < ac; a++) {
                intervals[a][0] = scan.nextInt();
                intervals[a][1] = scan.nextInt();
                intervals[a][2] = a;
                
            }
        
            Arrays.sort(intervals,(a,b)->a[0]-b[0]);
            intervals[0][3]= 1;//1->J,0->C assigning first to J
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>(ac, (a,b) -> a[1] - b[1]);
            pq.add(new int[]{intervals[0][0],intervals[0][1],intervals[0][2],intervals[0][3]});
                for (int b=1; b < ac; b++) {
                    int temp=0;
                    if (intervals[b][0]>= pq.peek()[1]) {
                        temp = pq.poll()[3];
                    }else{
                        if(pq.peek()[3]==1)temp=0;
                        else temp=1;
                    }
                    intervals[b][3]=temp;
                    pq.add(new int[]{intervals[b][0],intervals[b][1],intervals[b][2],temp});
                    if(pq.size()>2){
                        System.out.println("Case #"+i+": IMPOSSIBLE");
                        flag=1;
                        break;
                    }
                }
                if(flag==0){
                    StringBuilder sb1=new StringBuilder();
                    Arrays.sort(intervals,(a,b)->a[2]-b[2]);
                    for(int[] a: intervals) {
                        if(a[3]==1)
                        sb1.append("J");
                        else
                        sb1.append("C");
                    }
                    System.out.println("Case #"+i+": "+sb1.toString());
                }
            }
        }
    }