import javax.swing.*;

public class MyForm extends JFrame{
    private JButton climbButton;
    private JButton restButton;
    private JLabel outLabel;
    private JPanel MyPanel;

    Mountaineer mountaineer = new Mountaineer(new RestMount());
    private void climb(){
        outLabel.setText(mountaineer.climb() + "    \n" + mountaineer.getMountaineer().toString());
    }
    private void rest(){
        outLabel.setText(mountaineer.rest() + "     \n" + mountaineer.getMountaineer().toString());
    }

    public MyForm(){
        this.setVisible(true);
        this.setContentPane(MyPanel);
        this.setSize(200,100);
        climbButton.addActionListener(e -> climb());
        restButton.addActionListener(e -> rest());
    }

    public static void main(String[] args) {
        new MyForm();
    }
}
