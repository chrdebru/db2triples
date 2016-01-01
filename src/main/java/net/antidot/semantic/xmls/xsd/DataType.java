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
 * XSD Types
 * 
 * Reference : http://www.w3.org/TR/xmlschema-2/ http://www.schemacentral.com/sc/xsd 
 *
 */
package net.antidot.semantic.xmls.xsd;

public enum DataType {
	INTEGER("http://www.w3.org/2001/XMLSchema#", "integer"),
	STRING("http://www.w3.org/2001/XMLSchema#", "string"),
	BYTE("http://www.w3.org/2001/XMLSchema#", "byte"), // -128 to 127 normal
	UNSIGNED_BYTE("http://www.w3.org/2001/XMLSchema#", "unsignedByte"), // 0 to 255 UNSIGNED.
	SHORT("http://www.w3.org/2001/XMLSchema#", "short"), // -32768 to 32767 normal
	UNSIGNED_SHORT("http://www.w3.org/2001/XMLSchema#", "unsignedShort"),  // 0 to 65535 UNSIGNED.
	INT("http://www.w3.org/2001/XMLSchema#", "int"), // -8388608 to 8388607 normal.
	UNSIGNED_INT("http://www.w3.org/2001/XMLSchema#", "unsignedInt"), // 0 to 4294967295 UNSIGNED.
	LONG("http://www.w3.org/2001/XMLSchema#", "long"), // -9223372036854775808 to 9223372036854775807 normal.
	UNSIGNED_LONG("http://www.w3.org/2001/XMLSchema#", "unsignedLong"), // 0 to 18446744073709551615 UNSIGNED.
	FLOAT("http://www.w3.org/2001/XMLSchema#", "float"), // A small number with a floating decimal point.
	DOUBLE("http://www.w3.org/2001/XMLSchema#", "double"), // A large number with a floating decimal point.
	DECIMAL("http://www.w3.org/2001/XMLSchema#", "decimal"), // A DOUBLE stored as a string , allowing for a fixed decimal point.
	DATE("http://www.w3.org/2001/XMLSchema#", "date"),  // YYYY-MM-DD ("1000-01-01" - "9999-12-31").
	DATETIME("http://www.w3.org/2001/XMLSchema#", "dateTime"), // YYYY-MM-DDTHH:MM:SS ("1000-01-01 00:00:00" - "9999-12-31 23:59:59").
	TIME("http://www.w3.org/2001/XMLSchema#", "time"), // HH:MM:SS ("-838:59:59" - "838:59:59").
	GYEAR("http://www.w3.org/2001/XMLSchema#", "gYear"), // YYYY (1900 - 2155).
	ENUMERATION("http://www.w3.org/2001/XMLSchema#", "enumeration"), // See 4.3.5.2 XML Representation of enumeration Schema Components
	POSITIVE_INTEGER("http://www.w3.org/2001/XMLSchema#", "positiveInteger"), // Based on xsd:nonNegativeInteger
	HEXBINARY("http://www.w3.org/2001/XMLSchema#", "hexBinary"),
	BOOLEAN("http://www.w3.org/2001/XMLSchema#", "boolean"),
	
	WKTLITERAL("http://www.opengis.net/ont/geosparql#", "wktLiteral");
	
	private String type;
	private String namespace;
	
	private DataType(String namespace, String type){
		this.type = type;
		this.namespace = namespace;
	}
	
	public String toString(){
		return type;
	}
	
	public String getType() {
		return type;
	}
	
	public String getNameSpace() {
		return namespace;
	}
	
	/**
	 * Converts a data type from its display name (try with namespace too).
	 * @param displayName
	 * @return
	 */
	public static DataType toDataType(String displayName) {
		if (displayName == null) return null;
		for (DataType datatype : DataType.values()) {
			if (datatype.toString().equals(displayName) || (datatype.namespace + datatype).toString().equals(displayName))
				return datatype;
		}
		
		throw new IllegalArgumentException("[DataType:toDataType] Unknown data type : " + displayName);
		
	}
	
	/**
	 * Is data type in a date format.
	 * @param type
	 * @return
	 */
	public static boolean _isDateType(DataType type){
		return type.equals(DATETIME) || type.equals(DATE);
	}
	
	/**
	 * Return absolute URI of this data type in a string format.
	 * @return
	 */
	public String getAbsoluteStringURI(){
		return getNameSpace() + getType();
	}
	
	
}
