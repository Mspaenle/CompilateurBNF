package graph; 
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class Graph  {

	public ArrayList<Vertex> vertexList; 
	public ArrayList<InterferenceEdge> intEdgeList; 
	public ArrayList<PreferenceEdge> prefEdgeList; 

	public void Graph(ArrayList<Vertex> vertexList, ArrayList<InterferenceEdge> intEdgeList, List<PreferenceEdge> prefEdgeList){

		this.vertexList = vertexList ;
		this.intEdgeList= intEdgeList;
		this.prefEdgeList= prefEdgeList; 

	}
 



 	public void Graph(int k){
		Graph g = new Graph(new ArrayList<Vertex>(this.vertices), new ArrayList<InterferenceEdge>(this.iedges), new ArrayList<PreferenceEdge>(this.pedges));
		Vertex vertex = null;
		Stack toColor = new Stack();

		// Supprimer ceux qu'on veut pas et entasser les autres

		while (g.getNumberOfVertices()>1){
			// select the first edge with a number of neighbors inferior to k
			vertex = g.getAVertexWithLessThanKNeighbor(k);
			if (vertex == null){
				// spill the edge with the highest weight
				vertex = g.getVertexWithHighestWeigh();
				this.getVertex(vertex).setColor(0);
			} else {
				// add vertex into list for coloring
				toColor.push(vertex);
			}
			// supp the vertex from graph
			g.removeVertex(vertex);
		}

		while (!toColor.isEmpty()) {
			System.out.println("Start coloring");
			Vertex vertexToColor = toColor.pop();
			boolean available;
			ArrayList<Integer> preferenceColors = new ArrayList<Integer>();
			for (Edge pref : this.pedges) { // get preference colors
				Vertex neighbor = pref.getOtherEnd(vertexToColor);
				if (neighbor != null) {
					if (neighbor.getColor() > 0) {
						preferenceColors.add(neighbor.getColor());
					}
				}
			}
			for (int i : preferenceColors){ // try preference colors
				available = true;
				for (Edge interf : this.iedges) {
					Vertex neighbor = interf.getOtherEnd(vertexToColor);
					if (neighbor != null){
						if (neighbor.getColor() == i) {
							available = false;
						}
					}
				}
				if (available) {
					vertexToColor.setColor(i);
					break;
				}
			}
			if (vertexToColor.getColor() < 0) {
				for (int i = 1; i <= k; i++) { // choose another color
					available = true;
					for (Edge interf : this.iedges) {
						Vertex neighbor = interf.getOtherEnd(vertexToColor);
						if (neighbor != null){
							if (neighbor.getColor() == i) {
								available = false;
							}
						}
					}
					if (available) {
						vertexToColor.setColor(i);
						break;
					}
				}
			}
			toColor.remove(vertexToColor);
			System.out.println("Vertex colored and removed");
		}
		
	}







	public void addVertex(Vertex vertex){
		this.vertexList.add(vertex) ; 
	} 

/**
	* Remove the Vertex and the prefEdge
*/
	public void removeVertex(Vertex vertex){
		for(Edge e : this.prefEdgeList){
			if(e.containsVertex(vertex)){
				this.removePreferenceEdge(e);
			}
		}
		this.vertexList.remove(vertex);
	}

	public void addIntEdge(Edge edge){
		this.intEdgeList.add(edge) ; 
	}

	public void removeIntEdge(Edge edge){
		this.intEdgeList.remove(edge) ; 
	} 

	public void addPrefEdge(Edge edge){
		this.prefEdgeList.add(edge) ; 
	}

	public void removePrefEdge(Edge edge){
		this.prefEdgeList.remove(edge) ; 
	} 

//GETTEURS
	public ArrayList<Vertex> getVertexList(){
		return this.vertexList; 
	}

	public ArrayList<InterferenceEdge> getIntEdgeList(){
		return this.intEdgeList ; 
	}
	public ArrayList<PreferenceEdge> getPrefEdgeList(){
		return this.prefEdgeList ; 
	}

//SETTEURS

	public void setVertexList(ArrayList<Vertex> vertexlist){
		this.vertexList = vertexList; 
	}

	public void setIntEdgeList(ArrayList<InterferenceEdge> intEdgeList){
		this.intEdgeList= intEdgeList;
	}

	public void setPrefEdgeList(ArrayList<PreferenceEdge> prefEdgeList){
		this.prefEdgeList= prefEdgeList;
	}




	public Vertex getEqualVertex(Vertex vertex){
		// CHECK IF WHAT IS WANTED 
		boolean foundVertex = false ; 
		int i = 0 
		Vertex result = null;

		while ( i < vertexList.size() || ! foundVertex){
			if (this.vertexList.get(i).getName()==vertex.getName()){
				foundVertex = true; 
				result = this.vertexList.get(i);
			}
		}
		return vertexList.get(i); 

	}

	public int getDegre(Vertex vertex){
		// retourne le degres du sommet cad le nombre de voisins qu'il a (que en interference)
		int result = 0 ; 

		for (InterferenceEdge i : intEdgeList){
			if (i.containsVertex(vertex)){
				result ++ ; 
			}
		}

		return result ; 
	}

	public ArrayList<Vertex> getListAdjacence(Vertex vertex){

		ArrayList<Vertex> listAdjacence = new ArrayList<Vertex>(); 

		for (InterferenceEdge i : this.intEdgeList){
			if (i.containsVertex(vertex)){
				listAdjacence.add(i.getOtherEnd(vertex));
			}
		}
		return listAdjacence; 

	}

	public Vertex getVertexWithHighestDegree(){
		int highestCurrentDegree = -1; 
		Vertex highestCurrentVertex =null;


		for (Vertex i : this.vertexList){
			if ( this.getListAdjacence(i) > highestCurrentDegree ){

				highestCurrentDegree= this.getListAdjacence(i); 
				highestCurrentVertex = i; 

			}
		}

		return highestCurrentVertex; 
	}


	public Vertex getVertexWithDegreeInf(int k){
		Vertex result=null;
		int i =0;
		boolean found = false;

		while(!found && i < this.getNumberOfVertex()){
			if ( getDegre(vertexList.get(i)) < k  ){
				found=true;
				result = this.vertexlist.get(i);
			}
			i+=1;
		}
		return resultList; 
	}

	public int getNumberOfVertex(){
		return this.vertexList.size();
	}

}