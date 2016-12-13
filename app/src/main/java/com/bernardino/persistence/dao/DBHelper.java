package com.bernardino.persistence.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.bernardino.persistence.MyApplication;
import com.bernardino.persistence.model.Livro;

/**
 * Created by rm31243 on 12/12/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static String NOME_BANCO = "book.db";
    public static int VERSION_DB = 1;

    public DBHelper() {
        super(MyApplication.getContext(), NOME_BANCO, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(LivroDAO.createTable());
        seed();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private void seed() {
        try {


        LivroDAO dao = new LivroDAO();

        Livro android = new Livro();
        android.setAutor("Ricardo Lecheta");
        android.setEditora("Novatec");
        android.setTitulo("Google Android");
        dao.insereDado(android);

        Livro torreNegra = new Livro();
        torreNegra.setTitulo("A Torre Negra");
        torreNegra.setAutor("Stephen King");
        torreNegra.setEditora("Suma das Letras");
        dao.insereDado(torreNegra);
        } catch (Exception e) {
            Log.e("minhatag", e.getMessage());
        }
    }
}
