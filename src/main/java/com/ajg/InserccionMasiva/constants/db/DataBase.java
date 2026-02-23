package com.ajg.InserccionMasiva.constants.db;

/**
 * Database
 * 
 * @author ajg
 *
 */
public final class DataBase {

	public static final String DBAPRUEBAS = "DBAPRUEBAS"; 
	public static final String PACKAGE = "PACKAGE";
	public static final String PROCEDURE = "PROCEDURE";
	
	private DataBase() {
		throw new IllegalStateException(this.getClass().toString());
	}
}