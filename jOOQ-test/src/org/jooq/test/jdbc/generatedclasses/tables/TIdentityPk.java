/**
 * This class is generated by jOOQ
 */
package org.jooq.test.jdbc.generatedclasses.tables;

/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TIdentityPk extends org.jooq.impl.TableImpl<org.jooq.test.jdbc.generatedclasses.tables.records.TIdentityPkRecord> {

	private static final long serialVersionUID = -495001995;

	/**
	 * The singleton instance of <code>PUBLIC.T_IDENTITY_PK</code>
	 */
	public static final org.jooq.test.jdbc.generatedclasses.tables.TIdentityPk T_IDENTITY_PK = new org.jooq.test.jdbc.generatedclasses.tables.TIdentityPk();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.jooq.test.jdbc.generatedclasses.tables.records.TIdentityPkRecord> getRecordType() {
		return org.jooq.test.jdbc.generatedclasses.tables.records.TIdentityPkRecord.class;
	}

	/**
	 * The column <code>PUBLIC.T_IDENTITY_PK.ID</code>. 
	 */
	public static final org.jooq.TableField<org.jooq.test.jdbc.generatedclasses.tables.records.TIdentityPkRecord, java.lang.Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER, T_IDENTITY_PK);

	/**
	 * The column <code>PUBLIC.T_IDENTITY_PK.VAL</code>. 
	 */
	public static final org.jooq.TableField<org.jooq.test.jdbc.generatedclasses.tables.records.TIdentityPkRecord, java.lang.Integer> VAL = createField("VAL", org.jooq.impl.SQLDataType.INTEGER, T_IDENTITY_PK);

	/**
	 * No further instances allowed
	 */
	private TIdentityPk() {
		super("T_IDENTITY_PK", org.jooq.test.jdbc.generatedclasses.Public.PUBLIC);
	}
}