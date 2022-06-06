package Fase4.Pruebas;

import Fase4.Produccion.BusinessFlight;
import Fase4.Produccion.EconomyFlight;
import Fase4.Produccion.Flight;
import Fase4.Produccion.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirportTest {

    // Refactorización de la clase AirportTest. Pregunta 3
    @DisplayName("Dado que hay un vuelo economico")
    @Nested
    class EconomyFlightTest {
        private Flight economyFlight;//

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");//inicializando un vuelo economico
        }

        @Test
        public void testEconomyFlightRegularPassenger() {
            Passenger jessica = new Passenger("Jessica", false);

            assertAll(() -> assertEquals("1", economyFlight.getId()),
                    ()->assertEquals(true, economyFlight.addPassenger(jessica)),
                    ()->assertEquals(1, economyFlight.getPassengersList().size()),
                    ()->assertEquals("Jessica", economyFlight.getPassengersList().get(0).getName()),
                    ()->assertEquals(true, economyFlight.removePassenger(jessica)),
                    ()->assertEquals(0, economyFlight.getPassengersList().size()));


        }
        @Test
        public void testEconomyFlightVipPassenger() {
            Passenger cesar = new Passenger("Cesar", true);//inicializando el pasajero VIP cesar

            assertAll(() -> assertEquals("1", economyFlight.getId()),
                    ()->assertEquals(true, economyFlight.addPassenger(cesar)),
                    ()->assertEquals(1, economyFlight.getPassengersList().size()),
                    ()->assertEquals("Cesar", economyFlight.getPassengersList().get(0).getName()),
                    ()->assertEquals(false, economyFlight.removePassenger(cesar)),
                    ()->assertEquals(1, economyFlight.getPassengersList().size()));

        }
    }


    @DisplayName("Dado que hay un vuelo negocios")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("2");//inicializando un vuelo de Negocios
        }

        @Test
        public void testBusinessFlightRegularPassenger() {
            Passenger jessica = new Passenger("Jessica", false);//inicializando el pasajero noVIP Jessica

            assertAll(() -> assertEquals(false, businessFlight.addPassenger(jessica)),
                    ()->assertEquals(0, businessFlight.getPassengersList().size()),
                    ()->assertEquals(false, businessFlight.removePassenger(jessica)),
                    ()->assertEquals(0, businessFlight.getPassengersList().size()));


        }

        @Test
        public void testBusinessFlightVipPassenger() {
            Passenger cesar = new Passenger("Cesar", true);//inicializando el pasajero VIP Cesar

            assertAll(() -> assertEquals(true, businessFlight.addPassenger(cesar)),
                    ()->assertEquals(1, businessFlight.getPassengersList().size()),
                    ()->assertEquals(false, businessFlight.removePassenger(cesar)),
                    ()->assertEquals(1, businessFlight.getPassengersList().size()));


        }

    }

}