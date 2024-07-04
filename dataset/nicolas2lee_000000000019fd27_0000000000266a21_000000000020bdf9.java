

import java.util.*;

class Solution {

    static class Activity{
        int start;
        int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution s = new Solution();
        final int cas = scanner.nextInt();
        for (int ca=1; ca<=cas; ca++){
            final int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int i=0; i<n; i++){
                final int start = scanner.nextInt();
                final int end = scanner.nextInt();
                activities.add(new Activity(start, end));
            }
            Collections.sort(activities, Comparator.comparingInt(a -> a.start));
            StringBuilder sb = new StringBuilder();
            int endC=0;
            int endJ=0;
            boolean flag=false;
            for (int i=0; i<activities.size();i++){
                final Activity current = activities.get(i);
                if (current.start>= endC){
                    sb.append("C");
                    endC=current.end;
                }else if (current.start>=endJ){
                    sb.append("J");
                    endJ=current.end;
                }else{
                    System.out.println( String.format("Case #%d: IMPOSSIBLE", ca));
                    flag=true;
                    break;
                }
            }
            if (flag)continue;
            else System.out.println( String.format("Case #%d: %s", ca, sb.toString()));
        }
    }
}
