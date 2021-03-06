package com.example.daypilot.sqlite;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.example.daypilot.sqlite.Rooms;
import com.example.daypilot.sqlite.Reservations;

import com.example.daypilot.sqlite.RoomsDao;
import com.example.daypilot.sqlite.ReservationsDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig roomsDaoConfig;
    private final DaoConfig reservationsDaoConfig;

    private final RoomsDao roomsDao;
    private final ReservationsDao reservationsDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        roomsDaoConfig = daoConfigMap.get(RoomsDao.class).clone();
        roomsDaoConfig.initIdentityScope(type);

        reservationsDaoConfig = daoConfigMap.get(ReservationsDao.class).clone();
        reservationsDaoConfig.initIdentityScope(type);

        roomsDao = new RoomsDao(roomsDaoConfig, this);
        reservationsDao = new ReservationsDao(reservationsDaoConfig, this);

        registerDao(Rooms.class, roomsDao);
        registerDao(Reservations.class, reservationsDao);
    }
    
    public void clear() {
        roomsDaoConfig.getIdentityScope().clear();
        reservationsDaoConfig.getIdentityScope().clear();
    }

    public RoomsDao getRoomsDao() {
        return roomsDao;
    }

    public ReservationsDao getReservationsDao() {
        return reservationsDao;
    }

}
