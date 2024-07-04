import java.util.Scanner;
public class Solution {

 public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int c = 0; c < t; c++) {
            String result="";
            boolean jbusy=false, cbusy=false, impossible=false;
            int activities = sc.nextInt();
            int start[]=new int[activities];
            int end[]=new int[activities];

            for (int i = 0; i < activities; i++) {
                start[i]=sc.nextInt();
                end[i]=sc.nextInt();
            }
            
            int jcurrent=0,ccurrent=0;
            
            for(int a=0;a<start.length;a++){
                if(jcurrent<=start[a]){
                    jcurrent=end[a];
                    result+="J";
                    if(jcurrent<end[a]){
                        ccurrent=0;
                    }
                    
                }
                else if(ccurrent<=start[a]){
                    ccurrent=end[a];
                    result+="C";
                    if(jcurrent<end[a]){
                        jcurrent=0;
                    }
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