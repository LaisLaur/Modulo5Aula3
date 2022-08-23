package org.example.validacao;

import org.example.dominio.Aluno;
import org.example.dominio.InscricaoCurso;

import java.util.ArrayList;
import java.util.List;

public class ValidaTecnicasProgramacao implements ValidaInscricaoCurso {

    @Override
    public boolean isValid(Aluno aluno, String nomeCurso) {
        List<String> nomesCursos = getNomesDosCursos(aluno.getInscricaoCursoList());
        return nomesCursos.contains(nomeCurso);
    }

    private List<String> getNomesDosCursos (List<InscricaoCurso> inscricaoCursoList){
        List<String> nomeDosCursos = new ArrayList<>();
        for (InscricaoCurso inscricaoCurso : inscricaoCursoList){
            nomeDosCursos.add(inscricaoCurso.getCurso().getNome());
        }
        return nomeDosCursos;
    }

}
