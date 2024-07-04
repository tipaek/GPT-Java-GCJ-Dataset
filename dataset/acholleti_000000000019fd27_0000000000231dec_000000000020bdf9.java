import java.util.Scanner;
import java.util.*;

class Solution{

    public static void helper(int caseNo, int noActivities, List<int[]> activities){
    PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> {
        return a[0] - b[0];
    });

    for(int[] time : activities){
        queue.add(time);
    }

    String result = "C";
    int cLast = 0;
    int jLast = 0;
    int[] previous = queue.poll();
    cLast = previous[1];
    while(!queue.isEmpty()){
        int[] temp = queue.poll();
        
            if(cLast <= temp[0]){
                result = result + 'C';
                cLast = temp[1];
            }else if(jLast <= temp[0]){
                result = result + 'J';
                jLast = temp[1];
            }else{
                System.out.println("Case "+"#"+caseNo+": IMPOSSIBLE");
                return;
            }
        
        previous = temp;
    }
    System.out.println("Case "+"#"+caseNo+": "+result);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for(int n=1;n<=cases;n++){
            int noActivities = scanner.nextInt();
            List<int[]> activities = new ArrayList<>();
            int[] times = new int[2];
            for(int i=0;i<noActivities;i++){
                times = new int[2];               
                times[0] = scanner.nextInt();
                times[1] = scanner.nextInt();
                activities.add(times);
            }
            helper(n, noActivities, activities);
        }
        scanner.close();
    }
}