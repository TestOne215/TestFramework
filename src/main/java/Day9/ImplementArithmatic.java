package Day9;

public class ImplementArithmatic implements ArithematicInterface{


    @Override
    public int add(int i, int j) {
        return i+j;
    }

    @Override
    public int subtract(int i, int j) {
        return i-j;
    }

    public int multiply(int i, int j) {
        return i*j;
    }
}
