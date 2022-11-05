package week3.creationalPatterns.vehicles;

import week3.creationalPatterns.Passenger;
import week3.creationalPatterns.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehiclesFactory {
    public enum VehicleType {
        PLANE(1),
        BUS(4),
        TAXI(8),
        BOAT(3);

        VehicleType(int size) {
            this.size = size;
        }

        public final int size;

        public static VehicleType getVehicleByIndex(int i) {
            return VehicleType.values()[i];
        }
    }

    private static VehiclesFactory instance;
    private static Map<VehicleType, Integer> agencyVehicle;
    private static Map<Passenger, Vehicle> passengerVehicleMap = new HashMap<>();

    public static VehiclesFactory getInstance() {
        if (instance == null) {
            instance = new VehiclesFactory();
        }
        return instance;
    }

    private VehiclesFactory() {
        agencyVehicle = new HashMap<>();
        for (VehicleType type : VehicleType.values()) {
            agencyVehicle.put(type, type.size);
        }
    }

    private static Vehicle createVehicle(VehicleType type) {
        switch (type) {
            case PLANE:
                return new Plane();
            case BUS:
                return new Bus();
            case TAXI:
                return new Taxi();
            case BOAT:
                return new Boat();
            default:
                throw new IllegalArgumentException(String.format("Vehicle type not supported: %s", type));
        }
    }

    public static Boolean getAvailableCar(Passenger passenger) {
        VehicleType favorite = passenger.getFavoriteVehicle();
        if (agencyVehicle.get(favorite) > 0) {//passenger’s favorite vehicle is available
            agencyVehicle.put(favorite, agencyVehicle.get(favorite) - 1);//update the count
            passengerVehicleMap.put(passenger, createVehicle(favorite));
        } else {// another random vehicle
            VehicleType randomVehicle = randomAvailableCar();
            if (randomVehicle == null) {
                System.out.println("All vehicles are used");
                return false;
            }
            agencyVehicle.put(randomVehicle, agencyVehicle.get(randomVehicle) - 1);//update the count
            passengerVehicleMap.put(passenger, createVehicle(randomVehicle));
        }
        return true;
    }

    private static VehicleType randomAvailableCar() {
        List<VehicleType> availableCarList = new ArrayList<>();
        for (VehicleType type : VehicleType.values()) {
            if (agencyVehicle.get(type) > 0) {
                availableCarList.add(type);
            }
        }
        if (availableCarList.size() == 0) {
            return null;
        }
        int random = Util.randomNumber(availableCarList.size() - 1);
        return availableCarList.get(random);
    }

}
