package sv.edu.udb.www.managedbeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@ManagedBean
@ViewScoped

public class PollView implements Serializable {

    private int number;

    public void increment() {
        number++;
    }

    public int getNumber() {
        return this.number;
    }
}