package com.example.concerttickets;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public class Concerts {
        private int image;
        private String artistName;
        private String location;
        private String date;
        private String time;

        public Concerts(int image, String artistName, String location, String date, String time) {
            this.image = image;
            this.artistName = artistName;
            this.location = location;
            this.date = date;
            this.time = time;
        }

        public int getImage(){ return image; }

        public void setImage(int image){ this.image = image; }

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

        concertList.add(new Concerts(R.drawable.beyonce, "Beyonce", "Barcelona", "15 AUG", "19:00"));
        concertList.add(new Concerts(R.drawable.coldplay, "Coldplay", "London", "17 AUG", "19:30"));
        concertList.add(new Concerts(R.drawable.bruno, "Bruno Mars", "Berlin", "20 AUG", "20:00"));
        concertList.add(new Concerts(R.drawable.edsheeran, "Ed Sheeran", "Paris", "21 AUG", "18:00"));
        concertList.add(new Concerts(R.drawable.shawn, "Shawn Mendes", "Vienna", "24 AUG", "19:00"));
        concertList.add(new Concerts(R.drawable.bts, "BTS", "London", "1 JUN", "19:30"));
        concertList.add(new Concerts(R.drawable.billieelish, "Billie Eilish", "Copenhagen", "15 SEP", "20:30"));
        concertList.add(new Concerts(R.drawable.littlemix, "Little Mix", "Glasgow", "1 SEP", "19:00"));


        /*
        Concerts c = new Concerts();
        c.setImage(R.drawable.beyonce);
        c.setArtistName("Beyonce");
        c.setLocation("Barcelona");
        c.setDate("15 AUG");
        c.setTime("19:00");

        Concerts c1 = new Concerts();
        c1.setImage(R.drawable.coldplay);
        c1.setArtistName("Coldplay");
        c1.setLocation("London");
        c1.setDate("17 AUG");
        c1.setTime("19:30");

        Concerts c2 = new Concerts();
        c2.setImage(R.drawable.bruno);
        c2.setArtistName("Bruno Mars");
        c2.setLocation("Berlin");
        c2.setDate("20 AUG");
        c2.setTime("20:00");

        Concerts c3 = new Concerts();
        c3.setImage(R.drawable.edsheeran);
        c3.setArtistName("Ed Sheeran");
        c3.setLocation("Paris");
        c3.setDate("21 AUG");
        c3.setTime("18:00");

        Concerts c4 = new Concerts();
        c4.setImage(R.drawable.shawn);
        c4.setArtistName("Shawn Mendes");
        c4.setLocation("Vienna");
        c4.setDate("24 AUG");
        c4.setTime("19:00");


        concertList.add(c);
        concertList.add(c1);
        concertList.add(c2);
        concertList.add(c3);
        concertList.add(c4); */


        return concertList;
    }
}
