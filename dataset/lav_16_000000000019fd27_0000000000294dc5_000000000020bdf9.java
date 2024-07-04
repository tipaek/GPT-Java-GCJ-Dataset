import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) throws Exception{
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int i =0;i<tc;i++){
    boolean flag=true;
            int n = Integer.parseInt(br.readLine());
            jobs jobs[] = new jobs[n];
            for(int k =0;k<n;k++){
                String a[]= br.readLine().split(" ");

                jobs[k]= new jobs(getInt(a[0]),getInt(a[1]),k);


            }
            Arrays.sort(jobs,new sort());
           
            int s1=0;
            int e1=0;
            int s2=0;
            int e2=0;
            char[] anss = new char[n];
            for(int k=0;k<n;k++){

                int s=jobs[k].s;
                int e = jobs[k].e;
                 if(s>=e1){
                     s1=s;
                     e1=e;
                     jobs[k].w='C';
                     anss[jobs[k].i]='C';
                 } else if(s>=e2){
                     s2 = s;
                     e2=e;
                     jobs[k].w='J';
                     anss[jobs[k].i]='J';

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
       class jobs{
        int s;
        int e;
        int i;
        char w;

        public jobs(int s,int e,int i){
            this.s=s;
            this.e=e;
            this.i=i;
        }

           public void setJ(char j) {
               this.w = j;
           }

       }
    class sort implements Comparator<jobs>{
        @Override
        public int compare(jobs activity, jobs t1) {
            return activity.s-t1.s;
        }
    }

