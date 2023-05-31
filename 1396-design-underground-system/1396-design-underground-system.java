public class UndergroundSystem {

    private static record CheckIn(String checkInStation, int checkInTime) {}
    private static record Journey(String checkInStation, String checkOutStationName) {}
    private final Map<Integer, CheckIn> checkInData;
    private final Map<Journey, int[]> journeyData;

    public UndergroundSystem() {
        checkInData = new HashMap<>();
        journeyData = new HashMap<>();
    }

    public void checkIn(int ID, String checkInStation, int checkInTime) {
        checkInData.put(ID, new CheckIn(checkInStation, checkInTime));
    }

    public void checkOut(int ID, String checkOutStation, int checkOutTime) {
        CheckIn checkIn = checkInData.remove(ID);
        Journey journey = new Journey(checkIn.checkInStation, checkOutStation);

        journeyData.putIfAbsent(journey, new int[]{0, 0});
        journeyData.get(journey)[0] += checkOutTime - checkIn.checkInTime;
        journeyData.get(journey)[1]++;
    }

    public double getAverageTime(String startStation, String endStation) {
        Journey journey = new Journey(startStation, endStation);
        return (double) journeyData.get(journey)[0] / journeyData.get(journey)[1];
    }
}
/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */