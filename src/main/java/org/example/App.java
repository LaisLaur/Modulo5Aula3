package org.example;

import org.example.dominio.Aluno;
import org.example.dominio.Curso;
import org.example.dominio.InscricaoCurso;
import org.example.validacao.ValidaAWS;
import org.example.validacao.ValidaInscricaoCurso;
import org.example.validacao.ValidaTecnicasProgramacao;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner (System.in);
        Aluno aluno = new Aluno();
        Curso curso = new Curso();

        curso.setNome("Técnicas de Programação 4");
        curso.setDuracao(6L);

        InscricaoCurso inscricaoCurso = new InscricaoCurso();
//        inscricaoCurso.setAluno(aluno);
        inscricaoCurso.setCurso(curso);
        inscricaoCurso.setDataInicioCurso(LocalDate.now().plusMonths(2L)); // CONSIDERA O INÍCIO DO CURSO PRA DAQUI 2 MESES
//        inscricaoCurso.setDataInicioCurso(LocalDate.now()); CONSIDERA O DIA ATUAL COMO INÍCIO

        aluno.setInscricaoCursoList(new ArrayList<>());
//        aluno.setInscricaoCursoList(new LinkedList<>());
        aluno.getInscricaoCursoList().add(inscricaoCurso);

        Curso cursoTecnicasProgramacao5 = new Curso ("Técnicas de Programaçõ 5", 8L);

        aluno.getInscricaoCursoList().add(new InscricaoCurso(
                aluno,
                cursoTecnicasProgramacao5,
                LocalDate.now().plusMonths(1L),
                "Técnicas de Programação 4",
                new ValidaTecnicasProgramacao()));

        Curso cursoAWS = new Curso ("Serviço Cloud", 3L);

        aluno.getInscricaoCursoList().add(
                new InscricaoCurso(aluno,
                        cursoAWS,
                        LocalDate.now().plusMonths(2L),
                        "Deployment",
                        new ValidaAWS()));

        // CLASSE ANÔNIMA
        aluno.getInscricaoCursoList().add(
                new InscricaoCurso(aluno,
                        cursoAWS,
                        LocalDate.now().plusMonths(2L),
                        "Deployment",
                        new ValidaInscricaoCurso() {
                            @Override
                            public boolean isValid(Aluno aluno, String nomeCurso) {
                                return aluno.containsCurso(nomeCurso);
                            }
                        }));

        // EXPRESSÃO LAMBDA
        aluno.getInscricaoCursoList().add(
                new InscricaoCurso(aluno,
                        cursoAWS,
                        LocalDate.now().plusMonths(2L),
                        "Deployment",
                        (Aluno a, String s) -> aluno.containsCurso(s)));

        aluno.setMatricula("b310ci7");
        aluno.setNome("Laís Laur Piccoli");
//        aluno.setDataNascimento(LocalDate.of(1994,9,15));
        LocalDate localDataNascimento = LocalDate.of(1994, 9, 15);
        aluno.setDataNascimento(
                Date.from(
                        localDataNascimento.atStartOfDay()
                                        .atZone(ZoneId.systemDefault())
                                                .toInstant()));


        System.out.println(aluno.apresentar());

//        System.out.println(LocalDate.new());
//        System.out.println(LocalDateTime.new());
//        System.out.println(LocalDateTime.new(ZoneId.of("Europe/Amsterdam"));
//        System.out.println(ZonaId.getAvailableZoneIds());

    }
}
