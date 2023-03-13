package HW1_s133607;/*
Name:Sulaiman Khalifa Khalfan Al Yousfi
Id:s133607
Problem:
Input:
Output:
Tests:
*/

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
//This class takes a Rectangle2D and a Line2D both should be DOUBLE type ,and it contains my custom intersection check.
//@para rec Rectangle2D.Double
//@para line Line2D.Double
public class Intersection {
    private static Rectangle2D.Double rec;
    private static Line2D.Double line;
    public Intersection(Rectangle2D.Double rec, Line2D.Double line) {
        this.rec=rec;
        this.line = line;
    }
    //it will check for intersection ,if there is no intersection it checks weather the rectangle is above or below the
    // line
    public static String checkIntersection(){
        if(line.intersects(rec)){
            return "Intersects";
        }
        else{
            double recY1 = rec.getY();
            Point2D lineP1 = line.getP1();
            Point2D lineP2 = line.getP2();

            double slope = (lineP2.getY() - lineP1.getY()) / (lineP2.getX() - lineP1.getX());
            double lineY = slope * (rec.getX() - lineP1.getX()) + lineP1.getY();
            if(lineY < recY1){
                return "Below";
            }else{
                return "Above";
            }
        }
    }
}
