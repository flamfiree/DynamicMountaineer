public class RestMount extends State {
    @Override
    public String resting(Mountaineer mountaineer) {
        mountaineer.setPower(mountaineer.getPower() + 2);
        return "Resting";
    }
}
