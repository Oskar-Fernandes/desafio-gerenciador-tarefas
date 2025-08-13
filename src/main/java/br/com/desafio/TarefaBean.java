package br.com.desafio;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class TarefaBean implements Serializable {

    private TarefaDAO tarefaDAO;

    private Tarefa tarefa;

    // atributos para os filtros da tela não esquecerrr




    private List<Tarefa> todasAsTarefas;
    private List<Tarefa> tarefasEmAndamento;





    private String filtroTitulo;
    private String filtroResponsavel;

    // Este método é chamado automaticamente logo após a classe ser criada
    @PostConstruct
    public void init() {
        tarefaDAO = new TarefaDAO();
        tarefa = new Tarefa();
        tarefa.setSituacao(SituacaoTarefa.EM_ANDAMENTO);
        tarefa.setDeadline(LocalDate.now());
        carregarTarefas();
    }

    private void carregarTarefas() {
        this.tarefasEmAndamento = tarefaDAO.buscarComFiltros(filtroTitulo, filtroResponsavel);
    }


    public void salvar() {
        if (tarefa.getId() == null) {

            tarefaDAO.salvar(tarefa);
        } else {

            tarefaDAO.atualizar(tarefa);
        }

        tarefa = new Tarefa();
        tarefa.setSituacao(SituacaoTarefa.EM_ANDAMENTO);
        tarefa.setDeadline(LocalDate.now());

        carregarTarefas();
    }


    public void editar(Tarefa tarefaSelecionada) {
        this.tarefa = tarefaSelecionada;
    }


    public void remover(Tarefa tarefaParaRemover) {
        if (tarefaParaRemover != null && tarefaParaRemover.getId() != null) {
            tarefaDAO.remover(tarefaParaRemover.getId());
            carregarTarefas(); // aqui vai atualizar a lista
        }
    }

    //  concluir
    public void concluir(Tarefa tarefaParaConcluir) {
        tarefaParaConcluir.setSituacao(SituacaoTarefa.CONCLUIDA);
        tarefaDAO.atualizar(tarefaParaConcluir);
        carregarTarefas();
    }

    // parte geters mais o setters

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public List<Tarefa> getTarefasEmAndamento() {
        return tarefasEmAndamento;
    }


    public Prioridade[] getPrioridades() {
        return Prioridade.values();
    }






    public void buscar() {

        carregarTarefas();
    }


    public String getFiltroTitulo() {
        return filtroTitulo;
    }

    public void setFiltroTitulo(String filtroTitulo) {
        this.filtroTitulo = filtroTitulo;
    }

    public String getFiltroResponsavel() {
        return filtroResponsavel;
    }

    public void setFiltroResponsavel(String filtroResponsavel) {
        this.filtroResponsavel = filtroResponsavel;
    }
}


