package HW1_s133607;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Name:Sulaiman Khalifa Khalfan Al Yousfi
 * ID:s133607
 * HomeWork:1
 **/
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Declare constants
        int X1 = 0;
        int X2 = 100;

        //Prompting the user for Y1 and Y2
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the coordinates y1 and y2 of the given line: ");
        //Declaring Y1 and Y2
        double y1 = 0;
        double y2 = 0;

        //Validating for the correct input.
        if (input.hasNextDouble()){
                y1 = input.nextDouble();
                y2 = input.nextDouble();
                while (y1 < 1 || y2 < 1) {
                    System.out.println("Error: Enter coordinates > 0 .... Try Again");
                    System.out.print("Please enter the coordinates y1 and y2 of the given line: ");

                    //Validating for double inputs
                    if (input.hasNextDouble()) {
                        y1 = input.nextDouble();
                        y2 = input.nextDouble();
                    } else {
                        System.out.println("Error: It is not double value...Exit");
                        System.exit(0);
                    }
                }
        } else {
            System.out.println("Error: It is not double value...Exit");
            System.exit(0);
        }

        //Creating the Line2D.Double object.
        Line2D.Double line = new Line2D.Double(X1,y1,X2,y2);

        //Declaring a Rectangle2D.
        Rectangle2D.Double rec = new Rectangle2D.Double();

        //Declaring Count
        int count = 1;

        // User file input
        System.out.print("Please enter input file name: ");
        String name = input.next();
        File file = new File(name);
        Scanner infile = new Scanner(file);

        //The start of table printing.
        System.out.println("=".repeat(65));
        System.out.println("|   Rect   |  R(    x,    y,    w,    h  )  |  relative position |");
        System.out.println("=".repeat(65));
        // This is the middle part where the rectangle information is printed
        while (infile.hasNextLine()){
            String fLine = infile.nextLine();
            Scanner data = new Scanner(fLine);
            data.useDelimiter(":");
            double x = data.nextDouble();// x of the top left corner
            double y = data.nextDouble();// y of the top left corner
            double xx = data.nextDouble();// x of the down right corner
            double yy = data.nextDouble();// y of the down right corner
            rec.setRect(x,y,Math.abs(x-xx),Math.abs(y-yy));//the distance between the x's and y's are the width and height
            Intersection posRec = new Intersection(rec,line);
            System.out.printf("|   %-7d|   (%5.1f,%5.1f,%5.1f,%5.1f  )  |    %-10s      |",count,rec.getX(),rec.getY(),rec.getWidth(),rec.getHeight(),posRec.checkIntersection());
            System.out.println();
        }
        System.out.println("=".repeat(65));
        //End of table printing
        // Getting the slope of the line.
        Point2D lineP1 = line.getP1();
        Point2D lineP2 = line.getP2();
        double slope = (lineP2.getY() - lineP1.getY()) / (lineP2.getX() - lineP1.getX());
        System.out.println("The slope of the line passing through ( 0, "+lineP1.getY()+" ) and ( 100, "+lineP2.getY()+" ) is "+slope);

        infile.close();v
    }
}
