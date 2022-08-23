package org.example.dominio;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.validacao.ValidaInscricaoCurso;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class InscricaoCurso {

    private Aluno aluno;
    private Curso curso;
    private LocalDate dataInicioCurso;

    public InscricaoCurso (Aluno aluno,
                           Curso curso,
                           LocalDate dataInicioCurso,
                           String nomeCursoAnterior,
                           ValidaInscricaoCurso validaInscricaoCurso){
//        List<String> nomesCursos = getNomesDosCursos(aluno.getInscricaoCursoList());
//        if (nomesCursos.contains(nomeCursoAnterior)){
        if (validaInscricaoCurso.isValid(aluno,nomeCursoAnterior)){
            this.aluno = aluno;
            this.curso = curso;
            this.dataInicioCurso = dataInicioCurso;
        }else{
            throw new RuntimeException("Não é possível se inscrever no curso!");
        }
    }

//    private List<String> getNomesDosCursos (List<InscricaoCurso> inscricaoCursoList){
//        List<String> nomeDosCursos = new ArrayList<>();
//        for (InscricaoCurso inscricaoCurso : inscricaoCursoList){
//            nomeDosCursos.add(inscricaoCurso.getCurso().getNome());
//        }
//        return nomeDosCursos;
//    }
//    public Aluno getAluno() {
//        return aluno;
//    }
//
//    public void setAluno(Aluno aluno) {
//        this.aluno = aluno;
//    }
//
//    public Curso getCurso() {
//        return curso;
//    }
//
//    public void setCurso(Curso curso) {
//        this.curso = curso;
//    }
//
//    public LocalDate getDataInicioCurso() {
//        return dataInicioCurso;
//    }
//
//    public void setDataInicioCurso(LocalDate dataInicioCurso) {
//        this.dataInicioCurso = dataInicioCurso;
//    }

}
