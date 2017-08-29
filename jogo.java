import java.awt.*;
import java.io.*;
import javax.imageio.*;
import sun.audio.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;




public class Jogo extends BaseTutorial{
  Image imgT;
  Image imgR;
  Image imgY;
  Image WY;
  Image WR;
  Image inicio;
  Image emp;
  Image help;
  int posX, posY, x, y,quant, cont;
  boolean v[][] = new boolean[9][2];
  boolean venceu[] = new boolean[2];
  boolean comecar, ajuda, empate;


  public void init() {
    setSize(700, 700);
    try {
      imgT = ImageIO.read(new File("dark.png"));
      imgY = ImageIO.read(new File("amarelo.jpg"));
      imgR = ImageIO.read(new File("vermelho.jpg"));
      WY = ImageIO.read(new File("amarelovenceu1.jpg"));
      WR = ImageIO.read(new File("vermelhovenceu1.jpg"));
      emp = ImageIO.read(new File("empate1.jpg"));
      help =   ImageIO.read(new File("ajuda.jpg"));
      inicio = ImageIO.read(new File("comecar1.jpg"));
      posX = width / 2;
      posY = height;
    } catch (IOException e) {
      System.out.println("A imagem não pode ser carregada.");
    }
  }


  public void paint(Graphics g) {
    if(!comecar){
      if(ajuda){
        g.drawImage(help, posX - imgT.getWidth(this) / 2, posY - imgT.getHeight(this), this);
      }else
      g.drawImage(inicio, posX - imgT.getWidth(this) / 2, posY - imgT.getHeight(this), this);

    }
    else if(!venceu[0]){
    g.drawImage(imgT, posX - imgT.getWidth(this) / 2, posY - imgT.getHeight(this), this);
    if(v[0][0]){
      if(v[0][1])
      g.drawImage(imgR, 337, 135, null);
      else
      g.drawImage(imgY, 337, 135, null);
    }
    if(v[1][0]){
      if(v[1][1])
      g.drawImage(imgR, 286, 224, null);
      else
      g.drawImage(imgY, 286, 224, null);
    }
    if(v[2][0]){
      if(v[2][1])
      g.drawImage(imgR, 425, 289, null);
      else
      g.drawImage(imgY, 425, 289, null);
    }
    if(v[3][0]){
      if(v[3][1])
      g.drawImage(imgR, 360, 295, null);
      else
      g.drawImage(imgY, 360, 295, null);
    }
    if(v[4][0]){
      if(v[4][1])
      g.drawImage(imgR, 300, 302, null);
      else
      g.drawImage(imgY, 300, 302, null);
    }
    if(v[5][0]){
      if(v[5][1])
      g.drawImage(imgR, 317, 353, null);
      else
      g.drawImage(imgY, 317, 353, null);
    }
    if(v[6][0]){
      if(v[6][1])
      g.drawImage(imgR, 151, 461, null);
      else
      g.drawImage(imgY, 151, 461, null);
    }
    if(v[7][0]){
      if(v[7][1])
      g.drawImage(imgR, 260, 459, null);
      else
      g.drawImage(imgY, 260, 459, null);
    }
    if(v[8][0]){
      if(v[8][1])
      g.drawImage(imgR, 525, 463, null);
      else
      g.drawImage(imgY, 525, 463, null);
      }
    }else if(venceu[0]&&(!empate)) {
      if(venceu[1]){
      g.drawImage(WR, posX - imgT.getWidth(this) / 2, posY - imgT.getHeight(this), this);
     }else{
      g.drawImage(WY, posX - imgT.getWidth(this) / 2, posY - imgT.getHeight(this), this);
     }
   }else{
     g.drawImage(emp, posX - imgT.getWidth(this) / 2, posY - imgT.getHeight(this), this);
   }
   }


