public class ClimbMount implements IMountaineerState{
    public ClimbMount(){

    }
    @Override
    public String climbing(Mountaineer mountaineer) {
        mountaineer.setPower(mountaineer.getPower() - 1);
        return "Still climbing";
    }
    @Override
    public String resting(Mountaineer mountaineer) {
        mountaineer.setMountaineer(new RestMount());
        mountaineer.setPower(mountaineer.getPower() + 1);
        return "Climb -> Rest";
    }
}
