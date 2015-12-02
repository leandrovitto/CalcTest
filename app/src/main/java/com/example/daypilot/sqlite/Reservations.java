package com.example.daypilot.sqlite;

import com.example.daypilot.sqlite.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "RESERVATIONS".
 */
public class Reservations {

    private Long id;
    private String name;
    private Long start;
    private Long end;
    private Long room_id;
    private Long roomsId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient ReservationsDao myDao;

    private Rooms rooms;
    private Long rooms__resolvedKey;


    public Reservations() {
    }

    public Reservations(Long id) {
        this.id = id;
    }

    public Reservations(Long id, String name, Long start, Long end, Long room_id, Long roomsId) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.room_id = room_id;
        this.roomsId = roomsId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getReservationsDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public Long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }

    public Long getRoomsId() {
        return roomsId;
    }

    public void setRoomsId(Long roomsId) {
        this.roomsId = roomsId;
    }

    /** To-one relationship, resolved on first access. */
    public Rooms getRooms() {
        Long __key = this.roomsId;
        if (rooms__resolvedKey == null || !rooms__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            RoomsDao targetDao = daoSession.getRoomsDao();
            Rooms roomsNew = targetDao.load(__key);
            synchronized (this) {
                rooms = roomsNew;
            	rooms__resolvedKey = __key;
            }
        }
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        synchronized (this) {
            this.rooms = rooms;
            roomsId = rooms == null ? null : rooms.getId();
            rooms__resolvedKey = roomsId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
