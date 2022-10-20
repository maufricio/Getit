package sv.edu.udb.www.managedbeans;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
//Mauricio Perez
public class AjaxCounter {
    int counter;
    public int getCounter() {
        return counter;
    }
    public void setCounter(int counter) {
        this.counter = counter;
    }
    public void increment(){
        counter+=1;
    }
}
