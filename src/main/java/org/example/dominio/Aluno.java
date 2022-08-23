package org.example.dominio;

import lombok.Data;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data // lombok permite não fazer gets e sets

public class Aluno {

    private String nome;
    private String matricula;
//    private LocalDate dataNascimento;
    private Date dataNascimento; // teste para transformar Date em LocalDate
//    private List<InscricaoCurso> inscricaoCursoList;
    private Collection<InscricaoCurso> inscricaoCursoList;

//    public String apresentar(){
//        return String.format("Aluno: %s de matrícula %s com data de nascimento %s" + "%n%nCursos %n%s",
//                this.getNome(), this.getMatricula(), DateTimeFormatter.ofPattern("dd/MM/yyyy").format(dataNascimento), getCursos());
//    }

    public String apresentar(){
        LocalDate dataNascimento = this.dataNascimento.toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
        return String.format("Aluno: %s de matrícula %s com data de nascimento %s (%d anos)" + "%n%nCursos %n%s",
                this.getNome(),
                this.getMatricula(),
                DateTimeFormatter.ofPattern("dd/MM/yyyy").format(dataNascimento),
//                LocalDate.now().getYear()-dataNascimento.getYear(), opção 1
                Period.between(dataNascimento, LocalDate.now()).getYears(),
                getCursos());
    }

    private String getCursos(){
        StringBuilder builder = new StringBuilder();
        builder.append("Curso \t Data Início \t Data Término \t Dias para início do curso \n"); // %n pula linha e \t dá um tab na visulização da impressão
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // String.format("%s - %s");
        for (InscricaoCurso objetoInscricaoCurso: inscricaoCursoList) {
            final LocalDate dataTermino = objetoInscricaoCurso.getDataInicioCurso().
                    plusMonths(objetoInscricaoCurso.getCurso().getDuracao());
            builder.append(String.format("%s \t %s \t %s \t %d %n",
                    objetoInscricaoCurso.getCurso().getNome(),
                    formatter.format(objetoInscricaoCurso.getDataInicioCurso()),
//                    formatter.format(objetoInscricaoCurso.getDataInicioCurso().
//                            plusMonths(objetoInscricaoCurso.getCurso().getDuracao()) * ISSO TUDO FOI TRANSFORMADO NA VARIÁVEL dataTermino*
                    formatter.format(dataTermino),
                    Duration.between(LocalDate.now().atStartOfDay(),objetoInscricaoCurso.getDataInicioCurso().atStartOfDay()).toDays()
//                    Period.between(LocalDate.now(),objetoInscricaoCurso.getDataInicioCurso()).getDays() ASSIM NÃO TRAZ OS DIAS, SE MUDAR PRA MÊS DÁ CERTO
                    ));
        }
        /*for (int i = 0; i < inscricaoCursoList; i++) {
            InscricaoCurso objetoInscricaoCurso = inscricaoCursoList.get(i);
        }*/
        return builder.toString();
    }

    public boolean containsCurso (String nomeCurso){
        List<String> nomesCursos = getNomesDosCursos(this.getInscricaoCursoList());
        return nomesCursos.contains(nomeCurso);
    }
    private List<String> getNomesDosCursos (List<InscricaoCurso> inscricaoCursoList){
        List<String> nomeDosCursos = new ArrayList<>();
        for (InscricaoCurso inscricaoCurso : inscricaoCursoList){
            nomeDosCursos.add(inscricaoCurso.getCurso().getNome());
        }
        return nomeDosCursos;
    }

//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public String getMatricula() {
//        return matricula;
//    }
//
//    public void setMatricula(String matricula) {
//        this.matricula = matricula;
//    }
//
//    public Date getDataNascimento() {
//        return dataNascimento;
//    }
//
////    public LocalDate getDataNascimento() {
////        return dataNascimento;
////    }
//
//    public void setDataNascimento(Date dataNascimento) {
//        this.dataNascimento = dataNascimento;
//    }
//
////    public void setDataNascimento(LocalDate dataNascimento) {
////        this.dataNascimento = dataNascimento;
////    }
//
//    public List<InscricaoCurso> getInscricaoCursoList() {
//        return inscricaoCursoList;
//    }
//
//    public void setInscricaoCursoList(List<InscricaoCurso> inscricaoCursoList) {
//        this.inscricaoCursoList = inscricaoCursoList;
//    }

}
