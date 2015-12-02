package com.example.daypilot.sqlite;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import com.example.daypilot.sqlite.Reservations;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "RESERVATIONS".
*/
public class ReservationsDao extends AbstractDao<Reservations, Long> {

    public static final String TABLENAME = "RESERVATIONS";

    /**
     * Properties of entity Reservations.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Start = new Property(2, Long.class, "start", false, "START");
        public final static Property End = new Property(3, Long.class, "end", false, "END");
        public final static Property Room_id = new Property(4, Long.class, "room_id", false, "ROOM_ID");
        public final static Property RoomsId = new Property(5, Long.class, "roomsId", false, "ROOMS_ID");
    };

    private DaoSession daoSession;

    private Query<Reservations> rooms_ReservationsQuery;

    public ReservationsDao(DaoConfig config) {
        super(config);
    }
    
    public ReservationsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"RESERVATIONS\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"START\" INTEGER," + // 2: start
                "\"END\" INTEGER," + // 3: end
                "\"ROOM_ID\" INTEGER," + // 4: room_id
                "\"ROOMS_ID\" INTEGER);"); // 5: roomsId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"RESERVATIONS\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Reservations entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        Long start = entity.getStart();
        if (start != null) {
            stmt.bindLong(3, start);
        }
 
        Long end = entity.getEnd();
        if (end != null) {
            stmt.bindLong(4, end);
        }
 
        Long room_id = entity.getRoom_id();
        if (room_id != null) {
            stmt.bindLong(5, room_id);
        }
 
        Long roomsId = entity.getRoomsId();
        if (roomsId != null) {
            stmt.bindLong(6, roomsId);
        }
    }

    @Override
    protected void attachEntity(Reservations entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Reservations readEntity(Cursor cursor, int offset) {
        Reservations entity = new Reservations( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // start
            cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3), // end
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // room_id
            cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5) // roomsId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Reservations entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setStart(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setEnd(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
        entity.setRoom_id(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setRoomsId(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Reservations entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Reservations entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "reservations" to-many relationship of Rooms. */
    public List<Reservations> _queryRooms_Reservations(Long roomsId) {
        synchronized (this) {
            if (rooms_ReservationsQuery == null) {
                QueryBuilder<Reservations> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.RoomsId.eq(null));
                rooms_ReservationsQuery = queryBuilder.build();
            }
        }
        Query<Reservations> query = rooms_ReservationsQuery.forCurrentThread();
        query.setParameter(0, roomsId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getRoomsDao().getAllColumns());
            builder.append(" FROM RESERVATIONS T");
            builder.append(" LEFT JOIN ROOMS T0 ON T.\"ROOMS_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Reservations loadCurrentDeep(Cursor cursor, boolean lock) {
        Reservations entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Rooms rooms = loadCurrentOther(daoSession.getRoomsDao(), cursor, offset);
        entity.setRooms(rooms);

        return entity;    
    }

    public Reservations loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Reservations> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Reservations> list = new ArrayList<Reservations>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Reservations> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Reservations> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
