import java.util.*;


class Solution{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int tr = sc.nextInt();
        for(int i=1;i<=tr;++i){
            int actNum = sc.nextInt();
            char[] time = new char[1440];
            char[] actRes = new char[actNum];
            Arrays.fill(time,'N');
            boolean impossible = false;
            for(int j=0;j<actNum;++j){
                int begin = sc.nextInt();
                int end = sc.nextInt();
                boolean canCameron = true;
                boolean canJamie = true;
                for(int k=begin;k<end;++k){
                    if(time[k] == 'C')
                      canCameron = false;
                    else if(time[k] == 'J')
                      canJamie = false;
                }//findout who can be resposible
                for(int k=begin;k<end;++k){
                    if(canCameron) time[k] = 'C';
                    else{
                      if(canJamie) time[k] = 'J';
                      else impossible = true;
                    }
                }//update time array

                if(impossible){
                  System.out.println("Case #"+i+": "+"IMPOSSIBLE");
                  break;
                }

                if(canCameron) actRes[j] = 'C';
                else actRes[j] = 'J';
            }//end of j loop: for each activity
            if(impossible) continue;
            System.out.print("Case #"+i+": ");
            for(char who: actRes)
                System.out.print(who);
            System.out.println();
        }   
    
        sc.close();
    }
}