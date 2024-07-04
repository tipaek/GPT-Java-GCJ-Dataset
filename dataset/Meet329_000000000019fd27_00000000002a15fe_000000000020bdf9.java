import java.util.Scanner;
import java.util.StringTokenizer;  

public class Solution {
    public static void main(String[] args) {
        //System.out.println(args[0]);
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        //if(testCase > 0){
        sc.nextLine();
        int line=1;
        for (int i = 1; i <= testCase; i++) {
            int[] C = new int[1440];
            int[] J = new int[1440];
            for(int j=0;j<1440;j++){
                C[j]=0;
                J[j]=0;
            }
            String output = "";
            int activities = Integer.parseInt(sc.nextLine());
            //System.out.println("Activities " + activities);
            //activities*=2;
            for(int j=1; j<=activities;j++){
                String newAct = sc.nextLine();
                
                StringTokenizer st = new StringTokenizer(newAct," ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                //System.out.println(newAct + " start:"+ start+" end:"+end);

                boolean boolC=true;
                for(int k=start;k<end;k++){
                    if(C[k]!=0){
                        boolC = false;
                        break;
                    }
                }
                if(boolC){
                    for(int k=start;k<end;k++){
                        C[k]=1;
                    }
                    output=output.concat("C");
                }
                else{
                    boolean boolJ=true;
                    for(int k=start;k<end;k++){
                        if(J[k]!=0){
                            boolJ = false;
                            break;
                        }
                    }
                    if(boolJ){
                        for(int k=start;k<end;k++){
                            J[k]=1;
                        }
                        output=output.concat("J");
                    }
                    else {
                        output = "IMPOSSIBLE";
                        break;
                    }
                }


            }
            System.out.println("Case #"+i+": "+output);
            //line+=activities;
            //line+=1;
            //line+=activities;
        }
        sc.close();
    }
}
