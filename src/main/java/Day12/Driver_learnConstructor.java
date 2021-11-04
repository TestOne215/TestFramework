package Day12;

public class Driver_learnConstructor {
    public static void main(String[] args) {
        LearnConstructor lconst = new LearnConstructor();
        lconst.setVal(10,20); //overwrites the value here
        System.out.println(lconst.sum());

        LearnConstructor lconst1 = new LearnConstructor(90,20);
        System.out.println(lconst1.sum());
    }
}
