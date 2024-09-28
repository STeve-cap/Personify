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


public class SignUp extends JFrame implements ActionListener{
   
   Container signUpContainer;
   ImageIcon startBG,icon,backBtn,homeBtn,exitBtn;
   Cursor cursor;
   JButton back,home,exit;
   Font labelFont, inputFont, label30, input40;
   JLabel personName, favGen, favArtist, favSong,uniqueIdentifier;
   Border border1,border2,border3;
   JTextField inputName,inputArt,inputSong;
   JComboBox genrePicker;
   JPasswordField uniqueKeyField;
   ButtonRounder signUp;

   public SignUp() {

        // JFrame
        this.setTitle("Personify");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 650);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        //App Icon
        icon = new ImageIcon("Personify-logo.png");
       this.setIconImage(icon.getImage());

        //Container
        signUpContainer = this.getContentPane();
        signUpContainer.setLayout(null);
        signUpContainer.setBackground(Color.decode("#784CBA"));

        //Border
       border1 = BorderFactory.createLineBorder(Color.decode("#4486DB"), 1);
       border2 = BorderFactory.createLineBorder(Color.decode("#BAD121"), 1);
       border3 = BorderFactory.createLineBorder(Color.decode("#C91E1E"), 1);

          //Fonts
          	try{
			label30 = Font.createFont(Font.TRUETYPE_FONT, new File("Southampton.ttf")).deriveFont(30f);	
			GraphicsEnvironment ge4 = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge4.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Southampton.ttf")));			
		}
		catch(IOException | FontFormatException e){
			
		}
		

