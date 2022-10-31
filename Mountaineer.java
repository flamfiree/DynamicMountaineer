public class Mountaineer {
    public IMountaineerState getMountaineer() {
        return mountaineer;
    }
    public void setMountaineer(IMountaineerState mountaineer) {
        this.mountaineer = mountaineer;
    }
    private IMountaineerState mountaineer;

    public Mountaineer(IMountaineerState mountaineer) {
        this.mountaineer = mountaineer;
    }
    public String climb(){
        return mountaineer.climbing(this);
    }
    public String rest(){
        return mountaineer.resting(this);
    }
}
