import java.util.*;


class Solution{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int tr = sc.nextInt();
        for(int i=1;i<=tr;++i){
            int actNum = sc.nextInt();
            List<Character> time = new ArrayList<Character>(1440);
            // char[] time = new char[1440];
            char[] actRes = new char[actNum];
            for(int j=1440;j!=0;--j)
              time.add('N');
            // Arrays.fill(time,'N');
            boolean impossible = false;
            for(int j=0;j<actNum;++j){
                int begin = sc.nextInt();
                int end = sc.nextInt();
                boolean canCameron = true;
                boolean canJamie = true;
                for(int k=begin;k<end;++k){
                    if(time.get(k) == 'C')
                      canCameron = false;
                    if(time.get(k) == 'J')
                      canJamie = false;
                    // if(!canCameron && !canJamie) break;
                }//findout who can be resposible
                for(int k=begin;k<end;++k){
                    if(canCameron) time.set(k, 'C');
                    else{
                      if(canJamie) time.set(k, 'J');
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