package kn222gp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import graphs.*;

public class MyGML<E> extends GML<E>{
	
	public MyGML(DirectedGraph<E> dg) {
		super(dg);
	}

	@Override
	public String toGML() {
		Map<Node<E>, Integer> map = new HashMap<>(); 
		String gmlString = "";
		int id = 0;
		
		gmlString += "graph\n[";
		for(E item: graph.allItems()) {
			Node<E> node = graph.getNodeFor(item);
			gmlString += "\n\tnode\n\t[";
			gmlString += "\n\t\tid " + id;
			gmlString += "\n\t\tlabel \"" + node + "\"";
			gmlString += "\n\t]";
			map.put(node, id);
			id++;
		}
		
		id = 0;
		for(E item: graph.allItems()) {
			Node<E> node = graph.getNodeFor(item);
			Iterator iterator = node.succsOf();

			while(iterator.hasNext()) {  
				gmlString += "\n\tedge\n\t[";
				gmlString += "\n\t\tsource " + map.get(node);
				gmlString += "\n\t\ttarget " + map.get(iterator.next());
				gmlString += "\n\t]";
			}
		}
		gmlString += "\n]";
		return gmlString;
	}

}
