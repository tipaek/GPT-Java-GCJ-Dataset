import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String s;
        String[] line;
        for(int i=1;i<=T;i++){
			s=br.readLine();
            char[] arr=s.toCharArray();
            System.out.print("Case #"+i+": ");
            if(arr.length==1){
				if(arr[0]=='1') System.out.print("("+arr[0]+")");
				else System.out.print(arr[0]);
			}else{
				if(arr[0]=='1') System.out.print("(1");
				else System.out.print("0");
				
				for(int x=1;x<arr.length;x++){
					
					if(arr[x-1]=='1' && arr[x]=='0'){
						System.out.print(")"+arr[x]);
					}else if(arr[x-1]=='0' && arr[x]=='1'){
						System.out.print("("+arr[x]);
					}else if(arr[x-1]=='1' && arr[x]=='1'){
						System.out.print(arr[x]);
					}else{
						System.out.print(arr[x]);
					}    
						   
							
				}
				if(arr[arr.length-1]=='1') System.out.print(")");
				else System.out.print("");
				System.out.println();    
        }
	}
    }
			
				

    
       
}
