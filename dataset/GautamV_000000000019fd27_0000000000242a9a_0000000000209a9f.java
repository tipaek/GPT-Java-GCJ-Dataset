import java.util.*;
import java.io.*;
class Solution{
public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count=0;
        int T = 0;
        String input = "", output = "";
        int n = 0;
        int cop=0, ccp=0;
        int index = 0;
		int temp =0;
        while(T<1 || T>100){
            T = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<T; i++){
            input = br.readLine();
            int ar[] = new int[input.length()];
            for(int j=0; j< input.length(); j++){
                ar[j] = Character.getNumericValue(input.charAt(j));
            }
            for(int j=0; j< ar.length; j++){
                if(ar[j]==0){
                    output += ar[j];
                    index = j;
                    while((index<ar.length-1) && (ar[j] == ar[index+1])){
						System.out.println("Line 25 "+index);
                        output += ar[j];
                        index++;
                    }
					j++;
                }
                else{
                    for(int k=cop; k<ar[j]; k++){
                        output +="(";
                        cop++;
                    }
					//temp = index;
                    //index = j;
					//j = temp;
					if(count==0){
						output += ar[j];
						count++;
					}
					//output += ar[j];
					//j++;
                    while((index<ar.length-1) && (ar[j] == ar[index+1])){    //&& (j<ar.length)
                        System.out.println("Line 37"+index);
						output += ar[j];
                        index++;
                    }
                    if((ar[j]-ar[index])<0){
                        for(int k=cop; k< ar[j]; k++){//(ar[j]-ar[index])
                            output += "(";
                            cop++;
                        }
						
                    }
                    else{
                        for(int k=0; k<(ar[j]-ar[index]); k++){
                            output += ")";
                            ccp++;
                        }
                    }
                }
                
            }
        }
        if(cop>ccp){
            for(int i=0; i<(cop-ccp); i++){
                output += ")";
            }
        }
		System.out.println(output);
    }
}
