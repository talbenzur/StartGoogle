package Week3.CreationalPatterns;

import Week3.CreationalPatterns.Vehicles.VehiclesFactory;

import java.lang.reflect.Array;

public class Util {
    private static String names[] = {
            "James", "Robert", "David", "Michael", "William", "Richard",
            "Joseph", "Thomas", "Charles", "Daniel", "Mark", "Paul",
            "Sarah", "Karen", "Lisa", "Jennifer", "Linda", "Emily",
            "Michelle", "Melissa", "Sharon", "Dana", "Deborah", "Amy", "Anna"
    };

    public static int randomNumber(int size) {
        return (int) Math.floor(Math.random() * size);
    }

    public static String randomName() {
        return names[randomNumber(names.length - 1)];
    }

    public static VehiclesFactory.VehicleType randomVehicleType() {
        int sizeOfVehicleType = VehiclesFactory.VehicleType.values().length;
        int randomNumber = randomNumber(sizeOfVehicleType - 1);
        return VehiclesFactory.VehicleType.getVehicleByIndex(randomNumber);
    }
}
