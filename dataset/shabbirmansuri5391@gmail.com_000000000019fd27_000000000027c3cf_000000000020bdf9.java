import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args){
        
		Scanner sc = new Scanner(System.in);
        int T=0,N=0;
        
		T = sc.nextInt();
        int x=0,y=0;
		
		HashMap<Integer,Character> hash = new HashMap<>();
        ArrayList<Activity> actList= new ArrayList<>();
        
		int counter = 1;
        int flag=0;
        
        while((T--)!=0){
            flag=0;
            N=0;
			
            hash.clear();
            actList.clear();
			
			
            N = sc.nextInt();
            int s=0,e=0;
            for(int i=0;i<N;++i){
				
                s = sc.nextInt();
                e = sc.nextInt();
                //System.out.println("S:"+s+"  e:"+e);
                actList.add(new Activity(i,true,s));
                actList.add(new Activity(i,false,e));
            }
            Collections.sort(actList);
            /*for(int i=0;i<actList.size();++i){
                System.out.println("Activity id:"+actList.get(i).id+" types:"+actList.get(i).types+" value:"+actList.get(i).value);
            }*/
            boolean C = true;
			boolean J = true;
            
            for(int i=0;i<actList.size();++i){
                Activity curr = actList.get(i);
                if( J && C ){
                    if(curr.types){
                        hash.put(curr.id,new Character('J'));
                        J = false;
                    }
                }else if(J){
                    if(curr.types){
                        hash.put(curr.id,new Character('J'));
                        J = false;
                    }else{
                        if(hash.containsKey(curr.id)){
                            Character p = hash.get(curr.id);
                            if (p=='J'){
                                J = true;  
                            }else{
                                C = true;
                            }
                        }
                    }
                }else if(C){
                    if(curr.types){
                        hash.put(curr.id,new Character('C'));
                        C = false;
                    }else{
                        if(hash.containsKey(curr.id)){
                            Character p = hash.get(curr.id);
                            if (p=='J'){
                                J = true;  
                            }else{
                                C = true;
                            }
                        }
                    }
                }else{
                    if(curr.types){
                        flag=1;
                        break;
                    }else{
                        if(hash.containsKey(curr.id)){
                            Character p = hash.get(curr.id);
                            if (p=='J'){
                                J = true;  
                            }else{
                                C = true;
                            }
                        }
                    }
                }
            }
            if(flag==1){
                System.out.println("Case #"+counter+": IMPOSSIBLE");
            }else{
                StringBuilder sb = new StringBuilder("");
                for(int i=0;i<N;++i){
                    sb.append(hash.get(i));
                }
                System.out.println("Case #"+counter+": "+sb.toString());
            }
            counter++;
        }
    }
    
    public static class Activity implements Comparable<Activity>{
        public int id;
        public boolean types;
        public int value;
        
        public Activity(int id,boolean types,int value){
            this.id = id;
            this.types = types;
            this.value = value;
        }
        
        @Override
        public int compareTo(Activity act) 
        {
            if(this.value<act.value){
                return -1;
            }
            else if(this.value==act.value){
                if(this.types==act.types){
                    return -1;
                }else if(this.types==true){
                    return 1;
                }else{
                    return -1;
                }
            }else{
                return 1;
            }
        }
    }
    
}