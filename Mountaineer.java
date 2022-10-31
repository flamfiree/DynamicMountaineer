import javax.swing.*;

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

    public int getSpeed() {
        return speed;
    }

    public final int speed;

    public IMountaineerState getMountaineer() {
        return mountaineer;
    }
    public void setMountaineer(IMountaineerState mountaineer) {
        this.mountaineer = mountaineer;
    }
    private IMountaineerState mountaineer;

    public Mountaineer(int speed, int maxPower) {
        this.speed = speed;
        this.maxPower = maxPower;
        this.power = maxPower;
        this.mountaineer = new RestMount();
    }
    public String climb(){
        return mountaineer.climbing(this);
    }
    public String rest(){
        return mountaineer.resting(this);
    }
}
