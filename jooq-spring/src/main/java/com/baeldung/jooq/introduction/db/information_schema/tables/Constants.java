/**
 * This class is generated by jOOQ
 */
package com.baeldung.jooq.introduction.db.information_schema.tables;


import com.baeldung.jooq.introduction.db.information_schema.InformationSchema;
import com.baeldung.jooq.introduction.db.information_schema.tables.records.ConstantsRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.3"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Constants extends TableImpl<ConstantsRecord> {

	private static final long serialVersionUID = 107996087;

	/**
	 * The reference instance of <code>INFORMATION_SCHEMA.CONSTANTS</code>
	 */
	public static final Constants CONSTANTS = new Constants();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<ConstantsRecord> getRecordType() {
		return ConstantsRecord.class;
	}

	/**
	 * The column <code>INFORMATION_SCHEMA.CONSTANTS.CONSTANT_CATALOG</code>.
	 */
	public final TableField<ConstantsRecord, String> CONSTANT_CATALOG = createField("CONSTANT_CATALOG", org.jooq.impl.SQLDataType.VARCHAR.length(2147483647), this, "");

	/**
	 * The column <code>INFORMATION_SCHEMA.CONSTANTS.CONSTANT_SCHEMA</code>.
	 */
	public final TableField<ConstantsRecord, String> CONSTANT_SCHEMA = createField("CONSTANT_SCHEMA", org.jooq.impl.SQLDataType.VARCHAR.length(2147483647), this, "");

	/**
	 * The column <code>INFORMATION_SCHEMA.CONSTANTS.CONSTANT_NAME</code>.
	 */
	public final TableField<ConstantsRecord, String> CONSTANT_NAME = createField("CONSTANT_NAME", org.jooq.impl.SQLDataType.VARCHAR.length(2147483647), this, "");

	/**
	 * The column <code>INFORMATION_SCHEMA.CONSTANTS.DATA_TYPE</code>.
	 */
	public final TableField<ConstantsRecord, Integer> DATA_TYPE = createField("DATA_TYPE", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>INFORMATION_SCHEMA.CONSTANTS.REMARKS</code>.
	 */
	public final TableField<ConstantsRecord, String> REMARKS = createField("REMARKS", org.jooq.impl.SQLDataType.VARCHAR.length(2147483647), this, "");

	/**
	 * The column <code>INFORMATION_SCHEMA.CONSTANTS.SQL</code>.
	 */
	public final TableField<ConstantsRecord, String> SQL = createField("SQL", org.jooq.impl.SQLDataType.VARCHAR.length(2147483647), this, "");

	/**
	 * The column <code>INFORMATION_SCHEMA.CONSTANTS.ID</code>.
	 */
	public final TableField<ConstantsRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * Create a <code>INFORMATION_SCHEMA.CONSTANTS</code> table reference
	 */
	public Constants() {
		this("CONSTANTS", null);
	}

	/**
	 * Create an aliased <code>INFORMATION_SCHEMA.CONSTANTS</code> table reference
	 */
	public Constants(String alias) {
		this(alias, CONSTANTS);
	}

	private Constants(String alias, Table<ConstantsRecord> aliased) {
		this(alias, aliased, null);
	}

	private Constants(String alias, Table<ConstantsRecord> aliased, Field<?>[] parameters) {
		super(alias, InformationSchema.INFORMATION_SCHEMA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Constants as(String alias) {
		return new Constants(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Constants rename(String name) {
		return new Constants(name, null);
	}
}
