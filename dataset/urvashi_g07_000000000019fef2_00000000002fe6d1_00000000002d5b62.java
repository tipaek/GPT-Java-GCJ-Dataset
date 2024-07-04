import java.util.Scanner;
class Solution {
    public static void main(String[] args) {
        Scanner scrn=new Scanner(System.in);
        int T=scrn.nextInt();
        while(T>0){
            int x=scrn.nextInt();
            int y=scrn.nextInt();
            int total=Math.abs(x)+Math.abs(y);
            double max=Math.log(total)/Math.log(2);
            max=Math.ceil(max);
            String ans=findsteps(x,y,(int)max,0,0,0,"");
            if(ans.equals("")){
                System.out.println("IMPOSSIBLE");
            }
            else{
                System.out.println(ans);
            }
            T--;
        }
    }
    public static String findsteps(int x,int y,int max,int i,int j,int steps,String ans){
        if(steps>max){
            return "";
        }
        if(i==x&&y==j) {
            return ans;
        }
        String ans1=findsteps(x,y,max,i+(int)Math.pow(2,steps),j,steps+1,ans+'E');
        String ans2=findsteps(x,y,max,i,j+(int)Math.pow(2,steps),steps+1,ans+'N');
        String ans3=findsteps(x,y,max,i,j-(int)Math.pow(2,steps),steps+1,ans+'S');
        String ans4=findsteps(x,y,max,i-(int)Math.pow(2,steps),j,steps+1,ans+"W");
        if(!ans1.equals("")){
            return ans1;
        }else if(!ans2.equals("")){
            return ans2;
        }
        else if(!ans3.equals("")){
            return ans3;
        }else{
            return ans4;
        }
    }
}
