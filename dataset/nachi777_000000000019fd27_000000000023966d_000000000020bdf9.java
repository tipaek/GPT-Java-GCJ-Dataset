import java.io.*;
import java.util.*;

public class Solution{

	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine());
            for(int k=1;k<=t;k++){
            int c1=0,c2=0,j1=0,j2=0;
            int x,y;
            int flag=0;
            int n=Integer.parseInt(br.readLine());
            ArrayList<String> a=new ArrayList<>();
             String[] st=br.readLine().split(" ");
            x=Integer.parseInt(st[0]);
            y=Integer.parseInt(st[1]);
              j1=x;j2=y;
              a.add("J");
            for(int i=1;i<n;i++){
            String[] str=br.readLine().split(" ");
            x=Integer.parseInt(str[0]);
            y=Integer.parseInt(str[1]);
            
             if((j2<=x && (j1<=y)) ||(j2>=x && j1>=y) ){
                j1=Math.min(x,j1);j2=Math.max(y,j2);
                a.add("J");
            }
             else if((c1<=y && c2<=x) ||( c1>=y && c2>=x)  ){
                a.add("C");
                if(c1!=0)
                c1=Math.min(x,c1);
                else
                    c1=x;
                if(c2!=0)
                c2=Math.max(y,c2);
                else
                    c2=y;
            }
            else{
               flag=1;
               //break;
            }  
                //System.out.println(a);
            }
            
                if(flag==1){
                    System.out.print("Case #"+k+": ");
                    System.out.println("IMPOSSIBLE");
                }
                else{
                    System.out.print("Case #"+k+": ");
                    for(int i=0;i<a.size();i++)
                        System.out.print(a.get(i));
                    
                    System.out.println("");
                }
            }
            }
            }