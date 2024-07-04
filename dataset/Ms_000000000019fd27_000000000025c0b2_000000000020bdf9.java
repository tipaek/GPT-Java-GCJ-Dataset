import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int k=1;k<=t;k++){
            StringBuilder sb  = new StringBuilder();
            int n = sc.nextInt();
            int arr[][] = new int[n][2];
            boolean bool = false;
            for(int i=0;i<n;i++){
                for(int j=0;j<2;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
           sb.append("J");
           char cr[] = new char[n];
           cr[0] = 'J';
           char b[] = new char[2];
           for(int i=1;i<n;i++){
               char c[] = new char[2];
               for(int j=0;j<i;j++){
                   if(arr[i][0]>arr[j][0] && arr[i][0]<arr[j][1] || arr[i][1]>arr[j][0] && arr[i][1]<arr[j][1]){
                        if(c[0]=='\u0000')
                            c[0]=cr[j];
                        else if(c[0]==cr[j])
                            c[1] = '\u0000';
                        else{
                            if(c[0]=='J')
                                c[1]='C';
                            else
                                c[1]='J';
                        }
                   }
               }
                if(c[0]=='\u0000')
                    sb.append("J");
                else if(c[1]=='\u0000'){
                    if(c[0]=='C')
                        sb.append('J');
                    else{
                        sb.append('C');
                    }
                    }
                else{
                    bool  = true;
                    break;
                }    
           }
           if(bool)
                System.out.println("Case #"+k+": IMPOSSIBLE");
           else{
           String str = sb.toString();
           System.out.println("Case #"+k+": "+str);
           }
        }
    }
}