package sv.edu.udb.www;

import sv.edu.udb.www.entities.MotoristaEntity;
import sv.edu.udb.www.models.MotoristaModels;

public class Testings {
    public static void main(String[] args) throws Exception {
        MotoristaModels motoristaModels = new MotoristaModels();
        /*List<ComidasEntity> listasComidas = motoristaModels.listarComidas();

        for(ComidasEntity comidas : listasComidas) {
            System.out.println("Id de la comida: " + comidas.getIdComida());
            System.out.println("Nombre de la comida: " + comidas.getNombreComida());
            System.out.println("Stock de comida: " + comidas.getStockComida());
            System.out.println("Precio de comida: $" + comidas.getPrecioComida());
            System.out.println("Tipo de la comida: " + comidas.getTipoOfertaComida());
        }*/

        MotoristaEntity motoristaEntity = motoristaModels.getMotoristaById(1);
        System.out.println("Id Motorista: "+ motoristaEntity.getIdMotorista());
        System.out.println("Dui de motorista: " + motoristaEntity.getDui());
    }
}
