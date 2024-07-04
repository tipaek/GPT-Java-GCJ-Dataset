import java.io.*;
import java.util.HashMap;

public class Solution{
    public static void main(String[] args)throws IOException {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine());
            for(int i=0;i<t;i++){
                String str=br.readLine();
                String[] arr_start=new String[10];
                String[] arr_end=new String[10];
                String temp_start="";
                String temp_end="";
                arr_start[0]=temp_start;
                arr_end[0]=temp_end;
                for (int j = 1; j < arr_start.length; j++) {
                    temp_start=temp_start.concat("(");
                    temp_end=temp_end.concat(")");
                    arr_start[j]=temp_start;
                    arr_end[j]=temp_end;
                }
                String result="";
                for (int j = 0; j < str.length(); j++) {
                    char c=str.charAt(j);
                    int index=c-'0';
                    result=result+arr_start[index]+index+arr_end[index];
                }
                int count=0,prev=0;
                String final_result="";
                for (int j = 0; j < result.length();) {
                    int value=result.indexOf(str.charAt(count),j);
                    String temp=result.substring(j,value);
                    prev=value+1;
                    String paren="";
                    int[] temp_paren=new int[2];
                    if(!temp.equals("")&&temp.charAt(0)=='('){
                        for (int k = 0; k < temp.length(); k++) {
                            if(temp.charAt(k)=='(')temp_paren[0]++;
                            else if(temp.charAt(k)==')')temp_paren[1]++;
                        }
                        int val=temp_paren[0]-temp_paren[1];
                        if(val>=0)paren+=arr_start[val];
                        else paren+=arr_end[(-1*val)];
                    }
                    else if(!temp.equals("")&&temp.charAt(0)==')'){
                        for (int k = 0; k < temp.length(); k++) {
                            if(temp.charAt(k)==')')temp_paren[0]++;
                            else if(temp.charAt(k)=='(')temp_paren[1]++;
                        }
                        int val=temp_paren[0]-temp_paren[1];
                        if(val>=0)paren+=arr_end[val];
                        else paren+=arr_start[(-1*val)];
                    }
                    j=value+1;
                    final_result+=paren+ str.charAt(count++);
                    if(count>=str.length())break;
                }
                char index=str.charAt(str.length()-1);
                System.out.println("Case #"+(i+1)+": "+final_result+arr_end[index-'0']);
            }
    }
}