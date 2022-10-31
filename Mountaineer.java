import javax.swing.*;

public class Mountaineer {

    public int power = 50;
    public final int speed = 30;

    public IMountaineerState getMountaineer() {
        return mountaineer;
    }
    public void setMountaineer(IMountaineerState mountaineer) {
        this.mountaineer = mountaineer;
    }
    private IMountaineerState mountaineer;

    public Mountaineer() {
        this.mountaineer = new RestMount();
//        timer.start();
    }
    public String climb(){
        return mountaineer.climbing(this);
    }
    public String rest(){
        return mountaineer.resting(this);
    }

}
