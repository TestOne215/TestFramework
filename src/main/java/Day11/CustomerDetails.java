package Day11;

import java.util.*;

public class CustomerDetails {
    public static void main(String[] args) {
        HyundaiCustomerInfo custInfo1 = new HyundaiCustomerInfo();
        custInfo1.setName("Annie");
        custInfo1.setCity("Bangalore");
        custInfo1.setState("karnataka");
        custInfo1.setCarModel("i10");
        List<String> phoneNumber = new ArrayList<>();
        phoneNumber.add("234546457676");
        phoneNumber.add("9234546457676");
        custInfo1.setPhoneNumbers(phoneNumber);



        HyundaiCustomerInfo custInfo2 = new HyundaiCustomerInfo();
        custInfo2.setName("John");
        custInfo2.setCity("Kochi");
        custInfo2.setState("kerala");
        custInfo2.setCarModel("i20");
        custInfo2.setPhoneNumbers(new ArrayList<String>(Arrays.asList("234546457676","9234546457676")));

        HyundaiCustomerInfo custInfo3 = new HyundaiCustomerInfo();
        custInfo3.setName("Jim");
        custInfo3.setCity("Chennai");
        custInfo3.setState("Tamil Nadu");
        custInfo3.setCarModel("Creta");
        custInfo3.setPhoneNumbers(new ArrayList<String>(Arrays.asList("1234546457676","79234546457676")));

        Map<String, HyundaiCustomerInfo> customerMap = new HashMap<String, HyundaiCustomerInfo>();
        customerMap.put("Annie",custInfo1);
        customerMap.put("John",custInfo2);
        customerMap.put("Jim",custInfo3);

        //retrieve particular value
        System.out.println(customerMap.get("Annie").getCity());
        System.out.println(customerMap.get("Annie").getName());

        //get all phone numbers of Annie
        System.out.println(customerMap.get("Annie").getPhoneNumbers());

    }
}
