import java.io.*;
import java.util.*;

public class Solution{

public static void main(String[] args) throws IOException {
   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int tc=Integer.parseInt(br.readLine());
            for(int k=1;k<=tc;k++){
                int n=Integer.parseInt(br.readLine());
            ArrayList<Data> arr=new ArrayList<>();
           
            for(int i=0;i<n;i++){
                String[] s=br.readLine().split(" ");
                arr.add(new Data(Integer.parseInt(s[0]),Integer.parseInt(s[1]),i));
            }
            Collections.sort(arr);
           
int st,ed;
int c=0,j=0;
int flg=0;
String[] sts=new String[n];
   for(int i=0;i<arr.size();i++){
       if(arr.get(i).st<c && arr.get(i).st<j){
           flg=1;
           break;
       }
       else if(arr.get(i).st>=c){
           sts[arr.get(i).id]="C";
           c=arr.get(i).ed;
       }
       else{
           sts[arr.get(i).id]="J";
           j=arr.get(i).ed;
       }
   }
    System.out.print("Case #"+k+": ");
   if(flg==1){
       System.out.println("IMPOSSIBLE");
   }
   else{
       for(int i=0;i<n;i++){
           System.out.print(sts[i]);
           
       }
       System.out.println("");
   }
            }
            }
            }
            
class Data implements Comparable<Data>{
    int st,ed,id;
    Data(int st,int ed,int id){
        this.st=st;
        this.ed=ed;
        this.id=id;
    }

    @Override
    public int compareTo(Data d2) {
        if(this.st-d2.st==0){
            if(this.ed-d2.ed==0){
                return this.id-d2.id;
            }
            else
                return this.ed-d2.ed;
        }
        else
            return this.st-d2.st;
    }
}            
            
            