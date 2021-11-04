package Day8;

public class OutsideClassSamePackage {

    public static void main(String[] args) {
        AccessModifiers am = new AccessModifiers();
        System.out.println(am.pub);
        //System.out.println(am.pri);
        System.out.println(am.pro);
        System.out.println(am.def);

        am.pubmethod();
        am.promethod();
        //am.primethod();
        am.defmethod();
    }
}
