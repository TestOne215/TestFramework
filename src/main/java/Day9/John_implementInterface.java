package Day9;

public class John_implementInterface implements ArithematicInterface {
    @Override
    public int add(int i, int j) {
        return i+j;
    }

    @Override
    public int subtract(int i, int j) {
        return i-j;
    }

    public int Divide(int i, int j) {
        return i-j;
    }

}
