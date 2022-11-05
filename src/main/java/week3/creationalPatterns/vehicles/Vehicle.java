package week3.creationalPatterns.vehicles;

import week3.creationalPatterns.Passenger;

public abstract class Vehicle {

    public static void transport(Passenger passenger) {
        if (VehiclesFactory.getAvailableCar(passenger)) {
            System.out.println("successful transport, passenger name: " + passenger.getName());
        }
    }

}

