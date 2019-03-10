package br.caelum.java8.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class NovoRecursoJava {
	
	public static void main(String[] args) {

		/*Ordenacao da forma antiga <Antes do Java 8>*/
		List<String> livros = new ArrayList<String>();
		livros.add("online JVM");
		livros.add("editora casa do codigo");
		livros.add("caelum");
		
		/*Ordenacao tradicional A-Z*/
		Collections.sort(livros);
		System.out.println("Tradicional: " + livros);
		
		//ForEach Java 8
		Consumer<String> consumer = new ImprimeNaLinha();
		livros.forEach(consumer);
	}
}

class ImprimeNaLinha implements Consumer<String>{

	public void accept(String t) {
		System.out.println(t);
	}
	
}
