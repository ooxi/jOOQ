/**
 * Copyright (c) 2009-2015, Data Geekery GmbH (http://www.datageekery.com)
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Other licenses:
 * -----------------------------------------------------------------------------
 * Commercial licenses for this work are available. These replace the above
 * ASL 2.0 and offer limited warranties, support, maintenance, and commercial
 * database integrations.
 *
 * For more information, please visit: http://www.jooq.org/licenses
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package org.jooq.impl;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.function;

import java.sql.Timestamp;

import org.jooq.Configuration;
import org.jooq.DatePart;
import org.jooq.Field;
import org.jooq.exception.SQLDialectNotSupportedException;

/**
 * @author Lukas Eder
 */
class Extract extends AbstractFunction<Integer> {

    private static final long serialVersionUID = 3748640920856031034L;

    private final Field<?>    field;
    private final DatePart    datePart;

    Extract(Field<?> field, DatePart datePart) {
        super("extract", SQLDataType.INTEGER, field);

        this.field = field;
        this.datePart = datePart;
    }

    @Override
    final Field<Integer> getFunction0(Configuration configuration) {
        switch (configuration.family()) {
            case SQLITE:
                switch (datePart) {
                    case YEAR:
                        return field("{strftime}('%Y', {0})", SQLDataType.INTEGER, field);
                    case MONTH:
                        return field("{strftime}('%m', {0})", SQLDataType.INTEGER, field);
                    case DAY:
                        return field("{strftime}('%d', {0})", SQLDataType.INTEGER, field);
                    case HOUR:
                        return field("{strftime}('%H', {0})", SQLDataType.INTEGER, field);
                    case MINUTE:
                        return field("{strftime}('%M', {0})", SQLDataType.INTEGER, field);
                    case SECOND:
                        return field("{strftime}('%S', {0})", SQLDataType.INTEGER, field);
                    default:
                        throw new SQLDialectNotSupportedException("DatePart not supported: " + datePart);
                }

            /* [pro] xx
            xxxx xxxxxxxxx
                xxxxxx xxxxxxxxxx x
                    xxxx xxxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxx
                    xxxx xxxxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxx
                    xxxx xxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxx
                    xxxx xxxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxxxx xxxx xx xxxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxx
                    xxxx xxxxxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxxxx xxxxxx xx xxxxxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxx
                    xxxx xxxxxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxxxx xxxxxx xx xxxxxxxxxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxx
                    xxxxxxxx
                        xxxxx xxx xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx xxx xxxxxxxxxx x x xxxxxxxxxx
                x

            xxxx xxxx
            xx [/pro] */
            case DERBY:
                switch (datePart) {
                    case YEAR:
                        return function("year", SQLDataType.INTEGER, field);
                    case MONTH:
                        return function("month", SQLDataType.INTEGER, field);
                    case DAY:
                        return function("day", SQLDataType.INTEGER, field);
                    case HOUR:
                        return function("hour", SQLDataType.INTEGER, field);
                    case MINUTE:
                        return function("minute", SQLDataType.INTEGER, field);
                    case SECOND:
                        return function("second", SQLDataType.INTEGER, field);
                    default:
                        throw new SQLDialectNotSupportedException("DatePart not supported: " + datePart);
                }

            /* [pro] xx

            xxxx xxxxxxx
                xxxxxx xxxxxxxxxx x
                    xxxx xxxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxxxxxxxx xxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxx
                    xxxx xxxxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxxxxx xxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxx
                    xxxx xxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxxxxx xxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxx
                    xxxx xxxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxxxxx xxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxx
                    xxxx xxxxxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxxxxx xxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxx
                    xxxx xxxxxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxxxxx xxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxx
                    xxxxxxxx
                        xxxxx xxx xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx xxx xxxxxxxxxx x x xxxxxxxxxx
                x

            xxxx xxxxxxx
                xxxxxx xxxxxxxxxx x
                    xxxx xxxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxx x xxxxxxxxxxxxxxxx x x xxxxx xxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxx
                    xxxx xxxxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxx x xxxxxxxxxxxxxxxx x x xxxxx xxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxx
                    xxxx xxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxx x xxxxxxxxxxxxxxxx x x xxxxx xxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxx
                    xxxx xxxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxx x xxxxxxxxxxxxxxxx x x xxxxx xxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                    xxxx xxxxxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxx x xxxxxxxxxxxxxxxx x x xxxxx xxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                    xxxx xxxxxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxx x xxxxxxxxxxxxxxxx x x xxxxx xxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxxxxxxxxxxxxxxxxxxxxxxxx
                    xxxxxxxx
                        xxxxx xxx xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx xxx xxxxxxxxxx x x xxxxxxxxxx
                x

            xxxx xxxx
            xxxx xxxxxxxxxx
            xxxx xxxxxxx
                xxxxxx xxxxxxxxxx x
                    xxxx xxxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxxxx xxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxx
                    xxxx xxxxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxxxx xxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxx
                    xxxx xxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxxxx xxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxx
                    xxxx xxxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxxxx xxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxx
                    xxxx xxxxxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxxxx xxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxx
                    xxxx xxxxxxx
                        xxxxxx xxxxxxxxxxxxxxxxxxxxx xxxxxx xxxxxxxxxxxxxxxxxxxx xxxxxxx
                    xxxxxxxx
                        xxxxx xxx xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx xxx xxxxxxxxxx x x xxxxxxxxxx
                x

            xxxx xxxxxxx
            xx [/pro] */
            case MARIADB:
            case MYSQL:
            case POSTGRES:
            case HSQLDB:
            case H2:

            // A default implementation is necessary for hashCode() and toString()
            default:
                return field("{extract}({" + datePart.toSQL() + " from} {0})", SQLDataType.INTEGER, field);
        }
    }
}
