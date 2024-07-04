import java.io.*; 
import java.util.*;
class Solution 
{ 
  public static void main(String[] args)throws Exception 
  { 
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    
    int n = sc.nextInt();
    int b = sc.nextInt();
    for (int i = 1; i <= n; ++i) {
        char[] mangThuong = new char[b];
        char[] mangDaoBit = new char[b];
        char[] mangDaoNguoc = new char[b];
        char[] mangDaoCaHai = new char[b];
        int curState = 1;

        int count = 0;
        int countDone = 0;
        int resIndex = 0;
        int indexToCheckKhacNhau = -1;
        int indexToCheckGiongNhau = -1;
        while(countDone < b/2) {

            //check
            if (count % 10 == 0 && count != 1) {
                //check count done + 1
                int checkIndex = 0;
                if (indexToCheckKhacNhau != -1) checkIndex = indexToCheckKhacNhau;
                
                char oldChar = 'a';
                if (curState == 1) {
                    oldChar = mangThuong[checkIndex];
                } else if (curState == 2) {
                    oldChar = mangDaoBit[checkIndex];
                } else if (curState == 3) {
                    oldChar = mangDaoNguoc[checkIndex];
                } else if (curState == 4) {
                    oldChar = mangDaoCaHai[checkIndex];
                }

                int checkIndex2 = 0;
                if (indexToCheckGiongNhau != -1) checkIndex2 = indexToCheckGiongNhau;
                char oldChar2 = 'a';
                if (curState == 1) {
                    oldChar2 = mangThuong[checkIndex2];
                } else if (curState == 2) {
                    oldChar2 = mangDaoBit[checkIndex2];
                } else if (curState == 3) {
                    oldChar2 = mangDaoNguoc[checkIndex2];
                } else if (curState == 4) {
                    oldChar2 = mangDaoCaHai[checkIndex2];
                }

                count++;
                System.out.println(checkIndex+1);
                char nextChar = sc.next().charAt(0);
            
                if (nextChar == 'N') return;

                if (indexToCheckKhacNhau == -1) {
                    if (oldChar != nextChar) {
                        if (curState == 1) {
                            curState = 2;
                        } else if (curState == 2) {
                            curState = 1;
                        } else if (curState == 3) {
                            curState = 4;
                        } else if (curState == 4) {
                           curState = 3;
                        }
                    }
                } else {
                    if (oldChar == nextChar && indexToCheckGiongNhau == -1) {

                    } else {
                        count++;
                        System.out.println(checkIndex2+1);
                        char nextChar2 = sc.next().charAt(0);
                        if (nextChar2 == 'N') return;

                        if (oldChar == nextChar && oldChar2 == nextChar2) { //1

                        } else if (oldChar != nextChar && oldChar2 == nextChar2) { //3
                            if (curState == 1) {
                                curState = 3;
                            } else if (curState == 2) {
                                curState = 4;
                            } else if (curState == 3) {
                                curState = 1;
                            } else if (curState == 4) {
                            curState = 2;
                            }
                        } else if (oldChar == nextChar && oldChar2 != nextChar2) { //4
                        if (curState == 1) {
                                curState = 4;
                            } else if (curState == 2) {
                                curState = 3;
                            } else if (curState == 3) {
                                curState = 2;
                            } else if (curState == 4) {
                            curState = 1;
                            }
                        } else if (oldChar != nextChar && oldChar2 != nextChar2) {//2
                            if (curState == 1) {
                                curState = 2;
                            } else if (curState == 2) {
                                curState = 1;
                            } else if (curState == 3) {
                                curState = 4;
                            } else if (curState == 4) {
                            curState = 3;
                            }
                        }
                    }
                    
                }
            }

            // goi thuan chieu
            resIndex = countDone;
            count++;
            System.out.println(resIndex+1);
            char nextChar = sc.next().charAt(0);
            
            if (nextChar == 'N') return;
            if (nextChar == 'Y') continue;

            boolean is0 = nextChar == '0';

            if (curState == 1) {
                mangThuong[resIndex] = is0 ? '0' : '1';
                mangDaoBit[resIndex] = is0 ? '1' : '0';
                mangDaoNguoc[b - 1 - resIndex] = is0 ? '0' : '1';
                mangDaoCaHai[b - 1 - resIndex] = is0 ? '1' : '0';
            } else if (curState == 2) {
                mangDaoBit[resIndex] = is0 ? '0' : '1';
                mangThuong[resIndex] = is0 ? '1' : '0';
                mangDaoCaHai[b - 1 - resIndex] = is0 ? '0' : '1';
                mangDaoNguoc[b - 1 - resIndex] = is0 ? '1' : '0';
            } else if (curState == 3) {
                mangDaoNguoc[resIndex] = is0 ? '0' : '1';
                mangDaoCaHai[resIndex] = is0 ? '1' : '0';
                mangThuong[b - 1 - resIndex] = is0 ? '0' : '1';
                mangDaoBit[b - 1 - resIndex] = is0 ? '1' : '0';
            } else if (curState == 4) {
                mangDaoCaHai[resIndex] = is0 ? '0' : '1';
                mangDaoNguoc[resIndex] = is0 ? '1' : '0';
                mangDaoBit[b - 1 - resIndex] = is0 ? '0' : '1';
                mangThuong[b - 1 - resIndex] = is0 ? '1' : '0';
            }

            countDone++;
            if (countDone >= b/2) break;
            // goi nguoc chieu
            resIndex = b - 1 - countDone - 1;
            count++;
            System.out.println(resIndex+1);
            nextChar = sc.next().charAt(0);
            
            if (nextChar == 'N') return;
            if (nextChar == 'Y') continue;

            is0 = nextChar == '0';

            if (curState == 1) {
                mangThuong[resIndex] = is0 ? '0' : '1';
                mangDaoBit[resIndex] = is0 ? '1' : '0';
                mangDaoNguoc[b - 1 - resIndex] = is0 ? '0' : '1';
                mangDaoCaHai[b - 1 - resIndex] = is0 ? '1' : '0';
            } else if (curState == 2) {
                mangDaoBit[resIndex] = is0 ? '0' : '1';
                mangThuong[resIndex] = is0 ? '1' : '0';
                mangDaoCaHai[b - 1 - resIndex] = is0 ? '0' : '1';
                mangDaoNguoc[b - 1 - resIndex] = is0 ? '1' : '0';
            } else if (curState == 3) {
                mangDaoNguoc[resIndex] = is0 ? '0' : '1';
                mangDaoCaHai[resIndex] = is0 ? '1' : '0';
                mangThuong[b - 1 - resIndex] = is0 ? '0' : '1';
                mangDaoBit[b - 1 - resIndex] = is0 ? '1' : '0';
            } else if (curState == 4) {
                mangDaoCaHai[resIndex] = is0 ? '0' : '1';
                mangDaoNguoc[resIndex] = is0 ? '1' : '0';
                mangDaoBit[b - 1 - resIndex] = is0 ? '0' : '1';
                mangThuong[b - 1 - resIndex] = is0 ? '1' : '0';
            }

            if (indexToCheckKhacNhau == -1) {
                if (mangThuong[resIndex] != mangDaoNguoc[resIndex])
                    indexToCheckKhacNhau = resIndex;
            }

            if (indexToCheckGiongNhau == -1) {
                if (mangThuong[resIndex] == mangDaoNguoc[resIndex])
                    indexToCheckGiongNhau = resIndex;
            }
        }

        String result = "";
        if (curState == 1) {
                result = new String(mangThuong);
            } else if (curState == 2) {
                result = new String(mangDaoBit);
            } else if (curState == 3) {
                result = new String(mangDaoNguoc);
            } else if (curState == 4) {
                result = new String(mangDaoCaHai);
            }
        System.out.println(result);
        char nextChar = sc.next().charAt(0);
        if (nextChar == 'N') return;
        if (nextChar == 'Y') continue;
    }
  }
} 