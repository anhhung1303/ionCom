package com.project.ioncom.model;


public class Experiment {
	private int id;
	private String name;
	private String tools;
	private String steps;
	private String phenomen;
	private String reactionEquation;
	private String explanation;
	private String fileName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTools() {
		return tools;
	}

	public void setTools(String tools) {
		this.tools = tools;
	}

	public String getSteps() {
		return steps;
	}

	public void setSteps(String steps) {
		this.steps = steps;
	}

	public String getPhenomen() {
		return phenomen;
	}

	public void setPhenomen(String phenomen) {
		this.phenomen = phenomen;
	}

	public String getReactionEquation() {
		return reactionEquation;
	}

	public void setReactionEquation(String reactionEquation) {
		this.reactionEquation = reactionEquation;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString(){
		String resultString = "";
		
		resultString += "id = " + this.getId();
		resultString += "name = " + this.getName();
		resultString += "tools = " + this.getTools();
		resultString += "steps = " + this.getSteps();
		resultString += "phenomen = " + this.getPhenomen();
		resultString += "reactionEquation = " + this.getReactionEquation();
		resultString += "explanation = " + this.getExplanation();
		resultString += "fileName = " + this.getFileName();
		
		return resultString;
	}

}
