public class ClimbMount implements IMountaineerState{
    public ClimbMount(){

    }
    @Override
    public String climbing(Mountaineer mountaineer) {
        System.out.println("Still climbing");
        return "Still climbing";
    }
    @Override
    public String resting(Mountaineer mountaineer) {
        mountaineer.setMountaineer(new RestMount());
        System.out.println("Climb -> Rest");
        return "Climb -> Rest";
    }
}
