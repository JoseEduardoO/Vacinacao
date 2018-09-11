package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Vacina;

/**
 * Controle para usuarioGerenciar.xhtml
 * Cadastra, lista, exclui... usuários.
 * @author José
 */
@ManagedBean (name="vacinaGerenciar")
@ViewScoped
public class VacinaGerenciar implements Serializable{   

    private List<Vacina> vacinas;
    private Dao<Vacina> dao;
    private Vacina novo;
    private Vacina temp;
    private boolean mostraPopupNovo;
    
    public VacinaGerenciar(){
        dao = new Dao(Vacina.class);
        novo = new Vacina();
        vacinas = dao.listarTodos();
        mostraPopupNovo = false; 
    }
    
    public void excluirVacina(Vacina u){
        dao.excluir(u.getId());
        vacinas.remove(u); // remove da List
    }
    
    public void inserirVacina(){
        dao.inserir(novo);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "Vacina cadastrado", null));
        vacinas = dao.listarTodos();
        novo = new Vacina();
    }
    
    public void preparaEditarVacina(Vacina u){
        temp = u; 
    }
    
    public void alterarVacina(){
        dao.alterar(temp);
    }
    
    public void abrirPopupNovo() {
        this.mostraPopupNovo = true;
    }
    
    public void fecharPopupNovo(){
        mostraPopupNovo = false;
    }
    
    public boolean isMostraPopupNovo() {
        return mostraPopupNovo;
    }

    public void setMostraPopupNovo(boolean mostraPopupNovo) {
        this.mostraPopupNovo = mostraPopupNovo;
    }
    
    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

    public Dao<Vacina> getDao() {
        return dao;
    }

    public void setDao(Dao<Vacina> dao) {
        this.dao = dao;
    }

    public Vacina getNovo() {
        return novo;
    }

    public void setNovo(Vacina novo) {
        this.novo = novo;
    }
    
    public Vacina getTemp() {
        return temp;
    }

    public void setTemp(Vacina temp) {
        this.temp = temp;
    }
    
    
    
}