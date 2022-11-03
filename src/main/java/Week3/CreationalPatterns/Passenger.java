package Week3.CreationalPatterns;

import Week3.CreationalPatterns.Vehicles.Vehicle;
import Week3.CreationalPatterns.Vehicles.VehiclesFactory;

public class Passenger {
    String name;
    VehiclesFactory.VehicleType favoriteVehicle;


    public Passenger(String name, VehiclesFactory.VehicleType favoriteVehicle) {
        this.name = name;
        this.favoriteVehicle = favoriteVehicle;
    }

    public String getName() {
        return name;
    }

    public VehiclesFactory.VehicleType getFavoriteVehicle() {
        return favoriteVehicle;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", favoriteVehicle=" + favoriteVehicle +
                '}';
    }
}
