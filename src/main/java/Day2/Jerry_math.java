package Day2;

public class Jerry_math {
    public static void main(String[] args) {
        Common_arithemetics jerry_arith = new Common_arithemetics();

        //add 2 numbers
        int adds = jerry_arith.add(30,30);
        System.out.println("Sum of number "+adds);
        //multiply 2 numbers
        int mults = jerry_arith.mult(10,20);
        System.out.println("multiplication of number "+mults);

    }
}