   public class imprimebolas extends Thread {
     public void run() {
       while(!venceu[0]){
         try {
    Thread.sleep(10);
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}
    if (mousePressed&&mouseX>=337&&mouseX<=367&&mouseY>=135&&mouseY<=165&&!v[0][0]) {
      quant++;
      v[0][0]=true;
      if(quant%2 == 1)
      v[0][1]=true;
    }else if (mousePressed&&mouseX>=286&&mouseX<=316&&mouseY>=224&&mouseY<=254&&!v[1][0]) {
      quant++;
      v[1][0]=true;
      if(quant%2 == 1)
      v[1][1]=true;
    }else if (mousePressed&&mouseX>=425&&mouseX<=455&&mouseY>=289&&mouseY<=319&&!v[2][0]) {
      quant++;
      v[2][0]=true;
      if(quant%2 == 1)
      v[2][1]=true;
    }else if (mousePressed&&mouseX>=360&&mouseX<=390&&mouseY>=295&&mouseY<=325&&!v[3][0]) {
      quant++;
      v[3][0]=true;
      if(quant%2 == 1)
      v[3][1]=true;
    }else if (mousePressed&&mouseX>=300&&mouseX<=330&&mouseY>=302&&mouseY<=332&&!v[4][0]) {
      quant++;
      v[4][0]=true;
      if(quant%2 == 1)
      v[4][1]=true;
    }else if (mousePressed&&mouseX>=317&&mouseX<=347&&mouseY>=353&&mouseY<=383&&!v[5][0]) {
      quant++;
      v[5][0]=true;
      if(quant%2 == 1)
      v[5][1]=true;
    }else if (mousePressed&&mouseX>=151&&mouseX<=181&&mouseY>=461&&mouseY<=491&&!v[6][0]) {
      quant++;
      v[6][0]=true;
      if(quant%2 == 1)
      v[6][1]=true;
    }else if (mousePressed&&mouseX>=260&&mouseX<=290&&mouseY>=459&&mouseY<=489&&!v[7][0]) {
      quant++;
      v[7][0]=true;
      if(quant%2 == 1)
      v[7][1]=true;
    }else if (mousePressed&&mouseX>=525&&mouseX<=555&&mouseY>=463&&mouseY<=493&&!v[8][0]) {
      quant++;
      v[8][0]=true;
      if(quant%2 == 1)
      v[8][1]=true;
     }
     if((v[6][0]&&v[6][1]&&v[0][0]&&v[0][1]&&v[1][0]&&v[1][1])||(v[6][0]&&v[6][1]&&v[7][0]&&v[7][1]&&v[8][0]&&v[8][1])||(v[6][0]&&v[6][1]&&v[2][0]&&v[2][1]&&v[5][0]&&v[5][1])||(v[0][0]&&v[0][1]&&v[7][0]&&v[7][1]&&v[4][0]&&v[4][1])||(v[1][0]&&v[1][1]&&v[3][0]&&v[3][1]&&v[8][0]&&v[8][1])||(v[0][0]&&v[0][1]&&v[2][0]&&v[2][1]&&v[8][0]&&v[8][1])||(v[1][0]&&v[1][1]&&v[4][0]&&v[4][1]&&v[5][0]&&v[5][1])){
        venceu[0]=true;
        venceu[1]=true;
        cont = quant;
      }
     if((v[6][0]&&(v[6][1]==false)&&v[0][0]&&(v[0][1]==false)&&v[1][0]&&(v[1][1]==false))||(v[6][0]&&(v[6][1]==false)&&v[7][0]&&(v[7][1]==false)&&v[8][0]&&(v[8][1]==false))||(v[6][0]&&(v[6][1]==false)&&v[2][0]&&(v[2][1]==false)&&v[5][0]&&(v[5][1]==false))||(v[0][0]&&(v[0][1]==false)&&v[7][0]&&(v[7][1]==false)&&v[4][0]&&(v[4][1]==false))||(v[1][0]&&(v[1][1]==false)&&v[3][0]&&(v[3][1]==false)&&v[8][0]&&(v[8][1]==false))||(v[0][0]&&(v[0][1]==false)&&v[2][0]&&(v[2][1]==false)&&v[8][0]&&(v[8][1]==false))||(v[1][0]&&(v[1][1]==false)&&v[4][0]&&(v[4][1]==false)&&v[5][0]&&(v[5][1]==false))){
     venceu[0]=true;
     cont = quant;
     }
   if(quant == cont+9){
     venceu[0]=true;
     empate = true;
     cont = quant;
   }
      Jogo.novamente m = new novamente();
     m.start();
   }
  }
 }

 public class novamente extends Thread {
   public void run() {
     while(venceu[0]){
       try {
         Thread.sleep(10);
      }catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
      if (mousePressed&&mouseX>=30&&mouseX<=510&&mouseY>=500&&mouseY<=560) {
        for(int b=0; b<9;b++){
          for(int c=0;c<2;c++){
            v[b][c] = false;
          }
        }
        venceu[0] = false;
        venceu[1]=false;
        Jogo.imprimebolas n = new imprimebolas();
        n.start();
       }
       if (mousePressed&&mouseX>=30&&mouseX<=135&&mouseY>=610&&mouseY<=650) {
         System.exit(0);
        }
     }
  }
}

public class comeco extends Thread {
  public void run() {
  while(!comecar){
    try {
      Thread.sleep(10);
   }catch(InterruptedException ex) {
     Thread.currentThread().interrupt();
   }
if (mousePressed&&mouseX>=20&&mouseX<=290&&mouseY>=540&&mouseY<=640) {
        comecar=true;
        Jogo.imprimebolas n = new imprimebolas();
        n.start();

   }
  if(mousePressed&&mouseX>=450&&mouseX<=660&&mouseY>=530&&mouseY<=640){
  System.exit(0);
  }
  if(mousePressed&&mouseX>=560&&mouseX<=700&&mouseY>=665&&mouseY<=700){
  ajuda=true;
  mouseX=0;
  mouseY=0;
  }
  while (ajuda){
    try {
      Thread.sleep(10);
   }catch(InterruptedException ex) {
     Thread.currentThread().interrupt();
   }

     if(mousePressed&&mouseX>=1&&mouseX<=700&&mouseY>=1&&mouseY<=700){
     ajuda=false;
     mouseX=0;
     mouseY=0;
   }

  }
  }
}
}


static public void play() {
        try {
            AudioInputStream in = AudioSystem.getAudioInputStream(new File("mm.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(in);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            Thread.sleep(clip.getMicrosecondLength());
        } catch (Exception e) {
            e.printStackTrace();
        }
      }


  public static void main(String[] args) {
    Jogo canvas = new Jogo();
    Start t = new Start(canvas);
    t.setResizable(false);
    Jogo.comeco n = canvas.new comeco();
    n.start();
    play();

}
}
