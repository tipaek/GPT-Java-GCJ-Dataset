import java.util.*;

public class Solution {

    public static class Item {
        int start;
        int end;
        int rank;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i =0; i<t; i++) {
            int n = sc.nextInt();
            Item[] schedules = new Item[n];
            for(int j = 0; j<n; j++) {
                schedules[j] = new Item();
               schedules[j].start = sc.nextInt();
               schedules[j].end = sc.nextInt();
               schedules[j].rank = j;
            }
            System.out.print("Case #"+(i+1)+": ");
            scheduling(schedules);
        }
    }

    public static void scheduling(Item[] schedules) {
        int[] times = new int[1441];
        char[] result = new char[schedules.length];
        StringBuilder sb = new StringBuilder();
        int maxTime = 0;
        for(int i =0; i<schedules.length; i++) {
            for(int time = schedules[i].start; time<schedules[i].end; time++) {
                times[time]++;
                if(times[time]> maxTime) maxTime = times[time];
            }
        }
        if(maxTime>2) {
            sb.append("IMPOSSIBLE");
            System.out.println(sb.toString());
            return;
        }
        else {
            Arrays.sort(schedules, new Comparator<Item>() {
                @Override
                public int compare(Item o1, Item o2) {
                    return o1.end-o2.end;
                }
            });
            for(int i =0; i<schedules.length; i++) {
               int jEnd = schedules[i].end;
               result[schedules[i].rank]='J';
               while(i+1<schedules.length && schedules[i+1].start<jEnd) {
                   result[schedules[i+1].rank] = 'C';
                   i++;
               }
            }
            for(int i =0; i<result.length; i++) {
                sb.append(result[i]);
            }
            System.out.println(sb.toString());
        }
    }



}
