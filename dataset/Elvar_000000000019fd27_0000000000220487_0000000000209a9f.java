import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int x = 1; x<=T; x++){
            String S = sc.next();
            int n = S.length();
            int[] H = new int[n];
            int[] V = new int[n];
            int[] a = new int[n];
            for(int i = 0; i<n;i++){
                a[i] = Integer.parseInt(""+S.charAt(i));
            }
            for(int i = 0; i<n; i++){
                int mest = a[0];
                int stadur = 0;
                for(int j = 0; j<n; j++){
                    if(mest<a[j]){
                        mest = a[j];
                        stadur = j;
                    }
                }
                int k = stadur;
                while(k<=n-2 && a[k+1] == a[k]) k++; //a[k] == a[stadur]
                if(stadur == 0){
                    int munur = mest;
                    if(k<n-1)
                        munur = mest-a[k+1];
                    V[stadur]+= munur;
                    H[k]+= munur;
                    for(int j = 0; j<k+1;j++) a[j] -= munur;
                }
                else if(stadur == n-1){
                    int munur = mest-a[stadur-1];
                    V[stadur] += munur;
                    H[stadur] += munur;
                    a[stadur]-= munur;
                        
                }
                else{
                    int munur = mest;
                    if((k == n-1) || a[stadur-1]>a[k+1]){
                        munur = a[stadur]-a[stadur-1];
                        V[stadur] += munur;
                        H[k] += munur;
                        for(int j = stadur; j<k+1; j++) a[j]-= munur;
                            
                    }
                    else{
                        munur = mest-a[k+1];
                        V[stadur]+= munur;
                        H[k] += munur;
                        for(int j = stadur; j<k+1; j++) a[j]-= munur;
                    }
                }
            }
            
            String s = "";
            for(int i = 0; i<n; i++){
                for(int j = 0; j<V[i];j++) s+= "(";
                s+= S.charAt(i);
                for(int j = 0; j<H[i];j++) s+=")";
            }
            System.out.println("Case #"+x+": "+s);
            
        }
        
    }
    
}