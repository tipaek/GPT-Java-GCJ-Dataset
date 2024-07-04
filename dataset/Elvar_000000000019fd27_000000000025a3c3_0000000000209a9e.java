import java.util.Scanner;


public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int B = sc.nextInt();
        for(int x = 0; x<T;x++){
            int[] A = new int[B];
            for(int i = 0; i<B; i++) A[i] = -1;
            for(int i = 1; i<=5; i++){
                System.out.println(i);
                A[i-1] = sc.nextInt();
            }
            for(int i = 0; i<=4; i++){
                System.out.println(B-i);
                A[B-i-1] = sc.nextInt();
            }
            int stadureins = -1;
            int stadurolikur = -1;
            for(int r = 0; r<B/8+5; r+=4){
                
            for(int i = 0; i<5 ;i++){
                if(A[r+i] == A[B-i-1-r] && A[r+i] != -1) stadureins = r+i;
                else if (A[r+i] != -1) stadurolikur = r+i;
            }
            if(stadureins == -1){ //t.d. 11111 .... 00000
                System.out.println(1);
                int a = sc.nextInt();
                System.out.println(1);
                a = sc.nextInt();
                if(A[0]!= a){
                    rev(A);
                }
            }
            else if(stadurolikur == -1){ // t.d. 11111 .... 11111
                System.out.println(1);
                int a = sc.nextInt();
                System.out.println(1);
                a = sc.nextInt();
                if(A[0] != a){
                    comp(A);
                }
            }
            else{ // t.d. ..0..1...1..1..
                System.out.println(stadureins+1);
                int a = sc.nextInt();
                System.out.println(stadurolikur+1);
                int b = sc.nextInt();
                if(a != A[stadureins] && b != A[stadurolikur]) 
                    comp(A);
                else if(a== A[stadureins] && b != A[stadurolikur]) 
                    rev(A);
                else if(a!=A[stadureins] && b == A[stadurolikur]){
                    comp(A); 
                    rev(A);
                }
                
            }
            for(int i = r+4+1;i<r+8+1;i++){
                    System.out.println(i+1);
                    A[i] = sc.nextInt();
            }
            for(int i = B-r-4-2; i>B-r-8-2;i--){
                System.out.println((i+1));
                A[i] = sc.nextInt();
            }
            }
            String s = "";
            for(int i = 0; i<B; i++) s+= ""+A[i];
            System.out.println(s);
            
                
        }
    }
    public static void rev(int[] A){
        int n = A.length;
        int[] T = new int[n];
        for(int i = 0; i<n;i++) T[i] = A[n-i-1];
        for(int i = 0; i<n; i++) A[i] = T[i];
    }
    public static void comp(int[] A){
        int n = A.length;
        for(int i = 0; i<n; i++) {
            if(A[i] != -1) A[i] = 1-A[i];
        }
    }
}