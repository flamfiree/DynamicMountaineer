public class RestMount implements IMountaineerState{
    @Override
    public String climbing(Mountaineer mountaineer) {
        mountaineer.setMountaineer(new ClimbMount());
        System.out.println("Rest -> Climb");
        return "Rest -> Climb";
    }

    @Override
    public String resting(Mountaineer mountaineer) {
        System.out.println("Still resting");
        return "Still resting";
    }
}
