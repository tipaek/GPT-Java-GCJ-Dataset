import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
import java.util.Collections;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.lang.*;
import java.io.*;
class Pair{
    int start,end;
    Pair(int x,int y){
        start=x;
        end=y;
    }
    @Override
    public String toString(){
        return (start+" "+end);
    }
}
class sortEnd implements Comparator<Pair>{
    
    public int compare(Pair a,Pair b){
        if(a.end<b.end){
            return -1;
        }
        else if(a.end>b.end){
            return 1;
        }
        else
            return 0;
    }
    
}
public class Solution{
  public static void main(String[] args) throws Exception{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    int t=Integer.parseInt(br.readLine());
    int real=1;
    while(t-->0){
        int n=Integer.parseInt(br.readLine());
        HashMap<Pair,Character> hm=new HashMap<Pair,Character>();
        ArrayList<Pair> arr=new ArrayList<Pair>();
        ArrayList<Pair> ans=new ArrayList<Pair>();
        int flag=0;
        for(int i=0;i<n;i++){
            String[] inp=br.readLine().split(" ");
            int x=Integer.parseInt(inp[0]);
            int y=Integer.parseInt(inp[1]);
       
            Pair p=new Pair(x,y);
	    hm.put(p,'a');
            arr.add(p);
            ans.add(p);
        }
        Collections.sort(arr,new sortEnd());
        //System.out.println(arr);
        int j=0,c=0,js=0,je=0,cs=0,ce=0;
        for(int i=0;i<n;i++){
            Pair p=arr.get(i);
            if(p.start>=je && p.start>=ce){
                if((p.start-je)>(p.start-ce)){
                    hm.put(p,'C');
                    cs=p.start;
                    ce=p.end;
                }
                else{
                    hm.put(p,'J');
                    js=p.start;
                    je=p.end;
                }
            }
            else if(p.start>=je){
                js=p.start;
                je=p.end;
                hm.put(p,'J');
            }
            else if(p.start>=ce){
                cs=p.start;
                ce=p.end;
                hm.put(p,'C');
            }
            else{
                flag=1;
                break;
            }
        }
        System.out.print("Case #"+real+": ");
        if(flag==1){
            flag=0;
            System.out.print("IMPOSSIBLE");
        }
        else{
            for(int i=0;i<n;i++){
                Pair p=ans.get(i);
                System.out.print(hm.get(p));
            }
        }
        
        real++;
        System.out.println("");
    }
  }
}