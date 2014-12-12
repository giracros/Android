package com.cur.estudiantes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;

/**
 * Nombre del paquete com.cur.estudiantes
 * Creado por danielfuentes en la fecha 12/11/14.
 * Todos los derechos reservados
 * Email: giracros@gmail.com
 * Mobile: 3013366588
 * Nombre del proyecto Estudiantes.
 */
public class EstudiantesControl extends SQLiteOpenHelper {

    private static final int VERSION_DB = 1;
    private static final String NOMBRE_DB = "EstudianteDB";

    public EstudiantesControl(Context context) {
        super(context, NOMBRE_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql ="CREATE TABLE estudiante ( " +"id INTEGER PRIMARY KEY AUTOINCREMENT, " +"carnet INTEGER, nombre TEXT, " +"apellido TEXT, nota1 REAL, " +"nota2 REAL, nota3 REAL )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        String sql = "DROP TABLE IF EXIST estudiante";
        db.execSQL(sql);
        this.onCreate(db);
    }

    public void agregarEstudiante(Estudiante estudiante) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("carnet", estudiante.getCarnet());
        values.put("nombre", estudiante.getNombre());
        values.put("apellido", estudiante.getApellido());
        values.put("nota1", estudiante.getNota1());
        values.put("nota2", estudiante.getNota2());
        values.put("nota3", estudiante.getNota3());

        db.insert("estudiante", null, values);
        Log.d("agregarEstudiante", estudiante.toString());
        db.close();
    }
    public ArrayList<Estudiante> listarEstudiantes() {

        ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
        String sql = "SELECT * FROM estudiante";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        Estudiante estudiante = null;

        if (cursor.moveToFirst()) {
            do {
                estudiante = new Estudiante();
                estudiante.setId(Integer.parseInt(cursor.getString(0)));
                estudiante.setCarnet(cursor.getInt(1));
                estudiante.setNombre(cursor.getString(2));
                estudiante.setApellido(cursor.getString(3));
                estudiante.setNota1(cursor.getDouble(4));
                estudiante.setNota2(cursor.getDouble(5));
                estudiante.setNota3(cursor.getDouble(6));
                estudiantes.add(estudiante);
            } while(cursor.moveToNext());
        }
        return estudiantes;
    }
    public Estudiante consultarEstudiante(int carnet) {
        String columns[] = {"id", "carnet", "nombre", "apellido",
                "nota1", "nota2", "nota3"};
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("estudiante", columns, "carnet = ?",
                new String[] {String.valueOf(carnet)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            Estudiante estudiante = new Estudiante();
            estudiante.setId(Integer.parseInt(cursor.getString(0)));
            estudiante.setCarnet(cursor.getInt(1));
            estudiante.setNombre(cursor.getString(2));
            estudiante.setApellido(cursor.getString(3));
            estudiante.setNota1(cursor.getDouble(4));
            estudiante.setNota2(cursor.getDouble(5));
            estudiante.setNota3(cursor.getDouble(6));
            return estudiante;
        }
        else return null;
    }


    public int elminarEstudiante(int carnet) {
        SQLiteDatabase db = this.getWritableDatabase();

        int e = db.delete("estudiante", "carnet = ?", new String[] {String.valueOf(carnet)});
        db.close();
        return e;
    }

    public int actualizarEstudiante(Estudiante estudiante) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("carnet", estudiante.getCarnet());
        values.put("nombre", estudiante.getNombre());
        values.put("apellido", estudiante.getApellido());
        values.put("nota1", estudiante.getNota1());
        values.put("nota2", estudiante.getNota2());
        values.put("nota3", estudiante.getNota3());

        int e = db.update("estudiante", values,
                "id = ?", new String[] {String.valueOf(estudiante.getId())});
        db.close();
        return e;
    }
}
