import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = s.nextInt(); 
    try{
    for(int i = 1;i<=t;i++){
        String a = "";
        int n =s.nextInt();
        int ans[][]=new int[n][n];
        int k = s.nextInt();
        if(n==2){
            if(k==2){
                a = "POSSIBLE";
                ans[0][0]=1;ans[0][1]=2;
                ans[1][0]=2;ans[1][1]=1;
            }
            else{a="IMPOSSIBLE";}
        }
        else if(n==3){
            if(k==6){
                a = "POSSIBLE";
                ans[0][0]=1;ans[0][1]=2;ans[0][2]=3;
                ans[1][0]=2;ans[1][1]=3;ans[1][2]=1;
                ans[2][0]=3;ans[2][1]=1;ans[2][2]=2;
            }
            else if(k==3){
                a = "POSSIBLE";
                ans[0][0]=1;ans[0][1]=2;ans[0][2]=3;
                ans[1][0]=3;ans[1][1]=1;ans[1][2]=2;
                ans[2][0]=2;ans[2][1]=3;ans[2][2]=1;
            }
            else if(k==9){
                a = "POSSIBLE";
                ans[0][0]=3;ans[0][1]=1;ans[0][2]=2;
                ans[1][0]=2;ans[1][1]=3;ans[1][2]=1;
                ans[2][0]=2;ans[2][1]=3;ans[2][2]=1;
            }
            else{a="IMPOSSIBLE";}
        }
        else if(n==4){
            if(k==10){
                a = "POSSIBLE";
                ans[0][0]=4;ans[0][1]=1;ans[0][2]=2;ans[0][3]=3;
                ans[1][0]=1;ans[1][1]=4;ans[1][2]=3;ans[1][3]=2;
                ans[2][0]=2;ans[2][1]=3;ans[2][2]=1;ans[2][3]=4;
                ans[3][0]=3;ans[3][1]=2;ans[3][2]=4;ans[3][3]=1;
            }
            else if(k==16){
                a = "POSSIBLE";
                ans[0][0]=4;ans[0][1]=2;ans[0][2]=3;ans[0][3]=1;
                ans[1][0]=1;ans[1][1]=4;ans[1][2]=2;ans[1][3]=3;
                ans[2][0]=3;ans[2][1]=1;ans[2][2]=4;ans[2][3]=2;
                ans[3][0]=2;ans[3][1]=3;ans[3][2]=1;ans[3][3]=4;          
            }
            else if(k==12){
                a = "POSSIBLE";
                ans[0][0]=3;ans[0][1]=1;ans[0][2]=2;ans[0][3]=4;
                ans[1][0]=4;ans[1][1]=3;ans[1][2]=1;ans[1][3]=2;
                ans[2][0]=2;ans[2][1]=4;ans[2][2]=3;ans[2][3]=1;
                ans[3][0]=1;ans[3][1]=2;ans[3][2]=4;ans[3][3]=3;
            }
            else if(k==8){
                a = "POSSIBLE";
                ans[0][0]=2;ans[0][1]=1;ans[0][2]=3;ans[0][3]=4;
                ans[1][0]=1;ans[1][1]=2;ans[1][2]=4;ans[1][3]=3;
                ans[2][0]=4;ans[2][1]=3;ans[2][2]=2;ans[2][3]=1;
                ans[3][0]=3;ans[3][1]=4;ans[3][2]=1;ans[3][3]=2;
            }
            else if(k==11){
                a = "POSSIBLE";
                ans[0][0]=1;ans[0][1]=2;ans[0][2]=3;ans[0][3]=4;
                ans[1][0]=3;ans[1][1]=4;ans[1][2]=2;ans[1][3]=1;
                ans[2][0]=2;ans[2][1]=1;ans[2][2]=4;ans[2][3]=3;
                ans[3][0]=4;ans[3][1]=3;ans[3][2]=1;ans[3][3]=2;
            }
            else if(k==7){
                a = "POSSIBLE";
                ans[0][0]=3;ans[0][1]=2;ans[0][2]=4;ans[0][3]=1;
                ans[1][0]=4;ans[1][1]=1;ans[1][2]=2;ans[1][3]=3;
                ans[2][0]=2;ans[2][1]=3;ans[2][2]=1;ans[2][3]=4;
                ans[3][0]=1;ans[3][1]=4;ans[3][2]=3;ans[3][3]=2;
            }
            else if(k==4){
                a = "POSSIBLE";
                ans[0][0]=1;ans[0][1]=2;ans[0][2]=3;ans[0][3]=4;
                ans[1][0]=4;ans[1][1]=1;ans[1][2]=2;ans[1][3]=3;
                ans[2][0]=3;ans[2][1]=4;ans[2][2]=1;ans[2][3]=2;
                ans[3][0]=2;ans[3][1]=3;ans[3][2]=4;ans[3][3]=1;
            }
            else if(k==9){
                a = "POSSIBLE";
                ans[0][0]=1;ans[0][1]=2;ans[0][2]=3;ans[0][3]=4;
                ans[1][0]=4;ans[1][1]=3;ans[1][2]=1;ans[1][3]=2;
                ans[2][0]=2;ans[2][1]=1;ans[2][2]=4;ans[2][3]=3;
                ans[3][0]=3;ans[3][1]=4;ans[3][2]=2;ans[3][3]=1;
            }
            else{a="IMPOSSIBLE";}
        }
        else if(n==5){
            if(k==5){
                a = "POSSIBLE";
                ans[0][0]=1;ans[0][1]=2;ans[0][2]=3;ans[0][3]=4;ans[0][4]=5;
                ans[1][0]=5;ans[1][1]=1;ans[1][2]=2;ans[1][3]=3;ans[1][4]=4;
                ans[2][0]=4;ans[2][1]=5;ans[2][2]=1;ans[2][3]=2;ans[2][4]=3;
                ans[3][0]=3;ans[3][1]=4;ans[3][2]=5;ans[3][3]=1;ans[3][4]=2;
                ans[4][3]=2;ans[4][3]=3;ans[4][3]=4;ans[4][3]=5;ans[4][4]=1;
            }
            else if(k==10){
                a = "POSSIBLE";
                ans[0][0]=2;ans[0][1]=1;ans[0][2]=3;ans[0][3]=4;ans[0][4]=5;
                ans[1][0]=5;ans[1][1]=2;ans[1][2]=1;ans[1][3]=3;ans[1][4]=4;
                ans[2][0]=4;ans[2][1]=5;ans[2][2]=2;ans[2][3]=1;ans[2][4]=3;
                ans[3][0]=3;ans[3][1]=4;ans[3][2]=5;ans[3][3]=2;ans[3][4]=1;
                ans[4][3]=1;ans[4][3]=3;ans[4][3]=4;ans[4][3]=5;ans[4][4]=2;
            }
           else if(k==15){
                a = "POSSIBLE";
                ans[0][0]=3;ans[0][1]=1;ans[0][2]=2;ans[0][3]=4;ans[0][4]=5;
                ans[1][0]=5;ans[1][1]=3;ans[1][2]=1;ans[1][3]=2;ans[1][4]=4;
                ans[2][0]=4;ans[2][1]=5;ans[2][2]=3;ans[2][3]=1;ans[2][4]=2;
                ans[3][0]=2;ans[3][1]=4;ans[3][2]=5;ans[3][3]=3;ans[3][4]=1;
                ans[4][3]=1;ans[4][3]=2;ans[4][3]=4;ans[4][3]=5;ans[4][4]=3;
            }
            else if(k==20){
                a = "POSSIBLE";
                ans[0][0]=4;ans[0][1]=1;ans[0][2]=2;ans[0][3]=3;ans[0][4]=5;
                ans[1][0]=5;ans[1][1]=4;ans[1][2]=1;ans[1][3]=2;ans[1][4]=3;
                ans[2][0]=3;ans[2][1]=5;ans[2][2]=4;ans[2][3]=1;ans[2][4]=2;
                ans[3][0]=2;ans[3][1]=3;ans[3][2]=5;ans[3][3]=4;ans[3][4]=1;
                ans[4][3]=1;ans[4][3]=2;ans[4][3]=3;ans[4][3]=5;ans[4][4]=4;
            }
            else if(k==25){
                a = "POSSIBLE";
                ans[0][0]=5;ans[0][1]=1;ans[0][2]=2;ans[0][3]=3;ans[0][4]=4;
                ans[1][0]=4;ans[1][1]=5;ans[1][2]=1;ans[1][3]=2;ans[1][4]=3;
                ans[2][0]=3;ans[2][1]=4;ans[2][2]=5;ans[2][3]=1;ans[2][4]=2;
                ans[3][0]=2;ans[3][1]=3;ans[3][2]=4;ans[3][3]=5;ans[3][4]=1;
                ans[4][3]=1;ans[4][3]=2;ans[4][3]=3;ans[4][3]=4;ans[4][4]=5;
            }
            else{a="IMPOSSIBLE";}

    }
    if(a=="POSSIBLE"){
    System.out.println("Case #"+i+": "+a);
    //System.out.println();
    for(int l=0;l<n;l++){
        for(int m=0;m<n;m++)
            System.out.print(ans[l][m]+" ");
        System.out.println();
    }
  }
  else
    System.out.println("Case #"+i+": "+a);
}
}catch(Exception e){}
}
}

