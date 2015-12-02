package com.example.daypilot.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.example.daypilot.sqlite.Rooms;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ROOMS".
*/
public class RoomsDao extends AbstractDao<Rooms, Long> {

    public static final String TABLENAME = "ROOMS";

    /**
     * Properties of entity Rooms.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Capacity = new Property(2, String.class, "capacity", false, "CAPACITY");
        public final static Property Status = new Property(3, String.class, "status", false, "STATUS");
        public final static Property Note = new Property(4, String.class, "note", false, "NOTE");
    };

    private DaoSession daoSession;


    public RoomsDao(DaoConfig config) {
        super(config);
    }
    
    public RoomsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ROOMS\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"CAPACITY\" TEXT," + // 2: capacity
                "\"STATUS\" TEXT," + // 3: status
                "\"NOTE\" TEXT);"); // 4: note
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ROOMS\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Rooms entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String capacity = entity.getCapacity();
        if (capacity != null) {
            stmt.bindString(3, capacity);
        }
 
        String status = entity.getStatus();
        if (status != null) {
            stmt.bindString(4, status);
        }
 
        String note = entity.getNote();
        if (note != null) {
            stmt.bindString(5, note);
        }
    }

    @Override
    protected void attachEntity(Rooms entity) {
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
    public Rooms readEntity(Cursor cursor, int offset) {
        Rooms entity = new Rooms( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // capacity
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // status
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // note
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Rooms entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setCapacity(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setStatus(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setNote(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Rooms entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Rooms entity) {
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
    
}