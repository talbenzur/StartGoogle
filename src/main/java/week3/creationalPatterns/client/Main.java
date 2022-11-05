package week3.creationalPatterns.client;

import week3.creationalPatterns.Passenger;
import week3.creationalPatterns.Util;
import week3.creationalPatterns.vehicles.Vehicle;
import week3.creationalPatterns.vehicles.VehiclesFactory;

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
