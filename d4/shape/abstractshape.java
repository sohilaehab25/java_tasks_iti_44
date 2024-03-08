import java.util.ArrayList;
//import javafx.scene.shape.Circle;

abstract class Shape {
    abstract void draw();
}


class Rectangle extends Shape {
    @Override
    void draw() {
System.out.println("drawing rectangle");        
    }


}
class Mycircle extends Shape {
    @Override
    void draw() {
System.out.println("drawing circle");        
    }
}

class ArrayShape{
    public static void main(String[] args) {

        //create array of list
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        ArrayList<Mycircle> circles = new ArrayList<>();


        //adding some elements to the lists
        rectangles.add( new Rectangle());
        circles.add( new Mycircle());


         //calling for generic methof for every list
         testMethod(rectangles);
         testMethod(circles);
 

    }
        //generic method;
        static <T extends Shape> void testMethod(ArrayList<T> shapeList) {
            for (T shape : shapeList) {
                shape.draw();
            }
        }
}


       


    