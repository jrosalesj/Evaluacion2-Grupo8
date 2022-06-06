package Fase2.Pruebas;

import Fase2.Produccion.BusinessFlight;
import Fase2.Produccion.EconomyFlight;
import Fase2.Produccion.Flight;
import Fase2.Produccion.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirportTest {

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
            Passenger jessica = new Passenger("Jessica", false);//inicializando el pasajero noVIP Jessica

            assertEquals("1", economyFlight.getId());//comparando la Id esperado con el Id del vuelo economico
            assertEquals(true, economyFlight.addPassenger(jessica));//comparando true con que se pueda añadir la pasajero noVIP Jessica al vuelo economico
            assertEquals(1, economyFlight.getPassengers().size());//comparando 1 con el tamaño de la lista de pasajeros del vuelo ecnomico(1->"Jessica")
            assertEquals("Jessica", economyFlight.getPassengers().get(0).getName());//comparando "jessica" con el nombre del pasajero[0] de la lista de pasajeros

            assertEquals(true, economyFlight.removePassenger(jessica));//comparando true con que se pueda remover el pasajero noVIP jessica del vuelo economico
            assertEquals(0, economyFlight.getPassengers().size());//comparando 0 con el tamaño de la lista de pasajeros del vuelo ecnomico(void->"  ")
        }

        @Test
        public void testEconomyFlightVipPassenger() {
            Passenger cesar = new Passenger("Cesar", true);//inicializando el pasajero VIP cesar

            assertEquals("1", economyFlight.getId());//comparando la Id esperado con el Id del vuelo economico
            assertEquals(true, economyFlight.addPassenger(cesar));//comparando true con que se pueda añadir la pasajero VIP Cesar al vuelo economico
            assertEquals(1, economyFlight.getPassengers().size());//comparando 1 con el tamaño de la lista de pasajeros del vuelo ecnomico(1->"Cesar")
            assertEquals("Cesar", economyFlight.getPassengers().get(0).getName());//comparando "Cesar" con el nombre del pasajero[0] de la lista de pasajeros

            assertEquals(false, economyFlight.removePassenger(cesar));//comparando false con que se pueda remover el pasajero VIP Cesar del vuelo economico
            assertEquals(1, economyFlight.getPassengers().size());//comparando 1 con el tamaño de la lista de pasajeros del vuelo ecnomico(1->"Cesar"))
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

            assertEquals(false, businessFlight.addPassenger(jessica));//comparando false con que se pueda añadir la pasajero noVIP Jessica al vuelo de Negocios
            assertEquals(0, businessFlight.getPassengers().size());//comparando 0 con el tamaño de la lista de pasajeros del vuelo de Negocios("")
            assertEquals(false, businessFlight.removePassenger(jessica));//comparando false con que se pueda remover el pasajero noVIP jessica del vuelo de Negocios(OJO: como se elimina a alguien que no ha sido agregado)
            assertEquals(0, businessFlight.getPassengers().size());//comparando 0 con el tamaño de la lista de pasajeros del vuelo de Negocios("")

        }

        @Test
        public void testBusinessFlightVipPassenger() {
            Passenger cesar = new Passenger("Cesar", true);//inicializando el pasajero VIP Cesar

            assertEquals(true, businessFlight.addPassenger(cesar));//comparando true con que se pueda añadir la pasajero VIP Cesar al vuelo de Negocios
            assertEquals(1, businessFlight.getPassengers().size());//comparando 1 con el tamaño de la lista de pasajeros del vuelo de Negocios("1.Cesar")
            assertEquals(false, businessFlight.removePassenger(cesar));//comparando false con que se pueda remover el pasajero VIP Cesar del vuelo de Negocios
            assertEquals(1, businessFlight.getPassengers().size());//comparando 1 con el tamaño de la lista de pasajeros del vuelo de Negocios("1.Cesar")

        }

    }

}
