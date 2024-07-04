import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) throws Exception{
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i =0;i<t;i++){
    boolean flag=true;
            int n = Integer.parseInt(br.readLine());
            activity activity[] = new activity[n];
            for(int k =0;k<n;k++){
                String a[]= br.readLine().split(" ");

                activity[k]= new activity(getInt(a[0]),getInt(a[1]),k);


            }
            Arrays.sort(activity,new sort());
            int cs=0;
            int ce=0;
            int js=0;
            int je=0;
            char[] anss = new char[n];
            for(int k=0;k<n;k++){

                int s=activity[k].s;
                int e = activity[k].e;
                 if(s>=ce){
                     cs=s;
                     ce=e;
                     activity[k].w='C';
                     anss[activity[k].i]='C';
                 } else if(s>=je){
                     js = s;
                     je=e;
                     activity[k].w='J';
                     anss[activity[k].i]='J';

                 } else{
                     flag=false;
                     System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
                     break;
                 }

            }
            if(flag){
                System.out.print("Case #"+(i+1)+": ");
                for(int k =0;k<n;k++){
                    System.out.print(anss[k]);
                }
                System.out.println();

            }





        }

    }
    public static int getInt(String s){
        return Integer.parseInt(s);

}
}
       class activity{
        int s;
        int e;
        int i;
        char w;

        public activity(int s,int e,int i){
            this.s=s;
            this.e=e;
            this.i=i;
        }

           public void setJ(char j) {
               this.w = j;
           }

       }
    class sort implements Comparator<activity>{
        @Override
        public int compare(activity activity, activity t1) {
            return activity.s-t1.s;
        }
    }

