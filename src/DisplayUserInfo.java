import java.lang.*;
import java.awt.*;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class DisplayUserInfo extends JFrame implements ActionListener {
    Container displayUi;
    ImageIcon icon,exitBtn,homeBtn,backBtn;
    JLabel personName, personGen, personFavouriteGenre, personFavouriteArtist, personFavouriteSong;
    JButton back, home, exit;
    Border border1,border2,border3;
    Font info50,infoFont;
    Cursor cursor;
    
    

    public DisplayUserInfo(String userInfo) {
        String [] userDetails = userInfo.split(",");
       
        // JFrame
        this.setTitle("Personify");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 495);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        
        // Container
        displayUi = this.getContentPane();
        displayUi.setLayout(new GridLayout(5, 1));
        displayUi.setBackground(Color.decode("#FFBE9E"));

        //App Icon
       icon = new ImageIcon("Personify-logo.png");
       this.setIconImage(icon.getImage());

       //Border
       border1 = BorderFactory.createLineBorder(Color.decode("#4486DB"), 1);
       border2 = BorderFactory.createLineBorder(Color.decode("#BAD121"), 1);
       border3 = BorderFactory.createLineBorder(Color.decode("#C91E1E"), 1);

       //Custom Cursor
       cursor = new Cursor(Cursor.HAND_CURSOR);

       

        // Font
        	try{
			info50 = Font.createFont(Font.TRUETYPE_FONT, new File("akaDora.ttf")).deriveFont(50f);	
			GraphicsEnvironment ge8 = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge8.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("akaDora.ttf")));			
		}
		catch(IOException | FontFormatException e){
			
		}
         infoFont = info50.deriveFont(Font.PLAIN, 50);

         // Buttons
         JPanel buttonPanel = new JPanel();
         buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
         buttonPanel.setBackground(Color.decode("#FFBE9E"));
 
         // Back Button
         backBtn = new ImageIcon("Back.png");
        back = new JButton(backBtn);
        back.setBounds(10, 15, backBtn.getIconWidth(), backBtn.getIconHeight());
        back.setBorder(border1);
        back.setCursor(cursor);
        back.setFocusable(false);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.decode("#A3C0E6"));
        back.addActionListener(this);
        buttonPanel.add(back);
        
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
        buttonPanel.add(home);
 
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
        buttonPanel.add(exit);
 
       displayUi.add(buttonPanel);


        // Person Name
        personName = new JLabel("Person's Identity : " + userDetails[0]);
        personName.setFont(infoFont);
        personName.setForeground(Color.decode("#DB6E89"));
        personName.setOpaque(true);
        personName.setBackground(Color.decode("#E0DEDA"));
        displayUi.add(personName);

        // Person Favourite Genre
        personFavouriteGenre = new JLabel("Favourite Genre: " + userDetails[1]);
        personFavouriteGenre.setFont(infoFont);
        personFavouriteGenre.setForeground(Color.decode("#DB6E89"));
        personFavouriteGenre.setOpaque(true);
        personFavouriteGenre.setBackground(Color.decode("#E0DEDA"));
        displayUi.add(personFavouriteGenre);

        // Person Favourite Artist
        personFavouriteArtist = new JLabel("Favourite Artist: " + userDetails[2]);
        personFavouriteArtist.setFont(infoFont);
        personFavouriteArtist.setForeground(Color.decode("#DB6E89"));
        personFavouriteArtist.setOpaque(true);
        personFavouriteArtist.setBackground(Color.decode("#E0DEDA"));
        displayUi.add(personFavouriteArtist);

        // Person Favourite Song
        personFavouriteSong = new JLabel("Favourite Song: " + userDetails[3]);
        personFavouriteSong.setFont(infoFont);
        personFavouriteSong.setForeground(Color.decode("#DB6E89"));
        personFavouriteSong.setOpaque(true);
        personFavouriteSong.setCursor(cursor);
        personFavouriteSong.setBackground(Color.decode("#E0DEDA"));
        personFavouriteSong.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ShowFavSong s1 = new ShowFavSong(userInfo);
                s1.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(personFavouriteSong)).setVisible(false);
                }
        });
        displayUi.add(personFavouriteSong);

       

        this.setVisible(true);
    }

    // ActionListener for back, home, exit buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0); // Exit the application
        } else if (e.getSource() == back) {
            new LoginPage();
            this.setVisible(false);
        } else if (e.getSource() == home) {
            new LoginPage();
            this.setVisible(false);
        }
    }

}

