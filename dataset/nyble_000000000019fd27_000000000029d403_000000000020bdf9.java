import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int tc = Integer.parseInt(s.nextLine());
        for (int t=0; t < tc; t++) {
            int n = Integer.parseInt(s.nextLine());
            int[][] timeline = new int[n][2];
            StringBuilder finalSched = new StringBuilder();
            for(int i=0;i<n;i++){
                int[] act = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                timeline[i][0]=act[0];
                timeline[i][1]=act[1];
            }
            int[] camTime = new int[1441];
            int[] jamTime = new int[1441];

            for(int i = 0 ;i<n;i++){
                boolean camBusy = false;
                boolean jamBusy = false;
                if(camTime[timeline[i][0]] == 0){
                    for(int j=timeline[i][0];j<timeline[i][1];j++){
                        if(camTime[j] > 0){
                            camBusy = true;
                            //System.out.println("Cambusy="+camBusy);
                            break;
                        }
                    }
                    if(!camBusy){
                        for(int j=timeline[i][0];j<timeline[i][1];j++){
                            camTime[j]+=1;
                        }
                        finalSched.append("C");
                    }
                }
                else{
                    camBusy = true;
                }
                if(camBusy && jamTime[timeline[i][0]] == 0){
                    for(int j=timeline[i][0];j<timeline[i][1];j++){
                        if(jamTime[j] > 0){
                            jamBusy = true;
                            //System.out.println("Jambusy="+jamBusy);
                            break;
                        }
                    }
                    if(!jamBusy){
                        for(int j=timeline[i][0];j<timeline[i][1];j++){
                            jamTime[j]+=1;
                        }
                        finalSched.append("J");
                    }
                }
                else{
                    jamBusy = true;
                }
                if (camBusy && jamBusy){
                    finalSched = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            System.out.println(String.format("Case #%d: %s",t+1,finalSched));
        }

    }
}
