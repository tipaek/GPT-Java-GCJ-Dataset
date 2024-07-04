

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 *
 * @author qboiler
 */
public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        for(int i =1;i<=testCases; ++i) {
            processCase(reader, i);
        }
    }


    public static void processCase(BufferedReader reader, int caseN) throws IOException {

        int rows = Integer.parseInt(reader.readLine());

        String[] patterns = new String[rows];

        String start=null;
        String end=null;

        int maxWild = 0;
        boolean error = false;
        for(int i=0;i<rows;++i){


            String nl = reader.readLine();
            if(nl.startsWith("*")){
                String e = "";
                if(nl.length()>1){
                    e = nl.substring(1);
                }
                if(end == null){
                    end = e;
                }else{
                    if(end.endsWith(e)){
                        // do nothing...
                    }else if(e.endsWith(end)){
                        end=e;
                    }else{
                        error = true;
                        break;
                    }
                }
            }else if(nl.endsWith("*")){
                
                String s ="";
                if(nl.length()>1){
                    s = nl.substring(0, nl.length()-1);
                }
                if(start == null){
                    start =s;
                }else{
                    if(start.startsWith(s)){
                        // do nothing
                    }else if(s.startsWith(start)){
                        start = s;
                    }else{
                        error = true;
                        break;
                    }
                }
            }else{
                String[] parts = nl.split("\\*");
                String s = parts[0];
                String e = parts[parts.length-1];
                if(start == null){
                    start =s;
                }else{
                    if(start.startsWith(s)){
                        // do nothing
                    }else if(s.startsWith(start)){
                        start = s;
                    }else{
                        error = true;
                        break;
                    }
                }
                if(end == null){
                    end = e;
                }else{
                    if(end.endsWith(e)){
                        // do nothing...
                    }else if(e.endsWith(end)){
                        end=e;
                    }else{
                        error = true;
                        break;
                    }
                }


            }




        }
        
        if(error){
            System.out.println("Case #"+caseN+": *");
        }
        else{
            if(start==null){
                start = "";
            }
            if(end==null){
                end = "";
            }
            System.out.println("Case #"+caseN+": "+start+end);
        }
        
    }
}
