public class RestMount implements IMountaineerState{
    @Override
    public String climbing(Mountaineer mountaineer) {
        mountaineer.setMountaineer(new ClimbMount());
        mountaineer.power--;
        return "Rest -> Climb";
    }

    @Override
    public String resting(Mountaineer mountaineer) {
        mountaineer.power++;
        return "Still resting";
    }
}
