

import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();
        for(int i=1;i<=t;i++){
            int x = in.nextInt();
            int y = in.nextInt();
            boolean oppx=false;
            boolean oppy=false;
            if(x<0 && y<0){
                oppx=true;
                oppy=true;

            }
            if(x<0&&y>=0){
                oppx=true;
            }
            if(x>=0&&y<0){
                oppy=true;
            }
            x=Math.abs(x);
            y=Math.abs(y);
            String ans = "";
            boolean pos=true;
            if(x==0 && y==1){
                ans="N";
            }
            else if(x==0&&y==3){
                ans="NN";
            }
            else if(x==1&&y==0){
                ans="E";
            }
            else if(x==1&&y==2){
                ans="EN";
            }
            else if(x==2&&y==1){
                ans="NE";
            }
            else if(x==2&&y==3){
                ans="SEN";
            }
            else if(x==3&&y==0){
                ans="EE";
            }
            else if(x==3&&y==4){
                ans="EEN";
            }
            else
                pos=false;
            String opAns="";
            if(oppx&&oppy){

                for(int k=0;k<ans.length();k++){
                    if(ans.charAt(k)=='N'){
                        opAns+="S";
                    }
                    if(ans.charAt(k)=='S'){
                        opAns+="N";
                    }
                    if(ans.charAt(k)=='E'){
                        opAns+="W";
                    }
                    if(ans.charAt(k)=='W'){
                        opAns+="E";
                    }
                }
            }
            else if(oppx){

                for(int k=0;k<ans.length();k++){
                    if(ans.charAt(k)=='E'){
                        opAns+="W";
                    }
                    if(ans.charAt(k)=='W'){
                        opAns+="E";
                    }
                }
            }
            else if(oppy){

                for(int k=0;k<ans.length();k++){
                    if(ans.charAt(k)=='N'){
                        opAns+="S";
                    }
                    if(ans.charAt(k)=='S'){
                        opAns+="N";
                    }
                }
            }
            else {
                printAns(i, ans);
                continue;
            }
            if(!pos)
                printAns(i,"IMPOSSIBLE");
            else
                printAns(i,opAns);
        }
    }

    public static void printAns(int i,Object ans){
        System.out.println("Case #"+i+": "+ans.toString());
    }
}
