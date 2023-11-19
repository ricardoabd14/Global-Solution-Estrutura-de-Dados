package CIDADE;

public class Cidade implements Comparable<Cidade> {
    private String nome;
    private double coberturaVacinal;
    private int casosRegistrados;

    public Cidade(String nome, double coberturaVacinal, int casosRegistrados) {
        this.nome = nome;
        this.coberturaVacinal = coberturaVacinal;
        this.casosRegistrados = casosRegistrados;
    }

    public String getNome(String string) {
        return nome;
    }

    public double getCoberturaVacinal() {
        return coberturaVacinal;
    }

    public int getCasosRegistrados() {
        return casosRegistrados;
    }

    public int compareTo(Cidade outraCidade) {
        return this.nome.compareToIgnoreCase(outraCidade.nome);
    }

	
}
class cidade implements Comparable<Cidade> {
    private String nome;
    private double coberturaVacinal;
    private int casosRegistrados;

    public void Cidade(String nome, double coberturaVacinal, int casosRegistrados) {
        this.nome = nome;
        this.coberturaVacinal = coberturaVacinal;
        this.casosRegistrados = casosRegistrados;
    }

    public String getNome() {
        return nome;
    }

    public double getCoberturaVacinal() {
        return coberturaVacinal;
    }

    public int getCasosRegistrados() {
        return casosRegistrados;
    }

    @Override
    public int compareTo(Cidade outraCidade) {
        return this.nome.compareToIgnoreCase(outraCidade.getNome(nome));
    }
}