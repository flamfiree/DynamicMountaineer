public class ClimbMount implements IMountaineerState{
    public ClimbMount(){

    }
    @Override
    public String climbing(Mountaineer mountaineer) {
        mountaineer.power--;
        return "Still climbing";
    }
    @Override
    public String resting(Mountaineer mountaineer) {
        mountaineer.setMountaineer(new RestMount());
        mountaineer.power++;
        return "Climb -> Rest";
    }
}
