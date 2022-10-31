import javax.swing.*;

public class MyForm extends JFrame{
    private JButton climbButton;
    private JButton restButton;
    private JLabel outLabel;
    private JPanel MyPanel;

    Mountaineer mountaineer = new Mountaineer();
    private void climb(){
        outLabel.setText(mountaineer.climb() + "    \n" + mountaineer.power);
        if(mountaineer.power <= 0){
            this.rest();
        }
        timer.start();
    }
    private void rest(){
        outLabel.setText(mountaineer.rest() + "     \n" + mountaineer.power);
    }

    private void action(){
        if(mountaineer.getMountaineer().getClass() == RestMount.class){
            this.rest();
        }
        if(mountaineer.getMountaineer().getClass() == ClimbMount.class){
            this.climb();
        }
    }

    public Timer timer = new Timer(1000,e -> action());

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