        try{
			input40 = Font.createFont(Font.TRUETYPE_FONT, new File("AlexBrush-Regular.ttf")).deriveFont(40f);	
			GraphicsEnvironment ge5 = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge5.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("AlexBrush-Regular.ttf")));			
		}
		catch(IOException | FontFormatException e){
			
		}
          
          labelFont = label30.deriveFont(Font.BOLD, 30);
          inputFont = input40.deriveFont(Font.PLAIN,40);

         //JButtons

         //Home Button
         homeBtn = new ImageIcon("Home.png");
         home = new JButton(homeBtn);
         home.setBounds(65, 15, homeBtn.getIconWidth(), homeBtn.getIconHeight());
         home.setBorder(border2);
         home.setCursor(cursor);
         home.setForeground(Color.WHITE);
         home.setBackground(Color.decode("#CDD69F"));
         home.addActionListener(this);
         signUpContainer.add(home);
 
         //Exit Button
         exitBtn = new ImageIcon("Exit.png");
         exit = new JButton(exitBtn);
         exit.setBounds(120, 15, exitBtn.getIconWidth(), exitBtn.getIconHeight());
         exit.setBorder(border3);
         exit.setCursor(cursor);
         exit.setForeground(Color.WHITE);
         exit.setBackground(Color.decode("#C48787"));
         exit.addActionListener(this);
         signUpContainer.add(exit);
 
      
         //Back Button
        backBtn = new ImageIcon("Back.png");
        back = new JButton(backBtn);
        back.setBounds(10, 15, backBtn.getIconWidth(), backBtn.getIconHeight());
        back.setBorder(border1);
        back.setCursor(cursor);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.decode("#A3C0E6"));
        back.addActionListener(this);
        signUpContainer.add(back);

         //Sign Up Button
        signUp = new ButtonRounder("Sign Up");
        signUp.setBounds(270, 520, 400, 70);
        signUp.setHorizontalTextPosition(JButton.CENTER);
        signUp.setVerticalTextPosition(JButton.TOP);
        signUp.setFocusable(false);
        signUp.setFont(labelFont);
        signUp.setCursor(cursor);
        signUp.setBackground(Color.decode("#16C5D9"));
        signUp.addActionListener(this);
        signUpContainer.add(signUp);


        //JLabels

        //PersonName
        personName= new JLabel();
        personName.setBounds(50,100,220,60);
        personName.setFont(labelFont);
        personName.setForeground(Color.decode("#050505"));
        personName.setBackground(Color.decode("#11D9A0"));
        personName.setText("Person Goes By");
        personName.setHorizontalAlignment(JLabel.CENTER);
        personName.setOpaque(true);
        signUpContainer.add(personName);

        //favGen
        favGen= new JLabel();
        favGen.setBounds(50,180,220,60);
        favGen.setFont(labelFont);
        favGen.setForeground(Color.decode("#050505"));
        favGen.setBackground(Color.decode("#11D9A0"));
        favGen.setText("Favorite Genre");
        favGen.setHorizontalAlignment(JLabel.CENTER);
        favGen.setOpaque(true);
        signUpContainer.add(favGen);

        //favArtist

        favArtist= new JLabel();
        favArtist.setBounds(50,260,220,60);
        favArtist.setFont(labelFont);
        favArtist.setForeground(Color.decode("#050505"));
        favArtist.setBackground(Color.decode("#11D9A0"));
        favArtist.setText("Favorite Artist");
        favArtist.setHorizontalAlignment(JLabel.CENTER);
        favArtist.setOpaque(true);
        signUpContainer.add(favArtist);

        //favSong

        favSong= new JLabel();
        favSong.setBounds(50,340,220,60);
        favSong.setFont(labelFont);
        favSong.setForeground(Color.decode("#050505"));
        favSong.setBackground(Color.decode("#11D9A0"));
        favSong.setText("Favorite Song");
        favSong.setHorizontalAlignment(JLabel.CENTER);
        favSong.setOpaque(true);
        signUpContainer.add(favSong);

        

        //UniqueIdentifier
        uniqueIdentifier= new JLabel();
        uniqueIdentifier.setBounds(50,420,220,60);
        uniqueIdentifier.setFont(labelFont);
        uniqueIdentifier.setForeground(Color.decode("#050505"));
        uniqueIdentifier.setBackground(Color.decode("#11D9A0"));
        uniqueIdentifier.setText("Your Unique Key");
        uniqueIdentifier.setHorizontalAlignment(JLabel.CENTER);
        uniqueIdentifier.setOpaque(true);
        signUpContainer.add(uniqueIdentifier);

        //TextFields
        
        //InputName
        inputName = new JTextField();
        inputName.setBounds(280,100,520,60);
        inputName.setFont(inputFont);
        inputName.setForeground(Color.decode("#380554"));
        inputName.setBackground(Color.decode("#D1B8E3"));
        inputName.setCursor(cursor);
        inputName.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        signUpContainer.add(inputName);

        
        //Fav Artist Input
        inputArt = new JTextField();
        inputArt.setBounds(280,260,520,60);
        inputArt.setFont(inputFont);
        inputArt.setForeground(Color.decode("#380554"));
        inputArt.setBackground(Color.decode("#D1B8E3"));
        inputArt.setCursor(cursor);
        inputArt.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        signUpContainer.add(inputArt);


        //Fav Song Input

        inputSong = new JTextField();
        inputSong.setBounds(280,340,520,60);
        inputSong.setFont(inputFont);
        inputSong.setForeground(Color.decode("#380554"));
        inputSong.setBackground(Color.decode("#D1B8E3"));
        inputSong.setCursor(cursor);
        inputSong.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        signUpContainer.add(inputSong);

        //JComboBoxes

        //GenrePicker
        String [] genres = {"pop", "r&b", "hiphop", "indie", "rock", "metal"};
        genrePicker = new JComboBox(genres);
        genrePicker.setBounds(280,180,520,60);
        genrePicker.setFont(inputFont);
        genrePicker.setForeground(Color.decode("#380554"));
        genrePicker.setBackground(Color.decode("#D1B8E3"));
        genrePicker.addActionListener(this);
        signUpContainer.add(genrePicker);

         //PasswordField

        uniqueKeyField = new JPasswordField();
        uniqueKeyField.setBounds(280, 420, 520, 60);
        uniqueKeyField.setFont(inputFont);
        uniqueKeyField.setEchoChar('*');
        uniqueKeyField.setForeground(Color.decode("#380554"));
        uniqueKeyField.setBackground(Color.decode("#D1B8E3"));
        uniqueKeyField.setCaretColor(Color.decode("#05F7EF"));
        uniqueKeyField.setCursor(cursor);
        uniqueKeyField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        signUpContainer.add(uniqueKeyField);





        this.setVisible(true);
   }
  
   public void actionPerformed(ActionEvent e) {
    if (e.getSource() == signUp) {
        
        String name = inputName.getText();
        String favoriteGenre = genrePicker.getSelectedItem().toString();
        String favoriteArtist = inputArt.getText();
        String favoriteSong = inputSong.getText();
        String uniqueKey = new String(uniqueKeyField.getPassword());

        UserData userData = new UserData(name, favoriteGenre, favoriteArtist, favoriteSong, uniqueKey);

        UserDataManager.saveUser(userData);

        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
        this.setVisible(false);

    } else if (e.getSource() == home) {
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
        this.setVisible(false);

    } else if (e.getSource() == exit) {
        System.exit(0);
    } else if (e.getSource() == back) {
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
        this.setVisible(false);

    }
}


}
