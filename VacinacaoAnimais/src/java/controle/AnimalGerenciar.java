package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Animal;

/**
 * Controle para usuarioGerenciar.xhtml
 * Cadastra, lista, exclui... usuários.
 * @author José
 */
@ManagedBean (name="animalGerenciar")
@ViewScoped
public class AnimalGerenciar implements Serializable{   

    private List<Animal> animais;
    private Dao<Animal> dao;
    private Animal novo;
    private Animal temp;
    private boolean mostraPopupNovo;
    
    public AnimalGerenciar(){
        dao = new Dao(Animal.class);
        novo = new Animal();
        animais = dao.listarTodos();
        mostraPopupNovo = false; 
    }
    
    public void excluirAnimal(Animal u){
        dao.excluir(u.getId());
        animais.remove(u); // remove da List
    }
    
    public void inserirAnimal(){
        dao.inserir(novo);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "Animal cadastrado", null));
        animais = dao.listarTodos();
        novo = new Animal();
    }
    
    public void preparaEditarAnimal(Animal u){
        temp = u; 
    }
    
    public void alterarAnimal(){
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
    
    public List<Animal> getAnimal() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public Dao<Animal> getDao() {
        return dao;
    }

    public void setDao(Dao<Animal> dao) {
        this.dao = dao;
    }

    public Animal getNovo() {
        return novo;
    }

    public void setNovo(Animal novo) {
        this.novo = novo;
    }
    
    public Animal getTemp() {
        return temp;
    }

    public void setTemp(Animal temp) {
        this.temp = temp;
    }
    
    
    
}