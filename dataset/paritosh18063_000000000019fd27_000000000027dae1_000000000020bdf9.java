import java.util.*;
class Solution {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        for(int i=0;i<t;i++){
            int n=scanner.nextInt();
            int[] s=new int[n];
            int[] e=new int[n];
            for(int j=0;j<n;j++){
                s[j]=scanner.nextInt();
                e[j]=scanner.nextInt();
            }
            for(int x=0;x<n;x++){
                for (int y=0;y!=x&&y<n;y++){
                    if(s[x]<s[y]){
                        int z=s[y];
                        s[y]=s[x];
                        s[x]=z;
                        z=e[y];
                        e[y]=e[x];
                        e[x]=z;
                    }
                }
            }
            String out="";
            int c=-1;
            int j=-1;
            int k=0;
            int m=0;
            int cend=0;
            int jend=0;
            while(k<n) {
                if(k<n){
                    if(s[k]<cend && s[k]<jend){
                        out="IMPOSSIBLE";
                        break;
                    }else if(s[k]>cend&&s[k]<jend){
                        cend=e[k];
                        m++;
                        out+="C";
                    }else if(s[k]<cend&&s[k]>jend){
                        jend=e[k];
                        m++;
                        out+="J";
                    }else{
                        cend=e[k];
                        m++;
                        out+="C";
                    }k++;
                }
            }
            System.out.println("Case #"+(i+1)+": "+out);
        }
    }
}
