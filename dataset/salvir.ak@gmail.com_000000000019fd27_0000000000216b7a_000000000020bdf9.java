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
        char[] results = new char[schedules.length];
        StringBuilder sb = new StringBuilder();
        Comparator<Item> byStartTime = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.start-o2.start;
            }
        };
        Comparator<Item> byEndTime = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.end-o2.end;
            }
        };
        Arrays.sort(schedules, byEndTime);
        int jEnd = 0;
        int cEnd = 0;
        int jAssigned = 0;
        int cAssigned = 0;
        for(int i =0; i<schedules.length; i++) {
            jEnd = schedules[i].end;
            results[schedules[i].rank]='J';
            jAssigned++;
            schedules[i].start=-1;
            while(i+1<schedules.length && schedules[i+1].start<jEnd) i++;
        }
        int cStart = 0;
        while(cStart<schedules.length &&schedules[cStart].start==-1) cStart++;
        for(int i = cStart; i<schedules.length; i++) {
            cEnd = schedules[i].end;
            results[schedules[i].rank]='C';
            cAssigned++;
            while (i+1<schedules.length && schedules[i+1].start<cEnd) i++;
        }
        if(jAssigned+cAssigned<schedules.length) sb.append("IMPOSSIBLE");
        else {
            for(int i = 0; i<results.length; i++) {
                sb.append(results[i]);
            }
        }
        System.out.println(sb.toString());
    }



}
