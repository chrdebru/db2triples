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
/***************************************************************************
 *
 * RDB2RDF Commons : SQLToXMLS Toolkit
 * 
 * Collection of useful tool-methods used for conversion between SQL datatype and XML Schema Datatypes.
 *
 *
 ****************************************************************************/
package net.antidot.semantic.rdf.rdb2rdf.commons;

import java.util.HashMap;
import java.util.Map;

import net.antidot.semantic.xmls.xsd.DataType;
import net.antidot.sql.model.type.SQLType;

public abstract class SQLToXMLS {

	/**
	 * Equivalence datatype between standard SQL types and XSD types.
	 */
	private static Map<SQLType, DataType> equivalentTypes = new HashMap<SQLType, DataType>();
	
	static {
		equivalentTypes.put(SQLType.BINARY, DataType.HEXBINARY);
		equivalentTypes.put(SQLType.BINARY_VARYING, DataType.HEXBINARY);
		equivalentTypes.put(SQLType.NUMERIC, DataType.DECIMAL);
		equivalentTypes.put(SQLType.DECIMAL, DataType.DECIMAL);
		equivalentTypes.put(SQLType.SMALLINT, DataType.INTEGER);
		equivalentTypes.put(SQLType.INTEGER, DataType.INTEGER);
		equivalentTypes.put(SQLType.BIGINT, DataType.INTEGER);
		equivalentTypes.put(SQLType.FLOAT, DataType.DOUBLE);
		equivalentTypes.put(SQLType.REAL, DataType.DOUBLE);
		equivalentTypes.put(SQLType.DOUBLE_PRECISION, DataType.DOUBLE);
		equivalentTypes.put(SQLType.BOOLEAN, DataType.BOOLEAN);
		equivalentTypes.put(SQLType.BIT, DataType.BOOLEAN);
		equivalentTypes.put(SQLType.TINYINT, DataType.BOOLEAN);
		equivalentTypes.put(SQLType.DATE, DataType.DATE);
		equivalentTypes.put(SQLType.TIME, DataType.TIME);
		equivalentTypes.put(SQLType.TIMESTAMP, DataType.DATETIME);
		equivalentTypes.put(SQLType.VARCHAR, DataType.STRING);
		equivalentTypes.put(SQLType.CHAR, DataType.STRING);
		equivalentTypes.put(SQLType.STRING, DataType.STRING);
	}
	
	public static DataType getEquivalentType(SQLType sqlType){
		return equivalentTypes.get(sqlType);
	}
	
	public static DataType getEquivalentType(int sqlType){
		return equivalentTypes.get(SQLType.toSQLType(sqlType));
	}
	
	public static boolean isValidSQLDatatype(int datatype){
		return equivalentTypes.keySet().contains(SQLType.toSQLType(datatype));
	}

}
