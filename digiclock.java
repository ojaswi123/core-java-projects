

package digitalclock;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class Digitalclock extends JFrame{

 JLabel clockL;
 public Digitalclock(){
     setTitle("My Digital Clock");
     setSize(400,400);
     setLocationRelativeTo(null);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     createClock();
     setVisible(true);
     
 }   

    private void createClock() {    
        this.setLayout(new BorderLayout());
        clockL=new JLabel("45:1254");
        clockL.setFont(new Font("Arial",Font.BOLD,50));
        clockL.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(clockL,BorderLayout.CENTER);
      Cthread mythread=new Cthread();
      mythread.start();
    }
    public static void main(String[] args) {
        new Digitalclock();
    }
      class Cthread extends Thread
      {

        @Override
        public void run() {
        try{
        while(true){
        String currentTime;
        currentTime =new Date().toString();
        clockL.setText(currentTime);
   
           
        Thread.sleep(1000);
        }
       } catch (InterruptedException ex) {
                Logger.getLogger(Digitalclock.class.getName()).log(Level.SEVERE, null, ex);
            }
            } 
      }}
       

       

 
             