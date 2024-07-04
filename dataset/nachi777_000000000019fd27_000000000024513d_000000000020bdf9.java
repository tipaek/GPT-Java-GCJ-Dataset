import java.io.*;
import java.util.*;
class Parent implements Comparable<Parent>{
    int start,end,idx;
    Parent(int start,int end,int idx){
        this.start=start;
        this.end=end;
        this.idx=idx;
    }

    @Override
    public int compareTo(Parent p2) {
        if(this.start-p2.start==0){
            if(this.end-p2.end==0){
                return this.idx-p2.idx;
            }
            else
                return this.end-p2.end;
        } 
        else
            return this.start-p2.start;
    }
}
public class Solution{

	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine());
            for(int k=1;k<=t;k++){
                int n=Integer.parseInt(br.readLine());
            ArrayList<Parent> arr=new ArrayList<>();
            
            for(int i=0;i<n;i++){
                String[] s=br.readLine().split(" ");
                arr.add(new Parent(Integer.parseInt(s[0]),Integer.parseInt(s[1]),i));
            }
            Collections.sort(arr);
            
//            for(int i=0;i<arr.size();i++){
//                System.out.println(arr.get(i).start+" "+arr.get(i).end+" "+arr.get(i).idx);
//            }
int start,end;
int c=0,j=0;
int flag=0;
String[] sss=new String[n];
   for(int i=0;i<arr.size();i++){
       if(arr.get(i).start<c && arr.get(i).start<j){
           flag=1;
           break;
       }
       else if(arr.get(i).start>=c){
           sss[arr.get(i).idx]="C";
           c=arr.get(i).end;
       }
       else{
           sss[arr.get(i).idx]="J";
           j=arr.get(i).end;
       }
   }
    System.out.print("Case #"+k+": ");
   if(flag==1){
       System.out.println("IMPOSSIBLE");
   }
   else{
       for(int i=0;i<n;i++){
           System.out.print(sss[i]);
           
       }
       System.out.println("");
   }
            }
            }
            }