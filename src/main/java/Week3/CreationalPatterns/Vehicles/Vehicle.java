package Week3.CreationalPatterns.Vehicles;

import Week3.CreationalPatterns.Passenger;

public abstract class Vehicle {

    public static void transport(Passenger passenger) {
        if (VehiclesFactory.getAvailableCar(passenger)) {
            System.out.println("successful transport, passenger name: " + passenger.getName());
        }
    }

}

