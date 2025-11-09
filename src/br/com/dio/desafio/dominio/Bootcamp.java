package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Representa um Bootcamp, contendo cursos, mentorias e desenvolvedores inscritos.
 * Aplica os pilares da Programação Orientada a Objetos:
 * - Encapsulamento
 * - Abstração
 * - Composição
 */
public class Bootcamp {

    private String nome;
    private String descricao;
    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);

    // Usamos Set para evitar duplicidade
    private final Set<Dev> devsInscritos = new HashSet<>();
    private final Set<Conteudo> conteudos = new LinkedHashSet<>();

    // =============================
    // MÉTODOS DE NEGÓCIO
    // =============================

    /**
     * Adiciona um conteúdo (curso ou mentoria) ao bootcamp.
     */
    public void adicionarConteudo(Conteudo conteudo) {
        this.conteudos.add(conteudo);
    }

    /**
     * Inscreve um desenvolvedor no bootcamp.
     */
    public void inscreverDev(Dev dev) {
        this.devsInscritos.add(dev);
    }

    /**
     * Retorna o total de conteúdos disponíveis no bootcamp.
     */
    public int getTotalConteudos() {
        return conteudos.size();
    }

    /**
     * Retorna o total de devs inscritos.
     */
    public int getTotalDevs() {
        return devsInscritos.size();
    }

    // =============================
    // GETTERS E SETTERS
    // =============================

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Dev> getDevsInscritos() {
        return devsInscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    // =============================
    // MÉTODOS DE OBJETO
    // =============================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bootcamp)) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome)
                && Objects.equals(descricao, bootcamp.descricao)
                && Objects.equals(dataInicial, bootcamp.dataInicial)
                && Objects.equals(dataFinal, bootcamp.dataFinal)
                && Objects.equals(devsInscritos, bootcamp.devsInscritos)
                && Objects.equals(conteudos, bootcamp.conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, dataFinal, devsInscritos, conteudos);
    }

    @Override
    public String toString() {
        return "Bootcamp{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataInicial=" + dataInicial +
                ", dataFinal=" + dataFinal +
                ", totalConteudos=" + conteudos.size() +
                ", totalDevs=" + devsInscritos.size() +
                '}';
    }
}
