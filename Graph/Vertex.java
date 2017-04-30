package Graph;

/**
	*@author Assil El Yahyaoui - Mahé Spaenlé
	*@version 1.0
*/

public class Vertex{
	private String value;
	private int color;

	public Vertex(String val){
		this.value=val;
		this.color=-1;
	}

	public String getValue(){
		return this.value;
	}

	public void setValue(String val){
		this.value = val;
	}

	public int getColor(){
		return this.color;
	}
	
	public void setColor(int color){
		this.color = color;
	}

}