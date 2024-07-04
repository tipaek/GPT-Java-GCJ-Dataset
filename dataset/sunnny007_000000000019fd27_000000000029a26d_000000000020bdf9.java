import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
public class Solution {
    static class Schedule{
        int sta;
        int std;
        int pos;
        public Schedule(int sta, int std, int pos){
            this.sta = sta;
            this.std = std;
            this.pos = pos;
        }
    }
    public static void main(String[] args){
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));   
            int t = Integer.parseInt(br.readLine());
            int num = 1;
            while(t-- > 0){
                int n = Integer.parseInt(br.readLine());
                StringBuilder sb = new StringBuilder();
                List<Schedule> ll = new ArrayList<>();
                boolean bool = false;
                String[] ch = new String[n];
                for(int i = 0; i < n; i++){
                    String s = br.readLine();
                    String[] str = s.split(" ");
                    int arrival = Integer.parseInt(str[0]);
                    int depart = Integer.parseInt(str[1]);
                    ll.add(new Schedule(arrival, depart,i));
                }
                Collections.sort(ll,(a,b) -> (a.sta-b.sta));
                int ctd = 0;
                int jtd = 0;
                for(int i = 0; i < ll.size(); i++){
                    if(ll.get(i).sta >= ctd){
                        ch[ll.get(i).pos] = "C";
                        //sb.append("C");
                        ctd = ll.get(i).std;
                    }
                    else if(ll.get(i).sta >= jtd){
                        ch[ll.get(i).pos] = "J";
                        //sb.append("J");
                        jtd = ll.get(i).std;
                    }
                    else{
                        bool = true;
                        break;
                    }
                }
                for(String str : ch) sb.append(str);
                if(bool) System.out.println("Case #"+num+": "+"IMPOSSIBLE");
                else System.out.println("Case #"+num+": "+sb);
                num++;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
   
}