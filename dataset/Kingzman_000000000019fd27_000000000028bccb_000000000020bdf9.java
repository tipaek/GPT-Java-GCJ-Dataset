import java.io.*;
import java.util.*;
class Solution{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int cas = 0;
        while(++cas<=t){
            System.out.print("Case #"+cas+": ");
            int n = Integer.parseInt(br.readLine().trim());
            int time_org[][] = new int[n][2];
            int time_copy[][] = new int[n][2];
            for(int i=0; i<n; i++){
                int a[] = new int[2];
                String s[] = br.readLine().split(" ");
                a[0] = Integer.parseInt(s[0]);
                a[1] = Integer.parseInt(s[1]);
                time_org[i] = a;
                time_copy[i] = a.clone();
            }
            Arrays.sort(time_copy, (a1, a2)->(a1[0]-a2[0]));
            char res[] = new char[n];
            
            int cam_end=-1, jam_end=-1;
            int i=0;
            for(; i<n; i++){
                if(cam_end<=time_copy[i][0]){
                    res[i] = 'C';
                    cam_end = time_copy[i][1];
                }
                else if(jam_end<=time_copy[i][0]){
                    res[i] = 'J';
                    jam_end = time_copy[i][1];
                }
                else{
                    System.out.println("IMPOSSIBLE");
                    break;
                }
            }
            if(i!=n)
                continue;
            
            for(i=0; i<n; i++){
                int st = time_org[i][0];
                int end = time_org[i][1];
                int j=0;
                for(; j<n; j++){
                    if(time_copy[j][0]==st&&time_copy[j][1]==end){
                        time_copy[j][0] = -1;
                        break;
                    }   
                }
                System.out.print(res[j]);
            }
            System.out.println();
        }
    }
}