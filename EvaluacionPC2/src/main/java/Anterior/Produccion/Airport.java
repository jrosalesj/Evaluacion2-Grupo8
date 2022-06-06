package Anterior.Produccion;

public class Airport {

    public static void main(String[] args) {
        Flight economyFlight = new Flight("1", "Economico");
        Flight businessFlight = new Flight("2", "Negocios");

        Passenger cesar = new Passenger("Cesar", true);
        Passenger jessica = new Passenger("Jessica", false);
        Passenger juanito = new Passenger("Juanito", false);//

        businessFlight.addPassenger(cesar);//agregando el pasajero cesar
        businessFlight.removePassenger(cesar);//denegacion,no se puede remover un pasajero Vip
        businessFlight.addPassenger(jessica);//denegacion,no se puede agregar un pasajero noVip al vuelo de Negocios
        economyFlight.addPassenger(jessica);//agregando la pasajera jessica

        economyFlight.addPassenger(juanito);
        economyFlight.removePassenger(juanito);
        // businessFlight.removePassenger(juanito);

        System.out.println("Lista de pasajeros de vuelos de negocios:");
        for (Passenger passenger : businessFlight.getPassengersList()) {
            System.out.println(passenger.getName());
        }

        System.out.println("Lista de pasajeros de vuelos economicos:");
        for (Passenger passenger : economyFlight.getPassengersList()) {
            System.out.println(passenger.getName());
        }
    }
}
