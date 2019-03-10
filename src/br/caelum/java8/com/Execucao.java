package br.caelum.java8.com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Execucao {
	
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		//Ordenando pelo alunos
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		
		//imprimindo no console com lambda
		cursos.forEach(System.out::println);
		
		//Filtrando curso com mais de 50 alunos
		cursos.stream().filter(c-> c.getAlunos() >= 100).
		forEach(c -> System.out.println(c.getNome()));
		
		//Quantos alunos existem em cada curso
		cursos.stream().filter(curso -> curso.getAlunos() >= 100).map(Curso::getAlunos)	
		.forEach(System.out::println);
		
		//Trabalhando com Optional
		Optional<Curso> optionalCurso = cursos.stream().
				filter(curso -> curso.getAlunos() >= 100)
				.findAny();
		
		optionalCurso.ifPresent(curso -> System.out.println(curso.getNome()));
		
	   //Get da media QTD de alunos	
	   OptionalDouble media =  cursos.stream().mapToInt(Curso::getAlunos).average();
		
	   System.out.println("Média:" + media.getAsDouble());
	   
	   
	   //Retornando de uma Stream para uma Collection
	   List<Curso> cursosFiltrados = cursos.stream().
				filter(curso -> curso.getAlunos() >= 100).
				collect(Collectors.toList());
	
	 //Retornando de uma Stream para um Map
	  Map<String, Integer> map = cursos.stream().
				filter(curso -> curso.getAlunos() >= 100).
				collect(Collectors.toMap(
						curso->curso.getNome(), 
						curso->curso.getAlunos()));
	  
	  
	  
	}
	
}
