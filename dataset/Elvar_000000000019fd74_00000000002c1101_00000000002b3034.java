import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int x = 1; x<=T; x++){
            int N = sc.nextInt();
            String[] strengir = new String[N];
            for(int i = 0; i<N;i++){
                strengir[i] = sc.next();
            }
            String b = barn(strengir[0],strengir[1]);
            int j =2;
            while(!b.equals("*") && j<N){
                b = barn(b,strengir[j]);
                j++;
            }
            if(!b.equals("*")){
                b = fjarlaegja(b);
            }
            System.out.println("Case #"+x+": "+b);
        }
    }
    public static String barn(String A, String B){
        String S = "";
        int ia = 0;
        int ib =0;
        while(A.charAt(ia) != '*') ia++;
        while(B.charAt(ib) != '*') ib++;
        if(ia<ib){
            for(int i = 0; i<ia; i++){
                if(A.charAt(i) != B.charAt(i)) return "*";
                else S+=A.charAt(i);
            }
            for(int i = ia; i<ib; i++) S+= B.charAt(i);
        }
        else{
            for(int i = 0; i<ib; i++){
                if(B.charAt(i) != A.charAt(i)) return "*";
                else S+=B.charAt(i);
            }
            for(int i = ib; i<ia; i++) S+= A.charAt(i);
        }
        S+= "*";
        ia++;
        ib++;
        int na = A.length();
        int nb = B.length();
        if(na-ia>nb-ib){
            for(int i = ia; i<na-nb+ib; i++){
                S+= A.charAt(i);
            }
            int j = ib;
            for(int i = na-nb+ib; i<na; i++){
                if(A.charAt(i) != B.charAt(j)) return "*";
                S+=A.charAt(i);
                j++;
            }
        }
        else{
            for(int i = ib; i<-na+nb+ia; i++){
                S+= B.charAt(i);
            }
            int j = ia;
            for(int i = nb-na+ia; i<nb; i++){
                if(A.charAt(j) != B.charAt(i)) return "*";
                S+=B.charAt(i);
                j++;
            }
        }
        return S;
        
        
    }
    public static String fjarlaegja(String b){
        String bn = "";
        for(int i = 0; i<b.length();i++){
            if(b.charAt(i) != '*') bn+=b.charAt(i);
        }
        return bn;
    }
}