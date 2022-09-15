
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class ImageOperation {
    public static void operate(int key)
    {
        try {
            JFileChooser fileChooser=new JFileChooser();
            fileChooser.showOpenDialog(null);
            File file=fileChooser.getSelectedFile();
            //file input stream reader
            
            FileInputStream fis = new FileInputStream(file);
            byte []data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data)
            {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }
            
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null,"Done");
        } catch (IOException ex) {
            Logger.getLogger(ImageOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  public static void main(String args[])
  {
      System.out.println("Encrypt and Decrypt your files here.");
      
      JFrame f= new JFrame();
      f.setTitle("ImageOperation");
      f.setSize(300,300);
      f.setLocationRelativeTo(null);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Font font = new Font("Arial",Font.BOLD,20);
      
      //Creating button
      JButton button = new JButton();
      button.setText("Open Image");
      button.setFont(font);
      
      //Creating Textfield
      JTextField textField = new JTextField(10);
      textField.setFont(font);
  
      button.addActionListener(e->{System.out.println("Button Clicked"); 
      String text=textField.getText();
      int temp=Integer.parseInt(text);
      operate(temp);
      });
          
          
      f.setLayout(new FlowLayout());
      
      f.add(button);
      f.add(textField);
      f.setVisible(true);
  }
}
