/* 
 * Copyright 2011-2013 Antidot opensource@antidot.net
 * https://github.com/antidot/db2triples
 * 
 * This file is part of DB2Triples
 *
 * DB2Triples is free software; you can redistribute it and/or 
 * modify it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation; either version 2 of 
 * the License, or (at your option) any later version.
 * 
 * DB2Triples is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 *
 * RDB2RDF Commons : SQLToRDF Toolkit
 *
 * Collection of useful tool-methods used for conversion between SQL and RDF. 
 *
 */
package net.antidot.semantic.rdf.rdb2rdf.commons;

import java.util.HashMap;
import java.util.Map;

import net.antidot.sql.model.type.SQLSpecificType;
import net.antidot.sql.model.type.SQLType;
import net.antidot.semantic.xmls.xsd.DataType;

public abstract class SpecificSQLToXMLS {

	/**
	 * Equivalence datatype between standard SQL types and XSD types according
	 * to XML Schema Part 2: Datatypes Second Edition (W3C Recommendation 28
	 * October 2004) See : http://www.w3.org/TR/xmlschema-2/
	 */
	private static Map<SQLSpecificType, DataType> equivalentSpecificTypes = new HashMap<SQLSpecificType, DataType>();
	private static Map<SQLType, DataType> equivalentTypes = new HashMap<SQLType, DataType>();

