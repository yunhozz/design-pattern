package behavior.mediator;

import java.util.ArrayList;
import java.util.List;

// Mediator interface
interface ATCMediator {
    void registerRunway(Runway runway);
    void registerFlight(Flight flight);
    boolean isLandingOk();
    void setLandingStatus(boolean status);
}

// Concrete implementation of the Mediator interface
class ATCMediatorImpl implements ATCMediator {
    private final List<Flight> flights;
    private final List<Runway> runways;
    private boolean landing;

    public ATCMediatorImpl() {
        this.flights = new ArrayList<>();
        this.runways = new ArrayList<>();
        this.landing = false;
    }

    @Override
    public void registerRunway(Runway runway) {
        this.runways.add(runway);
    }

    @Override
    public void registerFlight(Flight flight) {
        this.flights.add(flight);
    }

    @Override
    public boolean isLandingOk() {
        return !landing;
    }

    @Override
    public void setLandingStatus(boolean status) {
        this.landing = status;
    }
}

// Runway class representing a runway at the airport
class Runway {
    private final String name;
    private final ATCMediator atcMediator;

    public Runway(String name, ATCMediator atcMediator) {
        this.name = name;
        this.atcMediator = atcMediator;
        this.atcMediator.registerRunway(this);
    }

    public void land() {
        if (atcMediator.isLandingOk()) {
            System.out.println("Landing permission granted. Landing on: " + name);
            atcMediator.setLandingStatus(true);
        } else {
            System.out.println("Landing permission denied. Runway is busy.");
        }
    }

    public void clearRunway() {
        System.out.println("Runway " + name + " is now clear.");
        atcMediator.setLandingStatus(false);
    }
}

// Flight class representing a flight
class Flight {
    private final String name;
    private final ATCMediator atcMediator;

    public Flight(String name, ATCMediator atcMediator) {
        this.name = name;
        this.atcMediator = atcMediator;
        this.atcMediator.registerFlight(this);
    }

    public void requestLanding() {
        System.out.println(name + " requesting landing permission.");
        atcMediator.isLandingOk();
    }

    public void land() {
        if (atcMediator.isLandingOk()) {
            System.out.println(name + " landing permission granted.");
            atcMediator.setLandingStatus(true);
        } else {
            System.out.println(name + " landing permission denied.");
        }
    }
}

class ATCDemo {
    public static void main(String[] args) {
        ATCMediator atcMediator = new ATCMediatorImpl();

        Flight flight1 = new Flight("Flight 101", atcMediator);
        Flight flight2 = new Flight("Flight 202", atcMediator);

        Runway runway1 = new Runway("Runway 1", atcMediator);

        flight1.requestLanding();
        // Flight 101 requesting landing permission.

        runway1.land();
        // Landing permission granted. Landing on: Runway 1

        flight1.land();
        // Flight 101 landing permission granted.

        runway1.clearRunway();
        // Runway Runway 1 is now clear.

        flight2.requestLanding();
        // Flight 202 requesting landing permission.

        flight2.land();
        // Flight 202 landing permission granted.
    }
}