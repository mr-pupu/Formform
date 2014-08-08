package com.example.typeform.ui.model;

public class AnswerModel {

	String id = null;
	String label = null; 
	String content = null;
	String value = null;
	String type = null;
	boolean selected = false;

	

	public AnswerModel(String id, String label, String content, String value,
			String type, boolean selected) {
		super();
		this.id = id;
		this.label = label;
		this.content = content;
		this.value = value;
		this.type = type;
		this.selected = selected;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}




}