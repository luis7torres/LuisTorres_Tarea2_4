package com.example.luistorres_tarea2_4.tablas;
public class Transacciones {

    public static final String tabla_firmas = "tb_firmas";


    public static final String id = "id";
    public static final String imagen = "imagen";
    public static final String descripcion = "descripcion";

    public static final String CreateTableFirmas= "CREATE TABLE tb_firmas" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "imagen BLOB, " +
            "descripcion TEXT)";

    public static final String DropTableFirmas= "DROP TABLE IF EXISTS tb_firmas";
    public static final String NameDataBase = "DBPWI";

}
