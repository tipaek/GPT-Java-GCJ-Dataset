import java.util.*;
import java.io.*;

class Pair implements Comparable{
    int st,end,ord;

    public Pair(int s, int e,int o){
        st=s;
        end=e;
        ord = o;
    }

    @Override
    public int compareTo(Object o) {
        int ost = ((Pair)o).st;
        return this.st - ost;
    }
}

public class Solution {




    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int z = 1; z <= t; ++z) {
            int B = in.nextInt();
            in.nextLine();
            String[] s = new String[B];
            String[] start = new String[B];
            String[] end = new String[B];
            String[] mid = new String[B];
            int startEmp=0;
            int endEmp=0;
            for (int i=0;i<B;i++){
                s[i] =  in.nextLine();
                String[] split = s[i].split("\\*");
                int midStart=0,midEnd=split.length-1;
                if (s[i].charAt(0)!='*'){
                    midStart=1;
                    start[i]=split[0];
                }
                else {
                    start[i]="";
                    startEmp++;
                }
                if (s[i].charAt(s[i].length()-1)!='*'){
                    end[i] = split[split.length-1];
                    midEnd=split.length-2;
                }
                else {
                    endEmp++;
                    end[i]="";
                }
                StringBuilder midSb = new StringBuilder();
                for (int j=midStart;j<=midEnd;j++){
                    midSb.append(split[j]);
                }
                mid[i] = midSb.toString();

            }
            Arrays.sort(start);
            Arrays.sort(end);

            String maxStart="";
            String maxEnd="";
            for (int i=0;i<start.length;i++){
                if (start[i].length()>maxStart.length())maxStart=start[i];
                if (end[i].length()>maxEnd.length())maxEnd=end[i];
            }

            Boolean imp=false;
            for (int i=0;i<start.length;i++) {
                if (start[i].equals(maxStart))continue;
                if (!start[i].equals("") && !maxStart.substring(0, start[i].length()).equals(start[i])) {
                    imp = true;
                    break;
                }
            }
            int endStrLen =  maxEnd.length();

            for (int i=0;i<end.length;i++){
                if (end[i].equals(maxEnd))continue;
                if (!end[i].equals("") && !maxEnd.substring(endStrLen-end[i].length()).equals(end[i])){
                    imp=true;
                    break;
                }
            }
            if (imp)System.out.println("Case #" + z + ": *");
            else{
                StringBuilder sb = new StringBuilder();
                sb.append(maxStart);
                for (int i=0;i<mid.length;i++){
                    sb.append(mid[i]);
                }
                sb.append(maxEnd);
                System.out.println("Case #" + z + ": "+ sb.toString());
            }




            //read 2 bits for verification
            //read 8 bits
            //repeat



        }
    }
}