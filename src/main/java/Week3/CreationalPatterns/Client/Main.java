package Week3.CreationalPatterns.Client;

import Week3.CreationalPatterns.Passenger;
import Week3.CreationalPatterns.Util;
import Week3.CreationalPatterns.Vehicles.Vehicle;
import Week3.CreationalPatterns.Vehicles.VehiclesFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        VehiclesFactory agency = VehiclesFactory.getInstance();
        List<Passenger> passengerList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Passenger passenger = new Passenger(Util.randomName(), Util.randomVehicleType());
            passengerList.add(passenger);
        }

        for (Passenger passenger : passengerList) {
            Vehicle.transport(passenger);
        }
       
    }
}
