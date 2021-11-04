package Day9_Abstract_class;

import Day9.ArithematicInterface;
import Day9.ImplementArithmatic;
import Day9.John_implementInterface;

public class Driver_AbstractClass {
    public static void main(String[] args) {

        //creating object with reference to class
        implementAbstractclass arith = new implementAbstractclass();
        System.out.println(arith.add(20, 30));
        System.out.println(arith.subtract(30, 20));
        System.out.println(arith.multiply(30, 20));

        //creating object with reference to abstract
        AbstractClass arith1 = new implementAbstractclass();
        System.out.println(arith1.add(20, 30));
        System.out.println(arith1.subtract(30, 20));
        //cannot access
        //System.out.println(arith1.multiply(30,20));




    }

}
