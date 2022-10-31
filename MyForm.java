import javax.swing.*;

public class MyForm extends JFrame{
    private JButton climbButton;
    private JButton restButton;
    private JLabel outLabel;
    private JPanel MyPanel;
    private JSpinner speedSpin;
    private JSlider maxPowerSlider;
    private JComboBox lengthBox;
    private JComboBox heightBox;
    private JProgressBar powerBar;
    private JLabel maxPowerLabel;
    private JButton startButton;

    Mountaineer mountaineer;

    private void start(){
        mountaineer = new Mountaineer((int)speedSpin.getValue(),maxPowerSlider.getValue());
        climbButton.setEnabled(true);
    }

    private void climb(){
        climbButton.setEnabled(false);
        restButton.setEnabled(true);
        outLabel.setText(mountaineer.climb() + "    " + mountaineer.getPower());
        if(mountaineer.getPower() <= 0){
            this.rest();
        }
        timer.start();
    }
    private void rest(){
        climbButton.setEnabled(true);
        restButton.setEnabled(false);
        outLabel.setText(mountaineer.rest() + "     " + mountaineer.getPower());
    }

    private void action(){
//        timer.setDelay(1000*(Hill.length/mountaineer.speed));
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
        this.setSize(500,400);
        Hill.length = 3000;
        Hill.height = 1000;
        climbButton.setEnabled(false);
        restButton.setEnabled(false);
        startButton.addActionListener(e -> start());
        climbButton.addActionListener(e -> climb());
        restButton.addActionListener(e -> rest());

    }

    public static void main(String[] args) {
        new MyForm();
    }

    private void createUIComponents() {
        Integer[] length = new Integer[]{200,300,400,500,600,700,800};
        lengthBox = new JComboBox<>(length);

        Integer[] height = new Integer[]{1000,1500,2000,2500,3000};
        heightBox = new JComboBox<>(height);

        speedSpin = new JSpinner(new SpinnerNumberModel(1, 1,15,1));
        ((JSpinner.DefaultEditor) speedSpin.getEditor()).getTextField().setEditable(false);

        maxPowerSlider = new JSlider(10,100,50);
        maxPowerSlider.setPaintTrack(true);
        maxPowerSlider.setPaintTicks(true);
        maxPowerSlider.setPaintLabels(true);
        maxPowerSlider.setMajorTickSpacing(10);
        maxPowerSlider.setMinorTickSpacing(5);
        maxPowerSlider.addChangeListener( e -> maxPowerLabel.setText(" = " + maxPowerSlider.getValue()));
    }
}
