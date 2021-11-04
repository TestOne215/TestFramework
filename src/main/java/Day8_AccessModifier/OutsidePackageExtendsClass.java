package Day8_AccessModifier;

import Day8.AccessModifiers;

public class OutsidePackageExtendsClass extends AccessModifiers {
    public static void main(String[] args) {
        OutsidePackageExtendsClass am = new OutsidePackageExtendsClass();
        System.out.println(am.pub);
        //System.out.println(am.pri);
         System.out.println(am.pro);
        // System.out.println(am.def);

        am.pubmethod();
        am.promethod();
       // am.primethod();
       // am.defmethod();
    }
}
