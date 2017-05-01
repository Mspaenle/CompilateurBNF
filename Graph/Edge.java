
package graph ; 


// Edge est un lien donc ' une arête ' 
// il y aura donc des sous classes pour les arc aka arêtes orientées 

public abstract class Edge{

	protected String name ; 
	protected Vertex first ;  
	protected Vertex second ;
	//protected Graph graph  ;


	public void Edge(String name, Vertex first, Vertex second){	
       
       this.name = name; 
       this.first = first ;
       this.second = second ;
      // this.graph = graph; 

	}	

	public Vertex getFirst(){

		return this.first ; 
	}

	public Vertex getSecond(){

		return this.second ; 
	}

	public String getName(){
		return this.name; 
	}

	public void setName (String name){
		this.name = name ;
	}

	public void setFirst (Vertex first){
		this.first = first ; 
	}

	public void setSecond (Vertex second ){
		this.second = second ; 
	}

	public boolean containsVertex (Vertex vertex){

		if (this.first == vertex | this.second == vertex ){ return true; }
		else { return false ; }

	}


	public Vertex getOtherEnd ( Vertex vertex){

		if ( this.first == vertex ){return this.second ; }
		else if (this.second == vertex) {return this.first ; }
			 else {return null}	
	}


}