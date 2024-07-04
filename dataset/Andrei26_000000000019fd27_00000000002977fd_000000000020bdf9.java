import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

final class Solution {

    public static void main(String[] args) {
         
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int i = 0; i < cases; i++) {
            int activities = in.nextInt();
           

            byte[] c = new byte[1441];
            byte[] j= new byte[1441];

            for (int j2 = 0; j2 < 1441; j2++) {
                c[j2] = 0;
                j[j2] = 0;
            }
            StringBuilder last = new StringBuilder();
            for(int ac =0; ac < activities; ac++){
                int activityStart = in.nextInt();
              
                int activityEnd = in.nextInt();
                int tries =0;
                try{

                    for(int x = activityStart; x <= activityEnd;x++){
                        if((c[x]==1) && (c[x+1] == 1)){
                             throw new Error("a");
                        }else{
                            c[x]=1;
                            tries++;
                        }
                    }
                    last.append("C");

                 }catch( Error e){
                    for(int x = activityStart; x < activityStart+tries;x++){
                        c[x]=0;
                    }
                    tries = 0;
                    try{
                        for(int x = activityStart; x<=activityEnd;x++){
                            if((j[x]==1) && (j[x+1]==1) ){
                                 throw new Error("a");
                            }else{
                                j[x]=1;
                                tries++;
                            }
                            
                    }
                    last.append("J");
                    }catch(Error a){
                        for(int x = activityStart; x < activityStart+tries;x++){
                            j[x]=0;
                        }
                        last.append("IMPOSSIBLE");
                    }
                    
                }
            } 

            if(last.toString().contains("IMPOSSIBLE")){
                last.setLength(0);
                last.append("IMPOSSIBLE");
            }



            System.out.println("Case #" + (i+1) + ": " + last.toString());
        
        }
            
    }

}