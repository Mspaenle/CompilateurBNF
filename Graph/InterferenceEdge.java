package graph ; 


// Edge est un lien donc ' une arête ' 
// il y aura donc des sous classes pour les arc aka arêtes orientées 

public class InterferenceEdge extends Edge{


	public void Vertex(String name, Vertex first, Vertex second){	
       
       this.name = name; 
       this.first = first ;
       this.second = second ;

	}	
}
