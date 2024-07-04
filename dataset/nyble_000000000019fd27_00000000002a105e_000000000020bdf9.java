import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int tc = Integer.parseInt(s.nextLine());
        for (int t=0; t < tc; t++) {
            int n = Integer.parseInt(s.nextLine());
            int[][] timeline = new int[n][2];
            int[][] timeline2 = new int[n][2];

            Map<String,String> pmap = new HashMap<>();

            StringBuilder finalSched = new StringBuilder();
            for(int i=0;i<n;i++){
                int[] act = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                timeline[i][0]=act[0];
                timeline[i][1]=act[1];
                timeline2[i][0]=act[0];
                timeline2[i][1]=act[1];
            }
            Arrays.sort(timeline, new Comparator<int[]>() {
                @Override
                public int compare(int[] s1, int[] s2) {
                    Integer start1 = s1[0];
                    Integer start2 = s2[0];
                    return start1.compareTo(start2);
                }
            });
            int[] camTime = new int[1441];
            int[] jamTime = new int[1441];

            for(int i = 0 ;i<n;i++){
                boolean camBusy = false;
                boolean jamBusy = false;
                for(int j=timeline[i][0];j<timeline[i][1];j++){
                    if(camTime[j] > 0){
                        camBusy = true;
                        //System.out.println("Cambusy="+camBusy);
                        break;
                    }
                }
                if(!camBusy){
                    for(int j=timeline[i][0];j<timeline[i][1];j++){
                        camTime[j]=i+1;
                        pmap.put(timeline[i][0]+","+timeline[i][1],"C");
                    }
                    //finalSched.append("C");
                }
                if(camBusy){
                    for(int j=timeline[i][0];j<timeline[i][1];j++){
                        if(jamTime[j] > 0){
                            jamBusy = true;
                            //System.out.println("Jambusy="+jamBusy);
                            break;
                        }
                    }
                    if(!jamBusy){
                        for(int j=timeline[i][0];j<timeline[i][1];j++){
                            jamTime[j]=i+1;
                            pmap.put(timeline[i][0]+","+timeline[i][1],"J");

                        }
                        //finalSched.append("J");
                    }
                }
                if (camBusy && jamBusy){
                    finalSched = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            if(finalSched.toString().isEmpty()){
                for(int i=0; i<n;i++){
                    finalSched.append(pmap.get(timeline2[i][0]+","+timeline2[i][1]));
                }
            }

            System.out.println(String.format("Case #%d: %s",t+1,finalSched));
        }

    }
}
