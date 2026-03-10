import java.util.*;

public class Two_Sum {

    boolean twoSum(int[] arr, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int num : arr) {

            int complement = target - num;

            if (map.containsKey(complement))
                return true;

            map.put(num,1);
        }

        return false;
    }

    public static void main(String[] args) {

        Two_Sum detector = new Two_Sum();

        int[] transactions = {500,300,200};

        System.out.println(detector.twoSum(transactions,500));
    }
}