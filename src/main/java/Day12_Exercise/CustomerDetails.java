package Day12_Exercise;

import Day12_Exercise.HyundaiCustomerInfo;

import java.util.*;

public class CustomerDetails {
    public static void main(String[] args) {
        List<String> phoneNumber = new ArrayList<>();
        phoneNumber.add("234546457676");
        phoneNumber.add("9234546457676");
        Day12_Exercise.HyundaiCustomerInfo custInfo1 = new Day12_Exercise.HyundaiCustomerInfo("Annie","karnataka","Bangalore","i10",phoneNumber);
//        custInfo1.setName("Annie");
//        custInfo1.setCity("Bangalore");
//        custInfo1.setState("karnataka");
//        custInfo1.setCarModel("i10");

//        custInfo1.setPhoneNumbers(phoneNumber);



        Day12_Exercise.HyundaiCustomerInfo custInfo2 = new Day12_Exercise.HyundaiCustomerInfo("John","kerala","kochi","i20",new ArrayList<String>(Arrays.asList("23454645","923454645")));
//        custInfo2.setName("John");
//        custInfo2.setCity("Kochi");
//        custInfo2.setState("kerala");
//        custInfo2.setCarModel("i20");
//        custInfo2.setPhoneNumbers(new ArrayList<String>(Arrays.asList("234546457676","9234546457676")));

        Day12_Exercise.HyundaiCustomerInfo custInfo3 = new Day12_Exercise.HyundaiCustomerInfo("Jim","Tamil Nadu","Chennai","Creta",new ArrayList<String>(Arrays.asList("1234546457676","79234546457676")));
        custInfo3.setCity("Madhurai");
//        custInfo3.setName("Jim");
//        custInfo3.setCity("Chennai");
//        custInfo3.setState("Tamil Nadu");
//        custInfo3.setCarModel("Creta");
//        custInfo3.setPhoneNumbers(new ArrayList<String>(Arrays.asList("1234546457676","79234546457676")));

        Map<String, Day12_Exercise.HyundaiCustomerInfo> customerMap = new HashMap<String, HyundaiCustomerInfo>();
        customerMap.put("Annie",custInfo1);
        customerMap.put("John",custInfo2);
        customerMap.put("Jim",custInfo3);

        //retrieve particular value
        System.out.println(customerMap.get("Annie").getCity());
        System.out.println(customerMap.get("Annie").getName());
        System.out.println(customerMap.get("Jim").getCity());
        //get all phone numbers of Annie
        System.out.println(customerMap.get("Annie").getPhoneNumbers());

    }
}
