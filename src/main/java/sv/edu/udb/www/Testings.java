package sv.edu.udb.www;

import sv.edu.udb.www.entities.ClientesEntity;
import sv.edu.udb.www.entities.MotoristaEntity;
import sv.edu.udb.www.models.MotoristaModels;
import sv.edu.udb.www.models.RegistroModels;

import java.util.Date;

public class Testings {
    public static void main(String[] args) throws Exception {
        /*MotoristaModels motoristaModels = new MotoristaModels();
        List<ComidasEntity> listasComidas = motoristaModels.listarComidas();

        for(ComidasEntity comidas : listasComidas) {
            System.out.println("Id de la comida: " + comidas.getIdComida());
            System.out.println("Nombre de la comida: " + comidas.getNombreComida());
            System.out.println("Stock de comida: " + comidas.getStockComida());
            System.out.println("Precio de comida: $" + comidas.getPrecioComida());
            System.out.println("Tipo de la comida: " + comidas.getTipoOfertaComida());
        }

        MotoristaEntity motoristaEntity = motoristaModels.getMotoristaById(1);
        System.out.println("Id Motorista: "+ motoristaEntity.getIdMotorista());
        System.out.println("Dui de motorista: " + motoristaEntity.getDui());*/

        /*
        RegistroModels registros = new RegistroModels();
        int resultado = registros.verifyExistenceOfCliente("bryan@gmail.com");
        int resultadoAdminGetit = registros.verifyExistenceOfAdminGetit("mauriciomaps42@gmail.com");
        int resultadoAdminTransportista = registros.verifyExistenceOfAdminTransportista("transportesorellana@gmail.com");
        int resultadoMotorista = registros.verifyExistenceOfMotorista("motorista1@gmail.com");
        System.out.println("Cliente: \n" + resultado);
        System.out.println("Administrador Getit: \n" + resultadoAdminGetit);
        System.out.println("Administrador Transportista:\n"+ resultadoAdminTransportista);
        System.out.println("Motorista: \n" + resultadoMotorista);*/

        ClientesEntity clientesEntity = new ClientesEntity();
        clientesEntity.setPrimerNombre("Mauricio");
        clientesEntity.setPrimerApellido("Pérez");
        clientesEntity.setEmail("mauriciomaps42@gmail.com");
        clientesEntity.setDomicilio("Pje. Barrios, Barrio El Progreso, Casa #34, Soyapango, S.S");
        clientesEntity.setFechaNac(new Date());
        clientesEntity.setIdCliente(0);

        RegistroModels registros = new RegistroModels();
        int resultadoRegistro = registros.signUpNewClientUser(clientesEntity);
        System.out.println(resultadoRegistro);
    }
}
