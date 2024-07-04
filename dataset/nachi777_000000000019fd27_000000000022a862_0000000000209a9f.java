import java.io.*;
import java.util.*;

public class Solution{

	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine());
            for(int k=1;k<=t;k++){
            String[] str=br.readLine().split("");
            ArrayList<String> a=new ArrayList<>();
            int[] arr=new int[str.length];
            for(int i=0;i<str.length;i++){
            arr[i]=Integer.parseInt(str[i]);
            
            }
            
            for(int i=0;i<arr[0];i++){
            a.add("(");
            }
            int curr=arr[0];
            a.add(str[0]);
            int diff;
            for(int i=1;i<str.length;i++){
                diff=arr[i]-arr[i-1];
                if(diff>0){
                    for(int j=1;j<=diff;j++)
                        a.add("(");
                }
                else if(diff<0){
                    for(int j=1;j<=Math.abs(diff);j++)
                        a.add(")");
                }
                
                a.add(str[i]);
            }
            for(int j=1;j<=arr[str.length-1];j++)
                a.add(")");
            
                System.out.print("Case #"+k+": ");
            for(int i=0;i<a.size();i++)
                    System.out.print(a.get(i));
            
                System.out.println("");
            }
            }
            }