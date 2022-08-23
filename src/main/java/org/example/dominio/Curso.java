package org.example.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // lombok permite não fazer gets e sets e ainda sim o programa rodar
@AllArgsConstructor // construtor
@NoArgsConstructor
public class Curso {

    private String nome;
    private Long duracao;

//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public Long getDuracao() {
//        return duracao;
//    }
//
//    public void setDuracao(Long duracao) {
//        this.duracao = duracao;
//    }

}
