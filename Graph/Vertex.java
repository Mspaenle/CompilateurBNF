package graph; 

// cest les noeuds 



public class Vertex {

	public String name ; 
	public Color color ;



	public void Vertex(String name, Color color){	
      this.name = name ; 
      this.color = color ; 
    }	


// NOT DONE 
	public String getName(){
		return this.name ; 
	}

	public Color getColor(){
		return this.color; 
	}

	public void setName(String name){
		this.name= name;
	}

	public void setColor(Color color){
		this.color = color ; 
	}


}