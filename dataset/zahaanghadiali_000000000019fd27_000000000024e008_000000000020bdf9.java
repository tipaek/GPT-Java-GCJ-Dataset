import java.util.Scanner;
public class Solution {

 public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int c = 0; c < t; c++) {
            String result="";
            boolean impossible=false;
            int activities = sc.nextInt();
            int start[]=new int[activities];
            int end[]=new int[activities];

            for (int i = 0; i < activities; i++) {
                start[i]=sc.nextInt();
                end[i]=sc.nextInt();
            }
            
            int jcurrent=0,ccurrent=0;
            int jstart=Integer.MAX_VALUE,cstart=Integer.MAX_VALUE;
            
            for(int a=0;a<start.length;a++){
                if(jcurrent<=start[a]){
                    jcurrent=end[a];
                    jstart=start[a];
                    result+="J";
                    
                }
                else if(end[a]<jstart){
                    jcurrent=end[a];
                    jstart=start[a];
                    result+="J";
                }
                
                else if(end[a]<cstart){
                    ccurrent=end[a];
                    cstart=start[a];
                    result+="C";
                }
                else if(ccurrent<=start[a]){
                    ccurrent=end[a];
                    cstart=start[a];
                    result+="C";
                    
                }
                
                else
                {
                    impossible=true;
                    
                }
            }
            if(impossible){
                System.out.println("Case #"+(c+1)+": IMPOSSIBLE");
            }
            else{
               System.out.println("Case #"+(c+1)+": "+result); 
            }
            
        }
    }
}