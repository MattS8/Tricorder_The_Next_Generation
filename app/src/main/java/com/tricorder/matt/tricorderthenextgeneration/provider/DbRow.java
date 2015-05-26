package com.tricorder.matt.tricorderthenextgeneration.provider;

/**
 * Created by Matt on 5/25/2015.
 */

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;

/**
 * Utility class for managing a row from a content provider.
 */
public abstract class DbRow {

    // ******************************************************************** //
    // Constructor.
    // ******************************************************************** //

    /**
     * Create a database row instance from a Cursor.
     *
     * @param   schema      Schema of the table the row belongs to.
     * @param   c           Cursor to read the row data from.
     */
    protected DbRow(TableSchema schema, Cursor c) {
        this(schema, c, schema.getDefaultProjection());
    }


    /**
     * Create a database row instance from a Cursor.
     *
     * @param   schema      Schema of the table the row belongs to.
     * @param   c           Cursor to read the row data from.
     * @param   projection  The fields to read.
     */
    protected DbRow(TableSchema schema, Cursor c, String[] projection) {
        tableSchema = schema;

        rowValues = new ContentValues();
        DatabaseUtils.cursorRowToContentValues(c, rowValues);
    }


    // ******************************************************************** //
    // Public Accessors.
    // ******************************************************************** //


    // ******************************************************************** //
    // Local Accessors.
    // ******************************************************************** //

    /**
     * Save the contents of this row to the given ContentValues.
     *
     * @param   values          Object to write to.
     */
    void getValues(ContentValues values) {
        values.putAll(rowValues);
    }


    // ******************************************************************** //
    // Private Data.
    // ******************************************************************** //

    // Schema of the table this row belongs to.
    @SuppressWarnings("unused")
    private final TableSchema tableSchema;

    // The values of the fields in this row.
    private final ContentValues rowValues;

}