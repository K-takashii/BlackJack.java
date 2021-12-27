import java.util.Random;
import java.util.*;
import java.io.*;

public class BlackJack {
  public static void main(String[] args) throws IOException {
    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    int PlayerPoint=0;
    int DealerPoint=0;
    Random random=new Random();
    int num=random.nextInt(52);
    int[] PlayerCard=new int[30];
    int[] DealerCard=new int[30];

    for (int i=0;i<2;i++) {
      PlayerCard[i]=random.nextInt(13)+1;
      if (PlayerCard[i]>=10) {
        PlayerCard[i]=10;
      }

      if (PlayerCard[i]==1) {
        PlayerCard[i]=11;
      }

      PlayerPoint += PlayerCard[i];

      if (PlayerPoint>=22) {
        for (int l=0;l<=PlayerCard.length;l++) {
          if (PlayerCard[l]==11) {
            PlayerCard[l]=1;
            PlayerPoint-=10;
          }
        }
      }
    }  
  }
}