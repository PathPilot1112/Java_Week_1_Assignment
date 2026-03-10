public class Parking_lot {

    String[] table = new String[10];

    int hash(String plate) {
        return Math.abs(plate.hashCode()) % table.length;
    }

    int park(String plate) {

        int index = hash(plate);

        while (table[index] != null)
            index = (index + 1) % table.length;

        table[index] = plate;

        return index;
    }

    public static void main(String[] args) {

        Parking_lot lot = new Parking_lot();

        System.out.println("Parked at: " + lot.park("ABC123"));
        System.out.println("Parked at: " + lot.park("XYZ999"));
    }
}