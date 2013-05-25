/**
 * This class is generated by jOOQ
 */
package org.jooq.test.h2.generatedclasses.routines;

/**
 * This class is generated by jOOQ.
 */
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PCreateAuthorByName extends org.jooq.impl.AbstractRoutine<java.lang.Void> {

	private static final long serialVersionUID = -1654387484;

	/**
	 * The parameter <code>PUBLIC.P_CREATE_AUTHOR_BY_NAME.P2</code>. 
	 */
	public static final org.jooq.Parameter<java.lang.String> P2 = createParameter("P2", org.jooq.impl.SQLDataType.VARCHAR.length(2147483647));

	/**
	 * The parameter <code>PUBLIC.P_CREATE_AUTHOR_BY_NAME.P3</code>. 
	 */
	public static final org.jooq.Parameter<java.lang.String> P3 = createParameter("P3", org.jooq.impl.SQLDataType.VARCHAR.length(2147483647));

	/**
	 * Create a new routine call instance
	 */
	public PCreateAuthorByName() {
		super("P_CREATE_AUTHOR_BY_NAME", org.jooq.test.h2.generatedclasses.Public.PUBLIC);

		addInParameter(P2);
		addInParameter(P3);
	}

	/**
	 * Set the <code>P2</code> parameter IN value to the routine
	 */
	public void setP2(java.lang.String value) {
		setValue(org.jooq.test.h2.generatedclasses.routines.PCreateAuthorByName.P2, value);
	}

	/**
	 * Set the <code>P3</code> parameter IN value to the routine
	 */
	public void setP3(java.lang.String value) {
		setValue(org.jooq.test.h2.generatedclasses.routines.PCreateAuthorByName.P3, value);
	}
}
