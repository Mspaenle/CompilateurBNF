package Graph;

/**
@author Assil El Yahyaoui - Mahé Spaenlé
@version 1.0
*/

public class Edge{
	public Vertex v1;
	public Vertex v2;

	public Edge(Vertex v1, Vertex v2){
		this.v1 = v1;
		this.v2 = v2;
	}

	public Vertex getVertex1(){
		return this.v1;
	}

	public void setVertex1(Vertex v){
		this.v1=v;
	}

	public Vertex getVertex2(){
		return this.v2;
	}

	public void setVertex2(Vertex v){
		this.v2=v;
	}

/**
	Test if the edge contain the vertex
	@param v a vertex
	@return boolean, true if it contains the vertex, else false
*/
	public boolean containsVertex(Vertex v){
		return (v.equals(this.v1)||v.equals(this.v2));
	}

/**
	Give the other end of the edge if v id v1 or v2
	@param v a vertex
	@return a vertex, v1 if v=v2, v2 if v=v1, null if not
*/
	public Vertex getNeighbor(Vertex v){
		if(!containsVertex(v)){
			return null;
		}
		else if(v.equals(this.v1)){
			return this.v2;
		}
		else {
			return this.v1;
		}
	}
}