/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/

import java.util.Scanner;
public class Solution {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;k++){
            String s=sc.next();
            String o="",w="";
            int f=0;
            int n=s.length();
            int l=0,r=0;
            for(int i=0;i<n;i++){
                if(s.charAt(i)=='0'){
                    if(f==1){
                        o+=')';
                        f=0;
                    }
                    while(r!=0){
                        r--;
                        o+=')';
                    }
                    if(l!=0){
                        w="";
                       while(l!=0){
                        l--;
                        w+='(';
                        }
                       o=w+o;
                    }
                }else{
                    if(f==0){
                        o+='(';
                        f=1;
                    }else if(s.charAt(i)!=s.charAt((i-1)) && i>=1){
                        r++;
                        l++;
                    }
                }
                while(r!=0){
                        r--;
                        o+=')';
                    }
                    if(l!=0){
                        w="";
                       while(l!=0){
                        l--;
                        w+='(';
                        }
                       w+=o;
                       o=w;
                    }
                    o+=s.charAt(i);
            }
            if(f==1){
                o+=')';
                f=0;
            }
            System.out.println("Case #"+k+": "+o);
        }
    }
}
