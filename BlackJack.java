import java.util.Random;
import java.io.*;

class BlackJack {
  public static void main(String[] args) throws IOException {
    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    int PlayerPoint=0;
    int DealerPoint=0;
    Random random=new Random();
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

    for (int i=2; PlayerPoint < 22; i++){
      System.out.println("現在の点数は"+ PlayerPoint + "です。");
      System.out.println("もう一枚引くなら「ヒット」、引かないなら「スタンド」と入力してください。");
      String str = br.readLine();

      if(str.equals("ヒット")){
        PlayerCard[i] = random.nextInt(13)+1;
        if(PlayerCard[i] >= 10){
          PlayerCard[i] = 10;
        }

        if(PlayerCard[i] == 1){
          PlayerCard[i] = 11;
        }

        PlayerPoint += PlayerCard[i];
        if(PlayerPoint >= 22){
          System.out.println("プレイヤーはバーストしました");
          break;
        }
      }

      if(str.equals("スタンド")) break;
      for(; DealerPoint < 17;){
        DealerCard[i] = random.nextInt(13) +1;
        if(DealerCard[i] >= 10){
          DealerCard[i] = 10;
        }

        if(DealerPoint >= 22){
          System.out.println("ディーラーはバーストしました。");
          break;
        }
      }
    }

    if(DealerPoint > 21 && PlayerPoint < 22){
      System.out.println("プレイヤーの勝ち");
    } else if(DealerPoint < 22 && PlayerPoint > 21){
      System.out.println("ディーラーの勝ち");
    } else if(DealerPoint > PlayerPoint){
      System.out.println("ディーラーの勝ち");
    } else if(DealerPoint < PlayerPoint){
      System.out.println("プレイヤーの勝ち");
    } else if(DealerPoint == PlayerPoint){
      System.out.println("引き分け");
    }else if(DealerPoint > 21 && PlayerPoint > 21){
      System.out.println("ディーラーの勝ち");
    }
  }
}

