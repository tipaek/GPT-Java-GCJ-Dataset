import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            int s= Math.abs(x)+Math.abs(y);
            String str="";
            
            ArrayList<Integer> v= new ArrayList<>();
            while(s>0){
                v.add((int)s%2);
                s/=2;
            }
            if(v.get(0)==0)
            { System.out.println("Case #"+t+": IMPOSSIBLE");
                continue;
            }
            int c=0;
            for(int i=0;i<v.size();i++){
                if(v.get(i)==0){c++; }
            }
            if(x>0 && y>0){
                if(x<y){
                for(int j=0;j<c;j++){
                    str=str+"S";
                }
                while(str.length()<v.size())
                str+="EN";
                }
                else{
                    for(int j=0;j<c;j++){
                    str=str+"W";
                    }
                    while(str.length()<v.size())
                    str+="NE";
                }
            }
            else if(x<0 && y>0){
                x=Math.abs(x);
                if(x<y){
                for(int j=0;j<c;j++){
                    str=str+"S";
                }
                while(str.length()<v.size())
                str+="WN";
                }
                else{
                    for(int j=0;j<c;j++){
                    str=str+"E";
                    }
                    while(str.length()<v.size())
                    str+="NW";
                }
            }
            else if(x<0 && y<0){
                x=Math.abs(x);
                y=Math.abs(y);
                if(x<y){
                for(int j=0;j<c;j++){
                    str=str+"N";
                }
                while(str.length()<v.size())
                str+="WS";
                }
                else{
                    for(int j=0;j<c;j++){
                    str=str+"E";
                    }
                    while(str.length()<v.size())
                    str+="SW";
                }
            }
            else if(x>0 && y<0){
                y=Math.abs(y);
                if(x<y){
                for(int j=0;j<c;j++){
                    str=str+"N";
                }
                while(str.length()<v.size())
                str+="ES";
                }
                else{
                    for(int j=0;j<c;j++){
                    str=str+"W";
                    }
                    while(str.length()<v.size())
                    str+="SE";
                }
            }
            else if(x==0 && y>0){
                for(int j=0;j<c;j++){
                    str=str+"S";
                }
                while(str.length()<v.size())
                    str+="N";
            }
            else if(x==0 && y<0){
                for(int j=0;j<c;j++){
                    str=str+"N";
                }
                while(str.length()<v.size())
                    str+="S";
            }
            else if(x>0 && y==0){
                for(int j=0;j<c;j++){
                    str=str+"W";
                }
                while(str.length()<v.size())
                    str+="E";
            }
            else if(x<0 && y==0){
                for(int j=0;j<c;j++){
                    str=str+"W";
                }
                while(str.length()<v.size())
                    str+="E";
            }
            System.out.println("Case #"+t+": "+str);
               
        }
        
    }
}
