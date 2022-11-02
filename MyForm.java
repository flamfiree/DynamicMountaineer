import javax.swing.*;
import java.io.PrintStream;
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
    private JSlider timeSlider;
    private JLabel timeCoefLabel;
    private JLabel speedTextLabel;
    private JLabel powerTextLabel;
    private JLabel lengthTextLabel;
    private JLabel heightTextLabel;

    Mountaineer mountaineer;

    private void enableStart(){
        speedTextLabel.setEnabled(false);
        speedSpin.setEnabled(false);

        powerTextLabel.setEnabled(false);
        maxPowerLabel.setEnabled(false);
        maxPowerSlider.setEnabled(false);

        lengthTextLabel.setEnabled(false);
        lengthBox.setEnabled(false);

        heightTextLabel.setEnabled(false);
        heightBox.setEnabled(false);

        startButton.setEnabled(false);
    }

    //The method linked to the button 'startButton'
    private void start(){
        Hill.length = (int) Objects.requireNonNull(lengthBox.getSelectedItem());
        Hill.height = (int) Objects.requireNonNull(heightBox.getSelectedItem());
        mountaineer = new Mountaineer((int)speedSpin.getValue(),maxPowerSlider.getValue());
        mountaineer.setState(new RestMount());
        climbButton.setEnabled(true);
        powerBar.setValue(mountaineer.getPower());
        time = 0;
        enableStart();
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

    double time = 0;
    private void action(){
        timer.setDelay((int) (1000 / (timeSlider.getValue()/50.000)));

        if(mountaineer.getState().getClass() == RestMount.class){
            this.rest();
        }
        if(mountaineer.getState().getClass() == ClimbMount.class){
            this.climb();
        }
        if(Objects.equals(mountaineer.getState().climbing(mountaineer), "End")) timer.stop();
//        lengthOutLabel.setText("Passed way: " + mountaineer.getPoint().x);

        lengthOutLabel.setText(String.format("Passed way: %.2f",mountaineer.getPoint().x));
        heightOutLabel.setText(String.format("Current height: %.2f",mountaineer.getPoint().y));
        time++;
        timeLabel.setText("Time: " + time);
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

        timeSlider = new JSlider(1,100,50);
        timeSlider.setPaintTrack(true);
        timeSlider.setPaintTicks(true);
        timeSlider.setPaintLabels(true);
        timeSlider.setMajorTickSpacing(10);
        timeSlider.setMinorTickSpacing(5);
        timeSlider.addChangeListener( e -> timeCoefLabel.setText("Coefficient =  " + timeSlider.getValue()));
    }
}
