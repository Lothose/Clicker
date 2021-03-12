import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PopupClicker {
    protected static int count = 0;

	public static void main(String[] args) { 
		new PopupClicker().run(); 
		}

    public void run() {
    	//Using OS look and feel
        JFrame.setDefaultLookAndFeelDecorated(false);
        
        //naming label
        JLabel label1 = new JLabel("Click Count: ", JLabel.LEFT);

        //making new panel and adding label using grid layout
        JPanel panelLabel = new JPanel();
        panelLabel.setLayout(new GridLayout(1, 1, 0, 10));
        panelLabel.add(label1);
        
        //making new text field and making it uneditable.
		final JTextField tf1 = new JTextField(count + "",10);
		tf1.setEditable(false);
		
		//adding text field to panel with grid layout
        JPanel panelTextField = new JPanel();
        panelTextField.setLayout(new GridLayout(1, 1, 0, 10));
        panelTextField.add(tf1);

        //centering panel with flow layout and adding the two previous created texts. 
        JPanel panelText = new JPanel();
        panelText.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));
        panelText.add(panelLabel);
        panelText.add(panelTextField);
        
        //creating button
        JButton butClick = new JButton("Click me");
        //adding action listener to button done anonymously (still don't completely grasp this part)
        butClick.addActionListener(
            new ActionListener() {
            	//overriding the action inherited from ActionEvent
                @Override
                public void actionPerformed(ActionEvent pEvent) {
                	//Adding count per click to text field and displaying message dialog box. 
                	count++;
                	tf1.setText(count + "");
                    String msg = "You clicked " + count + " times!";
                    JOptionPane.showMessageDialog(null, msg);
                }
            });
        //added button to panel with listener action.
        JPanel panelButton = new JPanel();
        panelButton.add(butClick);
        
        //combine text and panel buttons
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(panelText);
        mainPanel.add(panelButton);

        //create frame and name it.
        JFrame frame = new JFrame("Button Clicker");
        frame.setSize(450, 250);
        frame.add(mainPanel);
        //set exit conditions and visibility.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
