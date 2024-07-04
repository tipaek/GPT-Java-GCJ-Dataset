
import java.io.*;
import java.lang.*;
import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        for(int i=0;i<t;i++){
            int t1=scan.nextInt();
                int[] arr1=new int[t1];
                int[] arr2=new int[t1];
            for(int j=0;j<t1;j++){
                arr1[j]=scan.nextInt();
                arr2[j]=scan.nextInt();
            }
            String str="";
            int k;
            int cl=arr1[0];
            int ch=arr2[0];
            int jl=0;
            int jh=0;
            int count=0;
            str=str+"C";
            int flag=0;
            for(k=1;k<t1;k++){
                if(arr1[k]>=ch){
                    str=str+"C";
                }
                else if(arr2[k]<=cl){
                    str=str+"C";
                }
                else{
                    if(count>0){
                        if(arr1[k]>=jh || arr2[k]<=jl){
                            str=str+"J";
                        }
                        else{

                            flag=1;
                            break;
                        }
                    }
                    else{
                        str=str+"J";
                    }
                    jl=arr1[k];
                    jh=arr2[k];
                    count++;
                    
                }
            }
            int z=i+1;
            if(flag==0){
                 System.out.println("Case #"+z+": "+str);
            }
            else{
                System.out.println("Case #"+z+": "+"IMPOSSIBLE");
            }
            
            
            /*
            int k;
            for(k=0;k<t1-1;k++){
                if(arr1[k]>arr1[k+1]){
                    int temp=arr1[k+1];
                    arr1[k+1]=arr1[k];
                    arr1[k]=temp;
                    
                    temp=arr2[k+1];
                    arr2=arr2[k];
                    arr2[k]=temp;
                }
            }
            
            String str="";
            str=str+"C";
            int cl=arr2[0];
            int jl=0;
            for(k=1;k<t1;k++){
                if(arr1[k]>=cl ){
                    str=str+"C";
                    cl=arr2[k];
                }
                else if(arr1[k]<cl && arr1[k]>=jl){
                    str=str+"J";
                    jl=arr2[k];
                }
                
            }
            
            */
            
        }
    }
}



/*
#include <iostream>
#include <string>
#include <vector>
//#include <windows.h> 
using namespace std; 
struct timesection { int st; int et; };
bool isoverlap(timesection t1, timesection t2) 
{ if (t1.st<=t2.st && t1.et>t2.st) return true;
if (t1.st<t2.et && t1.et>=t2.et) return true;
if (t1.st>=t2.st && t1.et<=t2.et) return true;
return false; 
} 
int main()
{ int i,j,k,l,n,m; bool ret; 
bool *col;
int **matrix; vector<string> res;
vector<timesection> Csec, Jsec; string r;
timesection *sec; cin>>n; 
for (i=0;i<n;i++) { cin>>m;
r = ""; sec = new timesection[m];
for (j=0;j<m;j++) { 
    cin>>sec[j].st>>sec[j].et;
    if (j==0) {
        Csec.push_back(sec[j]);
        r+="C";
        } 
        else {
            ret = true; 
            for (k=0;k<Csec.size();k++) {
                if (isoverlap(sec[j], Csec[k])) 
                { ret = false; break; }
                }
                if(ret) { 
                    Csec.push_back(sec[j]);
                r+="C"; 
                continue; 
                    
                } 
                ret = true;
                for (k=0;k<Jsec.size();k++) 
                { if (isoverlap(sec[j], Jsec[k]))
                { ret = false; break; } }
                if(ret) { Jsec.push_back(sec[j]);
                r+="J";
                }
                else { r = "IMPOSSIBLE"; break; } } }
                res.push_back(r);
                delete []sec; 
                Csec.clear(); 
                Jsec.clear(); } 
                for (i=0;i<res.size();i++)
                { cout<<"Case #" << i+1 <<":"<<res[i]<<endl; 
                    
                } 
                res.clear();
                system("pause");
                return 0; 
    
} 
*/