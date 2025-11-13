package com.example.gettingstartedapp.dataAccess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.gettingstartedapp.DatabaseHelper;
import com.example.gettingstartedapp.model.Order;

import java.util.ArrayList;

public class PesananDao {
    public static final String TABLE_ORDER = "orders";
    static final String ORDER_ID = "id";
    static final String ORDER_NAME = "name";
    static final String ORDER_QUANTITY = "quantity";

    public static final String CREATE_TABLE_ORDER = "CREATE TABLE orders (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, quantity TEXT)";

    DatabaseHelper dbHelper;

    public PesananDao(DatabaseHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public long createOrder(Order order) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(ORDER_NAME, order.name);
        cv.put(ORDER_QUANTITY, order.quantity);

        long result = db.insert(TABLE_ORDER, null, cv);

        db.close();
        return result;
    }

    public Order getOrderById(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ORDER, new String[]{ORDER_ID, ORDER_NAME, ORDER_QUANTITY}, ORDER_ID + "=?", new String[]{ORDER_ID}, null, null, null);

        if (!cursor.moveToFirst()) {
            return null;
        }

        Order order = new Order(cursor.getString(1), cursor.getString(2));
        return order;
    }

    public ArrayList<Order> getAllOrder() {
        ArrayList<Order> orders = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ORDER, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                Order order = new Order(cursor.getString(cursor.getColumnIndexOrThrow(ORDER_NAME)), cursor.getString(cursor.getColumnIndexOrThrow(ORDER_QUANTITY)));
                orders.add(order);
            } while (cursor.moveToNext());
        }

        return orders;
    }
}
