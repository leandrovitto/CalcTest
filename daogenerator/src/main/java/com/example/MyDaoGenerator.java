package com.example;
import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

public class MyDaoGenerator {
    public static void main(String args[]) throws Exception {
        Schema schema = new Schema(1, "com.example.daypilot.sqlite");

        Entity rooms = schema.addEntity("Rooms");
        rooms.addIdProperty();
        rooms.addStringProperty("name");
        rooms.addStringProperty("capacity");
        rooms.addStringProperty("status");
        rooms.addStringProperty("note");

        Entity reservations = schema.addEntity("Reservations");
        reservations.addIdProperty();
        reservations.addStringProperty("name");
        reservations.addLongProperty("start");
        reservations.addLongProperty("end");
        reservations.addLongProperty("room_id");


        Property roomsId = reservations.addLongProperty("roomsId").getProperty();
        reservations.addToOne(rooms, roomsId);

       ToMany roomToReservation = rooms.addToMany(reservations, roomsId);
        roomToReservation.setName("reservations");

        new DaoGenerator().generateAll(schema, "../app/src/main/java");
    }
}
