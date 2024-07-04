

import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int total = in.nextInt();

        for(int i=0;i<total;i++){

            int round = in.nextInt();in.nextLine();

            String [] grammar = new String[round];

            for(int j=0;j<round;j++) {
                grammar[j] = in.nextLine();
            }
            boolean flag = true,flag1=true;
            for(int j=0;j<round;j++){
                String match = grammar[j].replace("*","");

                for(int k=0;k<round;k++){
                    if(!match.contains(grammar[k].replace("*",""))){
                        flag=false;
                    }
                }
                if(flag){
                    String result = grammar[j].replace("*","A");
                    System.out.println("Case #"+(i+1)+": "+result);flag1=false;break;
                }
                }
            if(flag1==false && flag==true){
                System.out.println("Case #"+(i+1)+": *");
            }

            }
        }
    }

