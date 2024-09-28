import java.lang.*;
import java.awt.*;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;


public class ShowFavSong extends JFrame implements ActionListener{
         
         Container favSong;
         ImageIcon albumCoverIc,icon,exitBtn,homeBtn,backBtn;
         JButton back, home, exit;
         Border border1,border2,border3;
         Cursor cursor;
         Font detailFont,announceFont,detail20,announce50;
         JLabel favSongName, favSongArtist, favSongTS,favSongReleased, albumCover;
         JTextField caption;
         String userData;
    
   public ShowFavSong(String userData) {
        this.userData = userData;
        // JFrame
        this.setTitle("Personify");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(950, 650);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        
        // Container
        favSong = this.getContentPane();
        favSong.setLayout(null);  
        favSong.setBackground(Color.decode("#E6E8CC"));

        //Font
        	try{
			detail20 = Font.createFont(Font.TRUETYPE_FONT, new File("Handycheera Regular.otf")).deriveFont(20f);	
			GraphicsEnvironment ge6 = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge6.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Handycheera Regular.otf")));			
		}
		catch(IOException | FontFormatException e){
			
		}
		

        try{
			announce50 = Font.createFont(Font.TRUETYPE_FONT, new File("Ruthie-Regular.ttf")).deriveFont(50f);	
			GraphicsEnvironment ge7 = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge7.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Ruthie-Regular.ttf")));			
		}
		catch(IOException | FontFormatException e){
			
		}
          
          detailFont = detail20.deriveFont(Font.PLAIN, 20);
          announceFont = announce50.deriveFont(Font.BOLD, 50);


        //App Icon
       icon = new ImageIcon("Personify-logo.png");
       this.setIconImage(icon.getImage());

       //Border
       border1 = BorderFactory.createLineBorder(Color.decode("#4486DB"), 1);
       border2 = BorderFactory.createLineBorder(Color.decode("#BAD121"), 1);
       border3 = BorderFactory.createLineBorder(Color.decode("#C91E1E"), 1);

       //Custom Cursor
       cursor = new Cursor(Cursor.HAND_CURSOR);


        // Back Button
        backBtn = new ImageIcon("Back.png");
        back = new JButton(backBtn);
        back.setBounds(10, 15, backBtn.getIconWidth(), backBtn.getIconHeight());
        back.setBorder(border1);
        back.setCursor(cursor);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.decode("#A3C0E6"));
        back.addActionListener(this);
        favSong.add(back);
        
        //Home Button
        homeBtn = new ImageIcon("Home.png");
        home = new JButton(homeBtn);
        home.setBounds(65, 15, homeBtn.getIconWidth(), homeBtn.getIconHeight());
        home.setBorder(border2);
        home.setCursor(cursor);
        home.setFocusable(false);
        home.setForeground(Color.WHITE);
        home.setBackground(Color.decode("#CDD69F"));
        home.addActionListener(this);
        favSong.add(home);
 
        //Exit Button
        exitBtn = new ImageIcon("Exit.png");
        exit = new JButton(exitBtn);
        exit.setBounds(120, 15, exitBtn.getIconWidth(), exitBtn.getIconHeight());
        exit.setBorder(border3);
        exit.setCursor(cursor);
        exit.setFocusable(false);
        exit.setForeground(Color.WHITE);
        exit.setBackground(Color.decode("#C48787"));
        exit.addActionListener(this);
        favSong.add(exit);

        //JLabels

        //albumCover
        albumCoverIc = new ImageIcon("RockStar-cover.png");
        albumCover= new JLabel(albumCoverIc);
        albumCover.setBounds(680,10,albumCoverIc.getIconWidth(),albumCoverIc.getIconWidth());
        favSong.add(albumCover);

        favSongName= new JLabel();
        favSongName.setBounds(20,220,850,80);
        favSongName.setFont(detailFont);
        favSongName.setForeground(Color.decode("#050505"));
        favSongName.setBackground(Color.decode("#11D9A0"));
        favSongName.setText("Favourite Song : RockStar");
        favSongName.setHorizontalAlignment(JLabel.CENTER);
        favSongName.setOpaque(true);
        favSong.add(favSongName);

        favSongArtist = new JLabel();
        favSongArtist.setBounds(20,320,850,80);
        favSongArtist.setFont(detailFont);
        favSongArtist.setForeground(Color.decode("#050505"));
        favSongArtist.setBackground(Color.decode("#11D9A0"));
        favSongArtist.setText("Artist : Post Malone featuring 21Savage");
        favSongArtist.setHorizontalAlignment(JLabel.CENTER);
        favSongArtist.setOpaque(true);
        favSong.add(favSongArtist);

        favSongTS= new JLabel();
        favSongTS.setBounds(20,420,850,80);
        favSongTS.setFont(detailFont);
        favSongTS.setForeground(Color.decode("#050505"));
        favSongTS.setBackground(Color.decode("#11D9A0"));
        favSongTS.setText("Times Streamed : 3,033,338,067 Streams");
        favSongTS.setHorizontalAlignment(JLabel.CENTER);
        favSongTS.setOpaque(true);
        favSong.add(favSongTS);

        favSongReleased= new JLabel();
        favSongReleased.setBounds(20,520,850,80);
        favSongReleased.setFont(detailFont);
        favSongReleased.setForeground(Color.decode("#050505"));
        favSongReleased.setBackground(Color.decode("#11D9A0"));
        favSongReleased.setText("Released On : Feb 16, 2018");
        favSongReleased.setHorizontalAlignment(JLabel.CENTER);
        favSongReleased.setOpaque(true);
        favSong.add(favSongReleased);


        caption = new JTextField();
        caption.setBounds(90,20,400,150);
        caption.setFont(announceFont);
        caption.setBackground(Color.decode("#E6E8CC"));
        caption.setText("Favorite Song...");
        caption.setEditable(false);
        caption.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        caption.setHorizontalAlignment(JTextField.RIGHT);
        favSong.add(caption);

        

       




       this.setVisible(true);
   }

   public void actionPerformed(ActionEvent e) {
     
      if (e.getSource() == home) {
          
         new LoginPage();
         this.setVisible(false);
          
      } else if (e.getSource() == exit) {
          System.exit(0);
      } else if (e.getSource() == back) {
          
          new DisplayUserInfo(userData);
         //  LoginPage.setVisible(true);
          this.setVisible(false);
      }
  }

   
}
