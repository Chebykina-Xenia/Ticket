package ticket;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String airportDeparture;  //аэропорт вылет
    private String airportArrival;    //аэропорт прилёт
    private int time;

    @Override
    public int compareTo(Ticket o) {
        return price - o.price;
    }

    public Ticket() {
    }

    public Ticket(int id, int price, String airportDeparture, String airportArrival, int time) {
        this.id = id;
        this.price = price;
        this.airportDeparture = airportDeparture;
        this.airportArrival = airportArrival;
        this.time = time;
    }

    public boolean matches(String from, String to) {
        return airportDeparture.contains(from) && airportArrival.contains(to);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAirportDeparture() {
        return airportDeparture;
    }

    public void setAirportDeparture(String airportDeparture) {
        this.airportDeparture = airportDeparture;
    }

    public String getAirportArrival() {
        return airportArrival;
    }

    public void setAirportArrival(String airportArrival) {
        this.airportArrival = airportArrival;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
