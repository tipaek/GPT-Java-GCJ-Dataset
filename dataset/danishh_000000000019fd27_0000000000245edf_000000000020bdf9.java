import java.util.*;

class Solution{

   static Scanner s = new Scanner(System.in);

    public static void main(String args[]){
    int T = s.nextInt();
    while(T--!=0){
        int x=s.nextInt();
        task(x);
    }//end while
    }//end main

    static boolean  Jworking = false;
    static int Js = 0;
    static int Je = 0;
    static boolean Cworking = false;
    static int count = 1;
    static int Cs = 0;
    static int Ce = 0;
    static String a="";

    public static void task(int row){
        int ar[][] = new int[row][2];
        
        for(int i=0; i<row; i++){
            ar[i][0] = s.nextInt();
            ar[i][1] = s.nextInt();
        }//for end
        
        
        for(int i=0; i<row; i++){
            if (Cs<=ar[i][1] && Ce<=ar[i][0]){

                System.out.println("Jworking");
                Cworking=true;
                Cs=ar[i][0];
                Ce=ar[i][1];
                a=a+"C";
            }else if(Js<=ar[i][1] && Je<=ar[i][0]){
                System.out.println("Jworking");
                Jworking=true;
                Js=ar[i][0];
                Je=ar[i][1];
                a=a+"J";
            }else{
                a= "IMPOSSIBLE";
                break;
            }   
            
        }
        
        System.out.println("Case #"+count+": "+a);

        count++;        
        
    }//end task
    
}