package br.caelum.java8.com;

public class Curso {

	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}

	@Override
	public String toString() {
		return "Curso [nome=" + nome + ", alunos=" + alunos + "]";
	}

}