	static {
		// Text types
		// A fixed section from 0 to 255 characters long.
		equivalentSpecificTypes.put(SQLSpecificType.CHAR, DataType.STRING);
		// A variable section from 0 to 255 characters long.
		equivalentSpecificTypes.put(SQLSpecificType.VARCHAR, DataType.STRING);
		// A string with a maximum length of 255 characters.
		equivalentSpecificTypes.put(SQLSpecificType.TINYTEXT, DataType.STRING);
		 // A string with a maximum length of 65535 characters.
		equivalentSpecificTypes.put(SQLSpecificType.TEXT, DataType.STRING);
		// A string with a maximum length of 65535 characters.
		equivalentSpecificTypes.put(SQLSpecificType.BLOB, DataType.STRING); 
		// A string with a maximum length of 16777215 characters.
		equivalentSpecificTypes.put(SQLSpecificType.MEDIUMTEXT, DataType.STRING); 
		// A string with a maximum length of 16777215 characters.
		equivalentSpecificTypes.put(SQLSpecificType.MEDIUMBLOB, DataType.STRING); 
		// A string with a maximum length of 4294967295 characters.
		equivalentSpecificTypes.put(SQLSpecificType.LONGTEXT, DataType.STRING); 
		// A string with a maximum length of 4294967295 characters.
		equivalentSpecificTypes.put(SQLSpecificType.LONGBLOB, DataType.STRING); 
		
		// Number types
		// 0 or 1
		equivalentSpecificTypes.put(SQLSpecificType.BIT, DataType.BYTE); 
		// -128 to 127 normal
		equivalentSpecificTypes.put(SQLSpecificType.TINYINT, DataType.BYTE); 
		// 0 to 255 UNSIGNED.
		equivalentSpecificTypes.put(SQLSpecificType.UNSIGNED_TINYINT, DataType.UNSIGNED_BYTE);
		// -32768 to 32767 normal
		equivalentSpecificTypes.put(SQLSpecificType.SMALLINT, DataType.SHORT);
		// 0 to 65535 UNSIGNED.
		equivalentSpecificTypes.put(SQLSpecificType.UNSIGNED_SMALLINT, DataType.UNSIGNED_SHORT); 
		// -8388608 to 8388607 normal.
		equivalentSpecificTypes.put(SQLSpecificType.MEDIUMINT, DataType.INT); 
		// 0 to 16777215 UNSIGNED.
		equivalentSpecificTypes.put(SQLSpecificType.UNSIGNED_MEDIUMINT, DataType.INT); 
		// -2147483648 to 2147483647 normal.
		equivalentSpecificTypes.put(SQLSpecificType.INT, DataType.INT);
		// 0 to 4294967295 UNSIGNED.
		equivalentSpecificTypes.put(SQLSpecificType.UNSIGNED_INT, DataType.UNSIGNED_INT); 
		// -9223372036854775808 to 9223372036854775807 normal.
		equivalentSpecificTypes.put(SQLSpecificType.BIGINT, DataType.LONG); 
		 // 0 to 18446744073709551615 UNSIGNED.
		equivalentSpecificTypes.put(SQLSpecificType.UNSIGNED_BIGINT, DataType.UNSIGNED_LONG);
		// A small number with a floating decimal point.
		equivalentSpecificTypes.put(SQLSpecificType.FLOAT, DataType.FLOAT);
		// A small number with a floating decimal point.
		equivalentSpecificTypes.put(SQLSpecificType.UNSIGNED_FLOAT, DataType.FLOAT);
		// A small number with a floating decimal point.
		equivalentSpecificTypes.put(SQLSpecificType.DOUBLE, DataType.DOUBLE); 
		// A large number with a floating decimal point.
		equivalentSpecificTypes.put(SQLSpecificType.UNSIGNED_DOUBLE, DataType.DOUBLE); 
		// A large number with a floating decimal point.
		equivalentSpecificTypes.put(SQLSpecificType.DECIMAL, DataType.DECIMAL); 
		// A DOUBLE stored as a string , allowing for a fixed decimal point.
		equivalentSpecificTypes.put(SQLSpecificType.UNSIGNED_DECIMAL, DataType.DECIMAL);
		
		// Date types
		 // YYYY-MM-DD ("1000-01-01" - "9999-12-31").
		equivalentSpecificTypes.put(SQLSpecificType.DATE, DataType.DATE);
		// YYYY-MM-DD HH:MM:SS ("1000-01-01 00:00:00" - "9999-12-31 23:59:59"). 
		// xsd:datetime doesn't match because the letter T is required ?
		// No, it's valid. See W3C Working Draft (24/03/2011), Section 2.3.4.
		equivalentSpecificTypes.put(SQLSpecificType.DATETIME, DataType.DATETIME); 
		// YYYYMMDDHHMMSS (19700101000000 - 2037+)
		equivalentSpecificTypes.put(SQLSpecificType.TIMESTAMP, DataType.DATETIME); 
		// HH:MM:SS ("-838:59:59" - "838:59:59").
		equivalentSpecificTypes.put(SQLSpecificType.TIME, DataType.TIME); 
		// YYYY (1900 - 2155).
		equivalentSpecificTypes.put(SQLSpecificType.YEAR, DataType.GYEAR); 
		
		// Misc types
		equivalentSpecificTypes.put(SQLSpecificType.ENUM, DataType.ENUMERATION); // Short for ENUMERATION which means that each column may have one of a specified possible values.
		equivalentSpecificTypes.put(SQLSpecificType.SET, DataType.ENUMERATION); // Similar to ENUM except each column may have more than one of the specified possible values.

		/**
		 * PostGreSQL equivalences.
		 */
		equivalentSpecificTypes.put(SQLSpecificType.INT4, DataType.INTEGER);
		equivalentSpecificTypes.put(SQLSpecificType.FLOAT4, DataType.FLOAT);
		equivalentSpecificTypes.put(SQLSpecificType.POINT, DataType.STRING);
		equivalentSpecificTypes.put(SQLSpecificType.BIGSERIAL, DataType.INTEGER);
		equivalentSpecificTypes.put(SQLSpecificType.VARBIT, DataType.INT);
		equivalentSpecificTypes.put(SQLSpecificType.BIT_VARYING, DataType.INT);
		equivalentSpecificTypes.put(SQLSpecificType.BOOL, DataType.BYTE);
		equivalentSpecificTypes.put(SQLSpecificType.BPCHAR, DataType.STRING);
		equivalentSpecificTypes.put(SQLSpecificType.BOOLEAN, DataType.BYTE);
		equivalentSpecificTypes.put(SQLSpecificType.BOX, DataType.STRING);
		equivalentSpecificTypes.put(SQLSpecificType.BYTEA, DataType.STRING);
		equivalentSpecificTypes.put(SQLSpecificType.CHARACTER_VARYING, DataType.STRING);
		equivalentSpecificTypes.put(SQLSpecificType.CHARACTER, DataType.STRING);
		equivalentSpecificTypes.put(SQLSpecificType.CIDR, DataType.STRING);
		equivalentSpecificTypes.put(SQLSpecificType.CIRCLE, DataType.STRING);
		equivalentSpecificTypes.put(SQLSpecificType.DOUBLE_PRECISION, DataType.DOUBLE);
		equivalentSpecificTypes.put(SQLSpecificType.FLOAT8, DataType.FLOAT);
		equivalentSpecificTypes.put(SQLSpecificType.INET, DataType.STRING);
		equivalentSpecificTypes.put(SQLSpecificType.INT2, DataType.INTEGER);
		equivalentSpecificTypes.put(SQLSpecificType.INT8, DataType.INTEGER);
		equivalentSpecificTypes.put(SQLSpecificType.INTERVAL, DataType.STRING);
		equivalentSpecificTypes.put(SQLSpecificType.LINE, DataType.STRING);
		equivalentSpecificTypes.put(SQLSpecificType.LSEG, DataType.STRING);
		equivalentSpecificTypes.put(SQLSpecificType.MACADDR, DataType.STRING);
		equivalentSpecificTypes.put(SQLSpecificType.MONEY, DataType.STRING);
		equivalentSpecificTypes.put(SQLSpecificType.NUMERIC, DataType.DECIMAL);
		equivalentSpecificTypes.put(SQLSpecificType.PATH, DataType.STRING);
		equivalentSpecificTypes.put(SQLSpecificType.POINT, DataType.STRING);
		equivalentSpecificTypes.put(SQLSpecificType.POLYGON, DataType.STRING);
		equivalentSpecificTypes.put(SQLSpecificType.REAL, DataType.FLOAT);
		equivalentSpecificTypes.put(SQLSpecificType.SERIAL, DataType.STRING);
		equivalentSpecificTypes.put(SQLSpecificType.SERIAL4, DataType.INTEGER);
		equivalentSpecificTypes.put(SQLSpecificType.TIMETZ, DataType.FLOAT);
		equivalentSpecificTypes.put(SQLSpecificType.TIMESTAMPTZ, DataType.STRING);
		equivalentSpecificTypes.put(SQLSpecificType.POLYGON, DataType.INTEGER);
		equivalentSpecificTypes.put(SQLSpecificType.REAL, DataType.FLOAT);
		equivalentSpecificTypes.put(SQLSpecificType.SERIAL, DataType.STRING);
		
		// Unkown type
		equivalentSpecificTypes.put(SQLSpecificType.UNKNOW, DataType.STRING);

		/**
		 * Generic equivalences.
		 */
		equivalentTypes.put(SQLType.BINARY, DataType.HEXBINARY);
		equivalentTypes.put(SQLType.BINARY_VARYING, DataType.HEXBINARY);
		equivalentTypes.put(SQLType.BINARY_LARGE_OBJECT, DataType.HEXBINARY);
		equivalentTypes.put(SQLType.NUMERIC, DataType.DECIMAL);
		equivalentTypes.put(SQLType.DECIMAL, DataType.DECIMAL);
		equivalentTypes.put(SQLType.SMALLINT, DataType.INTEGER);
		equivalentTypes.put(SQLType.INTEGER, DataType.INTEGER);
		equivalentTypes.put(SQLType.BIGINT, DataType.INTEGER);
		equivalentTypes.put(SQLType.FLOAT, DataType.DOUBLE);
		equivalentTypes.put(SQLType.REAL, DataType.DOUBLE);
		equivalentTypes.put(SQLType.DOUBLE_PRECISION, DataType.DOUBLE);
		equivalentTypes.put(SQLType.BOOLEAN, DataType.BOOLEAN);
		equivalentTypes.put(SQLType.DATE, DataType.DATE);
		equivalentTypes.put(SQLType.TIME, DataType.TIME);
		equivalentTypes.put(SQLType.TIMESTAMP, DataType.DATETIME);
		equivalentTypes.put(SQLType.TIMESTAMP, DataType.DATETIME);
		equivalentTypes.put(SQLType.TIMESTAMP, DataType.DATETIME);
		equivalentTypes.put(SQLType.TIMESTAMP, DataType.DATETIME);
		equivalentTypes.put(SQLType.CHAR, DataType.STRING);
		equivalentTypes.put(SQLType.VARCHAR, DataType.STRING);
		equivalentTypes.put(SQLType.STRING, DataType.STRING);
		equivalentTypes.put(SQLType.UNKNOWN, DataType.STRING);
		
		
	}

	public static DataType getEquivalentSpecificType(SQLSpecificType SQLType) {
		return equivalentSpecificTypes.get(SQLType);
	}

	public static DataType getEquivalentSpecificType(String sqlType) {
		return equivalentSpecificTypes.get(SQLSpecificType.toSQLType(sqlType));
	}

	public static boolean isValidSQLSpecificDatatype(String datatype) {
		return equivalentSpecificTypes.keySet().contains(SQLSpecificType.toSQLType(datatype));
	}
	
	public static DataType getEquivalentType(SQLType SQLType) {
		return equivalentTypes.get(SQLType);
	}

	public static DataType getEquivalentType(int sqlType) {
		return equivalentTypes.get(SQLType.toSQLType(sqlType));
	}

	public static boolean isValidSQLDatatype(int datatype) {
		return equivalentTypes.keySet().contains(SQLType.toSQLType(datatype));
	}

}
