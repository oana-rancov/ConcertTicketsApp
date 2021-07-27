package com.example.concerttickets;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    class Concerts {
        private String artistName;
        private String location;
        private String date;
        private String time;

        public String getArtistName() {
            return artistName;
        }

        public void setArtistName(String artistName) {
            this.artistName = artistName;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    public List<Concerts> getConcerts(){
        List<Concerts> concertList = new ArrayList<>();

        Concerts c = new Concerts();
        c.setArtistName("Beyonce");
        c.setLocation("Barcelona");
        c.setDate("15 AUG");
        c.setTime("19:00");

        Concerts c2 = new Concerts();
        c2.setArtistName("BTS");
        c2.setLocation("London");
        c2.setDate("17 AUG");
        c2.setTime("19:30");

        Concerts c3 = new Concerts();
        c3.setArtistName("Bruno Mars");
        c3.setLocation("Berlin");
        c3.setDate("20 AUG");
        c3.setTime("20:00");

        Concerts c4 = new Concerts();
        c4.setArtistName("Ed Sheeran");
        c4.setLocation("Paris");
        c4.setDate("21 AUG");
        c4.setTime("18:00");


        concertList.add(c);
        concertList.add(c2);
        concertList.add(c3);
        concertList.add(c4);


        return concertList;
    }
}
