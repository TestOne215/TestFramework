package Day2;

public class John_math {
    public static void main(String[] args) {

        Common_arithemetics arithemetics = new Common_arithemetics(); //object created of type Common_arithemetics.java

        //add 2 numbers
        int adds = arithemetics.add(20,30);
        System.out.println("Sum of number "+adds);
        //multiply 2 numbers
       int mults = arithemetics.mult(10,20);
        System.out.println("multiplication of number "+mults);
        //subtract 2 numbers
        int subts = arithemetics.subt(20,10);
        System.out.println("subtraction of number "+subts);



//        int sums = 10 + 20;
//        System.out.println("Sum of numbers "  +sums);
//
//        int muls = 20 - 10;
//        System.out.println("Subtraction of numbers "  +muls);
//
//        int subs = 10 * 20;
//        System.out.println("Multiplication of numbers "  +subs);


    }
}
