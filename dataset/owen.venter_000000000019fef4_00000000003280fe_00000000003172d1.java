import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author owen
 */
public class Solution {
 static Scanner in;
 static List arrList=new LinkedList();
 static int slices;
 static int diners;
 static int arrAng [];
 static int numCuts;
 static int smallest;
 static int secondValue;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        in= new Scanner(System.in);
       int t= in.nextInt();
        System.out.print("Case #"+t+": ");
       
        for (int i = 0; i < t; i++) {
             slices=in.nextInt();
             diners=in.nextInt();
            arrAng= new int[slices];
            
            for (int j = 0; j < slices; j++) {
                arrAng[j]=in.nextInt();
                //System.out.println(arrAng[j]);
            }
            
        }
       Solution.checkFirst();
    }
    
    public static void checkFirst(){
        int numSame=1;
        for (int i = 0; i < arrAng.length -1; i++) {
            for (int j = i+1; j < arrAng.length; j++) {
                if (arrAng[j]==arrAng[i]) {
                    numSame++;
                }
            }
                
            }
        if(numSame>=diners){
            numCuts=0;
        //System.out.print(numCuts);
        }else{
            Solution.cut();
        }
        }
    
    
    public static void cut(){
         smallest=arrAng[0];
        int pos=0;
        int modPos=0;
        
        List arrMods=new LinkedList();
        boolean canRun=false;
        
        if (slices==1){
            numCuts=diners-1;
            System.out.println(numCuts);
        }else{
        
            for (int i = 0; i < slices; i++) {
             if (arrAng[i]<smallest) {
                smallest= arrAng[i];
                pos=i;
                // System.out.println(smallest+"SMALL");
             }
            }
            
            for (int i = 0; i < slices; i++) {
             if (arrAng[i]%smallest==0 && arrAng[i]!= smallest) {
                arrMods.add(i);
                 System.out.println("ONE MOD"+arrAng[i]);
                 canRun=true;
                 
             }else{
                 int biggest=arrAng[i];
                 for (int j = 0; j < slices; j++) {
                     if (arrAng[i]>biggest) {
                    biggest= arrAng[i];
                    pos=i;
                
                     }
                 }
                 secondValue=biggest;
                 
             }
            }
           if(canRun==true){
            int smallestMod=arrAng[Integer.parseInt(""+arrMods.get(0))];
            
            for (int i = 0; i < arrMods.size(); i++) {
               if (arrAng[Integer.parseInt(""+arrMods.get(i))]<smallestMod) {
                smallestMod= arrAng[Integer.parseInt(""+arrMods.get(i))];
                modPos=i;
                   System.out.println("SMALLEST MOD:"+smallestMod);
                
             }
            }
           secondValue=smallestMod; 
        }
           
           
         }
        
        
     
       
        
    }
    
    public boolean checkEnough(){
        boolean ready=false;
        int amountOk=1;
        while (amountOk<diners){
            int magicNum=secondValue-smallest;
            
        }
        
        
       return ready ;
    }
    
    
    
    
    }
    
