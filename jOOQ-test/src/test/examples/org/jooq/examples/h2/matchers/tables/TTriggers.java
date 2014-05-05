/**
 * This class is generated by jOOQ
 */
package org.jooq.examples.h2.matchers.tables;

/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TTriggers extends org.jooq.impl.TableImpl<org.jooq.examples.h2.matchers.tables.records.TTriggersRecord> {

	private static final long serialVersionUID = -1828674254;

	/**
	 * The singleton instance of <code>PUBLIC.T_TRIGGERS</code>
	 */
	public static final org.jooq.examples.h2.matchers.tables.TTriggers T_TRIGGERS = new org.jooq.examples.h2.matchers.tables.TTriggers();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.jooq.examples.h2.matchers.tables.records.TTriggersRecord> getRecordType() {
		return org.jooq.examples.h2.matchers.tables.records.TTriggersRecord.class;
	}

	/**
	 * The column <code>PUBLIC.T_TRIGGERS.ID_GENERATED</code>. 
	 */
	public static final org.jooq.TableField<org.jooq.examples.h2.matchers.tables.records.TTriggersRecord, java.lang.Integer> ID_GENERATED = createField("ID_GENERATED", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), T_TRIGGERS);

	/**
	 * The column <code>PUBLIC.T_TRIGGERS.ID</code>. 
	 */
	public static final org.jooq.TableField<org.jooq.examples.h2.matchers.tables.records.TTriggersRecord, java.lang.Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER, T_TRIGGERS);

	/**
	 * The column <code>PUBLIC.T_TRIGGERS.COUNTER</code>. 
	 */
	public static final org.jooq.TableField<org.jooq.examples.h2.matchers.tables.records.TTriggersRecord, java.lang.Integer> COUNTER = createField("COUNTER", org.jooq.impl.SQLDataType.INTEGER, T_TRIGGERS);

	/**
	 * No further instances allowed
	 */
	private TTriggers() {
		super("T_TRIGGERS", org.jooq.examples.h2.matchers.NonPublic.NON_PUBLIC);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.jooq.examples.h2.matchers.tables.records.TTriggersRecord, java.lang.Integer> getIdentity() {
		return org.jooq.examples.h2.matchers.Keys.IDENTITY_T_TRIGGERS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.jooq.examples.h2.matchers.tables.records.TTriggersRecord> getPrimaryKey() {
		return org.jooq.examples.h2.matchers.Keys.PK_T_TRIGGERS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.jooq.examples.h2.matchers.tables.records.TTriggersRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.jooq.examples.h2.matchers.tables.records.TTriggersRecord>>asList(org.jooq.examples.h2.matchers.Keys.PK_T_TRIGGERS);
	}
}