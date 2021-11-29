package com.elementaryschool.view;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class TextFieldLimit extends PlainDocument {
	
	/**
	 * A plain document that maintains no character attributes. The default element structure for this document is a map of the lines in the text.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @author Danish Kamaa1
	 */
	
	private int fieldlimit;

	TextFieldLimit(int fieldlimit) {
		super();
		this.fieldlimit = fieldlimit;
	}

	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		if (str == null)
			return;

		if ((getLength() + str.length()) <= fieldlimit) {
			super.insertString(offset, str, attr);
		}
	}

}
