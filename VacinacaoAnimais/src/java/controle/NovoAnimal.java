package controle;

import dao.Dao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Animal;

@ManagedBean (name="novoAnimal")
@ViewScoped
public class NovoAnimal implements Serializable {
    private Animal animal;
    private Dao<Animal> dao;  
    
    public NovoAnimal(){
        animal = new Animal();
        dao = new Dao(Animal.class);
    }
    
    public void inserirAnimal(){
        dao.inserir(animal);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "Animal cadastrado", null));
        
        animal = new Animal();
    }
    
    
    public Animal getAnimal() { 
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Dao<Animal> getDao() {
        return dao;
    }

    public void setDao(Dao<Animal> dao) {
        this.dao = dao;
    }
    
    
}