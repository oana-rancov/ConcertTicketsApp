package com.example.concerttickets;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public class Concerts {
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

        Concerts c1 = new Concerts();
        c1.setArtistName("Coldplay");
        c1.setLocation("London");
        c1.setDate("17 AUG");
        c1.setTime("19:30");

        Concerts c2 = new Concerts();
        c2.setArtistName("Bruno Mars");
        c2.setLocation("Berlin");
        c2.setDate("20 AUG");
        c2.setTime("20:00");

        Concerts c3 = new Concerts();
        c3.setArtistName("Ed Sheeran");
        c3.setLocation("Paris");
        c3.setDate("21 AUG");
        c3.setTime("18:00");

        Concerts c4 = new Concerts();
        c4.setArtistName("Shawn Mendes");
        c4.setLocation("Vienna");
        c4.setDate("24 AUG");
        c4.setTime("19:00");


        concertList.add(c);
        concertList.add(c1);
        concertList.add(c2);
        concertList.add(c3);
        concertList.add(c4);


        return concertList;
    }
}
