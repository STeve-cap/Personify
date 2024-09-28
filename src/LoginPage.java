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


public class LoginPage extends JFrame implements ActionListener{
    
    JLabel startUpPage, personName,personIdentifier;
    Container container = new Container();
    ImageIcon startBG,icon,backBtn,homeBtn,exitBtn;
    Cursor cursor;
    JButton exit,signUp;
    ButtonRounder login;
    Border border1,border2,border3;
    Font loginFont,titleFont,inputFont,login40,title70,input40;
    JTextField appName,personLogin,inputName;
    JPasswordField inputIdentifier;
   public LoginPage() {
       
   

       //JFrame
       this.setTitle("Personify");
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(950,650);
       this.setLocationRelativeTo(null);
       this.setResizable(false);

       //Container
       container = this.getContentPane();
       container.setLayout(null);
       container.setBackground(Color.decode("#D1B8E3"));

       //App Icon
       icon = new ImageIcon("Personify-logo.png");
       this.setIconImage(icon.getImage());

       //Border
       border1 = BorderFactory.createLineBorder(Color.decode("#4486DB"), 1);
       border2 = BorderFactory.createLineBorder(Color.decode("#BAD121"), 1);
       border3 = BorderFactory.createLineBorder(Color.decode("#C91E1E"), 1);
       
      
       //Login Page Image
       startBG = new ImageIcon("Personify-login-screen.png");
       startUpPage = new JLabel(startBG);
       startUpPage.setBounds(0, 215, startBG.getIconWidth(), startBG.getIconHeight());
       container.add(startUpPage);

        //Fonts
			try{
			login40 = Font.createFont(Font.TRUETYPE_FONT, new File("Southampton.ttf")).deriveFont(40f);	
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Southampton.ttf")));			
		}
		catch(IOException | FontFormatException e){
			
		}
		
			try{
			title70 = Font.createFont(Font.TRUETYPE_FONT, new File("Antro_Vectra.otf")).deriveFont(70f);	
			GraphicsEnvironment ge2 = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge2.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Antro_Vectra.otf")));			
		}
		catch(IOException | FontFormatException e){
			
		}

        try{
			input40 = Font.createFont(Font.TRUETYPE_FONT, new File("AlexBrush-Regular.ttf")).deriveFont(40f);	
			GraphicsEnvironment ge3 = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge3.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("AlexBrush-Regular.ttf")));			
		}
		catch(IOException | FontFormatException e){
			
		}
          
          loginFont = login40.deriveFont(Font.BOLD, 40);
          titleFont = title70.deriveFont(Font.BOLD | Font.ITALIC, 70);
          inputFont = input40.deriveFont(Font.BOLD,40);



        //Custom Cursor
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons

        //Exit Button
        exitBtn = new ImageIcon("Exit.png");
        exit = new JButton(exitBtn);
        exit.setBounds(10, 15, exitBtn.getIconWidth(), exitBtn.getIconHeight());
        exit.setBorder(border3);
        exit.setCursor(cursor);
        exit.setForeground(Color.WHITE);
        exit.setBackground(Color.decode("#C48787"));
        exit.addActionListener(this);
        container.add(exit);

     
        //Login Button
        login = new ButtonRounder("Login");
        login.setBounds(510, 535, 200, 60);
        login.setHorizontalTextPosition(JButton.CENTER);
        login.setVerticalTextPosition(JButton.TOP);
        login.setFocusable(false);
        login.setFont(loginFont);
        login.setCursor(cursor);
        login.setBackground(Color.decode("#AD9E2A"));
        login.addActionListener(this);
        container.add(login);

        //Sign Up Button
        signUp = new JButton("Sign Up Here!");
        signUp.setBounds(490, 480, 400, 30);
        signUp.setHorizontalTextPosition(JButton.CENTER);
        signUp.setVerticalTextPosition(JButton.TOP);
        signUp.setFocusable(false);
        signUp.setFont(new Font("Southampton",Font.BOLD,15));
        signUp.setCursor(cursor);
        signUp.setBackground(Color.decode("#D1B8E3"));
        signUp.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        signUp.addActionListener(this);
        container.add(signUp);

        //TextFields

        //AppName Text
        appName = new JTextField();
        appName.setBounds(66,40,400,200);
        appName.setFont(titleFont);
        appName.setForeground(Color.decode("#380554"));
        appName.setBackground(Color.decode("#D1B8E3"));
        appName.setText("Personify");
        appName.setEditable(false);
        appName.setCursor(cursor);
        appName.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        appName.setHorizontalAlignment(JTextField.CENTER);
        container.add(appName);

        //PersonLogin Text
        personLogin= new JTextField();
        personLogin.setBounds(510,110,220,110);
        personLogin.setFont(loginFont);
        personLogin.setForeground(Color.decode("#050505"));
        personLogin.setBackground(Color.decode("#11D9A0"));
        personLogin.setCaretColor(Color.decode("#05F7EF"));
        personLogin.setText("Person Credential");
        personLogin.setCursor(cursor);
        personLogin.setEditable(false);
        personLogin.setHorizontalAlignment(JTextField.CENTER);
        container.add(personLogin);

        //InputName

        inputName= new JTextField();
        inputName.setBounds(645,250,280,100);
        inputName.setFont(loginFont);
        inputName.setForeground(Color.decode("#050505"));
        inputName.setBackground(Color.decode("#11D9A0"));
        inputName.setCaretColor(Color.decode("#05F7EF"));
        inputName.setCursor(cursor);
        container.add(inputName);

        //PasswordField

        inputIdentifier = new JPasswordField();
        inputIdentifier.setBounds(645, 370, 280, 100);
        inputIdentifier.setFont(inputFont);
        inputIdentifier.setEchoChar('*');
        inputIdentifier.setForeground(Color.decode("#050505"));
        inputIdentifier.setBackground(Color.decode("#11D9A0"));
        inputIdentifier.setCaretColor(Color.decode("#05F7EF"));
        inputIdentifier.setCursor(cursor);
        container.add(inputIdentifier);



        //JLabels

        //Person Name
        personName= new JLabel();
        personName.setBounds(410,250,220,100);
        personName.setFont(loginFont);
        personName.setForeground(Color.decode("#050505"));
        personName.setBackground(Color.decode("#11D9A0"));
        personName.setText("Person Goes By");
        personName.setHorizontalAlignment(JLabel.CENTER);
        personName.setOpaque(true);
        container.add(personName);

        //Person Identifier

        personIdentifier= new JLabel();
        personIdentifier.setBounds(410,370,220,100);
        personIdentifier.setFont(loginFont);
        personIdentifier.setForeground(Color.decode("#050505"));
        personIdentifier.setBackground(Color.decode("#11D9A0"));
        personIdentifier.setText("Unique Identifier");
        personIdentifier.setOpaque(true);
        container.add(personIdentifier);
     
      this.add(startUpPage);

      

     
     this.setVisible(true);
      
   }

  

   public void actionPerformed(ActionEvent e) {
    if (e.getSource() == login) {
        String username = inputName.getText();
        String password = new String(inputIdentifier.getPassword());
        String userLoggedIn = null;


        try {
            BufferedReader reader = new BufferedReader(new FileReader("user.txt"));
            String line;
            boolean loginSuccess = false;
            

            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData[0].equals(username) && userData[4].equals(password)) {
                    loginSuccess = true;
                    userLoggedIn = line;

                    break;
                }
            }

            reader.close();

            if (loginSuccess) {
               new DisplayUserInfo(userLoggedIn);
               this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials");
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    } else if (e.getSource() == signUp) {
        new SignUp();
        this.setVisible(false);
    } else if (e.getSource() == exit) {
        System.exit(0);
    }
}



}
