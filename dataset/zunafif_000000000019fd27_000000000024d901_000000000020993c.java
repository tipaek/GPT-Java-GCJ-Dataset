package vestigium;

class Vestigium{

public static void main (String[] args){

int vestigum[][] = new int[3][3];
vestigium[0][0] = 7;
vestigium[0][1] = 8;
vestigium[0][2] = 9;

vestigium[1][0] = 9;
vestigium[1][1] = 7;
vestigium[1][2] = 8;

vestigium[2][0] = 8;
vestigium[2][1] = 9;
vestigium[2][2] = 7;

for (int i = 0; i < vestigium.length; i++){
            for (int j = 0; j < vestigium[0].length; j++){
                System.out.print(vestigium[i][j] + " ");
            }       
            System.out.println();
        }
    }
}