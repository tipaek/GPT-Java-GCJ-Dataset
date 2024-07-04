
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Solution {

 
    public static int main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int x=0;x<t;x++){
            List<Integer>Si=new ArrayList<>();
            List<Integer>Ei=new ArrayList<>();
            List<HashMap> hMapArray =new ArrayList<>();
            String strAnswer="";
            boolean finish=false;
            int n=sc.nextInt();
            for(int i=0;i<n;i++){
                try {
                    
                    HashMap hMap=new HashMap();
                    String  lines = br.readLine();
                    String[] numbersArr = lines.trim().split("\\s+");
                    int fromTime=Integer.parseInt(numbersArr[0]);
                    int toTime=Integer.parseInt(numbersArr[1]);
                    if(toTime>=1440){
                        toTime-=1440;
                    }
                    if(fromTime>=1440){
                        fromTime-=1440;
                    }
                    if(toTime==0){
                        finish=true;
                    }
                    if(hMapArray.isEmpty()){
                        hMap.put("name", "C");
                        hMap.put("timeMapFrom", fromTime);
                        hMap.put("timeMapTo", toTime);
                        
                        hMapArray.add(hMap);
                    }else{
                        int jCount=0;
                        int cCount=0;
                        for(HashMap timeHMap:hMapArray){
                            
                            if(jCount==1&&cCount==1){
                                finish=true;
                                break;
                            }
                            if(!checkHashMap(timeHMap,fromTime,toTime)){
                                if(timeHMap.get("name")=="C"){
                                    cCount++;
                                }else if(timeHMap.get("name")=="J"){
                                    jCount++;
                                }
                            }
                        }
                        if(cCount==0){
                            hMap.put("name", "C");
                            hMap.put("timeMapFrom", fromTime);
                            hMap.put("timeMapTo", toTime);
                            hMapArray.add(hMap);
                        }else{
                            hMap.put("name", "J");
                            hMap.put("timeMapFrom", fromTime);
                            hMap.put("timeMapTo", toTime);
                            hMapArray.add(hMap);
                        }
                    }
                } catch (IOException ex) {
                    
                }
                
                
                
            }
            for(int i=0;i<hMapArray.size();i++){
                strAnswer+=hMapArray.get(i).get("name").toString();
            }
            if(finish==true){
                strAnswer="IMPOSSIBLE";
            }
            System.out.println("Case #"+(x+1)+": "+strAnswer);
        }
        return 0;
    }
    static boolean checkHashMap(HashMap hMap,int timeFrom,int timeTo){
        int timeMapFrom=Integer.parseInt(hMap.get("timeMapFrom").toString());
        int timeMapTo=Integer.parseInt(hMap.get("timeMapTo").toString());
        if(timeFrom<=timeMapFrom&&timeTo<=timeMapFrom){
            return true;
        }else if(timeFrom>=timeMapTo&&timeTo>=timeMapTo){
            return true;
        }else{
            return false;
        }
    }
    
}
