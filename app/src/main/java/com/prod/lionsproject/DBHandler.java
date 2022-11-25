package com.prod.lionsproject;

import android.database.Cursor;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.prod.lionsproject.modals.ConnectionsModal;
import com.prod.lionsproject.modals.ContactsModal;
import com.prod.lionsproject.modals.ImpairmentsModal;
import com.prod.lionsproject.modals.ProjectsModal;
import com.prod.lionsproject.modals.VisitsModal;

import java.util.List;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "activeDB";

    private static final int DB_VERSION = 1;

    private static final String TABLE1 = "Projects";
    private static final String TABLE2 = "Contacts";
    private static final String TABLE3 = "Visits";
    private static final String TABLE4 = "Impairments";
    private static final String TABLE5 = "Connections";

    //generals
    private static final String ID_COL_PROJ = "id_project";
    private static final String ID_COL_CONT = "id_contact";
    private static final String ID_COL_VISI = "id_visit";
    private static final String ID_COL_IMPA = "id_impairment";
    private static final String ID_COL_CONNECT = "id_connection";


    private static final String DATE_COL = "date";
    private static final String DAY_COL = "day";
    private static final String MONTH_COL = "month";
    private static final String YEAR_COL = "year";

    private static final String START_TIME_FULL = "start_time";
    private static final String END_TIME_FULL = "end_time";
    private static final String TOTAL_TIME_FULL = "total_time";

    private static final String START_TIME_HOUR_COL = "start_time_hour";
    private static final String START_TIME_MINUTE_COL = "start_time_minute";
    private static final String END_TIME_HOUR_COL = "ending_time_hour";
    private static final String END_TIME_MINUTE_COL = "ending_time_minute";

    private static final String TOTAL_TIME_HOUR_COL = "total_time_hour";
    private static final String TOTAL_TIME_MINUTE_COL = "total_time_minute";
    private static final String TOTAL_TIME_COMBINED = "total_time_combined";

    private static final String NAME_COL = "name";
    private static final String DESCRIPTION_COL = "description";


    //PROJECTS
    private static final String NAME_MACHON_COL = "name_machon";
    private static final String NUM_CONTRACT_COL = "num_contract";
    private static final String COSTUMER_NAME_COL = "name_costumer";
    private static final String COSTUMER_PHONE_COL = "costumer_phone";
    private static final String COSTUMER_EMAIL_COL = "costumer_email";

    //CONTACTS
    private static final String PROFESSION_COL = "profession";
    private static final String CONTACT_PHONE_COL = "phone_number";
    private static final String CONTACT_EMAIL_COL = "EMAIL";

    //IMPAIRMENTS
    private static final String IMPAIRMENT_COL = "impairment";
    private static final String CONTACT_1_ID_COL = "contact1_id";
    private static final String CONTACT_2_ID_COL = "contact2_id";
    private static final String SENT_COL = "sent";
    private static final String DONE_COL = "done";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String table1 = "CREATE TABLE " + TABLE1 + " ("
                + ID_COL_PROJ + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + DATE_COL + " TEXT,"
                + DAY_COL + " INTEGER,"
                + MONTH_COL + " INTEGER,"
                + YEAR_COL + " INTEGER,"
                + NAME_MACHON_COL + " TEXT,"
                + NUM_CONTRACT_COL + " TEXT,"
                + COSTUMER_NAME_COL + " TEXT,"
                + COSTUMER_PHONE_COL +" TAXT,"
                + CONTACT_EMAIL_COL + "TEXT)";

        String table2 = "CREATE TABLE " + TABLE2 + " ("
                + ID_COL_CONT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + "TEXT,"
                + PROFESSION_COL + " TEXT,"
                + CONTACT_PHONE_COL + " TEXT,"
                + CONTACT_EMAIL_COL + " TEXT)";

        String table3 = "CREATE TABLE " + TABLE3 + " ("
                + ID_COL_VISI + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ID_COL_PROJ + "INTEGER,"
                + DATE_COL + " TEXT,"
                + DAY_COL + " INTEGER,"
                + MONTH_COL + " INTEGER,"
                + YEAR_COL + " INTEGER,"
                + START_TIME_FULL + " TEXT,"
                + END_TIME_FULL + " TEXT,"
                + START_TIME_HOUR_COL + " INTEGER,"
                + START_TIME_MINUTE_COL + " INTEGER,"
                + END_TIME_HOUR_COL + " INTEGER,"
                + END_TIME_MINUTE_COL + " INTEGER,"
                + DESCRIPTION_COL + " TEXT,"
                + TOTAL_TIME_FULL + " TEXT,"
                + TOTAL_TIME_HOUR_COL + " INTEGER,"
                + TOTAL_TIME_MINUTE_COL + " INTEGER,"
                + TOTAL_TIME_COMBINED + " DOUBLE)";

        String table4 = "CREATE TABLE " + TABLE4 + " ("
                + ID_COL_IMPA + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ID_COL_PROJ + " INTEGER,"
                + ID_COL_VISI + " INTEGER,"
                + DATE_COL + " TEXT,"
                + DAY_COL + " INTEGER,"
                + MONTH_COL + " INTEGER,"
                + YEAR_COL + " INTEGER,"
                + DESCRIPTION_COL + " TEXT,"
                + IMPAIRMENT_COL + " TEXT,"
                + CONTACT_1_ID_COL + " INTEGER,"
                + CONTACT_2_ID_COL + " INTEGER,"
                + SENT_COL + " BOOLEAN,"
                + DONE_COL + " BOOLEAN)";

        String table5 = "CREATE TABLE " + TABLE5 + " ("
                + ID_COL_CONNECT + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ID_COL_PROJ + " INTEGER,"
                + ID_COL_CONT + " INTEGER)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(table1);
        db.execSQL(table2);
        db.execSQL(table3);
        db.execSQL(table4);
        db.execSQL(table5);

    }

    // this method is use to add new course to our sqlite database.
    public void addNewProject(String name, String date, String costumer, String name_machon, String num_contract, String costumer_phone, String costumer_mail) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.

        values.put(NAME_COL, name);
        values.put(DATE_COL, String.valueOf(date));
        values.put(NAME_MACHON_COL, name_machon);
        values.put(NUM_CONTRACT_COL, num_contract);
        values.put(COSTUMER_NAME_COL, costumer);
        values.put(COSTUMER_PHONE_COL, String.valueOf(costumer_phone));
        values.put(COSTUMER_EMAIL_COL, String.valueOf(costumer_mail));


        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE1, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public void addNewContact(String name, String profession, String contact_phone , String contact_mail) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.

        values.put(NAME_COL, name);
        values.put(PROFESSION_COL, profession);
        values.put(CONTACT_PHONE_COL, String.valueOf(contact_phone));
        values.put(CONTACT_EMAIL_COL, String.valueOf(contact_mail));


        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE2, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public void addNewVisit(int project_id, Date date, int day, int month, int year,
                            Time start_t, Time end_t, int start_time_H, int start_time_M, int end_time_H, int end_time_M,
                            String description, Time total_t, int total_time_H, int total_time_M, Double total_time_combined) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.

        values.put(ID_COL_PROJ, project_id);
        values.put(DATE_COL, String.valueOf(date));
        values.put(DAY_COL, day);
        values.put(MONTH_COL, month);
        values.put(YEAR_COL, year);
        values.put(START_TIME_FULL, String.valueOf(start_t));
        values.put(END_TIME_FULL, String.valueOf(end_t));
        values.put(START_TIME_HOUR_COL, start_time_H);
        values.put(START_TIME_MINUTE_COL, start_time_M);
        values.put(END_TIME_HOUR_COL, end_time_H);
        values.put(END_TIME_MINUTE_COL, end_time_M);
        values.put(DESCRIPTION_COL, description);
        values.put(TOTAL_TIME_FULL, String.valueOf(total_t));
        values.put(TOTAL_TIME_HOUR_COL, total_time_H);
        values.put(TOTAL_TIME_MINUTE_COL, total_time_M);
        values.put(TOTAL_TIME_COMBINED, total_time_combined);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE3, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public void addNewImpairment(int project_id, int visit_id, Date date, int day, int month, int year,
                                 String description, String impairment,
                                 int contact_id_1, int contact_id_2, boolean sent, boolean done) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(ID_COL_PROJ, project_id);
        values.put(ID_COL_VISI, visit_id);
        values.put(DATE_COL, String.valueOf(date));
        values.put(DAY_COL, day);
        values.put(MONTH_COL, month);
        values.put(YEAR_COL, year);
        values.put(DESCRIPTION_COL, description);
        values.put(IMPAIRMENT_COL, impairment);
        values.put(CONTACT_1_ID_COL, contact_id_1);
        values.put(CONTACT_2_ID_COL, contact_id_2);
        values.put(SENT_COL, sent);
        values.put(DONE_COL, done);


        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE4, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public void addNewConnection(int projectID, int contactID) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(ID_COL_PROJ, projectID);
        values.put(ID_COL_CONT, contactID);

        db.insert(TABLE5, null, values);

        db.close();
    }

    public ArrayList<ProjectsModal> readProjects() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor projectCursor = db.rawQuery("SELECT * FROM " + TABLE1, null);

        ArrayList<ProjectsModal> ProjectModalArrayList = new ArrayList<>();

        if (projectCursor.moveToFirst()) {
            do {
                ProjectModalArrayList.add(new ProjectsModal(
                        projectCursor.getInt(0),
                        projectCursor.getString(1),
                        projectCursor.getString(2),
                        projectCursor.getInt(3),
                        projectCursor.getInt(4),
                        projectCursor.getInt(5),
                        projectCursor.getString(6),
                        projectCursor.getString(7),
                        projectCursor.getString(8),
                        projectCursor.getString(9),
                        projectCursor.getString(10)
                ));
            } while (projectCursor.moveToLast());

        }

        projectCursor.close();
        return ProjectModalArrayList;
    }

    public ArrayList<ContactsModal> readContacts() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor contactCursor = db.rawQuery("SELECT * FROM " + TABLE1, null);

        ArrayList<ContactsModal> ContactsModalArrayList = new ArrayList<>();

        if (contactCursor.moveToFirst()) {
            do {
                ContactsModalArrayList.add(new ContactsModal(
                        contactCursor.getInt(0),
                        contactCursor.getString(1),
                        contactCursor.getString(2),
                        contactCursor.getString(3),
                        contactCursor.getString(4)
                ));
            } while (contactCursor.moveToLast());

        }

        contactCursor.close();
        return ContactsModalArrayList;
    }

    public ArrayList<VisitsModal> readVisits() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor visitsCursor = db.rawQuery("SELECT * FROM " + TABLE1, null);

        ArrayList<VisitsModal> VisitsModalArrayList = new ArrayList<>();

        if (visitsCursor.moveToFirst()) {
            do {
                VisitsModalArrayList.add(new VisitsModal(
                        visitsCursor.getInt(0),
                        visitsCursor.getInt(1),
                        visitsCursor.getString(2),
                        visitsCursor.getInt(3),
                        visitsCursor.getInt(4),
                        visitsCursor.getInt(5),
                        visitsCursor.getString(6),
                        visitsCursor.getString(7),
                        visitsCursor.getInt(8),
                        visitsCursor.getInt(9),
                        visitsCursor.getInt(10),
                        visitsCursor.getInt(11),
                        visitsCursor.getString(12),
                        visitsCursor.getString(13),
                        visitsCursor.getInt(14),
                        visitsCursor.getInt(15),
                        visitsCursor.getDouble(16)

                ));
            } while (visitsCursor.moveToLast());

        }

        visitsCursor.close();
        return VisitsModalArrayList;
    }

    public ArrayList<ImpairmentsModal> readImpairments() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor impairmentsCursor = db.rawQuery("SELECT * FROM " + TABLE1, null);

        ArrayList<ImpairmentsModal> ImpairmentsModalArrayList = new ArrayList<>();

        if (impairmentsCursor.moveToFirst()) {
            do {
                ImpairmentsModalArrayList.add(new ImpairmentsModal(
                        impairmentsCursor.getInt(0),
                        impairmentsCursor.getInt(1),
                        impairmentsCursor.getInt(2),
                        impairmentsCursor.getString(3),
                        impairmentsCursor.getInt(4),
                        impairmentsCursor.getInt(5),
                        impairmentsCursor.getInt(6),
                        impairmentsCursor.getString(7),
                        impairmentsCursor.getString(8),
                        impairmentsCursor.getInt(9),
                        impairmentsCursor.getInt(10),
                        impairmentsCursor.getExtras().getBoolean(String.valueOf(11)),
                        impairmentsCursor.getExtras().getBoolean(String.valueOf(12))
                ));
            } while (impairmentsCursor.moveToLast());

        }

        impairmentsCursor.close();
        return ImpairmentsModalArrayList;
    }

    public ArrayList<ConnectionsModal> readConnections() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor connectionCursor = db.rawQuery("SELECT * FROM " + TABLE5, null);

        ArrayList<ConnectionsModal> ConnectionModalArrayList = new ArrayList<>();

        if (connectionCursor.moveToFirst()) {
            do {
                ConnectionModalArrayList.add(new ConnectionsModal(
                        connectionCursor.getInt(0),
                        connectionCursor.getInt(1)
                ));
            } while (connectionCursor.moveToLast());

        }

        connectionCursor.close();
        return ConnectionModalArrayList;
    }

    public ArrayList<ProjectsModal> readProjects_to_spinner() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor projectCursor = db.rawQuery("SELECT * FROM " + TABLE1, null);

        ArrayList<ProjectsModal> ProjectModalArrayList = new ArrayList<>();

        if (projectCursor.moveToFirst()) {
            do {
                ProjectModalArrayList.add(new ProjectsModal(
                        projectCursor.getInt(0),
                        projectCursor.getString(1)
                ));
            } while (projectCursor.moveToLast());

        }

        projectCursor.close();
        return ProjectModalArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE3);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE4);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE5);
        onCreate(db);
    }
}