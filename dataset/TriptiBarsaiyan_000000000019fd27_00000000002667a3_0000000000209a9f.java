import java.util.Scanner;
 class Solution {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            String s=in.next();
            String a[]=s.split("");
            int b[]=new int[a.length],c1=0;
            String sb=new String();
            for(int j=0;j<a.length;j++){
                b[j]=Integer.parseInt(a[j]);
                }
                
            for(int k=0;k<b[0];k++){
                        sb+="(";
                        c1++;
                    }
                    sb+=""+b[0];
            for(int k=0;k<b.length-1;k++)
            {  if(b[k+1]==0){
                for(int l=0;l<c1;l++)
                    sb+=")";
                sb+="0";
                c1=0;
                continue;
            }
              if(b[k]<b[k+1]){
                 for(int l=0;l<(b[k+1]-b[k]);l++)
                   {  sb+="(";
                   c1++;}
                  sb+=""+b[k+1];
                 
             }else if(b[k+1]<b[k]){
                 for(int l=0;l<(b[k]-b[k+1]);l++){
                     sb+=")";
                     c1--;
                 }
                  sb+=""+b[k+1];
                 
             }else{
                  sb+=""+b[k+1];
             } 
            }
            for(int h=0;h<c1;h++)
                sb+=")";
            System.out.println("Case #"+(i+1)+": "+sb);
        }
    }
}
