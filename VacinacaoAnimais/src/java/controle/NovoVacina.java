package controle;

import dao.Dao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Vacina;

@ManagedBean (name="novoVacina")
@ViewScoped
public class NovoVacina implements Serializable {
    private Vacina vacina;
    private Dao<Vacina> dao;  
    
    public NovoVacina(){
        vacina = new Vacina();
        dao = new Dao(Vacina.class);
    }
    
    public void inserirVacina(){
        dao.inserir(vacina);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "Vacina cadastrado", null));
        
        vacina = new Vacina();
    }
    
    
    public Vacina getVacina() { 
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public Dao<Vacina> getDao() {
        return dao;
    }

    public void setDao(Dao<Vacina> dao) {
        this.dao = dao;
    }
    
    
}