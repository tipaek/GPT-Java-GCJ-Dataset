import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            int sum= Math.abs(x)+Math.abs(y);
            String str="";
            
            ArrayList<Integer> v= new ArrayList<>();
            while(sum>0){
                v.add((int)sum%2);
                sum/=2;
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
                int i=0;
                int s=0;
                if(x<y){
                for(int j=0;j<c;j++){
                    str=str+"S";
                    s+=Math.pow(2,i++);
                }
                while(str.length()<v.size()){
                str+="EN";
                s+=Math.pow(2,i++);
                }
                }
                else{
                    for(int j=0;j<c;j++){
                    str=str+"W";
                    s+=Math.pow(2,i++);
                    }
                    while(str.length()<v.size()){
                    str+="NE";
                    s+=Math.pow(2,i++);
                    }
                }
                if(str.length()!=v.size()){
                    str="IMPOSSIBLE";
                }
            }
            else if(x<0 && y>0){
                int i=1;
                int s=0;
                x=Math.abs(x);
                if(x<y){
                for(int j=0;j<c;j++){
                    str=str+"S";
                    s+=Math.pow(2,i++);
                }
                while(str.length()<v.size()){
                str+="WN";
                s+=Math.pow(2,i++);}
                }
                else{
                    for(int j=0;j<c;j++){
                    str=str+"E";
                    s+=Math.pow(2,i++);
                    }
                    while(str.length()<v.size()){
                    str+="NW";
                    s+=Math.pow(2,i++);
                    }
                }
                if(str.length()!=v.size()){
                    str="IMPOSSIBLE";
                }
            }
            else if(x<0 && y<0){
                int i=1,s=0;
                x=Math.abs(x);
                y=Math.abs(y);
                if(x<y){
                for(int j=0;j<c;j++){
                    str=str+"N";
                    s+=Math.pow(2,i++);
                }
                while(str.length()<v.size()){
                str+="WS";
                s+=Math.pow(2,i++);
                }
                }
                else{
                    for(int j=0;j<c;j++){
                    str=str+"E";
                    s+=Math.pow(2,i++);
                    }
                    while(str.length()<v.size()){
                    str+="SW";
                    s+=Math.pow(2,i++);
                    }
                }
                if(str.length()!=v.size()){
                    str="IMPOSSIBLE";
                }
            }
            else if(x>0 && y<0){
                int i=1,s=0;
                y=Math.abs(y);
                if(x<y){
                for(int j=0;j<c;j++){
                    str=str+"N";
                    s+=Math.pow(2,i++);
                }
                while(str.length()<v.size()){
                str+="ES";
                s+=Math.pow(2,i++);
                }
                }
                else{
                    for(int j=0;j<c;j++){
                    str=str+"W";
                    s+=Math.pow(2,i++);
                    }
                    while(str.length()<v.size()){
                    str+="SE";
                    s+=Math.pow(2,i++);
                    }
                }
                if(str.length()!=v.size()){
                    str="IMPOSSIBLE";
                }
            }
            else if(x==0 && y>0){
                int i=1,s=0;
                for(int j=0;j<c;j++){
                    str=str+"S";
                    s+=Math.pow(2,i++);
                }
                while(str.length()<v.size()){
                    str+="N";
                    s+=Math.pow(2,i++);
                }
                if(str.length()!=sum){
                    str="IMPOSSIBLE";
                }
            }
            else if(x==0 && y<0){
                int i=1,s=0;
                for(int j=0;j<c;j++){
                    str=str+"N";
                    s+=Math.pow(2,i++);
                }
                while(str.length()<v.size()){
                    str+="S";
                    s+=Math.pow(2,i++);
                }
                if(str.length()!=v.size()){
                    str="IMPOSSIBLE";
                }
            }
            else if(x>0 && y==0){
                int i=1,s=0;
                for(int j=0;j<c;j++){
                    str=str+"W";
                    s+=Math.pow(2,i++);
                }
                while(str.length()<v.size()){
                    str+="E";
                    s+=Math.pow(2,i++);
                }
                if(str.length()!=v.size()){
                    str="IMPOSSIBLE";
                }
            }
            else if(x<0 && y==0){
                int i=1,s=0;
                for(int j=0;j<c;j++){
                    str=str+"W";
                    s+=Math.pow(2,i++);
                }
                while(str.length()<v.size()){
                    str+="E";
                    s+=Math.pow(2,i++);
                }
                if(str.length()!=v.size()){
                    str="IMPOSSIBLE";
                }
            }
            System.out.println("Case #"+t+": "+str);
               
        }
        
    }
}
