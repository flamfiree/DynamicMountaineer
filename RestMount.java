public class RestMount implements IMountaineerState{
    @Override
    public String climbing(Mountaineer mountaineer) {
        mountaineer.setMountaineer(new ClimbMount());
        mountaineer.setPower(mountaineer.getPower() - 1);
        return "Rest -> Climb";
    }

    @Override
    public String resting(Mountaineer mountaineer) {
        mountaineer.setPower(mountaineer.getPower() + 1);
        return "Still resting";
    }
}
