import javax.swing.*;
import java.util.Objects;

public class MyForm extends JFrame{
    //Graphical interface elements
    private JButton climbButton;
    private JButton restButton;
    private JLabel outLabel;
    private JPanel MyPanel;
    private JSpinner speedSpin;
    private JSlider maxPowerSlider;
    private JComboBox<Integer> lengthBox;
    private JComboBox<Integer> heightBox;
    private JProgressBar powerBar;
    private JLabel maxPowerLabel;
    private JButton startButton;
    private JLabel lengthOutLabel;
    private JLabel heightOutLabel;
    private JLabel timeLabel;

    Mountaineer mountaineer;

    //The method linked to the button 'startButton'
    private void start(){
        Hill.length = (int) Objects.requireNonNull(lengthBox.getSelectedItem());
        Hill.height = (int) Objects.requireNonNull(heightBox.getSelectedItem());
        mountaineer = new Mountaineer((int)speedSpin.getValue(),maxPowerSlider.getValue());
        mountaineer.setState(new RestMount());
        climbButton.setEnabled(true);
        powerBar.setValue(mountaineer.getPower());
        time = 0;
    }

    private void climb(){
        climbButton.setEnabled(false);
        restButton.setEnabled(true);
        outLabel.setText(mountaineer.climb());
        powerBar.setValue(mountaineer.getPower());
        if(mountaineer.getPower() <= 0){
            this.rest();
        }
        timer.start();
    }
    private void rest(){
        climbButton.setEnabled(true);
        restButton.setEnabled(false);
        outLabel.setText(mountaineer.rest());
        powerBar.setValue(mountaineer.getPower());
    }

    int time = 0;
    private void action(){
//        timer.setDelay(1000*(Hill.length/mountaineer.speed));
        if(mountaineer.getState().getClass() == RestMount.class){
            this.rest();
        }
        if(mountaineer.getState().getClass() == ClimbMount.class){
            this.climb();
        }
        lengthOutLabel.setText(String.valueOf(mountaineer.getPoint().x));
        heightOutLabel.setText(String.valueOf(mountaineer.getPoint().y));
        time++;
        timeLabel.setText("Time since the beginning of the climbing: " + time);
    }

    public Timer timer = new Timer(1000,e -> action());

    public MyForm(){
        this.setVisible(true);
        this.setContentPane(MyPanel);
        this.setSize(600,500);

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
        Integer[] length = new Integer[]{50,300,400,500,600,700,800};
        lengthBox = new JComboBox<>();
        lengthBox.setModel(new DefaultComboBoxModel<>(length));

        Integer[] height = new Integer[]{100,1500,2000,2500,3000};
        heightBox = new JComboBox<>();
        heightBox.setModel(new DefaultComboBoxModel<>(height));

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
