//package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for (int k=0;k<t;k++){
            String st=br.readLine();
            String[] str=st.split("");

            String newstr = "";

            int open=0;
                    for(String i:str)
                    {
                        int n=Integer.parseInt(i);
                        if(n>open)
                            for(;open!=n;open++)
                                newstr +="(";
                        else if(n<open)
                            for(;open!=n;open--)
                                newstr +=")";
                        newstr+=i;
                    }
                    while (open-->0)
                        newstr +=")";
                    System.out.println("Case #"+(k+1)+": "+newstr);
                   // cout<<"Case #"<<tc+1<<": "<<newstr<<endl;
                }

            }
        }

