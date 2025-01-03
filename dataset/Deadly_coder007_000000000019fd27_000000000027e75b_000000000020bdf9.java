

import java.util.Scanner;
import java.util.TreeMap;

public class Solution{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int x=s.nextInt();
        for(int i=0;i<x;i++){
            int n=s.nextInt();
            TreeMap<Integer,String> data=new TreeMap<>();
            for(int j=0;j<n;j++){
                int start=s.nextInt();
                int end=s.nextInt();
                data.put(start,String.valueOf(end)+","+String.valueOf(j));
            }
            int CE=-1;
            int JE=-1;
            char[] out=new char[n];
            int flag=0;
            for(int str:data.keySet()){
                if(str>=CE){
                    CE=Integer.parseInt(data.get(str).split(",")[0]);
                    out[Integer.parseInt(data.get(str).split(",")[1])]='C';
                    continue;
                }
                if(str>=JE){
                    JE=Integer.parseInt(data.get(str).split(",")[0]);
                    out[Integer.parseInt(data.get(str).split(",")[1])]='J';
                    continue;
                }
                flag=1;
            }
            if(flag!=1)
            System.out.println("Case #"+(i+1)+": "+String.valueOf(out));
            else
            System.out.println("Case #"+(i+1)+": "+"Impossible");
        }
    }
}
