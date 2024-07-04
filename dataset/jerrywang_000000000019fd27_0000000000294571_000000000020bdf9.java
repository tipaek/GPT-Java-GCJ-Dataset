import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int NC = Integer.parseInt(in.nextLine());
        for(int i = 0; i < NC; i ++){
            boolean impossible = false;
            int actnum = Integer.parseInt(in.nextLine());
            ArrayList<int[]> activities = new ArrayList<int[]>(actnum);
            ArrayList<int[]> editable = new ArrayList<int[]>(actnum);
            for(int j = 0; j < actnum; j ++){
                int[] activity = new int[2];
                StringTokenizer ftoken = new StringTokenizer(in.nextLine());
                activity[0] = Integer.parseInt(ftoken.nextToken());
                activity[1] = Integer.parseInt(ftoken.nextToken());
                activities.add(activity);
                editable.add(activity);
            }
            for(int j = 0; j < activities.size(); j ++){
                for(int k = j+1; k < activities.size(); k ++){
                    if(activities.get(j)[0] < activities.get(k)[1] && activities.get(k)[0] < activities.get(j)[1]){
                        for(int m = k+1; m < activities.size(); m ++){
                            if(activities.get(m)[0] < activities.get(j)[1] && activities.get(j)[0] < activities.get(m)[1]){
                                if(activities.get(m)[0] < activities.get(k)[1] && activities.get(k)[0] < activities.get(m)[1]) impossible = true;
                            }
                        }
                    }
                }
            }
            if(impossible) System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
            else{
                ArrayList<int[]> jam = new ArrayList<int[]>();
                ArrayList<int[]> cam = new ArrayList<int[]>();
                boolean iterator = true;
                while(iterator){
                jam.add(editable.get(0));
                editable.remove(0);
                boolean switcher = true;
                while(switcher){
                    switcher = false;
                    for(int j = 0; j < jam.size(); j ++){
                        for(int k = 0; k < editable.size(); k ++){
                            if(editable.get(k)[0] < jam.get(j)[1] && jam.get(j)[0] < editable.get(k)[1]){
                                cam.add(editable.get(k));
                                editable.remove(k);
                                k--;
                                switcher = true;
                            }
                        }
                    }
                    if(switcher){
                        switcher = false;
                        for(int j = 0; j < cam.size(); j ++){
                            for(int k = 0; k < editable.size(); k ++){
                                if(editable.get(k)[0] < cam.get(j)[1] && cam.get(j)[0] < editable.get(k)[1]){
                                    jam.add(editable.get(k));
                                    editable.remove(k);
                                    k--;
                                    switcher = true;
                                }
                            }
                        }
                    }
                }
                iterator = !editable.isEmpty();
                }
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < activities.size(); j ++){
                    if(jam.contains(activities.get(j))) sb.append("J");
                    else sb.append("C");
                }
                System.out.println("Case #" + (i+1) + ": " + sb.toString());
            }
        }
    }
}