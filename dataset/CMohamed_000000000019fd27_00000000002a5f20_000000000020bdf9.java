import java.util.*;

class Activity implements Comparable<Activity> {
    public int a, b, c;
    public Activity(int a, int b, int c) { this.a = a; this.b = b; this.c = c;}
    @Override
    public int compareTo(Activity act) {
        int v = a*1000000+b*1000+c;
        int toC = act.a*1000000+act.b*1000+act.c;
        return (v == toC) ? 0 : (v > toC ? 1 : -1);
    }
}


class Solution {
    public static String replace(String str, int index, char replace){     
    if(str==null){
        return str;
    }else if(index<0 || index>=str.length()){
        return str;
    }
    char[] chars = str.toCharArray();
    chars[index] = replace;
    return String.valueOf(chars);       
}
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int o = 0; o<t; o++) {
            int n = in.nextInt();
            Activity act[] = new Activity[n];
            for(int i = 0; i<n; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                act[i] = new Activity(a, b, i);
            }
            Arrays.sort(act);
            int c = 0;
            int j = 0;
            String msg = "";
            for(int i=0; i<n; i++) msg += "C";
            for(int i = 0; i<n; i++) {
                if (c <= act[i].a) {
                    c = act[i].b;
                    msg=replace( msg, act[i].b, 'C');
                }
                else if (j <= act[i].a ) {
                    msg=replace(msg, act[i].b, 'J');
                    j = act[i].b;
                }
                else {
                    msg = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #"+(o+1)+": "+msg);
        }
    }
}