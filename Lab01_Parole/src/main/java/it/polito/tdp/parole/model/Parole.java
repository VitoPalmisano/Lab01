package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
	
	LinkedList<String> lista;
		
	public Parole() {
		lista = new LinkedList<String>();
	}
	
	public void addParola(String p) {
		lista.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(lista, new ComparatoreParoleOrdineAlfabetico());
		return lista;
	}
	
	public void reset() {
		lista.clear();
	}
	
	public void cancella(String s1) {
		
		for(ListIterator<String> iteratore = lista.listIterator(); iteratore.hasNext();) {
			String s2 = iteratore.next();
			if(s2.compareTo(s1)==0) {
				iteratore.remove();
			}
		}
	}

}
