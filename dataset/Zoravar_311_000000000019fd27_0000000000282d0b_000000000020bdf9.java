import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder op = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for(int t=1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder ans = new StringBuilder();

            int[][] time = new int[2*n][3]; //0:t, 1/2:st/ed, 2:ind
            int ind=0;
            for(int i=0; i<n; i++){
                String[] s = br.readLine().split(" ");
                int st = Integer.parseInt(s[0]);
                int en = Integer.parseInt(s[1]);
                time[ind][0] = st;
                time[ind][1] = 1;
                time[ind][2] = i;
                ind++;
                time[ind][0] = en;
                time[ind][1] = 2;
                time[ind][2] = i;
                ind++;
            }

            Arrays.sort(time, new Comparator<int[]>() {
                public int compare(int[] a, int[] b){
                    if(a[0]!=b[0])return a[0]-b[0];
                    else return b[1]-a[1];
                }
            });

            boolean bc=false, bj=false; // is C busy, is J busy
            boolean impsble = false;
            int ended = 0;
            int[] giv = new int[n]; //1:J , 2:C
            
            
            for(int[] cur: time){
                int i = cur[2];
                if(cur[1]==2){
                    if(giv[i]==2)bc = false;
                    if(giv[i]==1) bj = false;
                    ended--;
                }else{
                    if(!bc){
                        ans.append('C');
                        bc = true;
                        giv[i] = 2;
                    }else if(!bj){
                        ans.append('J');
                        bj = true;
                        giv[i] = 1;
                    }
                    ended++;
                    if(ended > 2){
                        impsble = true;
                        break;
                    }
                }
            }

            if(impsble){
                ans = new StringBuilder();
                ans.append("IMPOSSIBLE");
            }
            

            op.append("Case #"+t+": "+ans+"\n");
        }
        System.out.println(op);

    }

}
