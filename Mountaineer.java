import java.awt.geom.Point2D;

public class Mountaineer {

    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        if(power <= 0){
            this.power = 0;
            rest();
        }
        else this.power = Math.min(power, maxPower);
    }
    private final int maxPower;
    private int power;

    public double getInitSpeed() {
        return initSpeed;
    }
    private final double initSpeed;

    public double getCurSpeed() {
        return curSpeed;
    }
    public void setCurSpeed(double curSpeed) {
        this.curSpeed = curSpeed;
    }
    private double curSpeed;

    public Point2D.Double getPoint() {
        return point;
    }
    public void setPoint(Point2D.Double point) {
        if(point.x >= Hill.length) point.x = Hill.length;
        if(point.y >= Hill.height) point.y = Hill.height;
        this.point = point;
    }
    private Point2D.Double point;


    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
    private State state;

    public Mountaineer(int initSpeed, int maxPower) {
        this.initSpeed = initSpeed;
        this.curSpeed = initSpeed;

        this.maxPower = maxPower;
        this.power = maxPower;

        this.point = new Point2D.Double(0,0);
    }
    public String climb(){
        this.setState(new ClimbMount());
        return state.climbing(this);
    }
    public String rest(){
        this.setState(new RestMount());
        return state.resting(this);
    }
}
