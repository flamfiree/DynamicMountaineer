import java.awt.geom.Point2D;

public class ClimbMount extends State {
    Mountaineer mountaineer;

    @Override
    public String climbing(Mountaineer mountaineer) {
        this.mountaineer = mountaineer;
        if(mountaineer.getPoint().x < (double) Hill.length/3){
            climbUp();
        }
        else if(mountaineer.getPoint().x > (double) Hill.length/3 && mountaineer.getPoint().x <(double) 2*Hill.length/3){
            climbPlain();
        }
        else if(mountaineer.getPoint().x > (double) 2*Hill.length/3 && mountaineer.getPoint().x < Hill.length){
            climbDown();
        } else
            return "End";
        return "Climbing";
    }
    private void climbUp(){
        double tg = Hill.height/(double)(Hill.length/3);
        double cos = (double) (Hill.length/3)
                / (Math.sqrt(Math.pow(Hill.height,2) + Math.pow((double) Hill.length/3,2)));
        mountaineer.setCurSpeed(mountaineer.getInitSpeed()*cos);
        mountaineer.setPower(mountaineer.getPower() - 3);
        mountaineer.setPoint(new Point2D.Double(
                mountaineer.getPoint().x + mountaineer.getCurSpeed(),
                (mountaineer.getPoint().x + mountaineer.getCurSpeed()) * tg)
        );

    }
    private void climbPlain(){
        mountaineer.setCurSpeed(mountaineer.getInitSpeed());
        mountaineer.setPower(mountaineer.getPower() - 2);
        mountaineer.setPoint(new Point2D.Double(
                mountaineer.getPoint().x + mountaineer.getInitSpeed(),
                mountaineer.getPoint().y));
    }
    private void climbDown(){
        double tg = Hill.height/(double)(Hill.length/3);
        double cos = (double) (Hill.length/3)
                / (Math.sqrt(Math.pow(Hill.height,2) + Math.pow((double) Hill.length/3,2)));
        mountaineer.setCurSpeed(mountaineer.getInitSpeed()*(2 - cos));
        mountaineer.setPower(mountaineer.getPower() - 1);
//        mountaineer.setPoint(new Point2D.Double(
//                mountaineer.getPoint().x + mountaineer.getCurSpeed(),
//                mountaineer.getPoint().y - tg)
//        );
        mountaineer.setPoint(new Point2D.Double(
                mountaineer.getPoint().x + mountaineer.getCurSpeed(),
                - tg * ((mountaineer.getPoint().x + mountaineer.getCurSpeed()) - Hill.length))
        );
    }
}
