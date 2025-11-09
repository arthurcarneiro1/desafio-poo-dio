package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Dev {

    private String nome;
    private final Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private final Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    /**
     * Inscreve o Dev em um Bootcamp, adicionando todos os conteúdos do bootcamp.
     */
    public void inscreverBootcamp(Bootcamp bootcamp) {
        if (bootcamp == null) {
            System.err.println("Bootcamp inválido!");
            return;
        }
        conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    /**
     * Move o primeiro conteúdo inscrito para concluído.
     */
    public void progredir() {
        Optional<Conteudo> conteudo = conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()) {
            conteudosConcluidos.add(conteudo.get());
            conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("⚠️ Você não está matriculado em nenhum conteúdo!");
        }
    }

    /**
     * Calcula o total de XP dos conteúdos concluídos.
     */
    public double calcularTotalXp() {
        return conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return Set.copyOf(conteudosInscritos);
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return Set.copyOf(conteudosConcluidos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dev dev)) return false;
        return nome.equals(dev.nome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Dev{nome='%s', inscritos=%d, concluidos=%d}",
                nome, conteudosInscritos.size(), conteudosConcluidos.size());
    }
}
