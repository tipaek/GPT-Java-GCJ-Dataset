import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scrn=new Scanner(System.in);
        int T=scrn.nextInt();
        int k=1;
        while(T>0){
            int N=scrn.nextInt();
            int []S=new int[N];
            int []E=new int[N];
            for(int i=0;i<N;i++){
                S[i]=scrn.nextInt();
                E[i]=scrn.nextInt();
            }
            StringBuilder sb=new StringBuilder();
            sb.append('C');
            int JStart=-1;
            int JEnd=-1;
            int CStart=S[0];
            int CEnd=E[0];
            boolean possible=true;
            for(int i=1;i<N;i++){
               if(S[i]>=CEnd||E[i]<=CStart){
                 CStart=Math.min(S[i],CStart);
                 CEnd=Math.max(E[i],CEnd);
                 sb.append('C');
               }
               else if(JStart==-1&&JEnd==-1){
                   JStart=S[i];
                   JEnd=E[i];
                   sb.append('J');
               }else if(S[i]>=JEnd||E[i]<=JStart){
                   JStart=Math.min(S[i],JStart);
                   JEnd=Math.max(E[i],JEnd);
                   sb.append('J');
               }else{
                   possible=false;
                   break;
               }
            }
            if(!possible){
                System.out.println("Case #"+k+": IMPOSSIBLE");
            }
            else{
                System.out.println("Case #"+k+": "+sb.toString());
            }
            k++;
            T--;
        }
    }
}
