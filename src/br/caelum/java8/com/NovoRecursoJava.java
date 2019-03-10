package br.caelum.java8.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		
		/*Criando o comparator*/
		Comparator<String> comparator = new ComparadorPorTamanho();
		Collections.sort(livros, comparator);
		System.out.println("Ordenação pelo comparator: " + livros);
		
		livros.sort(comparator);
		System.out.println("Recurso do Java 8:" + livros);
		
		//foreach com lambda
		livros.forEach(s -> System.out.println(s));
		
		
		livros.sort(Comparator.comparing(s -> s.length() ));
		System.out.println("Lambda: "+ livros);
		
		//Method reference
		livros.sort(Comparator.comparing(String::length));
	}
}

class ImprimeNaLinha implements Consumer<String>{

	public void accept(String t) {
		System.out.println(t);
	}
}

/*Criado um comparator por ordenação pelo tamanho da String*/
class ComparadorPorTamanho implements Comparator<String>{

	public int compare(String s1, String s2) {
		
		if(s1.length() < s2.length())
			return -1;
		
		if(s1.length() > s2.length())
			return 1;
		
		return 0;
	}
	
}